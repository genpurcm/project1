//import * as lib from './UploadForm.js';
//import {dateFormat} from './UploadForm.js';

function GetPlayerList() {
    $.ajax({
        type: 'GET',
//        contentType: "application/json",
//        dataType: "json",
        url: "/players",
//        processData: false,
//        contentType: false,
        success: function(data){
            $.each(data, function(idx, item){
//                var birthdayItem = new Date(item.birthday);
//                var birthday = (birthdayItem.getMonth() + 1) + "/" + birthdayItem.getDate() + "/" + birthdayItem.getFullYear();
                $("#table_body").append("<tr><td>" + idx + "</td><td>" + item.firstName + "</td><td>" + item.lastName + "</td><td>" + item.emailAddress + "</td><td>" + item.birthday + "</td></tr>")
            });
            $('#added_items').show("slow");
        },
    });
};

$('#Ajax2').on("click", function(){
    $.ajax({
        type: 'GET',
//        contentType: "application/json",
//        dataType: "json",
        url: "/players",
        async:true,
     }).done(function(data, textStatus, jqXHR){
            if (textStatus == "success"){
                console.log("Ajax2 Button Success");
            } else {
                alert("Ajax2 Button No Success");
            };
        }).fail(function( jqXHR, textStatus, errorThrown){
             console.log("The error thrown is: " + errorThrown);
        });
});


