$('#singleUploadForm').submit(function(event) {
    var formElement = this;
    // You can directly create form data from the form element
    // (Or you could get the files from input element and append them to FormData as we did in vanilla javascript)
    var formData = new FormData(formElement);


    $.ajax({
        type: "POST",
        enctype: 'multipart/form-data',
        url: "/upload",
        data: formData,
        processData: false,
        contentType: false,
        success: function (data, textStatus, jqXHR) {
              console.log("Ajax CallBack Success");
//            WORKING OPTIONS
//            console.log(data);
//            console.log(data.fileName);
//            console.log(textStatus);
//            console.log(jqXHR);
//            console.log(jqXHR.responseText);
//            console.log(jqXHR.responseJSON);

            $("#singleFileUploadSuccess").html("<p id='success' style='color:green'>The file '" + data.fileName + "' has been uploaded successfuly</p>");
            $("#singleFileUploadSuccess").append("<p>Download IRI: " + data.fileDownloadUri + "</p>");
            $("#singleFileUploadSuccess").append("<p style='color:blue'>File Size: " + data.size + "</p>");
            $("#singleFileUploadSuccess").append("<p style='color:blue'>File Type: " + data.fileType + "</p>");
            $("#singleFileUploadSuccess").append("<p style='color:blue'>Description: " + data.nameField + "</p>");

//            var dataparsed = JSON.parse(data);
//            $("#singleFileUploadSuccess").append("<p id='success2' style='color:blue'>" + jqXHR.responseText + "</p>");
//
//            var datastringify = JSON.stringify(data);
//            $("#singleFileUploadSuccess").append("<p id='success3' style='color:magenta'>" + datastringify + "</p>");
//            var dataparsed = JSON.parse(jqXHR.responseText);
//            $("#singleFileUploadSuccess").append("<p id='success4' style='color:red'>" + dataparsed + "</p>");


        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log("Ajax CallBack Error");
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
            $("#singleFileUploadError").html("<p id='error' style='color:red'>Status: " + textStatus +" ReadyState Code: " + jqXHR.readyState +" Error: "+ jqXHR.status + "</p>");
            $("#error").append(errorThrown);
        }
    });
    event.preventDefault();
});

