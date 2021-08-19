<#macro timeLine>
    <div class="timeLineGeneral">
        <ul class="timeline">
            <#list tour.visitedPlaces as place>
                <#if place?index % 2 == 0>
                    <li>
                        <div class="direction-r">
                            <div class="flag-wrapperR">
                                <span class="flag">${place.name}</span>
                                <#--                        <span class="time-wrapper"><span class="time">2013 - present</span></span>-->
                            </div>
                            <div class="desc">${place.description}</div>
                        </div>
                    </li>
                <#else>
                    <li>
                        <div class="direction-l">
                            <div class="flag-wrapper">
                                <span class="flag">${place.name}</span>
                                <#--                        <span class="time-wrapper"><span class="time">2011 - 2013</span></span>-->
                            </div>
                            <div class="desc">${place.description}</div>
                        </div>
                    </li>
                </#if>

            </#list>
            <!-- Item 1 -->
            <#--            <li>-->
            <#--                <div class="direction-r">-->
            <#--                    <div class="flag-wrapperR">-->
            <#--                        <span class="flag">Your meeting place</span>-->
            <#--                        &lt;#&ndash;                        <span class="time-wrapper"><span class="time">2013 - present</span></span>&ndash;&gt;-->
            <#--                    </div>-->
            <#--                    <div class="desc">My current employment. Way better than the position before!</div>-->
            <#--                </div>-->
            <#--            </li>-->

            <!-- Item 2 -->
            <#--                        <li>-->
            <#--                            <div class="direction-l">-->
            <#--                                <div class="flag-wrapper">-->
            <#--                                    <span class="flag">Apple Inc.</span>-->
            <#--                                    &lt;#&ndash;                        <span class="time-wrapper"><span class="time">2011 - 2013</span></span>&ndash;&gt;-->
            <#--                                </div>-->
            <#--                                <div class="desc">My first employer. All the stuff I've learned and projects I've been working on.-->
            <#--                                </div>-->
            <#--                            </div>-->
            <#--                        </li>-->

            <#--            <!-- Item 3 &ndash;&gt;-->
            <#--            <li>-->
            <#--                <div class="direction-r">-->
            <#--                    <div class="flag-wrapperR">-->
            <#--                        <span class="flag">Harvard University</span>-->
            <#--                        &lt;#&ndash;                        <span class="time-wrapper"><span class="time">2008 - 2011</span></span>&ndash;&gt;-->
            <#--                    </div>-->
            <#--                    <div class="desc">A description of all the lectures and courses I have taken and my final degree?-->
            <#--                    </div>-->
            <#--                </div>-->
            <#--            </li>-->
            <#--            <!-- Item 2 &ndash;&gt;-->
            <#--            <li>-->
            <#--                <div class="direction-l">-->
            <#--                    <div class="flag-wrapper">-->
            <#--                        <span class="flag">Apple Inc.</span>-->
            <#--                        &lt;#&ndash;                        <span class="time-wrapper"><span class="time">2011 - 2013</span></span>&ndash;&gt;-->
            <#--                    </div>-->
            <#--                    <div class="desc">My first employer. All the stuff I've learned and projects I've been working on.-->
            <#--                    </div>-->
            <#--                </div>-->
            <#--            </li>-->
            <#--            <!-- Item 2 &ndash;&gt;-->
            <#--            <li>-->
            <#--                <div class="direction-l">-->
            <#--                    <div class="flag-wrapper">-->
            <#--                        <span class="flag">Your place of termination</span>-->
            <#--                        &lt;#&ndash;                        <span class="time-wrapper"><span class="time">2011 - 2013</span></span>&ndash;&gt;-->
            <#--                    </div>-->
            <#--                    <div class="desc">My first employer. All the stuff I've learned and projects I've been working on.-->
            <#--                    </div>-->
            <#--                </div>-->
            <#--            </li>-->
        </ul>
    </div>
</#macro>