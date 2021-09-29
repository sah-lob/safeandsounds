<#macro pager url page>
    <link rel="stylesheet" type="text/css" href="css/parts/pager.css"/>
    <div class="pager">
        <div class="pagerBody">
            <#if page.getNumber() != 0 >
                <div class="pagerBodyPrev pagerBtn">
                    <a class="page-link" href="${url}?page=${page.getNumber() - 1}&size=${page.getSize()}"
                       tabindex="-1">PREV</a>
                </div>
            </#if>
            <div class="pagerBodyPaginationContainer">
                <#if page.getTotalPages() gt 6 >
                    <#if page.getNumber() < 2>
                        <#list 1..3 as p>
                            <#if (p - 1) == page.getNumber()>
                                <div class="pagerBodyNum pagerBtnActive">
                                    ${p}
                                </div>
                            <#else>
                                <div class="pagerBodyNum pagerBtn">
                                    <a href="${url}?page=${p - 1}&size=${page.getSize()}" tabindex="-1">${p}</a>
                                </div>
                            </#if>
                        </#list>
                        <div class="pagerBodyNum">
                            ...
                        </div>
                        <#list 1..0 as p>
                            <div class="pagerBodyNum pagerBtn">
                                <a href="${url}?page=${page.getTotalPages() - p - 1}&size=${page.getSize()}"
                                   tabindex="-1">${page.getTotalPages() - p}</a>
                            </div>
                        </#list>
                    <#elseif page.getNumber() gt page.getTotalPages() - 3>
                        <#list 1..2 as p>
                            <div class="pagerBodyNum pagerBtn">
                                <a href="${url}?page=${p - 1}&size=${page.getSize()}" tabindex="-1">${p}</a>
                            </div>
                        </#list>
                        <div class="pagerBodyNum">
                            ...
                        </div>
                        <#list 2..0 as p>
                            <#if (page.getTotalPages() - p - 1) == page.getNumber()>
                                <div class="pagerBodyNum pagerBtnActive">
                                    ${page.getTotalPages() - p}
                                </div>
                            <#else>
                                <div class="pagerBodyNum pagerBtn">
                                    <a href="${url}?page=${page.getTotalPages() - p - 1}&size=${page.getSize()}"
                                       tabindex="-1">${page.getTotalPages() - p}</a>
                                </div>
                            </#if>
                        </#list>
                    <#else>
                        <div class="pagerBodyNum pagerBtn">
                            <a href="${url}?page=0&size=${page.getSize()}" tabindex="-1">1</a>
                        </div>
                        <#if page.getNumber() != 2>
                            <div class="pagerBodyNum">
                                ...
                            </div>
                        </#if>
                        <div class="pagerBodyNum pagerBtn">
                            <a href="${url}?page=${page.getNumber() - 1}&size=${page.getSize()}"
                               tabindex="-1">${page.getNumber()}</a>
                        </div>
                        <div class="pagerBodyNum pagerBtnActive">
                            ${page.getNumber() +1}
                        </div>
                        <div class="pagerBodyNum pagerBtn">
                            <a href="${url}?page=${page.getNumber() + 1}&size=${page.getSize()}"
                               tabindex="-1">${page.getNumber() + 2}</a>
                        </div>
                        <#if page.getNumber() != page.getTotalPages() - 3>
                            <div class="pagerBodyNum">
                                ...
                            </div>
                        </#if>
                        <div class="pagerBodyNum pagerBtn">
                            <a href="${url}?page=${page.getTotalPages() - 1}&size=${page.getSize()}"
                               tabindex="-1">${page.getTotalPages()}</a>
                        </div>
                    </#if>
                <#else>
                    <#list 1..page.getTotalPages() as p>
                        <#if (p - 1) == page.getNumber()>
                            <div class="pagerBodyNum pagerBtnActive">
                                ${p}
                            </div>
                        <#else>
                            <div class="pagerBodyNum pagerBtn">
                                <a href="${url}?page=${p - 1}&size=${page.getSize()}" tabindex="-1">${p}</a>
                            </div>
                        </#if>
                    </#list>
                </#if>
            </div>
            <#if page.getNumber()+1 != page.getTotalPages() >
                <div class="pagerBodyNext pagerBtn">
                    <a class="page-link" href="${url}?page=${page.getNumber() + 1}&size=${page.getSize()}"
                       tabindex="-1">NEXT</a>
                </div>
            </#if>
        </div>
    </div>
</#macro>