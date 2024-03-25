document.addEventListener('DOMContentLoaded', function () {
  document.getElementById('signup-form').addEventListener('submit',
      function (e) {
        let password = document.getElementById('password').value;
        let confirmPassword = document.getElementById('password-confirm').value;
        let errorMessage = document.getElementById('password-error');

        if (password !== confirmPassword) {
          errorMessage.style.display = 'block'; // 에러 메시지 표시
          e.preventDefault(); // 폼 제출 방지
        } else {
          errorMessage.style.display = 'none';
        }
      });
});