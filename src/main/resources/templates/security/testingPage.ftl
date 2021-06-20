<#import "../parts/common.ftl" as c>
<#import "../parts/pager.ftl" as p>
<#import "../parts/logo.ftl" as logo>

<@c.page "../css/parts/common.css" "../css/main.css">
    <@logo.logo "../css/parts/logo.css" "../css/parts/headerButtons.css" personalAccount/>
    <link rel="stylesheet" type="text/css" href="../css/security/addTour.css"/>
    <div class="addTour">
        <form method="post" enctype="multipart/form-data">
            <div class="nameContentForm">
                <div class="name">
                    Введите название экскурсии
                </div>
                <div class="content">
                    <input type="text" class="numOfGeneratingTours" name="numOfGeneratingTours" placeholder="Введите название экскурсии">
                </div>
            </div>
            <button class="addTourButton" type="submit">Добавить экскурсию</button>
        </form>
    </div>
</@c.page>