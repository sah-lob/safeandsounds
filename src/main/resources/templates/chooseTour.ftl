<#import "parts/common.ftl" as c>
<#import "parts/logo.ftl" as logo>
<#import "parts/headerButtons.ftl" as headerButtons>
<#import "parts/gallery.ftl" as gallery>

<@c.page "css/parts/common.css" "/css/parts/gallery.css">
    <@logo.logo "css/parts/logo.css"/>
    <@headerButtons.headerButtons "css/parts/headerButtons.css"/>
    <link rel="stylesheet" type="text/css" href="css/chooseTour.css"/>
    <div class="tourBody">
        <div class="tourName">
            ${tour.name}
        </div>
        <@gallery.page tour.imagesId/>
        <div class="tourText">
            ${tour.description}
        </div>
    </div>
</@c.page>
