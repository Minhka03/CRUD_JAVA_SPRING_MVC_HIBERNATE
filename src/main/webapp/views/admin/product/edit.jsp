<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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
				<form:form class="m-5"
					action="${pageContext.request.contextPath}/admin/product/editProduct/${product.productId}"
					modelAttribute="product" method="post"
					enctype="multipart/form-data">
					<form:input path="productId" type="hidden" />
					<h5 class="text-center">Thêm mới sản phẩm</h5>
					<div class="form-row">
						<div class="form-group col-md-6">
							<label for="inputCity">Tên sản phẩm</label>
							<form:input type="text" path="productName" class="form-control" />
						
						</div>
						<div class="form-group col-md-6">
							<label for="inputCity">Giá sản phẩm</label>
							<form:input type="text" path="price" class="form-control" />
							
						</div>
						<div class="form-group col-md-6">
							<form:select path="category.categoryId" class="form-control">
								<form:options items="${listCategory}" itemLabel="categoryName"
									itemValue="categoryId"></form:options>
							</form:select>
						</div>
						<div class="form-group col-md-6">
							<label for="inputCity">Giá sale sản phẩm</label>
							<form:input type="text" path="sale_price" class="form-control" />
							
						</div>
						<div class="form-group col-md-6">
							<label for="inputCity">Mô tả</label>
							<form:textarea rows="10" path="description" class="form-control"
								cols=""></form:textarea>
								
						</div>
						<div class="form-group col-md-6">
							<label for="inputCity">Ảnh sản phẩm</label>
							<form:input type="file" id="my_img" onchange="file_image()"
								path="image" class="form-control" />
								
							<img alt="" class="mt-3" id="image_preview"
								src="${pageContext.request.contextPath}/resources/uploads/images/${product.image}"
								width="300px">
						</div>

					</div>



					<button type="submit" class="btn btn-primary">Add</button>
				</form:form>

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

	<script type="text/javascript">
		function file_image() {
			var file = document.getElementById('my_img').files[0]
			var fr = new FileReader()
			fr.readAsDataURL(file)
			fr.onload = function(e) {
				var img = document.getElementById('image_preview');
				img.src = this.result;
			}
		}
	</script>

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