<#import "../parts/common.ftl" as c>
<#import "../parts/logo.ftl" as logo>
<#import "../parts/gallery.ftl" as gallery>
<#import "../parts/chooseTour/calender.ftl" as calender>
<#import "../parts/chooseTour/tourPrice.ftl" as tourPrice>
<#import "../parts/chooseTour/timeLine.ftl" as timeLine>

<@c.page "css/parts/common.css" "/css/parts/gallery.css">
    <@logo.logo "css/parts/logo.css" "css/parts/headerButtons.css" personalAccount/>

    <link rel="stylesheet" type="text/css" href="./css/personalAccount/personalAccount.css/"/>
    <div class="personalAccountBody">

        <div class="personalAccountHeader">
            Personal account
        </div>

        <div class="leftBlock">
            <div class="personalAccountHorizontalBlock">
                <div class="personalAccountAvatarBlock" id="personalAccountAvatarBlock">
                    <div class="personalAccountAvatarPlace" id="personalAccountAvatarPlace">
                        <#if photo == -1>
                            <div class="personalAccountAvatar" id="personalAccountAvatar">
                            </div>
                        <#else>
                            <img src="/getAvatar"/>
                        </#if>
                    </div>
                    <div class="personalAccountAvatarEdit" id="personalAccountAvatarEdit">
                        <#if photo == -1>
                            <a onclick="addAvatar()">
                                <div class="personalAccountAvatarEditBorder">
                                    add avatar
                                </div>
                            </a>
                        <#else>
                            <a onclick="addAvatar()">
                                <div class="personalAccountAvatarEditBorder">
                                    edit avatar
                                </div>
                            </a>
                        </#if>

                    </div>
                    <form class="hidden" id="formidasf">
                        <div class="upload-file__wrapper">
                            <input
                                    type="file"
                                    name="files[]"
                                    id="upload-file__input_1"
                                    class="upload-file__input"
                                    accept=".jpg, .jpeg, .png, .gif, .bmp, .doc, .docx, .xls, .xlsx, .txt, .tar, .zip, .7z, .7zip"
                                    multiple
                            >
                            <label class="upload-file__label" for="upload-file__input_1">
                                <svg class="upload-file__icon" xmlns="http://www.w3.org/2000/svg"
                                     viewBox="0 0 512 512">
                                    <path d="M286 384h-80c-14.2 1-23-10.7-24-24V192h-87.7c-17.8 0-26.7-21.5-14.1-34.1L242.3 5.7c7.5-7.5 19.8-7.5 27.3 0l152.2 152.2c11.6 11.6 3.7 33.1-13.1 34.1H320v168c0 13.3-10.7 24-24 24zm216-8v112c0 13.3-10.7 24-24 24H24c-13.3 0-24-10.7-23-23V366c0-13.3 10.7-24 24-24h136v8c0 31 24.3 56 56 56h80c30.9 0 55-26.1 57-55v-8h135c13.3 0 24 10.6 24 24zm-124 88c0-11-9-20-19-20s-19 9-20 20 9 19 20 20 21-9 20-20zm64 0c0-12-9-20-20-20s-20 9-19 20 9 20 20 20 21-9 20-20z">
                                    </path>
                                </svg>
                                <span class="upload-file__text">Прикрепить файл</span>
                            </label>
                        </div>
                        <button class="newAvatarBtn" type="submit">Отправить</button>
                    </form>
                </div>
                <div class="personalAccountName" id="personalAccountName">
                    <div class="personalAccountAttribute">
                        Name:
                    </div>
                    <div class="personalAccountNameValue">
                        &nbsp;${name}&nbsp;
                    </div>
                    <div class="personalAccountEditBtn">
                        <a onclick="editBtn('personalAccountName', '${name}')">
                            edit
                        </a>
                    </div>
                </div>
                <div class="personalAccountName" id="personalAccountEmail">
                    <#if email??>
                        <div class="personalAccountAttribute">
                            Email:
                        </div>
                        <div class="personalAccountNameValue">
                            &nbsp;${email}&nbsp;
                        </div>
                        <div class="personalAccountEditBtn">
                            <a onclick="editBtn('personalAccountEmail', '${email}')">
                                edit
                            </a>
                        </div>
                    <#else>
                        <a onclick="editBtn('personalAccountEmail', '')">
                            Add email
                        </a>
                    </#if>
                </div>
                <div class="personalAccountName" id="personalAccountPhone">
                    <#if phone??>
                        <div class="personalAccountAttribute">
                            Phone:
                        </div>
                        <div class="personalAccountNameValue">
                            &nbsp;${phone}&nbsp;
                        </div>
                        <div class="personalAccountEditBtn">
                            <a onclick="editBtn('personalAccountPhone', '${phone}')">
                                edit
                            </a>
                        </div>
                    <#else>
                        <a onclick="editBtn('personalAccountPhone', '')">
                            Add phone
                        </a>
                    </#if>
                </div>
                <div class="personalAccountName" id="personalAccountInstagram">
                    <#if instagram??>
                        <div class="personalAccountAttribute">
                            Insta:
                        </div>
                        <div class="personalAccountNameValue">
                            &nbsp;${instagram}&nbsp;
                        </div>
                        <div class="personalAccountEditBtn">
                            <a onclick="editBtn('personalAccountInstagram', '${instagram}')">
                                edit
                            </a>
                        </div>
                    <#else>
                        <a onclick="editBtn('personalAccountInstagram', '')">
                            Add instagram
                        </a>
                    </#if>
                </div>
            </div>
        </div>
        <div class="rightBlock">
            <div class="personalAccountHorizontalBlock">
                <div class="personalAccountHorizontalBlockOrders">
                    <div class="myOrdersHeader">
                        My orders
                    </div>
                    <#list orders as order>
                        <a href="/showOrder?orderId=${order.uuid2}">
                            <div class="personalAccountHorizontalBlockOrdersCard">
                                <div class="myOrdersHeaderInfo">
                                    <div class="myOrderHeaderInfoId">
                                        №${order.id}
                                    </div>
                                    <div class="myOrderHeaderInfoDate">
                                        ${order.tourDate}
                                    </div>
                                </div>
                                <div class="myOrdersHeaderBody">
                                    <div class="myOrdersHeaderName">
                                        ${order.tourName}
                                    </div>
                                    <div class="myOrdersHeaderPrice">
                                        ${order.tourPrice}$
                                    </div>
                                </div>
                            </div>
                        </a>
                    </#list>
                    <#if ordersCount gt 3>
                        <div class="shawAllOrders">
                            Show all orders
                        </div>
                    </#if>
                </div>
            </div>
            <div class="personalAccountHorizontalBlockLikes">
                <div class="personalAccountHorizontalBlockOrders">
                    <div class="myOrdersHeader">
                        I liked it
                    </div>
                    <#list  likes as like>
                        <a href="/chooseTour?id=${like.id}">
                            <div class="personalAccountHorizontalBlockLikesCard">
                                <div class="personalAccountHorizontalBlockLikesCardName">
                                    ${like.name}
                                </div>
                                <div class="personalAccountHorizontalBlockLikesCardId" hidden="true">
                                    ${like.id}
                                </div>
                            </div>
                        </a>
                    </#list>
                    <#if likeCount gt 3>
                        <div class="shawAllOrders">
                            Show all liked tours
                        </div>
                    </#if>
                </div>
            </div>
        </div>
        <script src='https://cdnjs.cloudflare.com/ajax/libs/gsap/1.19.1/TweenMax.min.js'></script>
        <script src='https://s3-us-west-2.amazonaws.com/s.cdpn.io/16327/MorphSVGPlugin.min.js'></script>
        <script src="/js/parts/personalAccount.js"></script>
    </div>
</@c.page>