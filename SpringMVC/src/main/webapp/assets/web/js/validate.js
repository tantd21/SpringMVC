function Validator(options){

    var selectorRules = {

    };
    // Hàm thực hiện validate
    function validate(inputElement , rule){
        
        var errorElement = inputElement.parentElement.querySelector(options.errorSelector);
        var errorMessage;
        // Lấy ra các rules của selector
        var rules = selectorRules[rule.selector];
        // Lặp qua từ rule và kiểm tra
        // có lỗi thì dừng việc kiểm tra
        for ( var i = 0 ; i < rules.length ; ++i){
            errorMessage = rules[i](inputElement.value);
            if (errorMessage) break;
        }

        if(errorMessage){
            errorElement.innerText = errorMessage;
            inputElement.parentElement.classList.add('invalid');
        }
        else{
            errorElement.innerText = '';
            inputElement.parentElement.classList.remove('invalid');
        }
    }
   // Lấy element của form cần validate
    var formElement = document.querySelector(options.form);

    if(formElement){

        options.rules.forEach(function(rule){
            // Lưu lại các rules cho mỗi input
             if(Array.isArray(selectorRules[rule.selector])){
                selectorRules[rule.selector].push(rule.test);
             }else{
                selectorRules[rule.selector] = [rule.test];
            }

            var inputElement = formElement.querySelector(rule.selector);

           
            
            if(inputElement){
                // Xử lý trường hợp blur khỏi input
                inputElement.onblur = function(){
                    validate(inputElement,rule);
               
                }

                 // Xử lý trường hợp khi người dùng vào input
                 inputElement.oninput = function(){
                    var errorElement = inputElement.parentElement.querySelector(options.errorSelector);
                    errorElement.innerText = '';
                    inputElement.parentElement.classList.remove('invalid');
               
                }
            }
        });

    }
}

Validator.isRequired = function(selector, message){
    return{
        selector: selector,
        test: function(value){
            return value.trim() ? undefined : message || 'Vui lòng nhập trường này'
        }
    };

}

Validator.isEmail = function(selector, message){
    return{
        selector: selector,
        test: function(value){
            var regex = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
            return regex.test(value) ? undefined : message || 'Trường này phải là email'
        }
    };

}

Validator.minLength = function(selector , min, message){
    return{
        selector: selector,
        test: function(value) {
            return value.length >= min ? undefined : message || `Vui lòng nhập tối thiểu ${min} kí tự`
        }
    };
}

Validator.maxPrice = function(selector , min, message){
    return{
        selector: selector,
        test: function(value) {
            return value <= min ? undefined : message || `Vui lòng nhập tối đa số tiền ${min}đ`
        }
    };
}

Validator.minPrice = function(selector , min, message){
    return{
        selector: selector,
        test: function(value) {
            return value >= min ? undefined : message || `Vui lòng nhập tối thiểu số tiền ${min}đ`
        }
    };
}

Validator.minPricepercent = function(selector , min, message){
    return{
        selector: selector,
        test: function(value) {
            return value >= min ? undefined : message || `Vui lòng nhập tối thiểu ${min}%`
        }
    };
}

Validator.maxPricepercent = function(selector , min, message){
    return{
        selector: selector,
        test: function(value) {
            return value <= min ? undefined : message || `Vui lòng nhập tối đa ${min}%`
        }
    };
}

Validator.isConfirmed = function(selector , getCofirmValue , message){
    return{
        selector: selector,
        test: function(value){
            return value === getCofirmValue() ? undefined : message || 'Giá trị nhập vào không chính xác'
        }
    };
}
