<#macro calender>
    <div class="calender">
        <div class="calendarFirstView">
            <div class="calenderHeader">
                <div class="calenderHeaderMonthsBack">
                    <a onclick="updateСalendar(-1)">
                        <
                    </a>
                </div>
                <div class="calenderHeaderMonthsName" id="calenderHeaderMonthsName">
                </div>
                <div class="calenderHeaderYear" id="calenderHeaderYear">
                </div>
                <div class="calenderHeaderMonthsNext">
                    <a onclick="updateСalendar(1)">
                        >
                    </a>
                </div>
            </div>
            <div class="calenderWeekDays">
                <div class="calenderWeekDay">
                    Mon
                </div>
                <div class="calenderWeekDay">
                    Tue
                </div>
                <div class="calenderWeekDay">
                    Wed
                </div>
                <div class="calenderWeekDay">
                    Thu
                </div>
                <div class="calenderWeekDay">
                    Fri
                </div>
                <div class="calenderWeekDay">
                    Sat
                </div>
                <div class="calenderWeekDay">
                    Sun
                </div>
            </div>
            <div class="calenderBody">
                <table class="calenderTable" id="calenderTable">
                </table>
            </div>
        </div>
        <div class="calenderSecondView" id="calenderSecondView">
            The date has not been selected yet.
            <br>
            Select an available date
            <div class="calenderSecondViewSvg" id="calenderSecondViewSvg">
            </div>
        </div>
    </div>
</#macro>