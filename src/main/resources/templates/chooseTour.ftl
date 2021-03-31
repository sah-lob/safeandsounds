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
                                        <a onclick="newTour('Групповая')">Выбрать</a>
                                    </div>
                                </div>
                            </td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
    </div>
</@c.page>