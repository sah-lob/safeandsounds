<#import "parts/common.ftl" as c>
<#import "parts/logo.ftl" as logo>
<#import "parts/gallery.ftl" as gallery>

<@c.page "css/parts/common.css" "/css/parts/gallery.css">
    <link rel="stylesheet" type="text/css" href="../css/showOrder.css"/>
    <@logo.logo "css/parts/logo.css" "css/parts/headerButtons.css" personalAccount/>
    <div class="showOrder">
        <div class="soBody">
            <div class="orderPhoto">
                <img src="/getLogin/?id=${imgId}"/>
            </div>
            <div class="orderPaper">
                <div class="orderPaperHeader">
                    <div class="orderPaperHeaderNameDear">
                        Dear ${name}
                    </div>
                    <div class="orderPaperHeaderOrderNum">
                        Order №${orderNum}
                    </div>
                </div>
                <hr>
                <div class="orderPaperBody">
                    <div class="orderPaperBodyName">
                        ${tourName}
                    </div>
                    <div class="orderPaperBodyParam">
                        <div class="orderPaperBodyLeftParam">
                            Тип экскурсии
                        </div>
                        <div class="orderPaperBodyRightParam">
                            ${orderType}
                        </div>
                    </div>
                    <div class="orderPaperBodyParam">
                        <div class="orderPaperBodyLeftParam">
                            Дата экскурсии
                        </div>
                        <div class="orderPaperBodyRightParam">
                            ${tourDate}
                        </div>
                    </div>
                    <div class="orderPaperBodyParam">
                        <div class="orderPaperBodyLeftParam">
                            Предпочтительный спосбо связи
                        </div>
                        <div class="orderPaperBodyRightParam">
                            ${performCommunicationMethod}
                        </div>
                    </div>
                    <div class="orderPaperBodyParam">
                        <div class="orderPaperBodyLeftParam">
                            Ваш комментарий
                        </div>
                        <div class="orderPaperBodyRightParam">
                            ${orderComment}
                        </div>
                    </div>
                    <hr>
                    <div class="orderPaperBodyEmail">
                        ${orderEmail} - на данный email отправлено письмо с подтверждением
                    </div>
                    <div class="orderPaperBodyPrice">
                        Price: ${price}
                    </div>
                    <div class="customButton customButtonPullDown">
                        <a href="/">To other tours</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</@c.page>