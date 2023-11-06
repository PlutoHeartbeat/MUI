$(function (){
    $("input:eq(3)").click(function (){
        var serialize = $("#from").serialize();
        console.log(serialize);
        //使用ajax发送请求，携带数据
        $.ajax({
            type:"post",
            url:"loginServlet",
            // data:{username:usernameVal,password:pwdVal,code:codeVal},
            data:serialize,
            dataType:text,
            success:function(data){
                console.log(data);
            },
            error:function (){
                alert();
            }
        });
    });
});