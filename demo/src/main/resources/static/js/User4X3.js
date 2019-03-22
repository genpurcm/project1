$('#GetUserListtestA3').click(function(){
    console.log("Before AJAX "),
    setLoading();
    $.ajax({
        type: 'GET',
        url: "/users41/test/testA/kkita",
        async:true,
        beforeSend:function(){
         return confirm("Are you sure?");
        },
    })
    .done(function(data, textStatus, jqXHR){
        console.log("Inside DONE");
        $("#added_itemstestA").html(data);
    })
    .fail(function( jqXHR, textStatus, errorThrown){
        console.log("The error thrown by GetUserListtestA3 is: " + errorThrown);
    })
    .always(function(){
        console.log("Inside ALWAYS ");
        clearLoading();
    });
});

var loadingButton = $('#GetUserListtestA3');
var setLoading = function() {
    loadingButton.prop('disabled', 'disabled');
    console.log(loadingButton.data('loading-text'));
    console.log(loadingButton.prop('loading-text'));
    console.log(loadingButton.attr('data-loading-text'));

    loadingButton.data('normal-text') ? null : loadingButton.data('normal-text', loadingButton.html());;

//    if (!loadingButton.data('normal-text')) {
//        loadingButton.data('normal-text', loadingButton.html());
//    }
    loadingButton.html(loadingButton.data('loading-text'));
};

var clearLoading = function () {
    loadingButton.prop('disabled', false);
    loadingButton.html(loadingButton.data('normal-text'));
};