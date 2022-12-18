<%@page import="entity.Cart"%>
<%@page import="entity.Account"%>

<%@page import="bo.giohangbo"%>

<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>

<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">


</head>
<body>

 <jsp:include page="Menuheader.jsp"></jsp:include>
	


	<table width="1000" align="center">
		<tr>
			<td width="100" valign="top">
		</tr>
		<td width="800" valign="top">
			<table class="table table-hover">
				<th scope="col" >ID</th>
				<th scope="col" width="200px">Name</th>
				<th scope="col">Image</th>
				<th scope="col">Price</th>
				<th scope="col" width="60px">Amount</th>
				<th scope="col">Total Money</th>
				<th scope="col"></th>

<%
	giohangbo gh = (giohangbo) session.getAttribute("gio");
	String key = request.getParameter("soluong");
	long tongtien = 0;

	if (gh != null) {
		for (Cart h : gh.ds) {

			tongtien += h.getTotalMoney();
	%>
				<form action="suaxoacls?ms=<%=h.getId()%>" method="post">
					<tr>

						<td><%=h.getId()%></td>

						<td><%=h.getName()%></td>
						<td>
						      <img style="height: 80px; width: 80px;" alt="anh" src="<%=h.getImage()%>">
						
						</td>

						<td><%=h.getPrice()%></td>
						<td><input class="form-control" name="txtsl" type="number"
							min="0" width="25" value="0"></td>
						<td><%=h.getTotalMoney()%></td>

						<td><input class="btn-primary" name="butsua" type="submit"
							value="Update">
							 <input class="btn-primary" name="butxoa"
							type="submit" value="Delete">
				</form>







				</td>
				</tr>






				<%
				}
				} else {
				%>
				Giỏ Hàng Trống
				<form action="HomeControl">
					<input class="btn-primary" name="" type="submit"
						value="Quay Lại Mua Hàng">
				</form>


				<%
				}
				%>




			</table>
			<table>
				<h3>
					<span class="label label-info">Tổng tiền: <%=tongtien%> VND
					</span>
				</h3>


			</table>

			<form action="thanhtoanctl" method="post">

				<button name="abc" type="submit" value="">Đặt mua</button>

			</form>

		</td>
		</tr>

	</table>

</body>
</html>

