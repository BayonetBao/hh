<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<meta http-equiv="X-UA-Compatible"content="IE=9; IE=8; IE=7; IE=EDGE" />
		<title>商品列表页面</title>
		<link href="<%= basePath %>css/all.css" rel="stylesheet" type="text/css" />
		<script src="<%= basePath %>js/jquery-1.8.0.min.js"></script>
		<script src="<%= basePath %>js/list.js"></script>
	</head>
	<body style="background: #e1e9eb;">
		<form action="<%= basePath %>List.action" id="mainForm" method="post">
			<input type="hidden" name="currentPage" id="currentPage" value="${page.currentPage}"/>
			
			<div class="right">
				<div class="current">当前位置：<a href="javascript:void(0)" style="color:#6E6E6E;" onclick="">商品管理</a> &gt; 商品列表</div>
				<div class="rightCont">
					<p class="g_title fix">商品列表 <a class="btn03" href="#">新 增</a></p>
					<table class="tab1">
						<tbody>
							<tr>
								<td width="90" align="right">商品号：</td>
								<td>
									<input name="gid" type="text" class="allInput" />
								</td>
								<td width="90" align="right">商品名：</td>
								<td>
									<input name="gname" type="text" class="allInput"/>
								</td>
								<td width="90" align="right">价格：</td>
								<td>
									<input name="minprice" type="text" class="allInput" /> &nbsp;~ &nbsp;
								</td>
								<td>
									<input name="maxprice" type="text" class="allInput" />
								</td>

								<td width="90" align="right">类别：</td>
								<td>
									<select name="catory">
										<option value="1">--请输入类别--</option>
										<c:forEach items="${clist}" var="catory">
											<option value="${catory.id}">${catory.cname}</option>
										</c:forEach>


									</select>
								</td>

	                            <td width="85" align="right"><input type="submit" class="tabSub" value="查 询" /></td>
	       					</tr>
						</tbody>
					</table>
					<div class="zixun fix">
						<table class="tab2" width="100%">
							<tbody>
								<tr>
								    <th><input type="checkbox" id="all"/></th>
								    <th>商品号</th>
								    <th>商品名</th>
								    <th>价格</th>
								    <th>图片</th>
								    <th>上架时间</th>
								    <th>类别</th>
									<th>操作</th>
								</tr>
								<c:forEach items="${glist}" var="good">
									<tr>
 										<td><input type="checkbox"/></td>
										<td>${good.id}</td>
										<td>${good.name}</td>
										<td>${good.price}</td>
										<td ><img width="30px" height="30px" src="${pageContext.request.contextPath}/${good.pic}"/> </td>
										<td>
												<fmt:formatDate value="${good.createtime}" pattern="yyyy-MM-dd hh:mm:ss"></fmt:formatDate>
												</td>
										<td>${good.catory.cname}</td>
										<td>
											<a href="<%=basePath%>goods/update.action?id=${good.id}">修改</a>
											<a href="<%=basePath%>goods/delete.action?id=${good.id}">删除</a>
										</td>
									</tr>
								</c:forEach>

							</tbody>
						</table>
						<div class='page fix'>
							共 <b>${page.totalNumber}</b> 条
							<c:if test="${page.currentPage != 1}">
								<a href="javascript:changeCurrentPage('1')" class='first'>首页</a>
								<a href="javascript:changeCurrentPage('${page.currentPage-1}')" class='pre'>上一页</a>
							</c:if>
							当前第<span>${page.currentPage}/${page.totalPage}</span>页
							<c:if test="${page.currentPage != page.totalPage}">
								<a href="javascript:changeCurrentPage('${page.currentPage+1}')" class='next'>下一页</a>
								<a href="javascript:changeCurrentPage('${page.totalPage}')" class='last'>末页</a>
							</c:if>
							跳至&nbsp;<input id="currentPageText" type='text' value='${page.currentPage}' class='allInput w28' />&nbsp;页&nbsp;
							<a href="javascript:changeCurrentPage($('#currentPageText').val())" class='go'>GO</a>
						</div>
					</div>
				</div>
			</div>
	    </form>
	</body>
</html>