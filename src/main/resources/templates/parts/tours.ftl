<#macro tours page>
    <link rel="stylesheet" type="text/css" href="../css/parts/tours.css"/>
    <script src="../js/parts/tours.js"></script>
    <div class="tours">
        <ul class="products clearfix">
            <#list  page.content as tour>
                <li class="product-wrapper">
                    <div class="tour">
                        <div class="post-module">
                            <div class="photo">
                                <img src="img/tt.png"/>
                            </div>
                            <div class="post-content">
                                <h1 class="title">${tour.name}</h1>
                                <h2 class="sub_title">The city that never sleeps.</h2>
                                <div class="description">
                                    ${tour.smallDescription}
                                    <a href="/chooseTour?id=${tour.id}">
                                        <div class="tourBtn">
                                            Подробнее
                                        </div>
                                    </a>
                                </div>
                                <div class="post-footer">
                                    <div class="price">
                                        ${tour.economyPrice} $
                                    </div>
                                    <#if tour.likedByPerson>
                                        <div class='like'>
                                            <button class="like-toggle basic2 like-active"
                                                    id="calenderHeaderMonthsNametest"
                                                    value="${tour.id}"> ♥
                                            </button>
                                            <span class="">I like this</span>
                                        </div>
                                    <#else>
                                        <div class='like'>
                                            <button class='like-toggle basic2' id="calenderHeaderMonthsNametest"
                                                    value="${tour.id}"> ♥
                                            </button>
                                            <span class='hidden'>I like this</span>
                                        </div>
                                    </#if>

                                    <#--                                    <div class="price">-->
                                    <#--                                        ${tour.economyPrice} $-->
                                    <#--                                    </div>-->
                                    <div class="duration">
                                        ${tour.duration}
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </li>
            </#list>
        </ul>
    </div>
</#macro>