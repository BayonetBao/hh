<%--
  Created by IntelliJ IDEA.
  User: Xena
  Date: 2018/5/23
  Time: 9:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>

<head>
    <title>商品修改页面</title>
</head>
<body>
<%--enctype="multipart/form-data" 文件上传--%>
<form enctype="multipart/form-data" action="${pageContext.request.contextPath}/goods/updateTrue.action?id=${good.id}" method="post" >
  <p>商品号：${good.id}</p>
  <p>商品名：${good.name}</p>
  <p>价格：<input name="price" type="number" value="${good.price}"/></p>
  <p>图片：<img name="pic" src="${pageContext.request.contextPath}/${good.pic}" width="50px" height="50px"/>

         <input name="imgFileUp" type="file"/>
  </p>

  <p>上架时间:<input type="date" name="createtime" value='<fmt:formatDate value="${good.createtime}" pattern="yyyy-MM-dd"></fmt:formatDate>'/></p>
    <p><input type="reset" value="取消"/>   <input type="submit" value="修改"/> </p>

</form>


</body>
</html>
