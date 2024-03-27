async function openTab(evt, tabName) {
  // 모든 탭 콘텐츠를 숨깁니다
  let tabContent = document.getElementsByClassName("tab_content");
  for (let i = 0; i < tabContent.length; i++) {
    tabContent[i].style.display = "none";
  }

  // 모든 탭 링크를 비활성화합니다
  let tabLinks = document.getElementsByClassName("tab_links");
  for (let i = 0; i < tabLinks.length; i++) {
    tabLinks[i].className = tabLinks[i].className.replace(" active", "");
  }

  // 클릭된 탭을 활성화하고 탭 콘텐츠를 보여줍니다
  document.getElementById(tabName).style.display = "block";
  evt.currentTarget.className += " active";

  //전체 회원 탭이 클릭되면 서버로부터 데이터를 가져와야 합니다 !
  if (tabName === 'AllMembers') {
    
  }
}

// 기본적으로 첫 번째 탭을 엽니다 (전체 회원 탭)
document.addEventListener("DOMContentLoaded", function () {
  document.getElementsByClassName("tab_links")[0].click();
});