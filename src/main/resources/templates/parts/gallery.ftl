<#macro page imagesId>
    <div class="gallery">
        <ul class="slides">
            <#list  imagesId as image>
                <input type="radio" name="radio-btn" id="img-${image?index}" checked/>
                <li class="slide-container">
                    <div class="slide">
                        <img src="/getLogin/?id=${image}"/>
                    </div>
                    <div class="nav">
                        <#if image?is_first>
                            <label for="img-${imagesId?size - 1}" class="prev">&#x2039;</label>
                        <#else>
                            <label for="img-${image?index - 1}" class="prev">&#x2039;</label>
                        </#if>

                        <#if image?is_last>
                            <label for="img-0" class="next">&#x203a;</label>
                        <#else>
                            <label for="img-${image?index + 1}" class="next">&#x203a;</label>
                        </#if>
                    </div>
                </li>
            </#list>
            <li class="nav-dots">
                <#list  imagesId as image>
                    <label for="img-${image?index}" class="nav-dot" id="img-dot-${image?index}"></label>
                </#list>
            </li>
        </ul>
    </div>
</#macro>