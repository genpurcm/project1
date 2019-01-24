    $('#GetPlayerListS41, #GetPlayerListtestA, #GetPlayerListS42').click(function(){
//    console.log($(this).data("value"))
//    console.log(this.id)
//    console.log($(this).attr("id"))
//    console.log($('input:button').val())
//    console.log($(this).val())
    var id = this.id
    var urlSelect
    var dataValue = $(this).data("value")

    switch ($(this).val()){
        case "Get Players testA":
            urlSelect = 'testA';
            break;
        case "Get Players S41":
            urlSelect = 'S41';
            break;
        case "Get Players S42":
            urlSelect = 'S42';
            break;
    }
    console.log("Before AJAX " + dataValue),
    $.ajax({
        type: 'GET',
        <!--contentType: "application/json",-->
        <!--dataType: "json",-->
        url: "/players41/test/" + urlSelect + "/kkita",
        async:true,
    }).done(function(data, textStatus, jqXHR){
            console.log("Inside DONE before IF " + dataValue);
            console.log(data);
            console.log(data.currentSize);
            console.log(data.currentPage);
            console.log(data.model);
            if (dataValue == "S42"){
                console.log("Inside DONE Inside IF " + dataValue.slice(1,3));
                $.each(data.dataPlayer.content, function(idx, item){
                $("#table_body" + dataValue.slice(1,3)).append("<tr><td>" + idx + "</td><td>" + item.firstName + "</td><td>" + item.lastName + "</td><td>" + item.emailAddress + "</td><td>" + item.birthday + "</td></tr>")
                });
                $("#added_items" + dataValue.slice(1,3)).show("slow");
//                $("#table" + dataValue.slice(1,3)).on('load', data);

            } else {
                console.log("Inside DONE Inside ELSE " + dataValue);
                $("#added_items" + dataValue).html(data);
//                console.log(data);
            };
        }).fail(function( jqXHR, textStatus, errorThrown){
             console.log("The error thrown by GetPlayerListS41 is: " + errorThrown);
        });
});

$(function(){
    $('#pageSizeSelect').change(function(evt){
            console.log(window.location);
            console.log(this.value);
            console.log("Working");
            window.location.replace("?page=0&size=" + this.value);
    });
});