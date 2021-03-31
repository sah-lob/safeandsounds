<#import "parts/common.ftl" as c>
<#import "parts/pager.ftl" as p>
<#import "parts/logo.ftl" as logo>
<#import "parts/headerButtons.ftl" as headerButtons>

<@c.page "css/parts/common.css" "css/main.css">
    <@logo.logo "css/parts/logo.css" "css/parts/headerButtons.css"/>
    <div class="tourBody">
        <div class="tourBodyContent">
            <ul class="products clearfix">
                <li class="product-wrapper">
                    <a href="" class="product"></a>
                </li>
                <li class="product-wrapper">
                    <a href="" class="product"></a>
                </li>
                <li class="product-wrapper">
                    <a href="" class="product"></a>
                </li>
                <li class="product-wrapper">
                    <a href="" class="product"></a>
                </li>
                <li class="product-wrapper">
                    <a href="" class="product"></a>
                </li>
                <li class="product-wrapper">
                    <a href="" class="product"></a>
                </li>
                <li class="product-wrapper">
                    <a href="" class="product"></a>
                </li>
                <li class="product-wrapper">
                    <a href="" class="product"></a>
                </li>
            </ul>
        </div>
        <#--        <div class="tourBodyContent">-->
        <#--            <#list  page.content as tour>-->
        <#--                    <a href="/chooseTour?id=${tour.id}">-->
        <#--                        <div class="ex">-->
        <#--                            <div class="photo">-->
        <#--                                <img src="/getLogin/?id=${tour.imagesId[0]}" alt="e">-->
        <#--                            </div>-->
        <#--                            <div class="tourHeader">-->
        <#--                                <div>${tour.name}</div>-->
        <#--                            </div>-->
        <#--                            <div class="description">-->
        <#--                                ${tour.description?left_pad(200)[0..*200]} ...-->
        <#--                            </div>-->
        <#--                            <div class="tourFooter">-->
        <#--                                <div class="pricePlace">-->
        <#--                                    Цена: ${tour.price} $-->
        <#--                                </div>-->
        <#--                                <div class="duration">-->
        <#--                                    <div class="durationImg">-->
        <#--                                        <img src="img/time.png" alt="e">-->
        <#--                                    </div>-->
        <#--                                    <div class="durationTime">-->
        <#--                                        4 часа-->
        <#--                                    </div>-->
        <#--                                </div>-->
        <#--                            </div>-->
        <#--                        </div>-->
        <#--                    </a>-->
        <#--            </#list>-->
        <#--        </div>-->
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