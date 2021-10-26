<#macro logo style style2 personalAccount>
    <div class="header">
        <link rel="stylesheet" type="text/css" href="../css/parts/logo/logo.css"/>
        <link rel="stylesheet" type="text/css" href="../css/parts/logo/logoWaves.css"/>
        <link rel="stylesheet" type="text/css" href="../css/parts/logo/headerButtons.css"/>
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"></script>
        <a href="/">
            <div class="inner-header flex">
                <div class="inner-header-logo">
                    <img src="img/logo1.png" alt="e">
                </div>
                <div class="inner-header-header">
                    Safe & Sound tours
                </div>
            </div>
        </a>

        <nav class="infoMenu">
            <ul class="topmenu">
                <li><a href="#">+7 916 633 58 00</a>
                    <ul class="submenu">
                        <li><a href="">Callback me</a></li>
                    </ul>
                </li>
                <li><a class="aClass" href="#">
                        Tours
                    </a>
                    <ul class="submenu">
                        <li><a class="aClass" href="">in Moscow</a></li>
                        <li><a href="">Moscow region</a></li>
                        <li><a href="">river trips</a></li>
                    </ul>
                </li>
                <li><a href="">About us</a></li>
                <li><a href="">Liked</a></li>
                <#if personalAccount.authorized>
                    <li><a href="/personalAccount" class="submenu-link">
                            <div class="aLeft">
                                <img src="img/account.png" alt="e">
                            </div>
                            <div class="aRight">
                                ${personalAccount.name}
                            </div>
                        </a>
                        <ul class="submenu">
                            <li><a href="/personalAccount">My account</a></li>
                            <li><a href="/logout">logout</a></li>
                        </ul>
                    </li>
                <#else>
                    <li><a href="/login">Login</a></li>
                </#if>
            </ul>
        </nav>
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