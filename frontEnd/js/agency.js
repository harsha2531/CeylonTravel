$(document).ready(function () {

  // Load all agencies
  $("#agency-getAll-btn").click(function (event) {
    event.preventDefault();
    console.log("Fetching all agencies...");

    $.ajax({
      url: `http://localhost:8080/api/v1/agency/getAll`,
      method: "GET",
      dataType: "json",
      success: function (response) {
        const tableBody = $("#agencyTableBody");
        tableBody.empty();

        response.forEach(agency => {
          tableBody.append(`
            <tr>
              <td>${agency.id}</td>
              <td>${agency.name}</td>
              <td>${agency.location}</td>
              <td>${agency.contactNo}</td>
              <td>
                <button class="btn btn-warning btn-sm edit-btn"
                        data-id="${agency.id}"
                        data-name="${agency.name}"
                        data-location="${agency.location}"
                        data-contact="${agency.contactNo}">
                  Edit
                </button>
                <button class="btn btn-danger btn-sm delete-btn" data-id="${agency.id}">
                  Delete
                </button>
              </td>
            </tr>
          `);
        });
      },
      error: function (err) {
        console.error("Error fetching agencies:", err);
        showToast("Failed to load agencies.", "error");
      }
    });
  });

  // Save Agency
  $("#agency-save-btn").click(function (event) {
    event.preventDefault();

    const agencyData = {
      name: $("#agencyName").val().trim(),
      location: $("#agencyLocation").val().trim(),
      contactNo: $("#agencyContact").val().trim()
    };

    if (!agencyData.name || !agencyData.location || !agencyData.contactNo) {
      showToast("All fields are required.", "error");
      return;
    }

    console.log("Saving agency:", agencyData); // Debugging

    $.ajax({
      url: `http://localhost:8080/api/v1/agency/save`,
      method: "POST",
      contentType: "application/json",
      data: JSON.stringify(agencyData),
      success: function () {
        showToast("Agency saved successfully", "success");
        $("#agency-getAll-btn").click(); // Refresh list
        clearAgencyForm();
      },
      error: function (err) {
        console.error("Error saving agency:", err);
        showToast("Failed to save agency.", "error");
      }
    });
  });

  // Edit Agency - Load selected row details into form
  $(document).on("click", ".edit-btn", function () {
    $("#agencyId").val($(this).data("id"));
    $("#agencyName").val($(this).data("name"));
    $("#agencyLocation").val($(this).data("location"));
    $("#agencyContact").val($(this).data("contact"));
  });

  // Update Agency
  $("#agency-update-btn").click(function (event) {
    event.preventDefault();

    const agencyData = {
      id: $("#agencyId").val().trim(),
      name: $("#agencyName").val().trim(),
      location: $("#agencyLocation").val().trim(),
      contactNo: $("#agencyContact").val().trim()
    };

    if (!agencyData.id || !agencyData.name || !agencyData.location || !agencyData.contactNo) {
      alert("All fields are required.");
      return;
    }

    console.log("Updating agency:", agencyData); // Debugging

    $.ajax({
      url: `http://localhost:8080/api/v1/agency/update`,
      method: "PUT",
      contentType: "application/json",
      data: JSON.stringify(agencyData),
      success: function () {
        showToast("Agency updated successfully", "success");
        $("#agency-getAll-btn").click();
        clearAgencyForm();
      },
      error: function (err) {
        console.error("Error updating agency:", err);
        showToast("Failed to update agency.", "error");
      }
    });
  });

  // Delete Agency
  $(document).on("click", ".delete-btn", function () {
    const agencyId = $(this).data("id");

    if (!confirm("Are you sure you want to delete this agency?")) return;

    $.ajax({
      url: `http://localhost:8080/api/v1/agency/delete/${agencyId}`,
      method: "DELETE",
      success: function () {
        showToast("Agency deleted successfully", "success");
        $("#agency-getAll-btn").click();
      },
      error: function (err) {
        console.error("Error deleting agency:", err);
        showToast("Failed to delete agency.", "error");
      }
    });
  });

  // Clear form
  $("#agency-clear-btn").click(function (event) {
    event.preventDefault();
    clearAgencyForm();
  });

  // Helper function to clear form
  function clearAgencyForm() {
    $("#agencyId").val('');
    $("#agencyName").val('');
    $("#agencyLocation").val('');
    $("#agencyContact").val('');
  }

  function showToast(message) {
    const toastElement = document.getElementById('liveToast');
    if (!toastElement) {
      console.error('Toast element not found!');
      return;
    }

    toastElement.querySelector('.toast-body').textContent = message; // update the text

    const toast = new bootstrap.Toast(toastElement);
    toast.show();
  }

});
