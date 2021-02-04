$(
    function () {
        $.ajax("../getLogo").done(function (data) {
            var ncarimg = data.logo;
            var result =
                "<p><img src=\""
                + "data:image/png\;base64," + ncarimg +
                "\" alt=\"Изображения машины нет.\"></p>"
            $("#img_с").html(result);
        });
    }
);