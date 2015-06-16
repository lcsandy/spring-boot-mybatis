$(function(){
    $.ajaxSetup({ cache: false });
    $('#code').on('keyup',codeChange);
    $('#submit').on('click',submit);
})
function codeChange(){
    var code = $(this).val().trim();
    if( code.length<4 ){
        return
    }
    var offset=$(this).offset();
    var height=$(this).height();
    $.getJSON('./stock/search/'+code,function(data){
        if( !data.success ){
            alert(data.message)
            return
        }
        var html = Mustache.render($('#code-select-template').html(),data)
        $('#code-select').html(html).css({'display':'block','top':offset.top+height+10,'left':offset.left});
        $('.code-option').on('click',codeSelect);
    })
}
function codeSelect(){
    var code=$(this).val()
    var name = $(this).text().trim();
    $('#code').val(name).attr('code',code);
    $('#code-select').css('display','none');
}

function submit(){
    var stockId = $('#code').attr('code');
    if( stockId== undefined ){
        alert('请先选股票');
        return
    }
    var money = $('#money').val().trim();
    if(money.length==0){
        alert('请先输入投资');
        return
    }
    money*=1000;
    var date = new Date();

    window.location.href = "/result/?stockId="+stockId+'&date='+formatDateString(date)+"&money="+money;
}

function formatDateString(date){
    var year= date.getFullYear();
    var month = date.getMonth()+1;
    var day = date.getDate();
    if( month <10 ){
        month='0'+month
    }
    if( day <10 ){
        day = '0' + day
    }
    return year+'-'+month+'-'+day;
}