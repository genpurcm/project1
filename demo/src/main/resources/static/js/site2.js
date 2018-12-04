//$.noConflict();
//$(function(){
$(function(){
    $('.table .eBtn').on('click', function(event){
        event.preventDefault();
        var href = $(this).attr('href');
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
    });
});