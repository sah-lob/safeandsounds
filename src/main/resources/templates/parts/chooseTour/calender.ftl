<#macro calender>
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
                    <a onclick="updateСalendar(1)">
                        <img src="img/east.png" alt="e">
                    </a>
                </div>
                <div class="calenderHeaderMonthsName" id="calenderHeaderMonthsName">
                    January
                </div>
                <div class="calenderHeaderMonthsBack" id="calenderHeaderMonthsBack">
                    <a onclick="updateСalendar(-1)">
                        <img src="img/west.png" alt="e">
                    </a>
                </div>
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
        <div class="calenderBody">
            <table class="calenderTable" id="calenderTable">
            </table>
        </div>
    </div>
</#macro>