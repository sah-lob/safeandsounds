<#import "parts/common.ftl" as c>
<#import "parts/logo.ftl" as logo>
<#import "parts/gallery.ftl" as gallery>

<@c.page "css/parts/common.css" "/css/parts/gallery.css">
    <link rel="stylesheet" type="text/css" href="../css/order.css"/>
    <@logo.logo "css/parts/logo.css" "css/parts/headerButtons.css" personalAccount/>
    <script src="/js/parts/order.js"></script>
    <div class="newOrder">
        <table class="newOrderTable">
            <tr>
                <td class="left">
                    Order number
                </td>
                <td id="orderID">
                    ${id}
                </td>
            </tr>
            <tr>
                <td class="left">
                    Title
                </td>
                <td id="orderName">
                    ${orderName}
                </td>
            </tr>
            <tr>
                <td class="left">
                    Date
                </td>
                <td id="orderDate">
                    ${date}
                </td>
            </tr>
            <tr>
                <td class="left">
                    Type
                </td>
                <td id="orderType">
                    ${type}
                </td>
            </tr>
            <tr>
                <td class="left">
                    Price
                </td>
                <td id="orderType">
                    ${price}
                </td>
            </tr>
            <tr>
                <td class="left">
                    Enter your name:
                </td>
                <td>
                    <#if name??>
                        <div id="orderUserName2">
                            ${name}
                        </div>
                    <#else>
                        <form>
                            <input type="search" id="orderUserName">
                        </form>
                    </#if>
                </td>
            </tr>
            <tr>
                <td class="left">
                    Your mobile phone:
                </td>
                <td>
                    <#if phone??>
                        <form>
                            <input type="search" id="orderUserPhone" value="${phone}">
                        </form>
                    <#else>
                        <form>
                            <input type="search" id="orderUserPhone">
                        </form>
                    </#if>
                </td>
            </tr>
            <tr>
                <td class="left">
                    Your email:
                </td>
                <td>
                    <#if email??>
                        <div id="orderUserEmail2">
                            ${email}
                        </div>
                    <#else>
                        <form>
                            <input type="search" id="orderUserEmail">
                        </form>
                    </#if>
                </td>
            </tr>
            <tr>
                <td class="left">
                    Preferred communication method:
                </td>
                <td>
                    <div class="communication" id="communication">
                        <div class="communicationName" id="communicationName">
                            Preferred communication method:
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
                            Choose a method
                        </div>
                    </div>
                </td>
            </tr>
            <tr>
                <td class="left">
                    Your comment:
                </td>
                <td>
                    <div class="content">
                    <textarea id="orderUserComment" name="smallDescription" rows="5" cols="45"
                              placeholder="Введите ваш комментарий тут"
                              name="text"></textarea>
                    </div>
                </td>
            </tr>
        </table>
        <div class="possibleProblems" id="possibleProblems">
            <#--            тут будут возможные проблемы-->
        </div>
        <a onclick="confirmOrder()">
            <div class="confirmBtn">
                Забронировать
            </div>
        </a>
    </div>
</@c.page>