<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Safe and sounds tours</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="../css/security/adminpage.css"/>
    <script src="../js/getlogo.js"></script>
    <script src="../js/security/adminpage.js"></script>
</head>
<body>
<br>
<div class="header">
    <p class="logo">
        <pp class="img_с2" id='img_с'>logo</pp>
    </p>
    <p class="info">
        МНОГОКАНАЛЬНЫЙ
        <br>
        Круглосуточно
        <br>
        +7-916-633-58-00
    </p>
</div>
<br>

<div class="tourBody">
    <div class="form">
        <table class="addTour">
            <tbody>
            <form method="post" enctype="multipart/form-data">
                <input type="file" name="file">
                <input type="text" name="name" placeholder="Введите название экскурсии">
                <textarea name="description" rows="10" cols="45" name="text"></textarea>
                <input type="text" class="form-control" name="price" onkeyup='this.value=parseInt(this.value) | 0'
                       placeholder="Цена">
                <input type="text" class="form-control" name="coolness" onkeyup='this.value=parseInt(this.value) | 0'
                       placeholder="Крутость">
                <button type="submit">Найти</button>
            </form>
            <#--            <tr>-->
            <#--                <th>-->
            <#--                    <div class="form-group col-sm-6" style="padding-right: 10px; width: 102%; margin-left: -1.35%;">-->
            <#--                        <label for="files"></label>-->
            <#--                        <input type="file" name="files[]" id="files" class="form-control"-->
            <#--                               data-filename-placement="inside" title="Загрузите фотографию машины."/>-->
            <#--                    </div>-->
            <#--                </th>-->
            <#--            </tr>-->
            <#--            <tr>-->
            <#--                <th>-->
            <#--                    <div class="name">-->
            <#--                        <input type="text" class="form-control" id="name" placeholder="Введите название экскурсии">-->
            <#--                    </div>-->
            <#--                </th>-->
            <#--            </tr>-->
            <#--            <tr>-->
            <#--                <th>-->
            <#--                    <textarea id="description" rows="10" cols="45" name="text"></textarea>-->
            <#--                </th>-->
            <#--            </tr>-->
            <#--            <tr>-->
            <#--                <th>-->
            <#--                    <div class="price">-->
            <#--                        <input type="text" class="form-control" id="price" onkeyup='this.value=parseInt(this.value) | 0'-->
            <#--                               placeholder="Цена">-->
            <#--                    </div>-->
            <#--                </th>-->
            <#--            </tr>-->
            <#--            <tr>-->
            <#--                <th>-->
            <#--                    <div class="coolness">-->
            <#--                        <input type="text" class="form-control" id="coolness" onkeyup='this.value=parseInt(this.value) | 0'-->
            <#--                               placeholder="Крутость">-->
            <#--                    </div>-->
            <#--                </th>-->
            <#--            </tr>-->
            <#--            <tr>-->
            <#--                <th>-->
            <#--                    <button type="submit" class="btn-success" id="button" onclick="saveInfo()" formaction="#">Добавить-->
            <#--                        экскурсию-->
            <#--                    </button>-->
            <#--                </th>-->
            <#--            </tr>-->
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
