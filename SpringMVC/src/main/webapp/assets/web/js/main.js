$(window).on('load',function(event){
    $('body').removeClass('preloading');
    $('.load').delay(500).fadeOut('fast'); /* fade fast/400/slow */
  });

$(document).ready(function(){ 
    $(window).scroll(function(){
        if($(this).scrollTop()){
            $('.navbar').addClass('sticky');
            $('.navbar-item-link').addClass('sticky-color');
        }else{
            $('.navbar').removeClass('sticky');
            $('.navbar-item-link').removeClass('sticky-color');
        }
    });   
});



// $( "#dangnhap" ).click(function() {
//     // $('.fromlogin').css('display', 'block'); 
//     // $('.fromsignup').css('display', 'none'); 
//     // // $('.fromlogin').show();
//     // // $('.fromsignup').hide();
//     alert( "Nhan Test Code" );
//   });
//   $( ".fromlogin-close" ).click(function() {
//     $('.fromlogin').hide();
//   });
// //   $( "#dangky" ).click(function() {
// //     alert( "Nhan Test Code" );
// //   });

$(document).ready(function(){
    $('.slider-js').owlCarousel({
        loop:true,
        margin:15,
        nav:false,
        autoplay:true,
        autoplayTimeout:2500,
        smartSpeed:1200,
        responsive:{
            0:{
                items:1
            },
            739:{
                items:2
            },
            1050:{
                items:3
            }
        }
    })
  });



  $(document).ready(function(){
    $('.recentlyviewed_boxcontent').owlCarousel({
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
                items:3
            },
            1200:{
                items:4
            }
        }
    })
  });







  $(document).ready(function(){
    $(window).scroll(function(event){
        var pos_body = $('html,body').scrollTop();
        // console.log(pos_body);
        // if(pos_body ==  500){
        //     TweenMax.staggerFrom(
        //         $('.flashsalehotel .flashsalehotel_boxcontent'), /* Phần tử được chọn */
        //         1, //Thời gian chuyển động
        //         { top:100,opacity:0},
        //         0.2 // Thời gian cách nhau mỗi hiệu ứng
        //       );
        // };
        // return;
    });
  });


//     var mockData = [
//     {
//         name : 'Le Boutique Danang',
//         place: 'Quận Hải Châu',
//         img: 'assets/img/trangchu/sale/1.jpg',
//     },
//     {
//         name : 'InterContinental Resort',
//         place: 'Quận Liên Chiểu',
//         img: 'assets/img/trangchu/sale/2.jpg',
//     },
//     {
//         name : 'Furama Resort Danang',
//         place: ' Quận Ngũ Hành Sơn',
//         img: 'assets/img/trangchu/sale/3.jpg',
//     },
//     {
//         name : ' Khách Sạn Crowne Plaza',
//         place: ' Quận Thanh Khê',
//         img: 'assets/img/trangchu/sale/4.jpg',
//     },
//     {
//         name : ' Melia Danang Beach Resort',
//         place: 'Quận Cẩm Lệ',
//         img: 'assets/img/trangchu/sale/5.jpg',
//     },
//     {
//         name : ' Khách sạn Mường Thanh Grand',
//         place: 'Quận Sơn Trà',
//         img: 'assets/img/trangchu/sale/6.png',
//     },
//     {
//     name : ' Khách Sạn Đà Nẵng',
//     place: ' Quận Hải Châu',
//     img: 'assets/img/trangchu/sale/7.jpg',
//     }
// ]

//    var inputsearchhotel  = document.querySelector('.inputsearchhotel')

//     mockData.forEach(item =>{
//         var newInfosearchhotel = document.createElement('div')
//         newInfosearchhotel.classList.add('infosearchhotel')
//         newInfosearchhotel.innerHTML = `
//         <div class="infosearchhotel-img">
//         <img width="100px" height="70px" style="border-radius: 8px;object-fit: cover;" src="${item.img}" alt="">
//     </div>
//     <div class="infosearchhotel-text">
//         <div class="infosearchhotel-name">
//             ${item.name}
//         </div>
//         <div class="infosearchhotel-place">
//         <i class="fa-solid fa-location-dot"></i>
//             ${item.place}
//         </div>
//     </div>`
//     inputsearchhotel.appendChild(newInfosearchhotel)
//     }) 
    
    var sreachInput = document.querySelector('.BoxSearch-Bottom-One-input-size')
    sreachInput.addEventListener('input',function(e){
        let txtSreach = e.target.value.trim().toLowerCase()
        let listHotelDOM = document.querySelectorAll('.infosearchhotel')
        listHotelDOM.forEach(item => {
            console.log(item.innerText.includes(txtSreach));
            if(item.innerText.toLowerCase().includes(txtSreach)){
                item.classList.remove('hide')
            }else{
                item.classList.add('hide')
            }
        })
    }) 







    
   
   