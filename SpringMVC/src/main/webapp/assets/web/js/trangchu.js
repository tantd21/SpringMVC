$(document).ready(function(){
    $('.flashsalehotel-js').owlCarousel({
        loop:true,
        margin:10,
        nav:false,
        autoplay:true,
        autoplayTimeout:15000,
        smartSpeed:1200,
        dots:false,
        touchDrag:true,
        responsive:{
            1:{
                items:1
            },
            710:{
                items:2
            },
            1080:{
                items:3
            },
            1110:{
                items:3
            },
            1224:{
                items:3
            },
            1442:{
                items:4
            },
            1499:{
                items:4
            }
        }
    })
  });


  $(document).ready(function(){
    $('.hottelpricesbox-js').owlCarousel({
        loop:true,
        margin:10,
        nav:false,
        autoplay:true,
        autoplayTimeout:15000,
        smartSpeed:1200,
        dots:false,
        touchDrag:true,
        responsive:{
            1:{
                items:1
            },
            710:{
                items:2
            },
            1080:{
                items:3
            },
            1110:{
                items:3
            },
            1224:{
                items:3
            },
            1442:{
                items:4
            },
            1499:{
                items:4
            }
        }
    })
  });

  $(document).ready(function(){
    TweenMax.staggerFrom(
      $('.slider-js .item'), /* Phần tử được chọn */
      1, //Thời gian chuyển động
      { top:100,opacity:0},
      0.2 // Thời gian cách nhau mỗi hiệu ứng
    );
});

$(document).ready(function(){
    $(window).scroll(function(event){
        var pos_body = $('html,body').scrollTop();
        // console.log(pos_body);
        if(pos_body > 300){
            $('.flashsaletop-left-text').addClass('animate__animated animate__repeat-1 animate__bounceInLeft');
        };
        if(pos_body > 900){
            $('.places-title').addClass('animate__animated animate__repeat-1 animate__bounceIn ');
        };
        if(pos_body > 1500){
            $('.inspiration-box-top-title').addClass('animate__animated animate__repeat-1 animate__bounceIn ');
        };
    });
 });