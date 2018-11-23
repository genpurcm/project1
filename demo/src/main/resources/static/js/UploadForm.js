$('#singleUploadForm').submit(function(event) {
    var formElement = this;
    // You can directly create form data from the form element
    // (Or you could get the files from input element and append them to FormData as we did in vanilla javascript)
    var formData = new FormData(formElement);
    $('#added_items').hide("slow");
    $('#table_body').empty();
    $("#singleFileUploadSuccess").empty();
    $("#singleFileUploadError").empty()
    $.ajax({
        type: "POST",
        enctype: 'multipart/form-data',
        url: "/upload",
        data: formData,
        processData: false,
        contentType: false,
        success: function (data, textStatus, jqXHR) {
            console.log("Ajax CallBack Success");
            console.log(data);
            console.log(textStatus);
            console.log(jqXHR);
            console.log(jqXHR.responseText);
            console.log(jqXHR.responseJSON);
            var $SFU = $("#singleFileUploadSuccess");
            $("#SingleFileUploadError").css("display", "none");
            $("#singleFileUploadSuccess").append("<p id='success' style='color:green'>The file '" + data.fileName + "' has been uploaded successfully</p>");
            $("#singleFileUploadSuccess").append("<p>Download IRI: <a href='" + data.fileDownloadUri + "' target='_blank'>" + data.fileDownloadUri + "</p>");
            $("#singleFileUploadSuccess").append("<p style='color:blue'>File Size: " + data.size + "</p>");
            $("#singleFileUploadSuccess").append("<p style='color:blue'>File Type: " + data.fileType + "</p>");
            $SFU.append("<p style='color:blue'>Description: " + data.nameField + "</p>");
            $("#SingleFileUploadSuccess").css('display', 'block');
            document.getElementById("added_items").style.display = 'block';

            $.each(data.playerList, function(idx, item){

                var birthdayItem = new Date(item.birthday);
                var birthday = (birthdayItem.getMonth() + 1) + "/" + birthdayItem.getDate() + "/" + birthdayItem.getFullYear();
                $("#table_body").append("<tr><td>" + item.first_Name + "</td><td>" + item.last_Name + "</td><td>" + item.email_Address + "</td><td>" + birthday + "</td></tr>")
            });
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log("Ajax CallBack Error");
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
            $("#SingleFileUploadSuccess").hide("slow");
            $("#singleFileUploadError").html("<p id='error' style='color:red'>Status: " + textStatus +" ReadyState Code: " + jqXHR.readyState +" Error: "+ jqXHR.status + "</p>");
            $("#error").append(errorThrown);
        }
    });
    event.preventDefault();
    $('#singleUploadForm')[0].reset();
});

