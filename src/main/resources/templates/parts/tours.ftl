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
                                <img src="/getLogin/?id=${tour.imagesId[0]}"/>
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
                                        ${tour.price} $
                                    </div>
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