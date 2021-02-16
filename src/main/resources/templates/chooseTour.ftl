<#import "parts/common.ftl" as c>
<#import "parts/logo.ftl" as logo>
<#import "parts/headerButtons.ftl" as headerButtons>
<#import "parts/gallery.ftl" as gallery>

<@c.page "css/parts/common.css" "/css/parts/gallery.css">
    <@logo.logo "css/parts/logo.css" "css/parts/headerButtons.css"/>
    <link rel="stylesheet" type="text/css" href="css/chooseTour.css"/>
    <link rel="stylesheet" type="text/css" href="css/chooseTour2.css"/>
    <script src="/js/parts/chooseTour.js"></script>

    <div class="chooseTourBody">
        <div class="has-animation animation-ltr" data-delay="10">
            <p class="bigger">${tour.name}</p>
        </div>
        <div class="has-animation animation-rtl" data-delay="2000">
            <@gallery.page tour.imagesId/>
        </div>
        <div class="has-animation animation-rtl" data-delay="1000">
            <div class="tourDescription">
                ${tour.description}
            </div>
        </div>
    </div>


























<#--    <div class="tourBody">-->
<#--        <div class="tourName">-->
<#--            ${tour.name}-->
<#--        </div>-->
<#--        <@gallery.page tour.imagesId/>-->
<#--        <div class="tourText">-->
<#--            ${tour.description}-->
<#--        </div>-->
<#--    </div>-->
</@c.page>


<#--<@gallery.page tour.imagesId/>-->
