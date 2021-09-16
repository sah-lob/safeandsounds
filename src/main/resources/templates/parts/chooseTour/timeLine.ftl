<#macro timeLine>
    <div class="timeLineGeneral">
        <ul class="timeline">
            <#list tour.visitedPlaces as place>
                <#if place?index % 2 == 0>
                    <li>
                        <div class="direction-r">
                            <div class="flag-wrapperR">
                                <span class="flag">${place.name}</span>
                            </div>
                            <div class="desc">${place.description}</div>
                        </div>
                    </li>
                <#else>
                    <li>
                        <div class="direction-l">
                            <div class="flag-wrapper">
                                <span class="flag">${place.name}</span>
                            </div>
                            <div class="desc">${place.description}</div>
                        </div>
                    </li>
                </#if>
            </#list>
        </ul>
    </div>
</#macro>