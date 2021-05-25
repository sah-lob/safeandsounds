<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="https://www.thymeleaf.org"
      xmlns:sec="https://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
    <title>Spring Security Example </title>
</head>
<body>
<form action="/login" method="post">
    <div><label> User Name : <input type="text" name="username"/> </label></div>
    <div><label> Password: <input type="password" name="password"/> </label></div>
    <div><input type="submit" value="Sign In"/></div>
</form>
<form action="/logout" method="post">
<#--    <input type="hidden" name="_csrf" value="${_csrf.token}" />-->
<#--    <button class="btn btn-primary" type="submit"><#if user??>Sign Out<#else>Log in</#if></button>-->
    <button class="btn btn-primary" type="submit">Log out</button>
</form>
</body>
</html>