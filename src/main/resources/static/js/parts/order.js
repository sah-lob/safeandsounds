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
    let passiveCommunicationMethod = '<div class="s2communicationMethod' + num + '" id="s2communicationMethod' + num + '">\n' +
        '                                <a onclick="selectCommunicationMethod(' + num + ')">\n' +
        getImgPath(num) +
        '                                </a>\n' +
        '                            </div>'
    $('#communicationMethod' + num).html(passiveCommunicationMethod);
}

function setActiveCommunicationMethod(num) {
    let mes = '<div class="w2communicationMethod' + num + '" id="w2communicationMethod' + num + '">\n' +
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
        '                                <input type="checkbox" name="a4" class="whatsAppCheckboxPlace" id="whatsAppCheckboxPlace"><span>Different phone number</span><br>\n' +
        '                                <div class="whatsAppPhonePlace">\n' +
        '                                   <img src="img/iphone.png" alt="e">' +
        '                                   <form>\n' +
        '                                       <input type="search" id="whatsAppNewPhone">\n' +
        '                                   </form>' +
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
        '                                <input type="checkbox" name="a4" class="telegramCheckboxPlace" id="telegramCheckboxPlace"><span>Different phone number</span><br>\n' +
        '                                <div class="telegramPhonePlace">\n' +
        '<form>\n' +
        '  <input type="search" id="telegramNewPhone">\n' +
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
        '  <input type="search" id="instagramAccountNewName">\n' +
        '</form>' +
        '                            </div>\n' +
        '                        </div>'
}

function setPhoneForceField() {
    return '<div class="phoneForceField" id="forceField">\n' +
        '                            <div class="phoneSameCheck">\n' +
        '                                <input type="checkbox" name="a4"\n' +
        '                                       class="phoneCheckboxPlace" id="phoneCheckboxPlace"><span>Different phone number</span><br>\n' +
        '                                <div class="phonePhonePlace">\n' +
        '<form>\n' +
        '  <input type="search" id="phoneNewPhone">\n' +
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

function confirmOrder() {
    let orderID = document.getElementById("orderID").innerText;
    let orderUserName = getValue("orderUserName2", "orderUserName");
    let orderUserPhone = document.getElementById('orderUserPhone').value
    let orderUserEmail = getValue("orderUserEmail2", "orderUserEmail");
    let orderUserComment = document.getElementById('orderUserComment').value
    let communicationMethodNum = getCommunicationMethod();
    let communicationMethodAdditionalValue = getCommunicationMethodAdditionalValue(communicationMethodNum);
    let errorString = validateInputData(orderUserName, orderUserPhone, orderUserEmail);
    if (errorString.length === 0) {
        $.post(
            "/confirmNewOrder",
            {
                orderID: orderID,
                clientName: orderUserName,
                clientPhone: orderUserPhone,
                clientEmail: orderUserEmail,
                communicationMethodNum: communicationMethodNum,
                communicationMethodAdditionalValue: communicationMethodAdditionalValue,
                comment: orderUserComment
            },
            onAjaxSuccess
        );

        function onAjaxSuccess(data) {
            window.location.replace(data);
        }
    } else {
        $('#possibleProblems').html(errorString);
    }
}

function getCommunicationMethod() {
    let communicationMethodNum = -1;
    if (document.getElementById("w2communicationMethod1") !== null) {
        communicationMethodNum = 1;
    } else if (document.getElementById("w2communicationMethod2") !== null) {
        communicationMethodNum = 2;
    } else if (document.getElementById("w2communicationMethod3") !== null) {
        communicationMethodNum = 3;
    } else if (document.getElementById("w2communicationMethod4") !== null) {
        communicationMethodNum = 4;
    } else if (document.getElementById("w2communicationMethod5") !== null) {
        communicationMethodNum = 5;
    }
    return communicationMethodNum;
}

function getCommunicationMethodAdditionalValue(communicationMethodNum) {
    let communicationMethodAdditionalValue = "no additional value";
    if (communicationMethodNum === 1) {
        if (document.getElementById('whatsAppCheckboxPlace').checked) {
            communicationMethodAdditionalValue = document.getElementById('whatsAppNewPhone').value;
        }
    } else if (communicationMethodNum === 2) {
        if (document.getElementById('telegramCheckboxPlace').checked) {
            communicationMethodAdditionalValue = document.getElementById('telegramNewPhone').value;
        }
    } else if (communicationMethodNum === 3) {
        communicationMethodAdditionalValue = document.getElementById('instagramAccountNewName').value;
    } else if (communicationMethodNum === 4) {
        if (document.getElementById('phoneCheckboxPlace').checked) {
            communicationMethodAdditionalValue = document.getElementById('phoneNewPhone').value;
        }
    }
    return communicationMethodAdditionalValue;
}

function validateInputData(userName, userPhone, userEmail) {
    let checkErrorText = "";
    alert(userName);
    if (!validateName(userName)) {
        checkErrorText += " фиговое имя."
    }
    if (!validateEmail(userEmail)) {
        checkErrorText += " фиговый email"
    }
    if (!validatePhone(userPhone)) {
        checkErrorText += " фиговый телефон"
    }
    return checkErrorText;
}

function validateName(value) {
    return value.length !== 0;
}

function getValue(divValue, inputValue) {
    let name = '';
    if (document.getElementById(inputValue) != null) {
        name = document.getElementById(inputValue).value;
    } else {
        name = document.getElementById(divValue).innerText;
    }
    return name;
}

function validateEmail(email) {
    let re = /\S+@\S+\.\S+/;
    return re.test(email);
}

function validatePhone(value) {
    return true;
}