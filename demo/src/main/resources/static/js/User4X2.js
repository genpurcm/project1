$('#GetUserListtestA2').click(function(){
    console.log("Before AJAX "),
    setLoading();
    $.ajax({
        type: 'GET',
        <!--contentType: "application/json",-->
        <!--dataType: "json",-->
        url: "/users41/test/testA/kkita",
        async:true,
    }).done(function(data, textStatus, jqXHR){
        console.log("Inside DONE");
//        console.log(data);
//        console.log(data.model);
        $("#added_itemstestA").html(data);
        }).fail(function( jqXHR, textStatus, errorThrown){
            console.log("The error thrown by GetUserListtestA2 is: " + errorThrown);
            }).always(function(){
                console.log("Inside ALWAYS ");
                clearLoading();
                });
});

var loadingButton = $('#GetUserListtestA2');
var setLoading = function() {
//    var loadingButton = $('#GetUserListtestA2');
    loadingButton.prop('disabled', 'disabled');
    if (!loadingButton.data('normal-text')) {
        loadingButton.data('normal-text', loadingButton.html());
    }
    loadingButton.html(loadingButton.data('loading-text'));
};

var clearLoading = function () {
//    var loadingButton = $('#GetUserListtestA2');
    loadingButton.prop('disabled', false);
//    loadingButton.removeAttr('disabled');
    loadingButton.html(loadingButton.data('normal-text'));
};