<#import "parts/common.ftl" as c>
<#import "parts/logo.ftl" as logo>
<#import "parts/headerButtons.ftl" as headerButtons>

<@c.page "css/parts/common.css" "css/main.css">
    <@logo.logo "css/parts/logo.css"/>
    <@headerButtons.headerButtons "css/parts/headerButtons.css"/>
    <div class="body">
        <table>
            <tbody>
            <tr>
                <th>
                    <div class="photos">
                        тут будут фотки
                    </div>
                </th>
            </tr>
            <tr>
                <th>
                    <div class="header">
                        Заголовок
                    </div>
                </th>
            </tr>
            <tr>
                <th>
                    <div class="description">
                        Lorem Ipsum - это текст-"рыба", часто используемый в печати и вэб-дизайне. Lorem Ipsum является
                        стандартной "рыбой" для текстов на латинице с начала XVI века. В то время некий безымянный
                        печатник
                        создал большую коллекцию размеров и форм шрифтов, используя Lorem Ipsum для распечатки образцов.
                        Lorem Ipsum не только успешно пережил без заметных изменений пять веков, но и перешагнул в
                        электронный дизайн. Его популяризации в новое время послужили публикация листов Letraset с
                        образцами
                        Lorem Ipsum в 60-х годах и, в более недавнее время, программы электронной вёрстки типа Aldus
                        PageMaker, в шаблонах которых используется Lorem Ipsum.
                    </div>
                </th>
            </tr>
            <tr>
                <th>Каталог экскурсий</th>
            </tr>
            <tr>
                <th>Каталог экскурсий</th>
            </tr>
            </tbody>
        </table>
    </div>
</@c.page>
