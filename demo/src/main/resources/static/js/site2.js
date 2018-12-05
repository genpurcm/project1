//$.noConflict();
$(function(){
    $('.table .eBtn, .nBtn').on('click', function(event){
        event.preventDefault();
        var href = $(this).attr('href');
        var text = $(this).text();
        console.log(text);
        if (text == 'Edit'){
            console.log("It is Edit");
            $('.myForm #Nro').val($(this).attr('value'));
    //        ****** TEST JSON PROCESSING ******
    //        console.log($(this).data('valuejson'));
    //        console.log($(this).attr('data-valuejson'));
    //        console.log($(this).data('valuejson')[0].myvalue);
    //        console.log($(this).data('valuejson')[1].myvalue);
    //        console.log((JSON.parse($(this).attr('data-valuejson')))[1].myvalue);
    //        var kk = JSON.parse($(this).attr('data-valuejson'));
    //        console.log(kk);
    //        console.log("Attr: " + kk);
    //        console.log("jsonAttr: " + kk[0].myvalue + "/" + kk[1].myvalue2);
    //        var json = $(this).data('valuejson');
    //        console.log(json);
    //        console.log("Data: " + json);
    //        console.log("jsonData: " + json[0].myvalue + "/" + json[1].myvalue2);

            $.get(href, function(player,status){
                $('.myForm #id').val(player.id);
                $('.myForm #firstName').val(player.firstName);
                $('.myForm #lastName').val(player.lastName);
                $('.myForm #emailAddress').val(player.emailAddress);
                $('.myForm #birthday').val(player.birthday);
            });
            $('.myForm #exampleModal').modal();
        }else{
            $('.myForm #firstName').val('');
            $('.myForm #lastName').val('');
            $('.myForm #emailAddress').val('');
            $('.myForm #birthday').val('');
            $('.myForm #exampleModal').modal();
            $('#save-createBtn').val("Create").removeClass( "btn-primary" ).addClass( "btn-success" );;
        }
    });

    $('.table .dBtn').on('click', function(event){
        event.preventDefault();
        var href = $(this).attr('href');

        console.log($(this).data('valuejson'));
        console.log($(this).attr('data-valuejson'));
        console.log($(this).data('valuejson').firstName);

        var kk = JSON.parse($(this).attr('data-valuejson'));
        console.log(kk);
        console.log("Attr: " + kk);
        console.log("jsonAttr: " + kk.id + "/" + kk.firstName);

        $('#itemToDelete').append("<p style='color:blue'>ID: " + $(this).data('valuejson').id + "</p>");
        $('#itemToDelete').append("<p style='color:blue'>Name: " + $(this).data('valuejson').firstName + " " + $(this).data('valuejson').lastName + "</p>");
        $('#deleteModal #delRef').attr('href', href);
        $('#deleteModal').modal();
    });
});

