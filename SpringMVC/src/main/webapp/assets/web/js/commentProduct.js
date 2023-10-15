
function postCommentProduct(session_customerID){
    $('.post').click(function (e) {

        let pd = $('#product_id').val();
        let cd = session_customerID;
        let tt = $('.titleComment').val();
        let ct = $('.contentComment').val();
        console.log(pd + " " + cd + " " + tt + " " + ct);

        let data = "product_id="+pd+"&customer_id="+cd+"&title_comment="+tt+"&content_comment="+ct;
        console.log("ban dã click post new ajax ");

        $.ajaxSetup({
            headers: {
                'X-CSRF-TOKEN': $("meta[name='csrf-token']").attr('content')
            }
        });

        $.ajax({
            url: './uploadCommentProduct',
            method: 'post',
            data: {
                // _token: _token,
                product_id: pd,
                customer_id: cd,
                title_comment: tt,
                content_comment: ct
            },
            success: function(data) {
                // load_cart();
                console.log("click post upload new ajax");
                console.log(data);

                $('.titleComment').val("");
                $('.contentComment').val("");
                reloadListTop5CommentProduct();

            },
            error: function() {
                alert("Lỗi k upload được :<<");
            }
        });
    });
}

function seeMoreCommentProduct() {
    $('.content-seeMore-Userwrite').click(function () {
        if($('.showMoreShowLess').text() == "Xem thêm")
        {
            reloadListCommentProduct();
            $('.showMoreShowLess').text('Thu gọn');
            $('.stopPoint')[0].click();

        }
        else 
        {
            reloadListTop5CommentProduct();
            $('.showMoreShowLess').text('Xem thêm');
            $('.stopPoint')[0].click();
        }
        // console.log($('.showMoreShowLess').text());
    });
}

function reloadListCommentProduct() {

    let pd = $('#product_id').val();

    // $.ajaxSetup({
    //     headers: {
    //         'X-CSRF-TOKEN': $("meta[name='csrf-token']").attr('content')
    //     }
    // });

    $.ajax({
        url: './reloadCommentProduct',
        method: 'get',
        data: {
            product_id: pd
        },
        success: function(data) {
            console.log('load success!');
            $('.big-div-Userwrite').html(data);
        },
        error: function() {
            alert("Lỗi k reload được :<<");
        }
    });
}

function reloadListTop5CommentProduct() {

    let pd = $('#product_id').val();

    // $.ajaxSetup({
    //     headers: {
    //         'X-CSRF-TOKEN': $("meta[name='csrf-token']").attr('content')
    //     }
    // });

    $.ajax({
        url: './reloadTop5CommentProduct',
        method: 'get',
        data: {
            product_id: pd
        },
        success: function(data) {
            console.log('load success!');
            $('.big-div-Userwrite').html(data);
        },
        error: function() {
            alert("Lỗi k reload được :<<");
        }
    });
}