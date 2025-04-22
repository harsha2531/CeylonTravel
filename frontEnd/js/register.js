// Register User
$("#register-btn").click(function (event) {
  event.preventDefault();

  const userData = {
    firstName: $("#firstName").val().trim(),
    lastName: $("#lastName").val().trim(),
    email: $("#email").val().trim(),
    password: $("#password").val().trim(),
    phone: $("#phone").val().trim()
  };

  if (!userData.firstName || !userData.lastName || !userData.email || !userData.password || !userData.phone) {
    alert("All fields are required.");
    return;
  }

  $.ajax({
    url: "http://localhost:8080/api/v1/users/save",
    method: "POST",
    contentType: "application/json",
    data: JSON.stringify(userData),
    success: function () {
      alert("Registration successful!");
      window.location.href = "login.html";
    },
    error: function (err) {
      console.error("Registration failed:", err);
      alert("Registration failed: " + (err.responseText || "Unknown error"));
    }
  });
});
