function startFilter() {
    var newUrl = "/?";
    newUrl = addBooleanParamToUrl(document.getElementById("box1").checked, 'lt', newUrl);
    newUrl = addParamToUrl(document.getElementById("tourFilterDurationFromInput").value, 'durationFrom', newUrl);
    newUrl = addParamToUrl(document.getElementById("tourFilterDurationToInput").value, 'durationTo', newUrl);
    newUrl = addParamToUrl(document.getElementById("tourFilterHourFromInput").value, 'hourFrom', newUrl);
    newUrl = addParamToUrl(document.getElementById("tourFilterHourToInput").value, 'hourTo', newUrl);
    newUrl = addParamToUrl(document.getElementById("tourFilterPriceFromInput").value, 'priceFrom', newUrl);
    newUrl = addParamToUrl(document.getElementById("tourFilterPriceToInput").value, 'priceTo', newUrl);
    window.location.replace(newUrl);
    // if (document.getElementById("box1").checked) {
    //     newUrl += "lt=true";
    // }
    // let durationFrom = document.getElementById("tourFilterDurationFromInput").value;
    // if (durationFrom !== '') {
    //     newUrl += "&durationFrom=" + durationFrom;
    // }
    //
    // let durationTo = document.getElementById("tourFilterDurationToInput").value;
    // if (durationTo !== '') {
    //     newUrl += "&durationTo=" + durationTo;
    // }
    //
    // let hourFrom;
    // if (hourFrom !== '') {
    //     newUrl += "&hourFrom" + hourFrom;
    // }
    // let hourTo;
    // let priceFrom;
    // let priceTo;
    // window.location.replace(newUrl);
}

function addParamToUrl(param, pathParamName, url) {
    if (param !== '') {
        url += "&" + pathParamName + '=' + param;
    }
    return url;
}

function addBooleanParamToUrl(param, pathParamName, url) {
    if (param) {
        url += pathParamName + '=' + param;
    }
    return url;
}