<%-- <%@page import="bean.UserBean"%>
<%@page import="bean.giohangbean"%>

<%@page import="bo.giohangbo"%>
<%@page import="bean.sachbean"%>
<%@page import="bo.sachbo"%>
<%@page import="bean.sachbean"%>
<%@page import="bean.loaibean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bo.loaibo"%>
<%@page import="bean.lichsubean"%>
<%@page import="bo.lichsubo"%>
<%@page import="dao.lichsudao"%> --%>
<%@page import="entity.HistoryStore"%>
<%@page import="dao.lichsudao"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Giỏ hàng</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <style >
  		.slform {
  		width: 60px;
  		}
  </style>
</head>
<body>
<jsp:include page="Menuheader.jsp"></jsp:include>
<table width="1000" align="center">
  <tr>
  <td width="800" valign="top">
     <table class="table table-hover">
	 <th scope="col" width="200px">Tên sách</th>
	 <th scope="col">Ngày mua</th>
	 <th scope="col">Số lượng</th>
	 <th scope="col">Giá tiền</th>
	 <th scope="col">Thành tiền</th>
	 	 <th scope="col">Trạng thái</th>
      <%
      
     
      ArrayList<HistoryStore> dsls = (ArrayList<HistoryStore>) request.getAttribute("dsls");
		if (dsls != null) {
			int n = dsls.size();
			for (int i = 0; i < n; i++) {
				HistoryStore s = dsls.get(i);

		%>
		<tr>
			<td><%=s.getNgaymua()%></td>
			<td><%=s.getTensach()%></td>	
			<td><%=s.getSoluongmua()%></td>
			<td><%=s.getGia()%></td>
			<td><%=s.getThanhtien()%></td>
			<%if(s.isDamua() == true) {%>
				<td class="text-success">Đã hoàn tất</td>
			<%}else { %>
				<td class="text-danger">Chưa hoàn tất</td>
			<%} %>
		</tr>
		<%
		}
		%>

		<%
		}
		%>
    </table>
   </td>
  </tr>
</table>
</body>
</html>