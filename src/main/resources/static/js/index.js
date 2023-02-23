function addToCart(bookId,userId){
            var cookie = $("#authenticated-user").text();
            console.log(cookie);
            console.log(userId);
            console.log(bookId);
}

// function createUserCart(userId){
//     var cartUrl = "/api/v1/carts";

//     var cartBody = {
//         "user": `/users/${userId}`,
//     };

//     $.ajax({
//                   type: "POST",
//                   url: cartUrl,
//                   data: JSON.stringify(cartBody),
//                   dataType: "json",
//                   contentType: "application/json; charset=utf-8"
//             })
// }
