<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin</title>
<%@ include file="/common/admin/lib_admin.jsp"%>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">

<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/js/bootstrap.min.js"></script>
<script src="../jquery.twbsPagination.js" type="text/javascript"></script>
</head>
<body>
	<div class="layout-wrapper layout-content-navbar">
		<div class="layout-container">
			<!-- menu -->
			<%@ include file="/common/admin/menu.jsp"%>
			<!-- menu -->
			<div class="layout-page">
				<!--header-->
				<%@ include file="/common/admin/header.jsp"%>

				<!--header-->


				<!--san pham -->

				<div class="container mt-5 mb-5">

					<div class="add d-flex justify-content-between">
						<form action="product" class="d-flex">

							<div class="form-group me-2">
								<input type="text" name="keyword" class="form-control"
									placeholder="Tìm kiếm...">

							</div>
							<div class="form-group me-2">
								<button class="btn btn-info" type="submit">
									<i class="fa-solid fa-magnifying-glass"></i>
								</button>
							</div>
						</form>
						<div class="form-group me-2">
							<a href="${pageContext.request.contextPath}/product/add"
								class="btn btn-primary"><i class="fa-solid fa-plus"></i></a>
						</div>
					</div>
					<h4 class="text-center">Danh sách sản phẩm</h4>
					<table class="table table-bordered  mt-5 mb-5 ">
						<tr>
							<td class="vertical-align-middle text-center"><strong>Id</strong>
							</td>
							<td class="vertical-align-middle text-center"><strong>Tên
									sản phẩm</strong></td>
							<td class="vertical-align-middle text-center"><strong>Danh
									mục sản phẩm</strong></td>
							<td class="vertical-align-middle text-center"><strong>Giá
									sản phẩm</strong></td>
							<td class="vertical-align-middle text-center"><strong>Giá
									sale sản phẩm</strong></td>
							<td class="vertical-align-middle text-center"><strong>Ảnh
									sản phẩm</strong></td>
							<td></td>

						</tr>
						<c:forEach items="${listPage}" var="p" varStatus="loop">
							<tr>
								<td class="vertical-align-middle text-center">${p.productId}</td>
								<td class="vertical-align-middle text-center">${p.productName}</td>
								<td class="vertical-align-middle text-center">${p.category.categoryName}</td>
								<td class="vertical-align-middle text-center">${p.price}</td>
								<td class="vertical-align-middle text-center">${p.sale_price}</td>
								<td class="vertical-align-middle text-center"><img alt=""
									src="${pageContext.request.contextPath}/<c:url value="resources/uploads"/>/images/${p.image}"
									width="100px"></td>
								<td class="vertical-align-middle text-center"><a
									href="product/editProduct/${p.productId}"
									class="btn btn-primary"><i class="fa-solid fa-edit"></i> </a> <a
									href="product/deleteProduct/${p.productId}"
									class="btn btn-danger"><i class="fa-solid fa-trash"></i></a></td>
							</tr>
						</c:forEach>
					</table>
					<ul class="pagination">
						<c:choose>
							<c:when test="${(empty(param.keyword))}">
								<li class="page-item"><a class="page-link"
									href="?pageno=${totalPage-1}" aria-label="Previous"> <span
										aria-hidden="true">&laquo;</span>
								</a></li>
								<c:forEach var="i" begin="1" end="${totalPage}">
									<li class="page-item"><a class="page-link"
										href="?pageno=${i}">${i}</a></li>
								</c:forEach>
								<li class="page-item"><a class="page-link"
									href="?pageno=${totalPage}" aria-label="Next"> <span
										aria-hidden="true">&raquo;</span>
								</a></li>

							</c:when>
							<c:otherwise>
								<li class="page-item"><a class="page-link"
									href="?pageno=${totalPage}" aria-label="Previous"> <span
										aria-hidden="true">&laquo;</span>
								</a></li>
								<c:forEach var="i" begin="1" end="${totalPage}">
									<li class="page-item"><a class="page-link"
										href="?pageno=${i}&keyword=${param.keyword}">${i}</a></li>
								</c:forEach>
								<li class="page-item"><a class="page-link"
									href="?pageno=${totalPage}" aria-label="Next"> <span
										aria-hidden="true">&raquo;</span>
								</a></li>
							</c:otherwise>
						</c:choose>
					</ul>

				</div>
				<div class="content-wrapper">

					<!-- main -->

					<!-- main -->

					<!--footer-->
					<%@ include file="/common/admin/footer.jsp"%>
					<!--footer-->
				</div>
			</div>
		</div>
		<div class="layout-overlay layout-menu-toggle"></div>
	</div>
	<div class="buy-now">
		<a
			href="https://themeselection.com/products/sneat-bootstrap-html-admin-template/"
			target="_blank" class="btn btn-danger btn-buy-now">Upgrade to Pro</a>
	</div>
	<script
		src="<c:url value="/template/admin/assets/vendor/libs/jquery/jquery.js" />"></script>

	<script
		src="<c:url value="/template/admin/assets/vendor/libs/popper/popper.js" />"></script>
	<script
		src="<c:url value="/template/admin/assets/vendor/js/bootstrap.js" />"></script>
	<script
		src="<c:url value="/template/admin/assets/vendor/libs/perfect-scrollbar/perfect-scrollbar.js" />"></script>

	<script src="<c:url value="/template/admin/assets/vendor/js/menu.js"/>"></script>
	<script
		src="<c:url value="/template/admin/assets/vendor/libs/apex-charts/apexcharts.js" />"></script>

	<script src="<c:url value="/template/admin/assets/js/main.js"/>"></script>

	<script
		src="<c:url value="/template/admin/assets/js/dashboards-analytics.js"/>"></script>

	<script async defer src="https://buttons.github.io/buttons.js"></script>
</body>
</html>