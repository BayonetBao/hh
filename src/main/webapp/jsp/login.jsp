<%--
  Created by IntelliJ IDEA.
  User: Xena
  Date: 2018/5/22
  Time: 10:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>登陆</title>
    <script src="<%= basePath %>js/jquery-1.8.0.min.js"></script>
    <script>
        function  register(name) {
            //alert(111);
            $.ajax(
                {
                    type:"post",
                    url:"${pageContext.request.contextPath}/user/findUname.action",
                    data:"uname="+name,
                    //接收返回数据
                    success:function (zhi) {
                        if(zhi==true){
                            $("#uname").html("用户名已存在！！！")
                        }else{
                            $("#uname").html("用户名可以使用");
                            $("#uname").style.color;
                        }
                    }
                }
            );
        }
        $("#form1").submit(function () {
            return false;
        });


    </script>
</head>
<body>
<%--login的处理器，匹配用户名和密码     login.action
 <%= application.getContextPath()%>   获得项目名    http://ip:端口号/项目名
--%>
<form id="form1" action="" method="post" >

    <p>用户名：<input id="name" name="uname" onblur="register(this.value)" type="text" placeholder="请输入用户名" onblur="deng(this.value)"/>
    <span id="uname" style="color: red;font-size: 12px"></span>
    </p>
    <p>密码：  <input name="pwd" type="password" placeholder="请输入密码"/> </p>

    <p>
        <input type="reset" value="取消"/>
        <input type="submit" value="登陆"/>
    </p>
</form>


</body>
</html>
