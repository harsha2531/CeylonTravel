$(document).ready(function () {
  $("form").submit(function (event) {
    event.preventDefault();

    const loginData = {
      email: $("#email").val().trim(),
      password: $("#password").val().trim()
    };

    if (!loginData.email || !loginData.password) {
      alert("Please enter both email and password.");
      return;
    }

    $.ajax({
      url: "http://localhost:8080/api/v1/auth/authenticate",
      method: "POST",
      contentType: "application/json",
      data: JSON.stringify(loginData),
      success: function (response) {
        alert("Login successful!");
        localStorage.setItem("token", response.content);
        localStorage.setItem("email", response.content);
        window.location.href = "../index.html";
      },
      error: function (xhr, status, error) {
        alert("Login failed: " + xhr.responseJSON.message);
        console.error("Login failed:", error);
      }
    });
  });
});
