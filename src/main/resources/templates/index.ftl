<#import "parts/common.ftl" as c>
<#import "parts/pager.ftl" as p>
<#import "parts/logo.ftl" as logo>
<#import "parts/tours.ftl" as tours>

<@c.page "css/parts/common.css" "css/main.css">
    <@logo.logo "css/parts/logo.css" "css/parts/headerButtons.css" personalAccount/>
    <div class="tourBody">
        <@tours.tours page/>
        <@p.pager url page/>
        <br>
    </div>
</@c.page>