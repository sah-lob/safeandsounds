function saveInfo() {
    const name = document.getElementById('name').value;
    const description = document.getElementById('description').value;
    const price = document.getElementById('price').value;
    const f = document.querySelector('input[type=file]').files[0];
    const reader = new FileReader();
    reader.onload = (function (theFile) {
        return function (e) {
            var binaryData = e.target.result;
            base64String = window.btoa(binaryData);
            uploadFile(base64String, name, description, price);
        };
    })(f);
    reader.readAsBinaryString(f);
}

function uploadFile(base64String, name, description, price) {
    var data = {
        "image": base64String,
        "name": name,
        "description": description,
        "price": price,
    };
    $.ajax({
        method: "POST",
        url: '../newTour',
        data: JSON.stringify(data),
        contentType: "application/json",
        async: false
    }).done(function (response) {
        nals = response;
    });
    window.location.href = "#";
}