<#macro filterBetween filterLabel inputFromId inputToId valueFrom valueTo placeHolderFrom placeHolderTo>
    <div class="tourFilterBetweenParam">
        <div class="tourFilterBetweenParamHeader">
            ${filterLabel}
        </div>
        <div class="tourFilterBetweenForms">
            <div class="tourFilterBetweenParamFrom">
                <@integerInput inputFromId valueFrom placeHolderFrom/>
            </div>
            <div class="tourFilterBetween">
                -
            </div>
            <div class="tourFilterBetweenParamTo">
                <@integerInput inputToId valueTo placeHolderTo/>
            </div>
        </div>
    </div>
</#macro>

<#macro integerInput inputId value placeHolder>
    <input id="${inputId}"
           type="text"
            <#if '${value}' != ''>
                value="${value}"
            <#else>
                placeholder="${placeHolder}"
            </#if>
           onkeypress="return (event.charCode >= 48 && event.charCode <= 57 && /^\d{0,3}$/.test(this.value));"
           size="40">
</#macro>