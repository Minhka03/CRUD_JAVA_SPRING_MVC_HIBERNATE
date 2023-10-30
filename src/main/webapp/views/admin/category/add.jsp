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
				<form class="m-5" action="insertCategory" method="post">
					<h5 class="text-center">Thêm mới Danh mục Category</h5>
					<div class="form-row">
						<div class="form-group col-md-6">
							<label for="inputCity">Tên Danh mục</label> <input type="text"
								name="categoryName" class="form-control">
							<span class="text-danger" name="categoryName" ></span>
						</div>
					</div>


					<label for="inputCity">Trạng thái</label>
					<div class="form-group col-md-6">
						<input type="radio" name="categoryStatus" checked="checked"
							value="1" id="inputCity">Active
					</div>
					<div class="form-group col-md-6">
						<input type="radio" name="categoryStatus" value="0" id="inputCity">Hidden
					</div>


					<button type="submit" class="btn btn-primary">Add</button>
				</form>

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