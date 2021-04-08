<#macro logo style style2>
    <div class="header">
<#--        <meta name="viewport" content="width=device-width, user-scalable=no">-->
        <link rel="stylesheet" type="text/css" href="${style}"/>
        <link rel="stylesheet" type="text/css" href="${style2}"/>
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
            <div class="callback">
                <img src="img/callbackB.png" alt="e">
                    Request a call back
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

