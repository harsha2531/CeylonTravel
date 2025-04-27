$(document).ready(function () {
  const token = localStorage.getItem("token");

  // Fetch and load all users when the page loads
  console.log("Fetching all users...");

  $.ajax({
    url: "http://localhost:8080/api/v1/user/getAllUsers",
    method: "GET",
   /* headers: {
      Authorization: "Bearer " + token
    },*/
    dataType: "json",
    success: function (users) {
      const tableBody = $("#user-table-body tbody");
      tableBody.empty();

      users.forEach(user => {
        tableBody.append(`
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.firstName}</td>
                        <td>${user.lastName}</td>
                        <td>${user.email}</td>
                        <td>${user.phone}</td>
                        <td>${user.password}</td>
                        <td>${user.role}</td>
                        <td>
                            <button class="btn btn-danger btn-sm delete-btn" data-id="${user.id}">Deactivate</button>
                        </td>
                    </tr>
                `);
      });
    },
    error: function (xhr, status, error) {
      console.error("Failed to load users:", error);
      alert("Failed to load users. Please try again.");
    }
  });
});


/* function loadAgencies() {
   $.ajax({
     url: "http://localhost:8080/api/v1/agency/getAllAgencies",
     method: "GET",
     headers: {
       Authorization: "Bearer " + token
     },
     success: function (agencies) {
       let agencyTable = "";
       agencies.forEach(agency => {
         agencyTable += `
                       <tr>
                           <td>${agency.agencyId}</td>
                           <td>${agency.name}</td>
                           <td>${agency.contact}</td>
                           <td>${agency.location}</td>
                       </tr>`;
       });
       $("#agencyTableBody").html(agencyTable);
     },
     error: function (xhr, status, error) {
       console.error("Failed to load agencies:", error);
     }
   });
 }

 function loadDestinations() {
   $.ajax({
     url: "http://localhost:8080/api/v1/destination/getAllDestinations",
     method: "GET",
     headers: {
       Authorization: "Bearer " + token
     },
     success: function (destinations) {
       let destinationTable = "";
       destinations.forEach(destination => {
         destinationTable += `
                       <tr>
                           <td>${destination.destinationId}</td>
                           <td>${destination.name}</td>
                           <td>${destination.country}</td>
                           <td>${destination.description}</td>
                       </tr>`;
       });
       $("#destinationTableBody").html(destinationTable);
     },
     error: function (xhr, status, error) {
       console.error("Failed to load destinations:", error);
     }
   });
 }

 function loadPayments() {
   $.ajax({
     url: "http://localhost:8080/api/v1/payment/getAllPayments",
     method: "GET",
     headers: {
       Authorization: "Bearer " + token
     },
     success: function (payments) {
       let paymentTable = "";
       payments.forEach(payment => {
         paymentTable += `
                       <tr>
                           <td>${payment.paymentId}</td>
                           <td>${payment.userId}</td>
                           <td>${payment.amount}</td>
                           <td>${payment.paymentDate}</td>
                       </tr>`;
       });
       $("#paymentTableBody").html(paymentTable);
     },
     error: function (xhr, status, error) {
       console.error("Failed to load payments:", error);
     }
   });
 }*/

  // Load all sections on page load
  // loadUsers();
  /*loadAgencies();
  loadDestinations();
  loadPayments();*/

