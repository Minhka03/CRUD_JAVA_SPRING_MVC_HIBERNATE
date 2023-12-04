<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- breadcrumb start -->
<div class="breadcrumb">
	<div class="container">
		<ul class="list-unstyled d-flex align-items-center m-0">
			<li><a href="https://spreethemesprevious.github.io/">Home</a></li>
			<li><svg class="icon icon-breadcrumb" width="64" height="64"
					viewBox="0 0 64 64" fill="none" xmlns="http://www.w3.org/2000/svg">
                            <g opacity="0.4">
                                <path
						d="M25.9375 8.5625L23.0625 11.4375L43.625 32L23.0625 52.5625L25.9375 55.4375L47.9375 33.4375L49.3125 32L47.9375 30.5625L25.9375 8.5625Z"
						fill="#000" />
                            </g>
                        </svg></li>
			<li>Cart</li>
		</ul>
	</div>
</div>
<!-- breadcrumb end -->

<main id="MainContent" class="content-for-layout">
	<div class="cart-page mt-100">
		<div class="container">
			<div class="cart-page-wrapper">
				<div class="row">
					<div class="col-lg-7 col-md-12 col-12">
						<table class="cart-table w-100">
							<thead>
								<tr>
									<th class="cart-caption heading_18">Product</th>
									<th class="cart-caption heading_18"></th>
									<th
										class="cart-caption text-center heading_18 d-none d-md-table-cell">Quantity</th>
									<th class="cart-caption text-end heading_18">Price</th>
								</tr>
							</thead>

							<tbody>
								<c:forEach items="${listCart}" var="c">
									<tr class="cart-item">
										<td class="cart-item-media">
											<div class="mini-img-wrapper">
												<img class="mini-img"
													src="${pageContext.request.contextPath}/<c:url value="resources/uploads"/>/images/${c.product.image}" alt="img">
											</div>
										</td>
										<td class="cart-item-details">
											<h2 class="product-title">
												<a href="#">${c.product.productName}</a>
											</h2>
											<p class="product-vendor">XS / Dove Gray</p>
										</td>
										<td class="cart-item-quantity">
										<form action="">
										
										
											<div
												class="quantity d-flex align-items-center justify-content-between">
												<button class="qty-btn dec-qty" onclick="decreaseQuantity()" >
													<img src="${pageContext.request.contextPath}/resources/assets/img/icon/minus.svg" alt="minus">
												</button>
												<input class="qty-input" type="number" id="quantityInput"   value="${c.quantity}"
													min="0">
												<button class="qty-btn inc-qty" onclick="increaseQuantity()" >
													<img src="${pageContext.request.contextPath}/resources/assets/img/icon/plus.svg" alt="plus">
												</button>
												<button onclick="updateQuantity()">Update Quantity</button>
											</div> <a href="#" class="product-remove mt-2">Remove</a>
											</form>
										</td>
										<td class="cart-item-price text-end">
											<div class="product-price">${c.totalPrice}$</div>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<div class="col-lg-5 col-md-12 col-12">
						<div class="cart-total-area">
							<h3 class="cart-total-title d-none d-lg-block mb-0">
								Cart Totals
								</h4>
								<div class="cart-total-box mt-4">
									<div class="subtotal-item subtotal-box">
										<h4 class="subtotal-title">Subtotals:</h4>
										<p class="subtotal-value">$465.00</p>
									</div>
									<div class="subtotal-item shipping-box">
										<h4 class="subtotal-title">Shipping:</h4>
										<p class="subtotal-value">$10.00</p>
									</div>
									<div class="subtotal-item discount-box">
										<h4 class="subtotal-title">Discount:</h4>
										<p class="subtotal-value">$100.00</p>
									</div>
									<hr />
									<div class="subtotal-item discount-box">
										<h4 class="subtotal-title">Total:</h4>
										<p class="subtotal-value">$1000.00</p>
									</div>
									<p class="shipping_text">Shipping & taxes calculated at
										checkout</p>
									<div class="d-flex justify-content-center mt-4">
										<a href="checkout.html"
											class="position-relative btn-primary text-uppercase">
											Procced to checkout </a>
									</div>
								</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</main>

<script>
    function increaseQuantity() {
        var quantityInput = document.getElementById("quantityInput");
        var currentQuantity = parseInt(quantityInput.value);
        quantityInput.value = currentQuantity + 1;
    }

    function decreaseQuantity() {
        var quantityInput = document.getElementById("quantityInput");
        var currentQuantity = parseInt(quantityInput.value);
        if (currentQuantity > 1) {
            quantityInput.value = currentQuantity - 1;
        }
    }

    function updateQuantity() {
        var productId = 1; // Thay đổi productId tương ứng
        var quantity = parseInt(document.getElementById("quantityInput").value);

        $.ajax({
            type: 'POST',
            url: 'http://localhost:8080/Project_Srping_MVC_Hibernate/update_quantity' ,
            data: {
                productId: productId,
                quantity: quantity
            },
            success: function(response) {
                // Xử lý phản hồi từ Controller (nếu cần)
                // Ví dụ: Hiển thị thông báo cập nhật thành công
                alert("Quantity updated successfully");
            },
            error: function(xhr, status, error) {
                // Xử lý lỗi nếu có
                alert("Error updating quantity");
            }
        });
    }
</script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>