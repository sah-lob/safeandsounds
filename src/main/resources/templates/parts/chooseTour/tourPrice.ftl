<#macro tourPrice>
    <div class="tourPrice">
        <div class="tourPriceEconomy">
            <div class="tourPriceEconomyCard">
                <p>Economy
            </div>
            <div class="tourPriceString">
                <div class="tourPriceStringIcon">
                    <div class="tourPriceStringIconDate" id="tourPriceStringIconDate1">
                    </div>
                </div>
                <div class="tourPriceStringText">
                    <div class="tourPriceTableTdDataName" id="tourPriceTableTdDataName1">
                        <p>No date selected yet
                    </div>
                </div>
            </div>
            <div class="tourPriceString">
                <div class="tourPriceStringIcon">
                    <div class="tourPriceStringIconDuration" id="tourPriceStringIconDuration1">
                    </div>
                </div>
                <div class="tourPriceStringText">
                    <p>${tour.duration}
                </div>
            </div>
            <div class="tourPriceString">
                <div class="tourPriceStringIcon">
                    <div class="tourPriceStringIconCar" id="tourPriceStringIconCar1">
                    </div>
                </div>
                <div class="tourPriceStringText">
                    <p>Ford Mondeo
                </div>
            </div>
            <div class="tourPriceString">
                <div class="tourPriceStringIcon">
                    <div class="tourPriceStringIconPrice" id="tourPriceStringIconPrice1">
                    </div>
                </div>
                <div class="tourPriceStringText">
                    <p>${tour.economyPrice}$
                </div>
            </div>
            <div class="tourPriceBtn">
                <a onclick="newTour('Эконом')">
                    <div class="tourPriceActiveBtn">
                        <p>Select
                    </div>
                </a>
            </div>
        </div>
        <div class="tourPricePremium">
            <div class="tourPricePremiumCard">
                <div class="tourPriceCardText">
                    <p>Premium
                </div>
            </div>
            <div class="tourPriceString tourPriceStringPr">
                <div class="tourPriceStringIcon tourPriceStringIconPr">
                    <div class="tourPriceStringIconDate" id="tourPriceStringIconDate2">
                    </div>
                </div>
                <div class="tourPriceStringText">
                    <div class="tourPriceTableTdDataName" id="tourPriceTableTdDataName2">
                        <p>No date selected yet
                    </div>
                </div>
            </div>
            <div class="tourPriceString tourPriceStringPr">
                <div class="tourPriceStringIcon tourPriceStringIconPr">
                    <div class="tourPriceStringIconDuration" id="tourPriceStringIconDuration2">
                    </div>
                </div>
                <div class="tourPriceStringText">
                    <p>${tour.duration}
                </div>
            </div>
            <div class="tourPriceString tourPriceStringPr">
                <div class="tourPriceStringIcon tourPriceStringIconPr">
                    <div class="tourPriceStringIconCar" id="tourPriceStringIconCar2">
                    </div>
                </div>
                <div class="tourPriceStringText">
                    <p>BMW M5 F90
                </div>
            </div>
            <div class="tourPriceString tourPriceStringPr">
                <div class="tourPriceStringIcon tourPriceStringIconPr">
                    <div class="tourPriceStringIconPrice" id="tourPriceStringIconPrice2">
                    </div>
                </div>
                <div class="tourPriceStringText">
                    <p>${tour.premiumPrice}$
                </div>
            </div>
            <div class="tourPriceBtn">
                <a onclick="newTour('Премиум')">
                    <div class="tourPriceActiveBtn tourPriceActiveBtnPr">
                        <p>Select
                    </div>
                </a>
            </div>
        </div>
        <div class="tourPriceGroup">
            <div class="tourPriceGroupCard">
                <div class="tourPriceCardText">
                    <p>Group
                </div>
            </div>
            <div class="tourPriceString">
                <div class="tourPriceStringIcon">
                    <div class="tourPriceStringIconDate" id="tourPriceStringIconDate3">
                    </div>
                </div>
                <div class="tourPriceStringText">
                    <div class="tourPriceTableTdDataName" id="tourPriceTableTdDataName3">
                        <p>No date selected yet
                    </div>
                </div>
            </div>
            <div class="tourPriceString">
                <div class="tourPriceStringIcon">
                    <div class="tourPriceStringIconDuration" id="tourPriceStringIconDuration3">
                    </div>
                </div>
                <div class="tourPriceStringText">
                    <p>${tour.duration}
                </div>
            </div>
            <div class="tourPriceString">
                <div class="tourPriceStringIcon">
                    <div class="tourPriceStringIconCar" id="tourPriceStringIconCar3">
                    </div>
                </div>
                <div class="tourPriceStringText">
                    <p>Ford Transit
                </div>
            </div>
            <div class="tourPriceString">
                <div class="tourPriceStringIcon">
                    <div class="tourPriceStringIconPrice" id="tourPriceStringIconPrice3">
                    </div>
                </div>
                <div class="tourPriceStringText">
                    <p>${tour.groupPrice}$
                </div>
            </div>
            <div class="tourPriceBtn">
                <a onclick="newTour('Групповая')">
                    <div class="tourPriceActiveBtn">
                        <p>Select
                    </div>
                </a>
            </div>
        </div>
    </div>
</#macro>