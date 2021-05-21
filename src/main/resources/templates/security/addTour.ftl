<#import "../parts/common.ftl" as c>
<#import "../parts/pager.ftl" as p>
<#import "../parts/logo.ftl" as logo>

<@c.page "../css/parts/common.css" "../css/main.css">
    <@logo.logo "../css/parts/logo.css" "../css/parts/headerButtons.css"/>
    <link rel="stylesheet" type="text/css" href="../css/security/addTour.css"/>
    <div class="addTour">
        <div class="addTourHeader">
            Форма добавления новой экскурсии.
        </div>
        <br>
        <br>
        <form method="post" enctype="multipart/form-data">

            <div class="nameContentForm">
                <div class="name">
                    Добавьте основную фотографию
                </div>
                <div class="content">
                    <input type="file" name="file">
                </div>
            </div>
            <br>
            <div class="nameContentForm">
                <div class="name">
                    Введите название экскурсии
                </div>
                <div class="content">
                    <input type="text" class="tourName" name="name" placeholder="Введите название экскурсии">
                </div>
            </div>

            <div class="nameContentForm">
                <div class="name">
                    Короткое описание
                </div>
                <div class="content">
                    <textarea name="smallDescription" rows="10" cols="45" placeholder="короткое описание"
                              name="text"></textarea>
                </div>
            </div>

            <div class="nameContentForm">
                <div class="name">
                    Полное описание
                </div>
                <div class="content">
                    <textarea name="description" rows="10" cols="45" placeholder="полное описание"
                              name="text"></textarea>
                </div>
            </div>

            <div class="nameContentForm">
                <div class="name">
                    Цена эконом
                </div>
                <div class="content">
                    <input type="text" class="form-control" name="price1" onkeyup='this.value=parseInt(this.value) | 0'
                           placeholder="Цена эконом">
                </div>
            </div>

            <div class="nameContentForm">
                <div class="name">
                    Цена премиум
                </div>
                <div class="content">
                    <input type="text" class="form-control" name="price2" onkeyup='this.value=parseInt(this.value) | 0'
                           placeholder="Цена премиум">
                </div>
            </div>

            <div class="nameContentForm">
                <div class="name">
                    Цена групповая
                </div>
                <div class="content">
                    <input type="text" class="form-control" name="price3" onkeyup='this.value=parseInt(this.value) | 0'
                           placeholder="Цена групповая">
                </div>
            </div>

            <div class="nameContentForm">
                <div class="name">
                    Крутость
                </div>
                <div class="content">
                    <input type="text" class="form-control" name="coolness"
                           onkeyup='this.value=parseInt(this.value) | 0'
                           placeholder="Крутость">
                </div>
            </div>

            <div class="nameContentForm">
                <div class="name">
                    Доступные дни недели
                </div>
                <div class="content">
                    <div class="availableWeekDays">
                        <div class="weekDaysName">
                            <table>
                                <tr>
                                    <td>monday</td>
                                    <td>tuesday</td>
                                    <td>wednesday</td>
                                    <td>thursday</td>
                                    <td>friday</td>
                                    <td>saturday</td>
                                    <td>sunday</td>
                                </tr>
                                <tr>
                                    <td>
                                        <input name="monday" type="checkbox" id="inlineCheckbox1" value="true">
                                    </td>
                                    <td>
                                        <input name="tuesday" type="checkbox" id="inlineCheckbox2" value="true">
                                    </td>
                                    <td>
                                        <input name="wednesday" type="checkbox" id="inlineCheckbox3" value="true">
                                    </td>
                                    <td>
                                        <input name="thursday" type="checkbox" id="inlineCheckbox4" value="true">
                                    </td>
                                    <td>
                                        <input name="friday" type="checkbox" id="inlineCheckbox5" value="true">
                                    </td>
                                    <td>
                                        <input name="saturday" type="checkbox" id="inlineCheckbox6" value="true">
                                    </td>
                                    <td>
                                        <input name="sunday" type="checkbox" id="inlineCheckbox7" value="true">
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </div>
            </div>

            <div class="nameContentForm">
                <div class="name">
                    Продолжительность:
                </div>
                <div class="content">
                    <input type="text" class="tourName" name="duration" placeholder="Продолжительность">
                </div>
            </div>

            <button class="addTourButton" type="submit">Добавить экскурсию</button>
        </form>

        <a href="https://wordhtml.com">
            конвертация текста в html
        </a>
    </div>
</@c.page>