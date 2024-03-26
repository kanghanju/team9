// 마이페이지에서 '작성글', '작성댓글' 클릭 시 글자 색이 바뀌고 해당 데이터를 불러와 화면에 표시하는 로직
document.addEventListener('DOMContentLoaded', function () {
  //작성글, 작성댓글 a태그가 sortLinks
  const sortLinks = document.querySelectorAll('.sort_area .link_sort');

  sortLinks.forEach(link => {
    link.addEventListener('click', function (e) {
      // e.preventDefault();

      // 모든 링크에서 'selected' 클래스 제거
      sortLinks.forEach(link => {
        link.classList.remove('selected');
      });

      // 클릭된 링크에 'selected' 클래스 추가
      this.classList.add('selected');

      // 데이터 로딩 함수 호출
      let pageType = this.getAttribute('data-page-type'); // 'posts' 또는 'comments' 같은 데이터 속성 사용
      loadPage(pageType, 0); // 첫 페이지 로드
    });
  });
});

function loadPage(pageType, pageNumber) {
  let url = `/user/${pageType}?page=${pageNumber}&size=10`; // 페이지 타입(글/댓글)과 페이지 번호, 페이지 크기 지정

  fetch(url)
  .then(response => response.text())
  .then(html => {
    document.querySelector('.board_content').innerHTML = html;
    // 추가로 페이징 링크에 대한 이벤트 리스너를 재설정할 필요가 있으면 여기에 구현
  });
}


