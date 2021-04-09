<#import "parts/common.ftl" as c>
<#import "parts/logo.ftl" as logo>
<#import "parts/gallery.ftl" as gallery>
<#import "parts/chooseTour/calender.ftl" as calender>
<#import "parts/chooseTour/tourPrice.ftl" as tourPrice>

<@c.page "css/parts/common.css" "/css/parts/gallery.css">
    <@logo.logo "css/parts/logo.css" "css/parts/headerButtons.css"/>
    <link rel="stylesheet" type="text/css" href="css/choosetour/chooseTour.css"/>
    <link rel="stylesheet" type="text/css" href="css/choosetour/chooseTour2.css"/>
    <link rel="stylesheet" type="text/css" href="css/choosetour/calendar.css"/>
    <link rel="stylesheet" type="text/css" href="css/choosetour/chooseTourPrice.css"/>
    <link rel="stylesheet" type="text/css" href="css/parts/customButton.css"/>

    <script src="/js/parts/chooseTour.js"></script>

    <div class="cb">
        <div class="chooseTourBody">
                <p class="bigger">${tour.name}</p>
                <@gallery.page tour.imagesId/>
                <div class="tourDescription">
                    ${tour.description}
                </div>
                <@calender.calender/>
                <@tourPrice.tourPrice/>
        </div>
    </div>
</@c.page>