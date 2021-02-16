<#macro logo style style2>
    <div class="header">
        <link rel="stylesheet" type="text/css" href="${style}"/>
        <link rel="stylesheet" type="text/css" href="${style2}"/>
        <!--Content before waves-->
        <a href="/">
            <div class="inner-header flex">
                <h1>Safe & Sounds tours</h1>
            </div>
        </a>
        <div class="header_buttons">
            <table>
                <thead>
                <tr>
                    <th scope="col">
                        <a href="#0">
                            Каталог экскурсий
                        </a>
                    </th>
                    <th scope="col">
                        <a href="#0">
                            Отзывы
                        </a>
                    </th>
                    <th scope="col">
                        <a href="#0">
                            Контакты
                        </a>
                    </th>
                    <th scope="col">
                        <a href="#0">
                            О нас
                        </a>
                    </th>
                </tr>
                </thead>
            </table>
        </div>
        <div class="info">
            <div class="infoLogo">
                +7-916-633-58-00
            </div>
            <div class="socialNetworking">
                <div class="callback">
                    <div class="callbackLogo">
                        <img src="img/callbackB.png" alt="e">
                    </div>
                    <div class="callbackText">
                        Request a call back
                    </div>
                </div>
                <div class="instagram">
                    <a href="https://www.instagram.com/safeandsoundtours/">
                        <img src="img/instagram.png" alt="e">
                    </a>
                </div>
                <div class="facebook">
                    <img src="img/facebook.png" alt="e">
                </div>
            </div>
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

