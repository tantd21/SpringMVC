$(document).ready(function(){
    $('.ShowImgHotel-js').owlCarousel({
        loop:true,
        margin:10,
        nav:false,
        autoplay:true,
        autoplayTimeout:15000,
        smartSpeed:1200,
        dots:true,
        touchDrag:true,
        responsive:{
            0:{
                items:1
            },
            600:{
                items:1
            },
            1000:{
                items:1
            }
        }
    })
  });

  $(document).ready(function(){
    $('.inforooms-left-js').owlCarousel({
        loop:true,
        margin:10,
        nav:false,
        autoplay:true,
        autoplayTimeout:15000,
        smartSpeed:1200,
        dots:true,
        touchDrag:true,
        responsive:{
            0:{
                items:1
            },
            600:{
                items:1
            },
            1000:{
                items:1
            }
        }
    })
  });

  $(document).ready(function(){
    $('.trendinghotel-js').owlCarousel({
        loop:true,
        margin:10,
        nav:false,
        autoplay:true,
        autoplayTimeout:15000,
        smartSpeed:1200,
        dots:false,
        touchDrag:true,
        responsive:{
            0:{
                items:1
            },
            600:{
                items:2
            },
            1000:{
                items:4
            }
        }
    })
  });

  $(document).ready(function(){

    // $(window).scroll(function(event){
    //     var pos_body = $('html,body').scrollTop();
    //     console.log(pos_body);
    // });

    $('#MeliaDanangBeachResort-Click').on('click',function(event){
        event.preventDefault(); /* Hủy sự kiện thẻ a */
        $('html,body').animate({scrollTop:1},400);
    });

    $('#MeliaDanangBeachResort-Map-Service-Click').on('click',function(event){
        event.preventDefault();
        $('html,body').animate({scrollTop:700},400);
    });

    $('#chooserooms-click').on('click',function(event){
        event.preventDefault();
        $('html,body').animate({scrollTop:951},400);
    });

    $('#userswrite-click').on('click',function(event){
        event.preventDefault();
        $('html,body').animate({scrollTop:3194},400);
    });

    $('#policy-click').on('click',function(event){
        event.preventDefault();
        $('html,body').animate({scrollTop:4280},400);
    });

    $('#hotelmessageboard-click').on('click',function(event){
        event.preventDefault();
        $('html,body').animate({scrollTop:4640},400);
    });

  });


  $(document).ready(function(){ 
    $(window).scroll(function(){
        if($(this).scrollTop()){
            $('.BoxSearch-infohotel').addClass('BoxSearch-fixed');
            $('.BoxSearch-End').addClass('BoxSearch-End-Show');
        }else{
            $('.BoxSearch-infohotel').removeClass('BoxSearch-fixed');
            $('.BoxSearch-End').removeClass('BoxSearch-End-Show');
        }
    });   
});

$( ".chooseroomsbox-boxcontent-bottom-img-bottomtext" ).click(function() {
    $('.inforooms').css('display', 'block'); 
    $('.inforooms_overlay').css('display', 'block');   
  });
  $( ".inforooms-right-btn-X" ).click(function() {
    $('.inforooms').css('display', 'none');  
    $('.inforooms_overlay').css('display', 'none');  
  });
  $( ".inforooms_overlay" ).click(function() {
    $('.inforooms').css('display', 'none');  
    $('.inforooms_overlay').css('display', 'none');  
  });



  $('#lightSlider').lightSlider({
    gallery: true,
    item: 1,
    loop:true,
    slideMargin: 0,
    thumbItem: 9
});