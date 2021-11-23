<%--
  Created by IntelliJ IDEA.
  User: MaoIno
  Date: 2021/11/21
  Time: 8:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

<script type="text/javascript" src=""></script>
<script type="text/javascript">
    $(function(){
        $("button").click(function(){
            $.ajax({
                url:"some.do",
                data:{
                    name:"zhangsan",
                    age:20
                },
                type:"post",
                //dataType:"json",
                success:function(resp){
                  alert(resp)
                }
            })
        })
    })
</script>
</head>
<body>
    <%--<p><a href="test/some.do" > 发起一个请求,来调用方法</a></p>
    <form action="test/other.do" method="post">
        <input type="submit" value="max" />
    </form>--%>
    <form action="some.do" method="post">
        name:<input type="text" name="rname" /><br>
        age:<input type="text" name="rage" /><br>
        <button type="submit" value="max" />
    </form>
    <%--<button type="submit" value="a"/>--%>
</body>
</html>
