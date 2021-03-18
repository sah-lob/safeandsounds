<#import "parts/common.ftl" as c>
<#import "parts/logo.ftl" as logo>
<#import "parts/headerButtons.ftl" as headerButtons>
<#import "parts/gallery.ftl" as gallery>

<@c.page "css/parts/common.css" "/css/parts/gallery.css">
    <@logo.logo "css/parts/logo.css" "css/parts/headerButtons.css"/>
    <link rel="stylesheet" type="text/css" href="css/choosetour/chooseTour.css"/>
    <link rel="stylesheet" type="text/css" href="css/choosetour/chooseTour2.css"/>
    <link rel="stylesheet" type="text/css" href="css/choosetour/calendar.css"/>
    <link rel="stylesheet" type="text/css" href="css/choosetour/chooseTourPrice.css"/>
    <link rel="stylesheet" type="text/css" href="css/parts/customButton.css"/>

    <script src="/js/parts/chooseTour.js"></script>

    <div class="cb">
        <div class="chooseTourBody">
            <div class="has-animation animation-ltr" data-delay="10">
                <p class="bigger">${tour.name}</p>
            </div>
            <div class="has-animation animation-rtl" data-delay="2000">
                <@gallery.page tour.imagesId/>
            </div>
            <div class="has-animation animation-rtl" data-delay="1000">
                <div class="tourDescription">
                    ${tour.description}
                </div>
                <div class="calender">
                    <div class="calenderHeader">
                        <div class="calenderHeaderData" id="calenderHeaderData">
                            <div class="calenderHeaderDataNotSelectedButton">
                                <img src="img/lamp.png" alt="e">
                            </div>
                            <div class="calenderHeaderDataNotSelected">
                                The date has not yet been selected. Select a date in the calendar
                            </div>
                        </div>
                        <div class="calenderHeaderYear" id="calenderHeaderYear">
                            -99
                        </div>
                        <div class="calenderHeaderMonths">
                            <div class="calenderHeaderMonthsNext">
                                <a onclick="submitOptIn(1)">
                                    <img src="img/east.png" alt="e">
                                </a>
                            </div>
                            <div class="calenderHeaderMonthsName" id="calenderHeaderMonthsName">
                                January
                            </div>
                            <div class="calenderHeaderMonthsBack" id="calenderHeaderMonthsBack">
                                <a onclick="submitOptIn(-1)">
                                    <img src="img/west.png" alt="e">
                                </a>
                            </div>
                            <div class="calenderTableHeader">
                                <div class="calenderTableHeaderDay">Mon</div>
                                <div class="calenderTableHeaderDay">Tue</div>
                                <div class="calenderTableHeaderDay">Wed</div>
                                <div class="calenderTableHeaderDay">Thu</div>
                                <div class="calenderTableHeaderDay">Fri</div>
                                <div class="calenderTableHeaderDay">Sat</div>
                                <div class="calenderTableHeaderDay">Sun</div>
                            </div>
                        </div>
                    </div>
                    <div class="calenderBody">
                        <table class="calenderTable" id="calenderTable">
                            <tbody>
                            <tr>
                                <td>
                                    1
                                    <div class="calenderTableCard">
                                        <div class="calenderTableCardStartTime">
                                            Начало в 12:00
                                        </div>
                                        <div class="calenderTableCardEndTime">
                                            Конец в 13:00
                                        </div>
                                        <div class="calenderTableCardChangeData">
                                            Выбрать эту дату
                                        </div>
                                        Какой-то текст который должен быть в блоке<br>
                                        <a href="#">Интересная ссылка</a>
                                    </div>
                                </td>
                                <td>2</td>
                                <td>3</td>
                                <td>4</td>
                                <td>5</td>
                                <td>6</td>
                                <td>7</td>
                            </tr>
                            <tr>
                                <td>1</td>
                                <td>2</td>
                                <td>3</td>
                                <td>4</td>
                                <td>5</td>
                                <td>6</td>
                                <td>7</td>
                            </tr>
                            <tr>
                                <td>1</td>
                                <td>2</td>
                                <td>3</td>
                                <td>4</td>
                                <td>5</td>
                                <td>6</td>
                                <td>7</td>
                            </tr>
                            <tr>
                                <td>1</td>
                                <td>2</td>
                                <td>3</td>
                                <td>4</td>
                                <td>5</td>
                                <td>6</td>
                                <td>7</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="tourPrice">
                    <table class="tourPriceTable">
                        <tr>
                            <td>

                                <div class="tourPriceTableTd">
                                    <div class="tourPriceTableTdName">
                                        Эконом
                                    </div>
                                    <div class="tourPriceTableTdData">
                                        <div class="tourPriceTableTdAutoLogo">
                                            <img src="img/event.png" alt="e">
                                        </div>
                                        <div class="tourPriceTableTdDataName" id="tourPriceTableTdDataName1">
                                            No date selected yet
                                        </div>
                                    </div>
                                    <div class="tourPriceTableTdData">
                                        <div class="tourPriceTableTdAutoLogo">
                                            <img src="img/timelapse.png" alt="e">
                                        </div>
                                        <div class="tourPriceTableTdDataName" id="tourPriceTableTdDataDuration">
                                            ${tour.duration}
                                        </div>
                                    </div>
                                    <div class="tourPriceTableTdAuto">
                                        <div class="tourPriceTableTdAutoLogo">
                                            <img src="img/car2.png" alt="e">
                                        </div>
                                        <div class="tourPriceTableTdAutoName">
                                            Ford Mondeo
                                        </div>
                                    </div>
                                    <div class="tourPriceTableTdPrice">
                                        <div class="tourPriceTableTdPriceLogo">
                                            <img src="img/tourPriceTableTdPriceLogo.png" alt="e">
                                        </div>
                                        <div class="tourPriceTableTdValue">
                                            300$
                                        </div>
                                    </div>
                                    <div class="customButton customButtonPullDown">
                                        <a>Выбрать</a>
                                    </div>
                                </div>
                            </td>
                            <td>
                                <div class="tourPriceTableTd">
                                    <div class="tourPriceTableTdName">
                                        Премиум
                                    </div>
                                    <div class="tourPriceTableTdData">
                                        <div class="tourPriceTableTdAutoLogo">
                                            <img src="img/event.png" alt="e">
                                        </div>
                                        <div class="tourPriceTableTdDataName" id="tourPriceTableTdDataName2">
                                            No date selected yet
                                        </div>
                                    </div>
                                    <div class="tourPriceTableTdData">
                                        <div class="tourPriceTableTdAutoLogo">
                                            <img src="img/timelapse.png" alt="e">
                                        </div>
                                        <div class="tourPriceTableTdDataName" id="tourPriceTableTdDataDuration">
                                            ${tour.duration}
                                        </div>
                                    </div>
                                    <div class="tourPriceTableTdAuto">
                                        <div class="tourPriceTableTdAutoLogo">
                                            <img src="img/car2.png" alt="e">
                                        </div>
                                        <div class="tourPriceTableTdAutoName">
                                            BMW M5 F90
                                        </div>
                                    </div>
                                    <div class="tourPriceTableTdPrice">
                                        <div class="tourPriceTableTdPriceLogo">
                                            <img src="img/tourPriceTableTdPriceLogo.png" alt="e">
                                        </div>
                                        <div class="tourPriceTableTdValue">
                                            1 300$
                                        </div>
                                    </div>
                                    <div class="customButton customButtonPullDown">
                                        <a>Выбрать</a>
                                    </div>
                                </div>
                            </td>
                            <td>
                                <div class="tourPriceTableTd">
                                    <div class="tourPriceTableTdName">
                                        Групповая
                                    </div>
                                    <div class="tourPriceTableTdData">
                                        <div class="tourPriceTableTdAutoLogo">
                                            <img src="img/event.png" alt="e">
                                        </div>
                                        <div class="tourPriceTableTdDataName" id="tourPriceTableTdDataName3">
                                            No date selected yet
                                        </div>
                                    </div>
                                    <div class="tourPriceTableTdData">
                                        <div class="tourPriceTableTdAutoLogo">
                                            <img src="img/timelapse.png" alt="e">
                                        </div>
                                        <div class="tourPriceTableTdDataName" id="tourPriceTableTdDataDuration">
                                            ${tour.duration}
                                        </div>
                                    </div>
                                    <div class="tourPriceTableTdAuto">
                                        <div class="tourPriceTableTdAutoLogo">
                                            <img src="img/car2.png" alt="e">
                                        </div>
                                        <div class="tourPriceTableTdAutoName">
                                            Ford Transit
                                        </div>
                                    </div>
                                    <div class="tourPriceTableTdPrice">
                                        <div class="tourPriceTableTdPriceLogo">
                                            <img src="img/tourPriceTableTdPriceLogo.png" alt="e">
                                        </div>
                                        <div class="tourPriceTableTdValue">
                                            1 300$
                                        </div>
                                    </div>
                                    <div class="customButton customButtonPullDown">
                                        <a>Выбрать</a>
                                    </div>
                                </div>
                            </td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
    </div>

    <script type="text/javascript">

        $(
            function () {
                submitOptIn(-99);
            }
        );

        function submitOptIn(direction) {
            let tourId = location.search.split('id=')[1];
            let currentMonth = document.getElementById("calenderHeaderMonthsName").innerText;
            let currentYear = document.getElementById("calenderHeaderYear").innerText;
            $.ajax("/test?currentMonth=" + currentMonth + "&direction=" + direction + "&currentYear=" + currentYear + "&tourId=" + tourId).done(function (data) {
                let result = '';
                result += '<table class="calenderTable">'
                result += '<tbody>'
                $.each(data.month.weeks, function (index, value) {
                        result += '<tr>';
                        $.each(value.days, function (index2, value2) {
                            if (value2.lastDay) {
                                result += '<td class="calenderTableLastDay">' + value2.num + '</td>';
                            } else if (value2.today) {
                                result += '<td class="calenderTableToday">' + value2.num + '</td>';
                            } else if (value2.availableTour) {
                                var currentMo = data.currentMonthName.toString();
                                result += '<td class="calenderTableAvailableTour">' +
                                    value2.num +
                                    '                    <div class="calenderTableCard">\n' +
                                    '<div class="calenderTableCardDate">\n' + value2.num + ' ' + data.currentMonthName + ' ' + data.currentYear +
                                    '                        </div>' +
                                    '                        <div class="calenderTableCardStartTime">\n' +
                                    '                            Начало: 12:00\n' +
                                    '                        </div>\n' +
                                    '<div class="customButton customButtonPullDown">\n' +
                                    '                                <a onclick="addData(\'' + value2.num + ' ' + currentMo + ' ' + data.currentYear + '\')">Выбрать</a>\n' +
                                    '                            </div>' +
                                    '                    </div>\n' +
                                    '        </td>';
                                // result += '<td class="calenderTableAvailableTour">' + value2.num + '</td>';
                            } else {
                                result += '<td>' + value2.num + '</td>';
                            }
                        });
                        result += '</tr>';
                    }
                );

                result += '</tbody>'
                result += '</table>'

                $('#calenderTable').html(result);

                let monthName = '';
                monthName += data.currentMonthName
                $('#calenderHeaderMonthsName').html(monthName)

                let year = '';
                year += data.currentYear
                $('#calenderHeaderYear').html(year)

                if (data.backMonth) {
                    document.getElementsByClassName('calenderHeaderMonthsBack')[0].style.display = "inline"
                    // $('#calenderHeaderMonthsBack').html('<a onclick="submitOptIn(-1)">\n' +
                    //     '<img src="img/west.png" alt="e">' +
                    //     '                        </a>')
                } else {
                    // inline
                    document.getElementsByClassName('calenderHeaderMonthsBack')[0].style.display = "none"
                    // $('#calenderHeaderMonthsBack').html('<img src="img/event.png" alt="e">');
                }
            });
        }

        function addData(data) {
            if (data == -1) {
                $('#tourPriceTableTdDataName1').html('No date selected yet');
                $('#tourPriceTableTdDataName2').html('No date selected yet');
                $('#tourPriceTableTdDataName3').html('No date selected yet');

                let calenderHeaderData = '<div class="calenderHeaderDataNotSelectedButton">\n' +
                    '                        <img src="img/lamp.png" alt="e">\n' +
                    '                    </div>\n' +
                    '                    <div class="calenderHeaderDataNotSelected">\n' +
                    '                        The date has not yet been selected. Select a date in the calendar\n' +
                    '                    </div>';

                $('#calenderHeaderData').html(calenderHeaderData);

            } else {
                alert(data);

                $('#tourPriceTableTdDataName1').html(data);
                $('#tourPriceTableTdDataName2').html(data);
                $('#tourPriceTableTdDataName3').html(data);

                let calenderHeaderData = '<div class="calenderHeaderDataButton">\n' +
                    '<a onclick="addData(-1)">' +
                    '                        <img src="img/clear.png" alt="e">\n' +
                    '</a>' +
                    '                    </div>\n' +
                    '                    <div class="calenderHeaderDataText">\n' +
                    '                        Выбранная дата: ' + data +
                    '                    </div>';

                $('#calenderHeaderData').html(calenderHeaderData);
            }
        }
    </script>
</@c.page>