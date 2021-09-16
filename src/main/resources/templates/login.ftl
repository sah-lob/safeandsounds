<!DOCTYPE html>
<html lang="es" dir="ltr">

<head>
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0">
    <meta charset="utf-8">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;700;800&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="../css/login2.css"/>
</head>

<body>
<div class="main">
    <div class="container a-container" id="a-container">
        <form class="form" id="a-form" action="/login" method="post">
            <h2 class="form_title title">Sign in to Website</h2>
            <div><input class="form__input" type="text" name="username" placeholder="Email"></div>
            <div><input class="form__input" type="password" name="password" placeholder="Password"></div>
            <a class="form__link">Forgot your password?</a>
            <div><input class="button" type="submit" value="Sign In"/></div>
        </form>
    </div>
    <div class="container b-container" id="b-container">
        <form class="form" id="b-form" method="post" action="/registration">
            <h2 class="form_title title">Create Account</h2>
            <input class="form__input" type="text" name="firstName" placeholder="Name">
            <input class="form__input" type="text" name="email" placeholder="Email">
            <input class="form__input" type="password" name="password" placeholder="Password">
            <div><input class="button" type="submit" value="Sign up"/></div>
        </form>
    </div>
    <div class="switch" id="switch-cnt">
        <div class="switch__circle"></div>
        <div class="switch__circle switch__circle--t"></div>
        <div class="switch__container" id="switch-c1">
            <h2 class="switch__title title">Welcome Back !</h2>
            <p class="switch__description description">To keep connected with us please login with your personal
                info</p>
            <button class="switch__button button switch-btn">SIGN UP</button>
        </div>
        <div class="switch__container is-hidden" id="switch-c2">
            <h2 class="switch__title title">Hello Friend !</h2>
            <p class="switch__description description">Enter your personal details and start journey with us</p>
            <button class="switch__button button switch-btn">SIGN IN</button>
        </div>
    </div>
</div>
<script src="/js/parts/login2.js"></script>
</body>

</html>