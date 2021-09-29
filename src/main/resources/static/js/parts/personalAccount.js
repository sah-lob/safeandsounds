$(
    function () {
        getSVGIMG("personalAccountAvatar", "account2");
    }
);

function editBtn(classId, inputValue) {
    if (classId === 'personalAccountName') {
        let nameText = '<div class="personalAccountEditLabel">\n' +
            '                        Name:\n' +
            '                    </div>\n' +
            '                    <div class="orderTextValue" id="orderUserName">\n' +
            '                        <input class="orderUserNameInput" id="orderUserNameInput" type="text"\n' +
            '                               value="' + inputValue + '">\n' +
            '                    </div>\n' +
            '                    <div class="personalAccountEditSaveBtn">\n' +
            '                        <a onclick="saveBtn(\'personalAccountName\', \'orderUserNameInput\')">\n' +
            '                            safe\n' +
            '                        </a>\n' +
            '                    </div>';
        $('#' + classId).html(nameText);
    }
    if (classId === 'personalAccountPhone') {
        let nameText = '<div class="personalAccountEditLabel">\n' +
            '                        Phone:\n' +
            '                    </div>\n' +
            '                    <div class="orderTextValue" id="orderUserName">\n' +
            '                        <input class="orderUserNameInput" id="orderUserPhoneInput" type="text"\n' +
            '                               value="' + inputValue + '">\n' +
            '                    </div>\n' +
            '                    <div class="personalAccountEditSaveBtn">\n' +
            '                        <a onclick="saveBtn(\'personalAccountPhone\', \'orderUserPhoneInput\')">\n' +
            '                            safe\n' +
            '                        </a>\n' +
            '                    </div>';
        $('#' + classId).html(nameText);
    }
    if (classId === 'personalAccountEmail') {
        let nameText = '<div class="personalAccountEditLabel">\n' +
            '                        Phone:\n' +
            '                    </div>\n' +
            '                    <div class="orderTextValue" id="orderUserName">\n' +
            '                        <input class="orderUserNameInput" id="orderUserEmailInput" type="text"\n' +
            '                               value="' + inputValue + '">\n' +
            '                    </div>\n' +
            '                    <div class="personalAccountEditSaveBtn">\n' +
            '                        <a onclick="saveBtn(\'personalAccountEmail\', \'orderUserEmailInput\')">\n' +
            '                            safe\n' +
            '                        </a>\n' +
            '                    </div>';
        $('#' + classId).html(nameText);
    }
    if (classId === 'personalAccountInstagram') {
        let nameText = '<div class="personalAccountEditLabel">\n' +
            '                        Insta:\n' +
            '                    </div>\n' +
            '                    <div class="orderTextValue" id="orderUserName">\n' +
            '                        <input class="orderUserNameInput" id="orderUserInstagramInput" type="text"\n' +
            '                               value="' + inputValue + '">\n' +
            '                    </div>\n' +
            '                    <div class="personalAccountEditSaveBtn">\n' +
            '                        <a onclick="saveBtn(\'personalAccountInstagram\', \'orderUserInstagramInput\')">\n' +
            '                            safe\n' +
            '                        </a>\n' +
            '                    </div>';
        $('#' + classId).html(nameText);
    }
}

function saveBtn(classId, inputId) {
    if (inputId.length > 0) {
        if (classId === 'personalAccountName') {
            postClientName(classId, inputId);
        }
        if (classId === 'personalAccountPhone') {
            if (validatePhone(document.getElementById(inputId).value)) {
                postClientPhone(classId, inputId);
            }
        }
        if (classId === 'personalAccountEmail') {
            if (validateEmail(document.getElementById(inputId).value)) {
                postClientEmail(classId, inputId);
            }
        }
        if (classId === 'personalAccountInstagram') {
            if (validateInstagram(document.getElementById(inputId).value)) {
                postClientInstagram(classId, inputId);
            }
        }
    }
}

function postClientName(classId, inputId) {
    $.post(
        "/editClientName",
        {
            newClientName: document.getElementById(inputId).value,
        },
        onAjaxSuccess
    );

    function onAjaxSuccess(data) {
        let newDiv = '<div class="personalAccountAttribute">\n' +
            '                                            Name:\n' +
            '                                        </div>\n' +
            '                                        <div class="personalAccountNameValue">\n' +
            '                                                &nbsp;' + document.getElementById(inputId).value + '&nbsp;\n' +
            '                                        </div>\n' +
            '                                        <div class="personalAccountEditBtn">\n' +
            '                                            <a onclick="editBtn(\'personalAccountName\', \'' + inputId + '\')">\n' +
            '                                                edit\n' +
            '                                            </a>\n' +
            '                                        </div>'
        $('#' + classId).html(newDiv);
    }
}

function postClientPhone(classId, inputId) {
    $.post(
        "/editClientPhone",
        {
            newClientPhone: document.getElementById(inputId).value,
        },
        onAjaxSuccess
    );

    function onAjaxSuccess(data) {
        let newDiv = '<div class="personalAccountAttribute">\n' +
            '                                            Phone:\n' +
            '                                        </div>\n' +
            '                                        <div class="personalAccountNameValue">\n' +
            '                                                &nbsp;' + document.getElementById(inputId).value + '&nbsp;\n' +
            '                                        </div>\n' +
            '                                        <div class="personalAccountEditBtn">\n' +
            '                                            <a onclick="editBtn(\'personalAccountPhone\', \'' + inputId + '\')">\n' +
            '                                                edit\n' +
            '                                            </a>\n' +
            '                                        </div>'
        $('#' + classId).html(newDiv);
    }
}

function postClientEmail(classId, inputId) {
    $.post(
        "/editClientEmail",
        {
            newClientEmail: document.getElementById(inputId).value
        },
        onAjaxSuccess
    );

    function onAjaxSuccess(data) {
        let newDiv = '<div class="personalAccountAttribute">\n' +
            '                                            Phone:\n' +
            '                                        </div>\n' +
            '                                        <div class="personalAccountNameValue">\n' +
            '                                                &nbsp;' + document.getElementById(inputId).value + '&nbsp;\n' +
            '                                        </div>\n' +
            '                                        <div class="personalAccountEditBtn">\n' +
            '                                            <a onclick="editBtn(\'personalAccountEmail\', \'' + inputId + '\')">\n' +
            '                                                edit\n' +
            '                                            </a>\n' +
            '                                        </div>'
        $('#' + classId).html(newDiv);
    }
}

function postClientInstagram(classId, inputId) {
    $.post(
        "/editClientInstagram",
        {
            newClientInstagram: document.getElementById(inputId).value
        },
        onAjaxSuccess
    );

    function onAjaxSuccess(data) {
        let newDiv = '<div class="personalAccountAttribute">\n' +
            '                                            Insta:\n' +
            '                                        </div>\n' +
            '                                        <div class="personalAccountNameValue">\n' +
            '                                                &nbsp;' + document.getElementById(inputId).value + '&nbsp;\n' +
            '                                        </div>\n' +
            '                                        <div class="personalAccountEditBtn">\n' +
            '                                            <a onclick="editBtn(\'personalAccountInstagram\', \'' + inputId + '\')">\n' +
            '                                                edit\n' +
            '                                            </a>\n' +
            '                                        </div>'
        $('#' + classId).html(newDiv);
    }
}

function validatePhone(phone) {
    return phone.length > 0;
}

function validateEmail(email) {
    let re = /\S+@\S+\.\S+/;
    return re.test(email);
}

function validateInstagram(login) {
    return login.length > 0;
}

function addAvatar() {
    // let str = '<form>\n' +
    //     '                            <div class="upload-file__wrapper">\n' +
    //     '                                <input\n' +
    //     '                                        type="file"\n' +
    //     '                                        name="files[]"\n' +
    //     '                                        id="upload-file__input_1"\n' +
    //     '                                        class="upload-file__input"\n' +
    //     '                                        accept=".jpg, .jpeg, .png, .gif, .bmp, .doc, .docx, .xls, .xlsx, .txt, .tar, .zip, .7z, .7zip"\n' +
    //     '                                        multiple\n' +
    //     '                                >\n' +
    //     '                                <label class="upload-file__label" for="upload-file__input_1">\n' +
    //     '                                    <svg class="upload-file__icon" xmlns="http://www.w3.org/2000/svg"\n' +
    //     '                                         viewBox="0 0 512 512">\n' +
    //     '                                        <path d="M286 384h-80c-14.2 1-23-10.7-24-24V192h-87.7c-17.8 0-26.7-21.5-14.1-34.1L242.3 5.7c7.5-7.5 19.8-7.5 27.3 0l152.2 152.2c11.6 11.6 3.7 33.1-13.1 34.1H320v168c0 13.3-10.7 24-24 24zm216-8v112c0 13.3-10.7 24-24 24H24c-13.3 0-24-10.7-23-23V366c0-13.3 10.7-24 24-24h136v8c0 31 24.3 56 56 56h80c30.9 0 55-26.1 57-55v-8h135c13.3 0 24 10.6 24 24zm-124 88c0-11-9-20-19-20s-19 9-20 20 9 19 20 20 21-9 20-20zm64 0c0-12-9-20-20-20s-20 9-19 20 9 20 20 20 21-9 20-20z">\n' +
    //     '                                        </path>\n' +
    //     '                                    </svg>\n' +
    //     '                                    <span class="upload-file__text">New avatar file</span>\n' +
    //     '                                </label>\n' +
    //     '                            </div>\n' +
    //     '                            <button class="newAvatarBtn" type="submit">Upload</button>\n' +
    //     '                        </form>'
    // $('#personalAccountAvatarBlock').html(str);
    document.getElementById("personalAccountAvatarPlace").className += " hidden";
    document.getElementById("personalAccountAvatarEdit").className = "hidden";
    document.getElementById("formidasf").className = "";
    document.getElementById("personalAccountAvatarPlace")
    $('#personalAccountAvatarPlace').html('');
    // document.getElementById("formidasf").style.display = "";
}


document.addEventListener('DOMContentLoaded', () => {

    const forms = document.querySelectorAll('form');
    const inputFile = document.querySelectorAll('.upload-file__input');

    /////////// Кнопка «Прикрепить файл» ///////////
    inputFile.forEach(function (el) {
        let textSelector = document.querySelector('.upload-file__text');
        let fileList;

        // Событие выбора файла(ов)
        el.addEventListener('change', function (e) {

            // создаём массив файлов
            fileList = [];
            for (let i = 0; i < el.files.length; i++) {
                fileList.push(el.files[i]);
            }

            // вызов функции для каждого файла
            fileList.forEach(file => {
                uploadFile(file);
            });
        });

        // Проверяем размер файлов и выводим название
        const uploadFile = (file) => {

            // файла <5 Мб
            if (file.size > 5 * 1024 * 1024) {
                alert('Файл должен быть не более 5 МБ.');
                return;
            }

            // Показ загружаемых файлов
            if (file && file.length > 1) {
                if (file.length <= 4) {
                    textSelector.textContent = `Выбрано ${file.length} файла`;
                }
                if (file.length > 4) {
                    textSelector.textContent = `Выбрано ${file.length} файлов`;
                }
            } else {
                textSelector.textContent = file.name;
            }
        }

    });

    // Отправка формы на сервер
    const postData = async (url, fData) => { // имеет асинхронные операции
        // начало отправки
        // здесь можно оповестить пользователя о начале отправки

        // ждём ответ, только тогда наш код пойдёт дальше
        let fetchResponse = await fetch(url, {
            method: 'POST',
            body: fData
        });

        // ждём окончания операции
        return await fetchResponse.text();
    };

    if (forms) {
        forms.forEach(el => {
            el.addEventListener('submit', function (e) {
                e.preventDefault();

                // создание объекта FormData
                let fData = new FormData();

                // Добавление всех input, кроме type="file"
                el.querySelectorAll('input:not([type="file"])').forEach(input => {
                    fData.append(input.name, input.value);
                });

                // Добавление файлов input type file
                let file = el.querySelector('.upload-file__input');
                for (let i = 0; i < (file.files.length); i++) {
                    fData.append('files[]', file.files[i]); // добавляем файлы в объект FormData()
                }

                // Отправка на сервер
                postData('/newAvatar', fData)
                    .then(fetchResponse => {
                        console.log('Данные успешно отправлены!');
                        console.log(fetchResponse);
                        window.location.replace("/personalAccount")
                    })
                    .catch(function (error) {
                        console.log('Ошибка!');
                        console.log(error);
                    });
            });
        });
    };
});