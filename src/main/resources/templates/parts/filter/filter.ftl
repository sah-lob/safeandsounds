<#import "tourFilterBetweenParam.ftl" as betweenParamsFilter>
<#macro filter tourFilter>
    <div class="tourFilter">
        <div class="tourFilterIcon">
            <div class="filterIcon" id="filterIcon"></div>
        </div>
        <div class="tourFilterHeader">
            filter
        </div>
        <div class="tourFilterLiked">
            <#if tourFilter.lt>
                <input id="box1" type="checkbox" checked="checked"/>
            <#else>
                <input id="box1" type="checkbox"/>
            </#if>
            <label for="box1">Liked tours</label>
        </div>
        <@betweenParamsFilter.filterBetween
        'tour duration'
        'tourFilterDurationFromInput'
        'tourFilterDurationToInput'
        tourFilter.durationFrom!''
        tourFilter.durationFrom!''
        0
        23/>

        <@betweenParamsFilter.filterBetween
        'starting hour'
        'tourFilterHourFromInput'
        'tourFilterHourToInput'
        tourFilter.hourFrom!''
        tourFilter.hourTo!''
        0
        23/>

        <@betweenParamsFilter.filterBetween
        'price'
        'tourFilterPriceFromInput'
        'tourFilterPriceToInput'
        tourFilter.priceFrom!''
        tourFilter.priceTo!''
        0
        999/>
        <a class="confirmFilterBtn" onclick="startFilter()">
            <div class="confirmFilterBtnText">
                apply
            </div>
        </a>
    </div>
</#macro>