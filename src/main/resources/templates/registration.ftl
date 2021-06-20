<#import "parts/common.ftl" as c>
<#import "parts/pager.ftl" as p>
<#import "parts/logo.ftl" as logo>
<#import "parts/tours.ftl" as tours>

<@c.page "css/parts/common.css" "css/main.css">
    <@logo.logo "css/parts/logo.css" "css/parts/headerButtons.css" personalAccount/>
    <link rel="stylesheet" type="text/css" href="../css/registration.css"/>
    <div class="registrationBody">
        <form action="/registration" method="post">
            <div><label> User Name : <input type="text" name="firstName"/> </label></div>
            <div><label> Password: <input type="password" name="password"/> </label></div>
<#--            <input type="hidden" name="_csrf" value="{{_csrf.token}}" />-->
            <div><input type="submit" value="Sign In"/></div>
        </form>
    </div>
</@c.page>