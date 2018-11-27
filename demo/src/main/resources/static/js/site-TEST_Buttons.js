function Ajax() {
    $.ajax({
        type: 'GET',
//        contentType: "application/json",
//        dataType: "json",
        url: "/players",
//        processData: false,
//        contentType: false,
        success: function(data){
            console.log("The Raw data CERO is: " + data[0].id);
            console.log("The Raw data CERO is: " + JSON.stringify(data[0]));
//            window.open("/players", "_blank");
            console.log("Ajax Button");

            $.each(data, function(idx, item){
                console.log(item.first_Name);
                console.log(idx);
                var birthdayItem = new Date(item.birthday);
                var birthday = (birthdayItem.getMonth() + 1) + "/" + birthdayItem.getDate() + "/" + birthdayItem.getFullYear();
                $("#table_body1").append("<tr><td>" + item.first_Name + "</td><td>" + item.last_Name + "</td><td>" + item.email_Address + "</td><td>" + birthday + "</td></tr>")
            });
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
            console.log("Inside .DONE");
            console.log("The JSON.stringify is: " + JSON.stringify(data));
            console.log("The Raw data is: " + data);
            console.log("The Raw data CERO is: " + data[0]);
            console.log(jqXHR);
            alert(JSON.stringify(data));
            alert("The data is: " + jqXHR.responseJSON);
            if (textStatus == "success"){
                window.open("/players", "_blank");
                console.log("Ajax2 Button");
                alert("Ajax2 Button Success");
            } else {
                alert("Ajax2 Button No Success");
                window.open("/playersError");
            };
        }).fail(function( jqXHR, textStatus, errorThrown){
             console.log("The error thrown is: " + errorThrown);
             alert(errorThrown);
//             $("#Ajax2P").html("<p id='error' style='color:red'>"+data+"</p>");
        });
});


