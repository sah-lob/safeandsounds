$(document).ready(function () {
    $('.has-animation').each(function (index) {
        $(this).delay($(this).data('delay')).queue(function () {
            $(this).addClass('animate-in');
        });
    });
});

$(
    function () {
        updateСalendar(0);
        getSVGIMG("calenderSecondViewSvg", "edit_calendar2");

        getSVGIMG("tourPriceStringIconDate1", "tour_price_calender");
        getSVGIMG("tourPriceStringIconDuration1", "tour_price_duration");
        getSVGIMG("tourPriceStringIconCar1", "tour_price_car");
        getSVGIMG("tourPriceStringIconPrice1", "tour_price_price");

        getSVGIMG("tourPriceStringIconDate2", "tour_price_calender");
        getSVGIMG("tourPriceStringIconDuration2", "tour_price_duration");
        getSVGIMG("tourPriceStringIconCar2", "tour_price_car");
        getSVGIMG("tourPriceStringIconPrice2", "tour_price_price");

        getSVGIMG("tourPriceStringIconDate3", "tour_price_calender");
        getSVGIMG("tourPriceStringIconDuration3", "tour_price_duration");
        getSVGIMG("tourPriceStringIconCar3", "tour_price_car");
        getSVGIMG("tourPriceStringIconPrice3", "tour_price_price");

    }
);

function updateСalendar(direction) {
    let tourId = location.search.split('id=')[1];
    let currentMonth = document.getElementById("calenderHeaderMonthsName").innerText;
    let currentYear = document.getElementById("calenderHeaderYear").innerText;
    $.ajax("/getCalender?currentMonth=" + currentMonth + "&direction=" + direction + "&currentYear=" + currentYear + "&tourId=" + tourId).done(function (data) {
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
                        result +=
                            '<td class="calenderTableAvailableTour test' + value2.month + '">' +
                            '<a onclick="addData(' + value2.num + ',\'' + value2.month + '\',' + data.currentYear + ',\'' + value2.duration + '\',\'' + value2.beginningTour + '\')">' +
                            '<div class="calenderTableAvailableTourSelectDate">' +
                            value2.num +
                            '</div>' +
                            '</a>' +
                            '</td>';

                    } else {
                        result += '<td class="calenderTableUnavailableTour">' + value2.num + '</td>';
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

function addData(monthDay, month, year, duration, beginningTour) {
    let i;
    if (monthDay === -1) {
        $('#tourPriceTableTdDataName1').html('<p>No date selected yet');
        $('#tourPriceTableTdDataName2').html('<p>No date selected yet');
        $('#tourPriceTableTdDataName3').html('<p>No date selected yet');

        let calenderSecondScreen = 'The date has not been selected yet.\n' +
            '                    Select an available date' +
            '<div class="calenderSecondViewSvg" id="calenderSecondViewSvg">\n' +
            '            </div>';

        let calenderTableAvailableTour = document.getElementsByClassName('calenderTableAvailableTour');
        for (i = 0; i < calenderTableAvailableTour.length; i++) {
            document.getElementsByClassName("calenderTableAvailableTour")[i]
                .className = document.getElementsByClassName("calenderTableAvailableTour")[i]
                .className.replaceAll(" otherDayAvailable", "");
            document.getElementsByClassName("calenderTableAvailableTour")[i]
                .className = document.getElementsByClassName("calenderTableAvailableTour")[i]
                .className.replaceAll(" thisDayAvailable", "");
        }

        $('#calenderSecondView').html(calenderSecondScreen);
        getSVGIMG("calenderSecondViewSvg", "edit_calendar2");

    } else {
        let dayMonthYear = '<p>' + monthDay + ' ' + month + ' ' + year;
        $('#tourPriceTableTdDataName1').html(dayMonthYear);
        $('#tourPriceTableTdDataName2').html(dayMonthYear);
        $('#tourPriceTableTdDataName3').html(dayMonthYear);

        var calenderTableAvailableTour = document.getElementsByClassName('calenderTableAvailableTour');
        for (i = 0; i < calenderTableAvailableTour.length; i++) {
            document.getElementsByClassName("calenderTableAvailableTour")[i]
                .className = document.getElementsByClassName("calenderTableAvailableTour")[i]
                .className.replaceAll(" otherDayAvailable", "");
            document.getElementsByClassName("calenderTableAvailableTour")[i]
                .className = document.getElementsByClassName("calenderTableAvailableTour")[i]
                .className.replaceAll(" thisDayAvailable", "");

            if (document.getElementsByClassName("calenderTableAvailableTour")[i].textContent === String(monthDay)
                && document.getElementsByClassName("calenderTableAvailableTour")[i].className.includes("test" + month)) {
                document.getElementsByClassName("calenderTableAvailableTour")[i].className += " thisDayAvailable";
            } else {
                document.getElementsByClassName("calenderTableAvailableTour")[i].className += " otherDayAvailable";
            }
        }

        let calenderSecondScreen = '<div class="calenderSecondViewHeader">\n' +
            '                <div class="calenderSecondViewData">\n' +
            monthDay + ' ' + month + ' ' + year +
            '                </div>\n' +
            '                <div class="calenderSecondViewExitBtn">\n' +
            '                    <a onclick="addData(-1,\'-1\',-1,\'-1\',\'-1\')">' +
            '                        <img src="img/clear.png" alt="e">\n' +
            '                    </a>' +
            '                </div>\n' +
            '            </div>\n' +
            '            <div class="calenderSecondViewBody">\n' +
            '                <div class="calenderSecondViewBodyString">\n' +
            '                    Beginning: ' + beginningTour +
            '                </div>\n' +
            '                <div class="calenderSecondViewBodyString">\n' +
            '                    Duration: ' + duration +
            '                </div>\n' +
            '<div class="calenderSecondViewSvgAvailableCalendar" id="calenderSecondViewSvgAvailableCalendar">\n' +
            '            </div>' +
            '            </div>'

        $('#calenderSecondView').html(calenderSecondScreen);
        getSVGIMG("calenderSecondViewSvgAvailableCalendar", "available_calendar");
    }
}

function newTour(tourType) {
    let tourDate = document.getElementById("tourPriceTableTdDataName3").innerText;
    const queryString = window.location.search;
    const urlParams = new URLSearchParams(queryString);
    const product = urlParams.get('id')
    alert(product);
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