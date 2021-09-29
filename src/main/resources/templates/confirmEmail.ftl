<#import "parts/common.ftl" as c>
<#import "parts/logo.ftl" as logo>
<#import "parts/gallery.ftl" as gallery>

<@c.page "css/parts/common.css" "/css/parts/gallery.css">
    <link rel="stylesheet" type="text/css" href="../css/showOrder.css"/>
    <@logo.logo "css/parts/logo.css" "css/parts/headerButtons.css" personalAccount/>
    status: ${status}
</@c.page>