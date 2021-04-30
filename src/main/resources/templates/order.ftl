<#import "parts/common.ftl" as c>
<#import "parts/logo.ftl" as logo>
<#import "parts/gallery.ftl" as gallery>

<@c.page "css/parts/common.css" "/css/parts/gallery.css">
    <link rel="stylesheet" type="text/css" href="../css/order.css"/>
    <@logo.logo "css/parts/logo.css" "css/parts/headerButtons.css"/>
    <script src="/js/parts/order.js"></script>
    <div class="newOrder">
        <table class="newOrderTable">
            <tr>
                <td class="left">
                    Номер заказа
                </td>
                <td id="orderID">
                    ${id}
                </td>
            </tr>
            <tr>
                <td class="left">
                    Дата
                </td>
                <td id="orderDate">
                    ${date}
                </td>
            </tr>
            <tr>
                <td class="left">
                    Тип
                </td>
                <td id="orderType">
                    ${type}
                </td>
            </tr>
            <tr>
                <td class="left">
                    Введите ваше имя:
                </td>
                <td>
                    <form>
                        <input type="search" id="orderUserName">
                    </form>
                </td>
            </tr>
            <tr>
                <td class="left">
                    Введите ваш номер телефона:
                </td>
                <td>
                    <form>
                        <input type="search" id="orderUserPhone">
                    </form>
                </td>
            </tr>
            <tr>
                <td class="left">
                    Введите ваш email:
                </td>
                <td>
                    <form>
                        <input type="search" id="orderUserEmail">
                    </form>
                </td>
            </tr>
            <tr>
                <td class="left">
                    Предпочтительный способ связи:
                </td>
                <td>
                    <div class="communication" id="communication">
                        <div class="communicationName" id="communicationName">
                            Предпочтительный способ связи
                        </div>
                        <div class="communicationMethod">
                            <div class="communicationMethod1" id="communicationMethod1">
                                <div class="s2communicationMethod1" id="s2communicationMethod1">
                                    <a onclick="selectCommunicationMethod(1)">
                                        <img src="img/callbackB.png" alt="e">
                                    </a>
                                </div>
                            </div>
                        </div>
                        <div class="communicationMethod">
                            <div class="communicationMethod2" id="communicationMethod2">
                                <div class="s2communicationMethod2" id="s2communicationMethod2">
                                    <a onclick="selectCommunicationMethod(2)">
                                        <img src="img/callbackB.png" alt="e">
                                    </a>
                                </div>
                            </div>
                        </div>
                        <div class="communicationMethod">
                            <div class="communicationMethod3" id="communicationMethod3">
                                <div class="s2communicationMethod3" id="s2communicationMethod3">
                                    <a onclick="selectCommunicationMethod(3)">
                                        <img src="img/callbackB.png" alt="e">
                                    </a>
                                </div>
                            </div>
                        </div>
                        <div class="communicationMethod">
                            <div class="communicationMethod4" id="communicationMethod4">
                                <div class="s2communicationMethod4" id="s2communicationMethod4">
                                    <a onclick="selectCommunicationMethod(4)">
                                        <img src="img/callbackB.png" alt="e">
                                    </a>
                                </div>
                            </div>
                        </div>
                        <div class="communicationMethod">
                            <div class="communicationMethod5" id="communicationMethod5">
                                <div class="s2communicationMethod5" id="s2communicationMethod5">
                                    <a onclick="selectCommunicationMethod(5)">
                                        <img src="img/callbackB.png" alt="e">
                                    </a>
                                </div>
                            </div>
                        </div>
                        <div class="forceField" id="forceField">
                            Выберете способ.
                        </div>
                    </div>
                </td>
            </tr>
        </table>
        <a onclick="confirmOrder()">
            <div class="confirmBtn">
                Забронировать
            </div>
        </a>
    </div>
</@c.page>