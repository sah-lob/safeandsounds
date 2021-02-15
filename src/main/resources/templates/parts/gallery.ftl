<#macro page imagesId>
    <div class="cd-slider">
        <ul>
            <#list  imagesId as image>
                <li>
<#--                    <div class="image" style="background-image:url(https://images.unsplash.com/photo-1421809313281-48f03fa45e9f?crop=entropy&fit=crop&fm=jpg&h=675&ixjsv=2.1.0&ixlib=rb-0.3.5&q=80&w=1000);"></div>-->
                    <div class="image"
                         style="background-image:url(/getLogin/?id=${image});"></div>
<#--                    <div class="content">-->
<#--                        <h2>Jackets Collection 2017</h2>-->
<#--                        <a href="#">View Gallery</a>-->
<#--                    </div>-->
                </li>
            </#list>
        </ul>
    </div> <!--/.cd-slider-->
    <script src="../js/parts/gallery.js"></script>
</#macro>