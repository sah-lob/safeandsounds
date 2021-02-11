<#import "parts/common.ftl" as c>
<#import "parts/logo.ftl" as logo>
<#import "parts/headerButtons.ftl" as headerButtons>

<@c.page "css/parts/common.css" "css/chooseTour.css">
    <@logo.logo "css/parts/logo.css"/>
    <@headerButtons.headerButtons "css/parts/headerButtons.css"/>
    <div class="tourBody">
        <table>
            <tbody>
            <tr>
                <th>
                    <div class="photos">
                        <img src="/getLogin/?id=${tour.imagesId[0]}" alt="e">
                    </div>
                </th>
            </tr>
            <tr>
                <th>
                    <div class="header">
                        ${tour.name}
                    </div>
                </th>
            </tr>
            <tr>
                <th>
                    <div class="description">
                        ${tour.description}
                    </div>
                </th>
            </tr>
            <tr>
                <th>Каталог экскурсий</th>
            </tr>
            <tr>
                <th>Каталог экскурсий</th>
            </tr>
            </tbody>
        </table>
    </div>
</@c.page>
