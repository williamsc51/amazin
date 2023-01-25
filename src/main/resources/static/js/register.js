$(document).ready(function () {
    $("form").on('submit', function(event){
        event.preventDefault();
        var firstName = $("#firstName").val();
        var lastName = $("#lastName").val();
        var email = $("#emailAddress").val();
        var password = $("#password").val();

        var body = {
            "firstName": firstName,
            "lastName": lastName,
            "email": email,
            "password": password
        };

        var url = "/api/v1/users";

        $.ajax({
              type: "POST",
              url: url,
              data: JSON.stringify(body),
              dataType: "json",
              contentType: "application/json; charset=utf-8",
              success: function(data) {
                   console.log(data)
                   window.location.href = "/";
               },
               error: function(xhr, textStatus, errorThrown) {
                    console.log(JSON.parse(xhr.responseText).cause);
               }
        })
    });
});