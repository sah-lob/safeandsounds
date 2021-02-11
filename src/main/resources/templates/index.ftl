<#import "parts/common.ftl" as c>
<#import "parts/pager.ftl" as p>
<#import "parts/logo.ftl" as logo>
<#import "parts/headerButtons.ftl" as headerButtons>

<@c.page "css/parts/common.css" "css/main.css">
    <@logo.logo "css/parts/logo.css"/>
    <@headerButtons.headerButtons "css/parts/headerButtons.css"/>
    <div class="tourBody">
        <table>
            <tbody>
            <#list  page.content as tour>
                <#if (tour_index == 0)>
                    <tr>
                </#if>
                <#if (tour_index %3 == 0) && (tour_index > 1)>
                    </tr>
                    <tr>
                </#if>
                <td>
                    <a href="/chooseTour?id=${tour.id}">
                        <div class="ex">
                            <div class="photo">
                                <img src="/getLogin/?id=${tour.imagesId[0]}" alt="e">
                            </div>
                            <div class="tourHeader">
                                <div>${tour.name}</div>
                            </div>
                            <div class="description">
                                ${tour.description?left_pad(200)[0..*200]} ...
                            </div>
                            <div class="tourFooter">
                                <div class="pricePlace">
                                    Цена: ${tour.price} $
                                </div>
                                <div class="duration">
                                    В 4 часа
                                </div>
                            </div>
                        </div>
                    </a>
                </td>
                <#if (page.content?size == 1)>
                    <td></td>
                    <td></td>
                </#if>
                <#if (tour_index == 1 && page.content?size == 2)>
                    <td></td>
                </#if>
                <#if !tour_has_next>
                    </tr>
                </#if>
            </#list>
            </tbody>
        </table>
        <br>
        <br>
        <br>
        <br>
        <br>
        <@p.pager url page />
        <br>
        <div class="form">
            <form method="post" enctype="multipart/form-data">
                <input type="file" name="file">
                <button type="submit">Найти</button>
            </form>
        </div>
    </div>
</@c.page>