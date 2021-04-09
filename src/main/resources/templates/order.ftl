<#import "parts/common.ftl" as c>
<#import "parts/logo.ftl" as logo>
<#import "parts/gallery.ftl" as gallery>

<@c.page "css/parts/common.css" "/css/parts/gallery.css">
    <@logo.logo "css/parts/logo.css" "css/parts/headerButtons.css"/>
    <div class="newOrder">
        <table class="newOrderTable">
            <tr>
                <td>
                    Номер заказа
                </td>
                <td>
                    ${id}
                </td>
            </tr>
            <tr>
                <td>
                    Дата
                </td>
                <td>
                    ${date}
                </td>
            </tr>
            <tr>
                <td>
                    Тип
                </td>
                <td>
                    ${type}
                </td>
            </tr>
            <tr>
                <td>
                    Введите ваше имя:
                </td>
                <td>
                    Александр
                </td>
            </tr>
            <tr>
                <td>
                    Введите ваш номер телефона:
                </td>
                <td>
                    Александр
                </td>
            </tr>
            <tr>
                <td>
                    Введите ваш email:
                </td>
                <td>
                    Александр
                </td>
            </tr>
        </table>
    </div>

</@c.page>