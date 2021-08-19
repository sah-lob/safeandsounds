$(document).ready(function () {
    $('.has-animation').each(function (index) {
        $(this).delay($(this).data('delay')).queue(function () {
            $(this).addClass('animate-in');
        });
    });
});

$(
    function () {
        getSVGIMG("footerInstagram", "instagram");
        getSVGIMG("footerFacebook", "facebook");
    }
);


async function getSVGIMG(classId, svgFileName) {
    let svgfile = readTextFromSvgFile("img/" + svgFileName + ".svg");
    $('#' + classId).html(svgfile);
}

function readTextFromSvgFile(file) {
    let allText = '';
    const rawFile = new XMLHttpRequest();
    rawFile.open("GET", file, false);
    rawFile.onreadystatechange = function () {
        if (rawFile.readyState === 4) {
            if (rawFile.status === 200 || rawFile.status === 0) {
                allText = rawFile.responseText;
            }
        }
    }
    rawFile.send(null);
    return allText;
}