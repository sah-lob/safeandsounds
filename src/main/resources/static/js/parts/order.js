let firstCommunicationName = 'Предпочтительный способ связи';
let communicationName1 = "Whatsapp";
let communicationName2 = "Telegram";
let communicationName3 = "Instagram";
let communicationName4 = "Phone";
let communicationName5 = "Email";

function selectCommunicationMethod(tourType) {
    let oldCommunicationName = document.getElementById("communicationName").innerText;
    let oldI = getOldI(oldCommunicationName);
    setCommunicationName(tourType);
    for (let i = 1; i < 6; i++) {
        if (oldI === i) {
            setPassiveCommunicationMethod(i)
        } else if (i === tourType) {
            setActiveCommunicationMethod(i)
        }
    }
}

function setPassiveCommunicationMethod(num) {
    let passiveCommunicationMethod = '<div class="s2communicationMethod' + num + '">\n' +
        '                                <a onclick="selectCommunicationMethod(' + num + ')">\n' +
        getImgPath(num) +
        '                                </a>\n' +
        '                            </div>'
    $('#communicationMethod' + num).html(passiveCommunicationMethod);
}

function setActiveCommunicationMethod(num) {
    let mes = '<div class="w2communicationMethod' + num + '">\n' +
        getImgPath(num) +
        '     </div>';
    setForceField(num);
    $('#communicationMethod' + num).html(mes);
}

function setCommunicationName(tourType) {
    if (tourType === 1) {
        $('#communicationName').html(communicationName1);
    } else if (tourType === 2) {
        $('#communicationName').html(communicationName2);
    } else if (tourType === 3) {
        $('#communicationName').html(communicationName3);
    } else if (tourType === 4) {
        $('#communicationName').html(communicationName4);
    } else {
        $('#communicationName').html(communicationName5);
    }
}

function getOldI(oldCommunicationName) {
    if (oldCommunicationName === firstCommunicationName) {
        return -3;
    } else if (oldCommunicationName === communicationName1) {
        return 1;
    } else if (oldCommunicationName === communicationName2) {
        return 2;
    } else if (oldCommunicationName === communicationName3) {
        return 3;
    } else if (oldCommunicationName === communicationName4) {
        return 4;
    } else {
        return 5;
    }
}

function getImgPath(num) {
    return '<img src="img/callbackB.png" alt="e">'
}

function setForceField(num) {
    let answer;
    if (num === 1) {
        answer = setWhatsAppForceField();
    } else if (num === 2) {
        answer = setTelegramForceField();
    } else if (num === 3) {
        answer = setInstagramForceField();
    } else if (num === 4) {
        answer = setPhoneForceField();
    } else {
        answer = setEmailForceField();
    }
    $('#forceField').html(answer);
}

function setWhatsAppForceField() {
    return '<div class="whatsappForceField" id="forceField">\n' +
        '                            <div class="whatsappTitle">\n' +
        '                                Your whatsApp phone number\n' +
        '                            </div>\n' +
        '                            <div class="whatsappSameCheck">\n' +
        '                                <input type="checkbox" name="a4" class="whatsAppCheckboxPlace"><span>Different phone number</span><br>\n' +
        '                                <div class="whatsAppPhonePlace">\n' +
        '<img src="img/iphone.png" alt="e">' +
        '<form>\n' +
        '  <input type="search">\n' +
        '</form>' +
        '                                </div>\n' +
        '                            </div>\n' +
        '                        </div>';
}

function setTelegramForceField() {
    return '<div class="telegramForceField" id="forceField">\n' +
        '                            <div class="telegramTitle">\n' +
        '                                Your telegram phone number\n' +
        '                            </div>\n' +
        '                            <div class="telegramSameCheck">\n' +
        '                                <input type="checkbox" name="a4" class="telegramCheckboxPlace"><span>Different phone number</span><br>\n' +
        '                                <div class="telegramPhonePlace">\n' +
        '<form>\n' +
        '  <input type="search">\n' +
        '</form>' +
        '                                </div>\n' +
        '                            </div>\n' +
        '                        </div>';
}

function setInstagramForceField() {
    return '<div class="instagramForceField" id="forceField">\n' +
        '                            <div class="instagramTitle">\n' +
        '                                Your account name\n' +
        '                            </div>\n' +
        '                            <div class="instagramAccountNamePlace">\n' +
        '<form>\n' +
        '  <input type="search">\n' +
        '</form>' +
        '                            </div>\n' +
        '                        </div>'
}

function setPhoneForceField() {
    return '<div class="phoneForceField" id="forceField">\n' +
        '                            <div class="phoneSameCheck">\n' +
        '                                <input type="checkbox" name="a4"\n' +
        '                                       class="phoneCheckboxPlace"><span>Different phone number</span><br>\n' +
        '                                <div class="phonePhonePlace">\n' +
        '<form>\n' +
        '  <input type="search">\n' +
        '</form>' +
        '                                </div>\n' +
        '                            </div>\n' +
        '                        </div>'
}

function setEmailForceField() {
    return '<div class="emailForceField" id="forceField">\n' +
        '                            <div class="emailTitle">\n' +
        '                                Email you have already entered=)\n' +
        '                            </div>\n' +
        '                        </div>'
}

