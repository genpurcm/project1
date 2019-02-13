
function GetUserList() {
    var table_bodyX
    var added_itemsX
    if ($('input:button').val() == 'Get Users'){
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
            url: "/dev/users",
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

$('#GetUserListS3').on("click", function(){
    $.ajax({
        type: 'GET',
//        contentType: "application/json",
//        dataType: "json",
        url: "/dev/usersS3",
        async:true,
     }).done(function(data, textStatus, jqXHR){
            console.log("GetUserListS3 Button Success");
            if (textStatus == "success"){
                $.each(data.content, function(idx, item){
                    $("#table_body3").append("<tr><td>" + idx + "</td><td>" + item.firstName + "</td><td>" + item.lastName + "</td><td>" + item.emailAddress + "</td><td>" + item.birthday + "</td></tr>")
                });
                $('#added_items3').show("slow");
            } else {
                alert("GetUserListS3 Button No Success");
            };
        }).fail(function( jqXHR, textStatus, errorThrown){
             console.log("The error thrown by GetUserListS3 is: " + errorThrown);
        });
});



$('#Ajax2').on("click", function(){
    $.ajax({
        type: 'GET',
//        contentType: "application/json",
//        dataType: "json",
        url: "/users",
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


