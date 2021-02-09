<#import "parts/common.ftl" as c>
<#import "parts/pager.ftl" as p>

<@c.page>
    <br>
    <div class="header">
        <div class="logo">
            <img src="/getLogo" alt="e">
        </div>
        <p class="info">
            МНОГОКАНАЛЬНЫЙ
            <br>
            Круглосуточно
            <br>
            +7-916-633-58-00
        </p>
    </div>
    <br>
    <div class="header_buttons">
        <table>
            <thead>
            <tr>
                <th scope="col">
                    <a href="#0">
                        Каталог экскурсий
                    </a>
                </th>
                <th scope="col">
                    <a href="#0">
                        Отзывы
                    </a>
                </th>
                <th scope="col">
                    <a href="#0">
                        Контакты
                    </a>
                </th>
                <th scope="col">
                    <a href="#0">
                        О нас
                    </a>
                </th>
            </tr>
            </thead>
        </table>
    </div>

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