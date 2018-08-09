<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	
</script>
<body>
	<form name="venderproduct_list" id="venderproduct_list" method="post"
		data-parsley-validate="true" enctype="multipart/form-data">

		<div class="container" style="margin-top: 10px">
			<div class="row">
				<div class="col-md-2"></div>
				<div class="col-md-8 text-center">
					<h1 style="text-align: center">거래처물품 관리</h1>
				</div>
				<div class="col-md-4"></div>
			</div>
			<table class="table table-bordered" style="text-align: center"
				id="dataTable">
				<thead class="thead-dark">
					<tr>
						<th scope="col">거래처이름</th>
						<th scope="col">물품이름</th>
						<th scope="col">단위</th>
						<th scope="col">가격</th>
						<th scope="col">메모</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="venderProduct" items="${venderProducts}" varStatus="status">
						<tr>
							<td style="text-align: center; vertical-align: middle;"> ${venderProduct.vendername}</td>
							<td style="text-align: center; vertical-align: middle;"><a
								href="venderproductUpdateForm?venderproductcode=${venderProduct.venderproductcode}">
								${venderProduct.proname}</a></td>
							<td style="text-align: center; vertical-align: middle;">
								${venderProduct.capacity}</td>
							<td style="text-align: center; vertical-align: middle;">
								${venderProduct.price}</td>
							<td style="text-align: center; vertical-align: middle;">
								${venderProduct.memo}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</form>
</body>
</html>