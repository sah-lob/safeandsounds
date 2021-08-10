<#import "../parts/footer.ftl" as footer>

<#macro page mainStyle pageStyle>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Safe and sounds tours</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
        <link rel="stylesheet" type="text/css" href="css/parts/colors.css"/>
        <link rel="stylesheet" type="text/css" href="css/parts/fonts.css"/>
        <link rel="stylesheet" type="text/css" href="${pageStyle}"/>
        <link rel="stylesheet" type="text/css" href="${mainStyle}"/>
    </head>
    <body>
    <#nested>
    <footer>
        <@footer.footer/>
    </footer>
    </body>
    </html>
</#macro>