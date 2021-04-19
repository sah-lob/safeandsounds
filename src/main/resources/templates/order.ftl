<#import "parts/common.ftl" as c>
<#import "parts/logo.ftl" as logo>
<#import "parts/gallery.ftl" as gallery>

<@c.page "css/parts/common.css" "/css/parts/gallery.css">
    <link rel="stylesheet" type="text/css" href="../css/order.css"/>
    <@logo.logo "css/parts/logo.css" "css/parts/headerButtons.css"/>
    <div class="newOrder">
        <table class="newOrderTable">
            <tr>
                <td class="left">
                    Номер заказа
                </td>
                <td>
                    ${id}
                </td>
            </tr>
            <tr>
                <td class="left">
                    Дата
                </td>
                <td>
                    ${date}
                </td>
            </tr>
            <tr>
                <td class="left">
                    Тип
                </td>
                <td>
                    ${type}
                </td>
            </tr>
            <tr>
                <td class="left">
                    Введите ваше имя:
                </td>
                <td>
                    Александр
                </td>
            </tr>
            <tr>
                <td class="left">
                    Введите ваш номер телефона:
                </td>
                <td>
                    Александр
                </td>
            </tr>
            <tr>
                <td class="left">
                    Введите ваш email:
                </td>
                <td>
                    Александр
                </td>
            </tr>
            <tr>
                <td class="left">
                    Предпочтительный способ связи:
                </td>
                <td>
                    телефон
                    телеграмм
                    email
                    instagram
                    Александр
                </td>
            </tr>
        </table>
        <div class="confirmBtn">
            Забронировать
        </div>
    </div>
</@c.page>