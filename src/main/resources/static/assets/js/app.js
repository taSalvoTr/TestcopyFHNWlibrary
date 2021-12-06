serviceEndpointURL = window.location.protocol + "//" + window.location.host;

$(document).ready(function() {
    isUserAdmin(function (isAdmin){
        // if user is no admin = ROLE_ADMIN = true, hide a few elements on the page
        if(!isAdmin) {
            //navigation of currently borrowed
            $("#currentlyBorrowed").hide();
            // button to add new book
            $("#addNewBook").hide();
        }
    })
})

// make a Get reguest to "/allBooks" and get the json with all books back
function getAllBooks(callback) {
    $.ajax({
        type: "GET",
        dataType: "json",
        url: serviceEndpointURL + "/allBooks",
        success: function (data) {
            callback(data);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log(jqXHR, textStatus, errorThrown);
        }
    });
}

// get reguest to "/userRole" and get a boolean with true back if user is ROLE_ADMIN
function isUserAdmin(callback) {
    $.ajax({
        type: "GET",
        dataType: "json",
        url: serviceEndpointURL + "/userRole",
        success: function (data) {
            callback(data);
        }
    });
}