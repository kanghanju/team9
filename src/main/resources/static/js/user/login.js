document.addEventListener('DOMContentLoaded', function () {
  // 폼의 id 속성을 사용하여 로그인 폼 선택
  const loginForm = document.getElementById('login-form');

  loginForm.addEventListener('submit', function (event) {
    event.preventDefault(); // 기본 제출 동작 방지

    // 'email'과 'password' id를 가진 입력 필드의 값을 가져옴
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;

    // 모든 필드가 채워져있는지 확인
    if (!email || !password) {
      alert('모든 필드를 입력해주세요.');
      return;
    }

    // 서버로 이메일과 비밀번호를 보내 검증
    fetch('/user/login', {
      method: 'POST',
      headers: {
        "Content-Type": "application/x-www-form-urlencoded",
      },
      // 'id' 대신 'email'을 사용하여 서버로 전송
      body: `email=${encodeURIComponent(email)}&password=${encodeURIComponent(
          password)}`
    })
    .then(response => response.json())
    .then(data => {
      if (data.success) { // 로그인 성공 시
        window.location.replace('/'); // 메인 페이지로 리다이렉트
      } else { // 로그인 실패 시
        alert(data.errormsg); // errormsg를 클라이언트에게 알림
        window.location.replace('/user/login');
      }
    })
    .catch(error => console.error('Error:', error));
  });
});
