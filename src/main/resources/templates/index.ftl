<#import "parts/common.ftl" as c>
<#import "parts/pager.ftl" as p>
<#import "parts/logo.ftl" as logo>
<#import "parts/headerButtons.ftl" as headerButtons>

<@c.page "css/parts/common.css" "css/main.css">
    <@logo.logo "css/parts/logo.css"/>
    <@headerButtons.headerButtons "css/parts/headerButtons.css"/>
    <div class="body">
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
                    <a href="#0">
                        <div class="ex">
                            <div class="photo">
                                <img src="/getLogin/?id=${tour.imageId}" alt="e">
                            </div>
                            <div class="header">
                                ${tour.name}
                            </div>
                            <div class="type">
                                4 часа
                            </div>
                            <div class="description">
                                ${tour.description}
                            </div>
                            <div class="price">
                                <div class="priceLabel">
                                    Цена:
                                </div>
                                <div class="pricePlace">
                                    ${tour.price}
                                </div>
                                <div class="currency">
                                    $
                                </div>
                            </div>
                        </div>
                    </a>
                </td>
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