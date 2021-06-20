<#macro logo style style2 personalAccount>
    <div class="header">
        <link rel="stylesheet" type="text/css" href="../css/parts/logo/logo.css"/>
        <link rel="stylesheet" type="text/css" href="../css/parts/logo/logoWaves.css"/>
        <link rel="stylesheet" type="text/css" href="../css/parts/logo/headerButtons.css"/>
        <a href="/">
            <div class="inner-header flex">
                <div class="inner-header-logo">
                    <img src="img/logo1.png" alt="e">
                </div>
                <div class="inner-header-header">
                    Safe & Sounds tours
                </div>
            </div>
        </a>
        <div class="info">
            <div class="infoLogo">
                +7-916-633-58-00
            </div>
            <div class="personalAccount">
                <#if personalAccount.authorized>
                    <nav id="primary_nav_wrap">
                        <ul>
                            <li><a href="#">
                                    <div class="authorizedPersonalAccount">
                                        <div class="authorizedPersonalAccountLogo">
                                            (*)
                                        </div>
                                        <div class="authorizedPersonalAccountName">
                                            ${personalAccount.name}
                                        </div>
                                    </div>
                                </a>
                                <ul>
                                    <#--                                    Личная информация, понравившиеся, мои заказы, выход из аккаунта-->
                                    <li><a href="#">Личная информация</a></li>
                                    <li><a href="#">Понравившиеся</a></li>
                                    <li><a href="#">Мои заказы</a></li>
                                    <li>
                                        <form action="/logout" method="post">
                                            <button class="logoutBtn" type="submit">Log out</button>
                                        </form>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </nav>
                <#--                    Hi ${personalAccount.name}, How are you?-->
                <#else>
                    <div class="unauthorizedAccount">
                        <div class="unauthorizedAccountTitle">
                        </div>
                        <div class="unauthorizedAccountBody">
                            <div class="unauthorizedAccountBodyBtn">
                                <div class="customButton customButtonPullDown">
                                    <a href="/login">Login / Sign up</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </#if>
            </div>
        </div>
        <div class="btn lightGreen pullDown">
            <a>TOURS</a>
            <a>REVIEWS</a>
            <a>CONTACT</a>
            <a>ABOUT</a>
        </div>
        <div>
            <svg class="waves" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink"
                 viewBox="0 24 150 28" preserveAspectRatio="none" shape-rendering="auto">
                <defs>
                    <path id="gentle-wave"
                          d="M-160 44c30 0 58-18 88-18s 58 18 88 18 58-18 88-18 58 18 88 18 v44h-352z"/>
                </defs>
                <g class="parallax">
                    <use xlink:href="#gentle-wave" x="48" y="0" fill="rgba(255,255,255,0.7"/>
                    <use xlink:href="#gentle-wave" x="48" y="3" fill="rgba(255,255,255,0.5)"/>
                    <use xlink:href="#gentle-wave" x="48" y="5" fill="rgba(255,255,255,0.3)"/>
                    <use xlink:href="#gentle-wave" x="48" y="7" fill="#fff"/>
                </g>
            </svg>
        </div>
    </div>
</#macro>

