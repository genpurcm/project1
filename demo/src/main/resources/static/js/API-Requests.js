//import * as lib from './UploadForm.js';
//import {dateFormat} from './UploadForm.js';

function GetPlayerList() {
    var table_bodyX
    var added_itemsX
    if ($('input:button').val() == 'Get Players'){
        table_bodyX = 'table_body';
        added_itemsX = 'added_items';
    }else{
        table_bodyX = 'table_body2';
        added_itemsX = 'added_items2';
    }
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
                    $("#" + table_bodyX).append("<tr><td>" + idx + "</td><td>" + item.firstName + "</td><td>" + item.lastName + "</td><td>" + item.emailAddress + "</td><td>" + item.birthday + "</td></tr>")
                });
                $('#' + added_itemsX).show("slow");
            },
        });
};
//********************************change to click

$('#GetPlayerListS3').on("click", function(){
    $.ajax({
        type: 'GET',
//        contentType: "application/json",
//        dataType: "json",
        url: "/players2",
        async:true,
     }).done(function(data, textStatus, jqXHR){
            console.log("GetPlayerListS3 Button Success");
            if (textStatus == "success"){
                $.each(data.content, function(idx, item){
                    $("#table_body3").append("<tr><td>" + idx + "</td><td>" + item.firstName + "</td><td>" + item.lastName + "</td><td>" + item.emailAddress + "</td><td>" + item.birthday + "</td></tr>")
                });
                $('#added_items3').show("slow");
            } else {
                alert("GetPlayerListS3 Button No Success");
            };
        }).fail(function( jqXHR, textStatus, errorThrown){
             console.log("The error thrown by GetPlayerListS3 is: " + errorThrown);
        });
});



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


