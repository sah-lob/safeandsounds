$(window).load(function () {
    $('.post-module').hover(function () {
        $(this).find('.description').stop().animate({
            height: "toggle",
            opacity: "toggle"
        }, 300);
    });
});


$(function () {
    $('.like-toggle').click(function () {
        let tourId = $(this).val();
        $.post(
            "/like",
            {
                tourId: tourId
            }
        );
        $(this).toggleClass('like-active');
        $(this).next().toggleClass('hidden');
    });
});