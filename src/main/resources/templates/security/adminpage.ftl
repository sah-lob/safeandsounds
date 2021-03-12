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
                <div class="form-check form-check-inline">
                    <input name="monday" type="checkbox" id="inlineCheckbox1" value="true">
                    <label for="inlineCheckbox1">monday</label>
                </div>
                <div class="form-check form-check-inline">
                    <input name="tuesday" type="checkbox" id="inlineCheckbox2" value="true">
                    <label for="inlineCheckbox2">tuesday</label>
                </div>
                <div class="form-check form-check-inline">
                    <input name="wednesday" type="checkbox" id="inlineCheckbox3" value="true">
                    <label for="inlineCheckbox3">wednesday</label>
                </div>
                <div class="form-check form-check-inline">
                    <input name="thursday" type="checkbox" id="inlineCheckbox4" value="true">
                    <label for="inlineCheckbox4">thursday</label>
                </div>
                <div class="form-check form-check-inline">
                    <input name="friday" type="checkbox" id="inlineCheckbox5" value="true">
                    <label for="inlineCheckbox5">friday</label>
                </div>
                <div class="form-check form-check-inline">
                    <input name="saturday" type="checkbox" id="inlineCheckbox6" value="true">
                    <label for="inlineCheckbox6">saturday</label>
                </div>
                <div class="form-check form-check-inline">
                    <input name="sunday" type="checkbox" id="inlineCheckbox7" value="true">
                    <label for="inlineCheckbox7">sunday</label>
                </div>
                <button type="submit">Найти</button>
            </form>

            <form action="/security/adminpage/addphotototour" method="post" enctype="multipart/form-data">
                <input type="file" name="file">
                <input type="text" name="name" placeholder="id тура, куда надо добавить еще фотку">
                <button type="submit">Добавить фото.</button>
            </form>

            <a href="https://wordhtml.com">
                конвертация текста в html
            </a>

            </tbody>
        </table>
    </div>
</div>
</body>
</html>
