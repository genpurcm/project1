//$.noConflict();
$(function(){
    $('.table .eBtn, .nBtn').on('click', function(event){
        event.preventDefault();
        var href = $(this).attr('href');
        var text = $(this).text();
        console.log(text);
        if (text == 'Edit'){
            $('#save-createBtn').val("Save").removeClass( "btn-success" ).addClass( "btn-primary" );
            $('.form-group #Nro').parent().closest('div').css('display', 'block');
            $('.form-group #Nro').prop("disabled", true);
            $('.form-group #id').parent().closest('div').show();
//            $('.form-group #id').prop("disabled", true);
            $('.form-group #id').prop("readonly", true);
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
//                $('.myForm #id').val(player.id);
                $('.myForm #firstName').val(player.firstName);
                $('.myForm #lastName').val(player.lastName);
                $('.myForm #emailAddress').val(player.emailAddress);
                $('.myForm #birthday').val(player.birthday);
            });
            $('.myForm #exampleModal').modal();
        }else{
            $('.form-group #Nro').prop("disabled", true);
//            $('.form-group #id').prop("disabled", true);
            $('.myForm #firstName').val('');
            $('.myForm #lastName').val('');
            $('.myForm #emailAddress').val('');
            $('.myForm #birthday').val('');
            $('.myForm #exampleModal').modal();
            $('#save-createBtn').val("Create").removeClass( "btn-primary" ).addClass( "btn-success" );
//            $('#save-createBtn').val("Create").toggleClass("btn-primary btn-success");
            $('.form-group #Nro').parent().closest('div').css('display', 'none');
//            $('.form-group #id').parent().closest('div').hide();
        }
    });

    $('.table .dBtn').on('click', function(event){
        event.preventDefault();
        var href = $(this).attr('href');
//        console.log($(this).data('valuejson'));
//        console.log($(this).attr('data-valuejson'));
//        console.log($(this).data('valuejson').firstName);
//        var kk = JSON.parse($(this).attr('data-valuejson'));
//        console.log(kk);
//        console.log("Attr: " + kk);
//        console.log("jsonAttr: " + kk.id + "/" + kk.firstName);
        $('#itemToDelete').empty();
        $('#itemToDelete').append("<p style='color:blue; padding-left:3px'>ID: " + $(this).data('valuejson').emailAddress + "</p>");
        $('#itemToDelete').append("<p style='color:blue; padding-left:3px'>Name: " + $(this).data('valuejson').firstName + " " + $(this).data('valuejson').lastName + "</p>");
        $('#deleteModal #delRef').attr('href', href);
        $('#deleteModal').modal();
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

