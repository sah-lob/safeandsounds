<#import "parts/common.ftl" as c>
<#import "parts/logo.ftl" as logo>
<#import "parts/gallery.ftl" as gallery>

<@c.page "css/parts/common.css" "/css/parts/gallery.css">
    <link rel="stylesheet" type="text/css" href="../css/order.css"/>
    <@logo.logo "css/parts/logo.css" "css/parts/headerButtons.css" personalAccount/>
    <script src="/js/parts/order.js"></script>
    <div class="newOrder">
        <div class="newOrderCheck">
            <div class="newOrderCheckLogo">
                ${orderName}
            </div>
            <div class="newOrderCheckLogoConfirm">
                confirm the selection...
            </div>
            <div class="newOrderCheckBody">
                <div class="newOrderCheckBodyOrderNumber">
                    <div class="orderText">
                        № Order
                    </div>
                    <div class="orderTextValue" id="orderID">
                        ${id}
                    </div>
                </div>
                <div class="newOrderCheckBodyOrderDate">
                    <div class="orderText">
                        Date
                    </div>
                    <div class="orderTextValue">
                        ${date}
                    </div>
                </div>
            </div>
            <div class="newOrderCheckBody">
                <div class="newOrderCheckBodyOrderType">
                    <div class="orderText">
                        Type
                    </div>
                    <div class="orderTextValue">
                        ${type}
                    </div>
                </div>
                <div class="newOrderCheckBodyOrderPrice">
                    <div class="orderText">
                        Price
                    </div>
                    <div class="orderTextValue">
                        ${price}
                    </div>
                </div>
            </div>
            <div class="newOrderCheckBody">
                <div class="newOrderCheckBodyOrderName" id="newOrderCheckBodyOrderName">
                    <#if name??>
                        <div class="orderText">
                            <div class="nameLabel">
                                Your name
                            </div>
                        </div>
                        <div class="orderTextValue" id="orderUserName">
                            ${name}
                            <a class="orderTextChange" onclick="editParam('name', '${name}')">
                                edit
                            </a>
                        </div>
                    <#else>
                        <div class="orderText">
                            <div class="nameLabel">
                                Enter your name
                            </div>
                        </div>
                        <div class="orderTextValue" id="orderUserName">
                            <input class="orderUserNameInput" id="orderUserNameInput" type="text">
                        </div>
                    </#if>
                </div>
                <div class="newOrderCheckBodyOrderPhone" id="newOrderCheckBodyOrderPhone">
                    <#if phone??>
                        <div class="orderText">
                            <div class="phoneLabel">
                                Your phone
                            </div>
                        </div>
                        <div class="orderTextValue" id="orderUserPhone">
                            ${phone}
                            <a class="orderTextChange" onclick="editParam('phone', '${phone}')">
                                edit
                            </a>
                        </div>
                    <#else>
                        <div class="orderText">
                            <div class="phoneLabel">
                                Enter your phone
                            </div>
                        </div>
                        <div class="orderTextValue" id="orderUserPhone">
                            <input class="orderUserPhoneInput" id="orderUserPhoneInput" type="text">
                        </div>
                    </#if>
                </div>
            </div>
            <div class="newOrderCheckBody">
                <div class="newOrderEmail" id="newOrderEmail">
                    <#if email??>
                        <div class="orderText">
                            <div class="emailLabel">
                                Your email
                            </div>
                        </div>
                        <div class="orderTextValue" id="orderUserEmail">
                            ${email}
                            <a class="orderTextChange" onclick="editParam('email', '${email}')">
                                edit
                            </a>
                        </div>
                    <#else>
                        <div class="orderText">
                            <div class="emailLabel">
                                Enter your email
                            </div>
                        </div>
                        <divs class="orderTextValue" id="orderUserEmail">
                            <input class="orderUserEmailInput" id="orderUserEmailInput" type="text">
                        </divs>
                    </#if>
                </div>
            </div>
            <div class="newOrderCheckBody">
                <div class="communicationMethodHeader">
                    Preferred communication
                </div>
                <div class="communicationMethodBody">
                <#if communicationMethod??>
                    <#if communicationMethod == 'WhatsApp'>
                        <div class="allCommunicationMethod cmWhatsApp cmWhatsAppPressed">
                    <#else>
                        <div class="allCommunicationMethod cmWhatsApp communicationMethodNotSelected">
                    </#if>
                    <#else>
                        <div class="allCommunicationMethod cmWhatsApp">
                </#if>
                    <a onclick="communicationMethod('cmWhatsApp')">
                        <div class="cmWhatsAppIcon" id="cmWhatsAppIcon">
                        </div>
                    </a>
                </div>
                <#if communicationMethod??>
                    <#if communicationMethod == 'Telegram'>
                        <div class="allCommunicationMethod cmTelegram cmTelegramPressed">
                    <#else>
                        <div class="allCommunicationMethod cmTelegram communicationMethodNotSelected">
                    </#if>
                <#else>
                        <div class="allCommunicationMethod cmTelegram">
                </#if>
                    <a onclick="communicationMethod('cmTelegram')">
                        <div class="cmTelegramIcon" id="cmTelegramIcon">
                        </div>
                    </a>
                </div>
                <#if communicationMethod??>
                    <#if communicationMethod == 'Instagram'>
                        <div class="allCommunicationMethod cmInstagram cmInstagramPressed">
                    <#else>
                        <div class="allCommunicationMethod cmInstagram communicationMethodNotSelected">
                    </#if>
                <#else>
                        <div class="allCommunicationMethod cmInstagram">
                </#if>
                <#if instagram??>
                    <a onclick="communicationMethod('cmInstagram', '${instagram}')">
                <#else>
                    <a onclick="communicationMethod('cmInstagram')">
                </#if>
                    <div class="cmInstagramIcon" id="cmInstagramIcon">
                    </div>
                    </a>
                </div>
                <#if communicationMethod??>
                    <#if communicationMethod == 'Email'>
                        <div class="allCommunicationMethod cmEmail cmEmailPressed">
                    <#else>
                        <div class="allCommunicationMethod cmEmail communicationMethodNotSelected">
                    </#if>
                <#else>
                    <div class="allCommunicationMethod cmEmail">
                </#if>
                    <a onclick="communicationMethod('cmEmail')">
                        <div class="cmEmailIcon" id="cmEmailIcon">
                        </div>
                    </a>
                </div>
                <#if communicationMethod??>
                    <#if communicationMethod == 'Phone'>
                        <div class="allCommunicationMethod cmPhone cmPhonePressed">
                    <#else>
                        <div class="allCommunicationMethod cmPhone communicationMethodNotSelected">
                    </#if>
                <#else>
                    <div class="allCommunicationMethod cmPhone">
                </#if>
                    <a onclick="communicationMethod('cmPhone')">
                        <div class="cmPhoneIcon" id="cmPhoneIcon">
                        </div>
                    </a>
                </div>
            </div>
            <#if communicationMethod??>
                <div class="communicationMethodBodySelected border${communicationMethod} cm${communicationMethod}"
                     id="communicationMethodBodySelected">
                    ${communicationMethod}
                </div>
            <#else>
                <div class="communicationMethodBodySelected" id="communicationMethodBodySelected">
                </div>
            </#if>
        </div>
        <#if (communicationMethod??) && (communicationMethod == 'Instagram')>
            <div class="newOrderAdditionalInstagram" id="newOrderAdditionalInstagram">
                <div class="communicationMethodName">Enter your instagram:</div>
                <div class="instagramCommunicationMethod">
                    <div class="communicationMethodDog">@</div>
                    <#if instagram??>
                        <input class="communicationMethodText" id="communicationMethodText" value="${instagram}" type="text">
                    <#else>
                        <input class="communicationMethodText" id="communicationMethodText" type="text">
                    </#if>
                </div>
            </div>
        <#else>
            <div class="newOrderAdditionalInstagram" id="newOrderAdditionalInstagram">
            </div>
        </#if>
        <div class="newOrderComment">
            <label>
        <textarea class="newOrderCommentTextArea" placeholder="Your comment"
                  id="orderUserComment"></textarea>
            </label>
        </div>
        <a onclick="confirmOrder()">
            <div class="confirmBtn">
                Book
            </div>
        </a>
    </div>
</div>
</@c.page>