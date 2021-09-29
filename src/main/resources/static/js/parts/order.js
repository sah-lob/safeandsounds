$(
    function () {
        getSVGIMG("cmWhatsAppIcon", "edit_calendar2");
        getSVGIMG("cmTelegramIcon", "tour_price_calender");
        getSVGIMG("cmInstagramIcon", "tour_price_duration");
        getSVGIMG("cmEmailIcon", "tour_price_car");
        getSVGIMG("cmPhoneIcon", "tour_price_price");
    }
);

function communicationMethod(communicationMethodName, instagramAccount) {
    if (instagramAccount === undefined) {
        instagramAccount = "";
    }
    setIconsColorGray();
    setIconActive(communicationMethodName)
    setCommunicationMethodBodySelected(communicationMethodName);
    if (communicationMethodName === 'cmInstagram') {
        var newOrderAdditionalInstagram = "<div class=\"communicationMethodName\">\n" +
            "                    Enter your instagram:\n" +
            "                </div>\n" +
            "                <div class=\"instagramCommunicationMethod\">\n" +
            "                    <div class=\"communicationMethodDog\">\n" +
            "                        @\n" +
            "                    </div>\n" +
            "                    <input class=\"communicationMethodText\" id=\"communicationMethodText\" value='" + instagramAccount + "' type=\"text\">\n" +
            "                </div>";
        $('#newOrderAdditionalInstagram').html(newOrderAdditionalInstagram);
    } else {
        $('#newOrderAdditionalInstagram').html("");
    }
}

function setIconsColorGray() {
    let calenderTableAvailableTour = document.getElementsByClassName('allCommunicationMethod');
    for (let i = 0; i < calenderTableAvailableTour.length; i++) {
        addExcessClassByClassNameAndIndex("allCommunicationMethod", "communicationMethodNotSelected", i);
    }
}

function setIconActive(communicationMethodName) {
    deleteExcessClassByClassNameAndIndex(communicationMethodName, "communicationMethodNotSelected", 0);

    if (communicationMethodName === "cmWhatsApp") {
        addExcessClassByClassNameAndIndex(communicationMethodName, "cmWhatsAppPressed", 0);
        deleteExcessClassByClassNameAndIndex("cmTelegram", "cmTelegramPressed", 0);
        deleteExcessClassByClassNameAndIndex("cmInstagram", "cmInstagramPressed", 0);
        deleteExcessClassByClassNameAndIndex("cmEmail", "cmEmailPressed", 0);
        deleteExcessClassByClassNameAndIndex("cmPhone", "cmPhonePressed", 0);
    }
    if (communicationMethodName === "cmTelegram") {
        addExcessClassByClassNameAndIndex(communicationMethodName, "cmTelegramPressed", 0);
        deleteExcessClassByClassNameAndIndex("cmWhatsApp", "cmWhatsAppPressed", 0);
        deleteExcessClassByClassNameAndIndex("cmInstagram", "cmInstagramPressed", 0);
        deleteExcessClassByClassNameAndIndex("cmEmail", "cmEmailPressed", 0);
        deleteExcessClassByClassNameAndIndex("cmPhone", "cmPhonePressed", 0);
    }
    if (communicationMethodName === "cmInstagram") {
        addExcessClassByClassNameAndIndex(communicationMethodName, "cmInstagramPressed", 0);
        deleteExcessClassByClassNameAndIndex("cmWhatsApp", "cmWhatsAppPressed", 0);
        deleteExcessClassByClassNameAndIndex("cmTelegram", "cmTelegramPressed", 0);
        deleteExcessClassByClassNameAndIndex("cmEmail", "cmEmailPressed", 0);
        deleteExcessClassByClassNameAndIndex("cmPhone", "cmPhonePressed", 0);
    }
    if (communicationMethodName === "cmEmail") {
        addExcessClassByClassNameAndIndex(communicationMethodName, "cmEmailPressed", 0);
        deleteExcessClassByClassNameAndIndex("cmWhatsApp", "cmWhatsAppPressed", 0);
        deleteExcessClassByClassNameAndIndex("cmTelegram", "cmTelegramPressed", 0);
        deleteExcessClassByClassNameAndIndex("cmInstagram", "cmInstagramPressed", 0);
        deleteExcessClassByClassNameAndIndex("cmPhone", "cmPhonePressed", 0);
    }
    if (communicationMethodName === "cmPhone") {
        addExcessClassByClassNameAndIndex(communicationMethodName, "cmPhonePressed", 0);
        deleteExcessClassByClassNameAndIndex("cmWhatsApp", "cmWhatsAppPressed", 0);
        deleteExcessClassByClassNameAndIndex("cmTelegram", "cmTelegramPressed", 0);
        deleteExcessClassByClassNameAndIndex("cmInstagram", "cmInstagramPressed", 0);
        deleteExcessClassByClassNameAndIndex("cmEmail", "cmEmailPressed", 0);
    }
}

function setCommunicationMethodBodySelected(communicationMethodName) {
    $('#communicationMethodBodySelected').html(getCommunicationMethodNameByClass(communicationMethodName));
    setCommunicationMethodBodySelectedNewColor(communicationMethodName);
}

function setCommunicationMethodBodySelectedNewColor(communicationMethodName) {
    deleteExcessClassByClassNameAndIndex("communicationMethodBodySelected", "cmWhatsApp", 0)
    deleteExcessClassByClassNameAndIndex("communicationMethodBodySelected", "cmTelegram", 0)
    deleteExcessClassByClassNameAndIndex("communicationMethodBodySelected", "cmInstagram", 0)
    deleteExcessClassByClassNameAndIndex("communicationMethodBodySelected", "cmEmail", 0)
    deleteExcessClassByClassNameAndIndex("communicationMethodBodySelected", "cmPhone", 0)
    deleteExcessClassByClassNameAndIndex("communicationMethodBodySelected", "borderWhatsApp", 0)
    deleteExcessClassByClassNameAndIndex("communicationMethodBodySelected", "borderTelegram", 0)
    deleteExcessClassByClassNameAndIndex("communicationMethodBodySelected", "borderInstagram", 0)
    deleteExcessClassByClassNameAndIndex("communicationMethodBodySelected", "borderEmail", 0)
    deleteExcessClassByClassNameAndIndex("communicationMethodBodySelected", "borderPhone", 0)
    addExcessClassByClassNameAndIndex("communicationMethodBodySelected", "border" + getCommunicationMethodNameByClass(communicationMethodName), 0)
    addExcessClassByClassNameAndIndex("communicationMethodBodySelected", communicationMethodName, 0)
}

function deleteExcessClassByClassNameAndIndex(className, deletedClass, id) {
    if (document.getElementsByClassName(className)[0] != null) {
        document.getElementsByClassName(className)[0]
            .className = document.getElementsByClassName(className)[id]
            .className.replaceAll(" " + deletedClass, "");
    }
}

function addExcessClassByClassNameAndIndex(className, addedClass, id) {
    if (document.getElementsByClassName(className)[0] != null) {
        document.getElementsByClassName(className)[id].className += " " + addedClass;
    }
}

function getCommunicationMethodNameByClass(communicationMethodName) {
    if (communicationMethodName === "cmWhatsApp") {
        return "WhatsApp"
    }
    if (communicationMethodName === "cmTelegram") {
        return "Telegram"
    }
    if (communicationMethodName === "cmInstagram") {
        return "Instagram"
    }
    if (communicationMethodName === "cmEmail") {
        return "Email"
    }
    if (communicationMethodName === "cmPhone") {
        return "Phone"
    }
}

function getValue(divValue, inputValue) {
    let name;
    if (document.getElementById(inputValue) != null) {
        name = document.getElementById(inputValue).value;
    } else {
        name = document.getElementById(divValue).innerText;
    }
    return name;
}

function validateInputData(userName, orderUserPhone, userEmail, communicationMethodBodySelected, instagram) {
    let checkErrorText = "";
    if (!validateName(userName)) {
        checkErrorText += " please enter name";
        addExcessClassByClassNameAndIndex("nameLabel", "errorBackGround", 0);
    } else {
        deleteExcessClassByClassNameAndIndex("nameLabel", "errorBackGround", 0);
    }
    if (!validateEmail(userEmail)) {
        checkErrorText += " please enter email";
        addExcessClassByClassNameAndIndex("emailLabel", "errorBackGround", 0);
    } else {
        deleteExcessClassByClassNameAndIndex("emailLabel", "errorBackGround", 0);
    }
    if (!validateCommunicationMethodBodySelectedPhone(orderUserPhone, communicationMethodBodySelected)) {
        checkErrorText += " please enter phone";
        addExcessClassByClassNameAndIndex("phoneLabel", "errorBackGround", 0);
    } else {
        deleteExcessClassByClassNameAndIndex("phoneLabel", "errorBackGround", 0);
    }
    if (!validateCommunicationMethodInstagram(communicationMethodBodySelected, instagram)) {
        checkErrorText += " please enter your instagram nickname";
        addExcessClassByClassNameAndIndex("communicationMethodName", "errorBackGround", 0);
    } else {
        deleteExcessClassByClassNameAndIndex("communicationMethodName", "errorBackGround", 0);
    }
    validateCommunicationMethod(communicationMethodBodySelected);
    return checkErrorText;
}

function validateName(value) {
    return value.length !== 0;
}

function validateEmail(email) {
    let re = /\S+@\S+\.\S+/;
    return re.test(email);
}

function validateCommunicationMethod(communicationMethod) {
    if (communicationMethod === "") {
        addExcessClassByClassNameAndIndex("communicationMethodHeader", "errorBackGround", 0);
    } else {
        deleteExcessClassByClassNameAndIndex("communicationMethodHeader", "errorBackGround", 0);
    }
}

function validateCommunicationMethodBodySelectedPhone(phone, communicationMethod) {
    return communicationMethod === "Phone"
    || communicationMethod === "WhatsApp"
    || communicationMethod === "Telegram"
        ? phone !== "" : true;
}

function validateCommunicationMethodInstagram(communicationMethod, instagram) {
    return communicationMethod === "Instagram" ? instagram !== "" : true;
}

function editParam(editParam, oldParam) {
    alert(editParam);
    alert(oldParam);

    if (editParam === "name") {
        let nameForm = '<div class="orderText">\n' +
            '<div class="nameLabel">\n' +
            'Enter your new name\n' +
            '</div>\n' +
            '</div>\n' +
            '<div class="orderTextValue" id="orderUserName">\n' +
            '<input class="orderUserNameInput" id="orderUserNameInput" type="text" placeholder="' + oldParam + '">\n' +
            '</div>';
        $('#newOrderCheckBodyOrderName').html(nameForm);
    }
    if (editParam === "phone") {
        alert("her")
        let phoneForm = '<div class="orderText">\n' +
            '<div class="phoneLabel">\n' +
            'Enter your new phone\n' +
            '</div>\n' +
            '</div>\n' +
            '<div class="orderTextValue" id="orderUserPhone">\n' +
            '<input class="orderUserPhoneInput" id="orderUserPhoneInput" type="text" placeholder="' + oldParam + '">\n' +
            '</div>';
        $('#newOrderCheckBodyOrderPhone').html(phoneForm);
    }
    if (editParam === "email") {
        let emailForm = '<div class="orderText">\n' +
            '<div class="emailLabel">\n' +
            'Enter your new email\n' +
            '</div>\n' +
            '</div>\n' +
            '<divs class="orderTextValue" id="orderUserEmail">\n' +
            '<input class="orderUserEmailInput" id="orderUserEmailInput" type="text">\n' +
            '</divs>';
        $('#newOrderEmail').html(emailForm);
    }
}

function confirmOrder() {
    let orderID = document.getElementById("orderID").innerText;
    let orderUserName = getValue("orderUserName", "orderUserNameInput");
    alert(orderUserName);
    orderUserName = orderUserName.replaceAll(" edit", "");
    alert(orderUserName);
    let orderUserPhone = getValue("orderUserPhone", "orderUserPhoneInput");
    orderUserPhone = orderUserPhone.replaceAll(" edit", "");
    let orderUserEmail = getValue("orderUserEmail", "orderUserEmailInput");
    orderUserEmail = orderUserEmail.replaceAll(" edit", "");
    let orderUserComment = document.getElementById('orderUserComment').value;
    let communicationMethodBodySelected = document.getElementById("communicationMethodBodySelected").innerText;
    let instagram = "";
    if (document.getElementById("communicationMethodText") != null) {
        instagram = document.getElementById("communicationMethodText").value;
    }
    let errorString = validateInputData(orderUserName, orderUserPhone, orderUserEmail, communicationMethodBodySelected, instagram);
    if (errorString.length === 0) {
        sendFrom(orderID, orderUserName, orderUserPhone, orderUserEmail, communicationMethodBodySelected, instagram, orderUserComment);
    }
}

function sendFrom(orderID, orderUserName, orderUserPhone, orderUserEmail, communicationMethodAdditionalValue, instagram, orderUserComment) {
    $.post(
        "/confirmNewOrder",
        {
            orderID: orderID,
            clientName: orderUserName,
            clientPhone: orderUserPhone,
            clientEmail: orderUserEmail,
            communicationMethodAdditionalValue: communicationMethodAdditionalValue,
            instagram: instagram,
            comment: orderUserComment
        },
        onAjaxSuccess
    );

    function onAjaxSuccess(data) {
        window.location.replace(data);
    }
}