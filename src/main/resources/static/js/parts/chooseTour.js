$(document).ready(function () {
    $('.has-animation').each(function (index) {
        $(this).delay($(this).data('delay')).queue(function () {
            $(this).addClass('animate-in');
        });
    });
});

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
        } else {
            document.getElementsByClassName('calenderHeaderMonthsBack')[0].style.display = "none"
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

function newTour(tourType) {
    let tourDate = document.getElementById("tourPriceTableTdDataName3").innerText;
    if (tourDate !== "No date selected yet") {
        let tourId = location.search.split('id=')[1]
        $.post(
            "/newOrder",
            {
                tourType: tourType,
                tourDate: tourDate,
                tourId: tourId
            },
            onAjaxSuccess
        );

        function onAjaxSuccess(data) {
            window.location.replace(data);
        }
    } else {
        alert("Please select a date");
    }
}