$("#register-btn").click(function (event) {
  event.preventDefault();

  const userData = {
    firstName: $("#firstName").val().trim(),
    lastName: $("#lastName").val().trim(),
    email: $("#email").val().trim(),
    phone: $("#phone").val().trim(),
    password: $("#password").val().trim(),
    role: $("#role").val(),
    verified: false
  };

  // Validate fields
  if (!userData.firstName || !userData.lastName || !userData.email || !userData.password || !userData.phone || !userData.role) {
    alert("Please fill in all fields.");
    return;
  }

  $.ajax({
    url: "http://localhost:8080/api/v1/users/save",
    method: "POST",
    contentType: "application/json",
    data: JSON.stringify(userData),
    success: function () {
      alert("User registered successfully!");
      $("#register-form")[0].reset();
    },
    error: function (xhr, status, error) {
      console.error("Registration failed:", error);
      alert("Registration failed. Check console for details.");
    }
  });
});
