<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta name="viewport" content="width=device-width">
		<title>Cosho Home Page</title>
		<!-- <spring:url value="/resources/css/style.css" var="styleCss" /> -->
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/headerFooter.css" />">
		<%-- <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style1.css" />">
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/product.css" />">
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/logiStyle.css" />"> 
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/productdescription.css" />"> --%>
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/cart.css" />">
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/w3.css" />">
		<link rel="stylesheet" type="text/css"  href="<c:url value="/resources/css/font-awesome.css" />">
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.css" /> ">
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/icons.css" /> ">
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/all.css" /> ">
		<style>
			.mySlides {display:none}
			.w3-left, .w3-right, .w3-badge {cursor:pointer}
			.w3-badge {height:10px;width:10px;padding:0;margin-bottom: 0px}
			.w3-section{height: 15px}
			
		</style>
	</head>
<body>
	<header>
			<div class="container">
			
				<div id="topheader">
					
						<ul>
							<li><a class="viewCart" href="giftcard.jsp">Gift Card</a></li>
							<li><a class="viewCart" href="aboutus.jsp">About</a></li>
							<li>Contact Us</li>
							<li><a class="viewCart" href="viewCart">View Cart</a></li>
							<li><a class="viewCart" href="orderDetails">Order Detail</a></li>
						</ul>
					
				</div>
				<div class="company-container">
					<div class="company-name-tag">
						<img class="brand-tag" src="<c:url value="/resources/img/brandTag/tag3.png" />" />	
						<a href="home.jsp">CoSho</a>
					</div>
					<div class="categories-list">
						<ul>
							<!-- <li><div style="border-bottom: #ee5f73 1px solid;"><a href="product12/pdca103" >Men</a></div></li> -->
							<li><div style="border-bottom: #ee5f73 1px solid;"><a href="<c:url value="product12">
							 	<c:param name="productCategoryId" value="pdca101" /> </c:url>" >Men</a></div></li>
							<li><div style="border-bottom: #F529A7 1px solid;"><a href="<c:url value="product12">
							 	<c:param name="productCategoryId" value="pdca102" /> </c:url>" >Women</a></div></li>
							<li><div style="border-bottom: #f26a10 1px solid;"><a href="<c:url value="product12">
							 	<c:param name="productCategoryId" value="pdca103" /> </c:url>" >Kids</a></div></li>
							<li><div style="border-bottom: #f2c210 1px solid;"><a href="<c:url value="product12">
							 	<c:param name="productCategoryId" value="pdca104" /> </c:url>" >Home & Living</a></div></li>
						</ul>
					</div>
					<div id="homeSearch">
							<input type="search" name="search" placeholder="Search">
							<button type="submit" class="button_1">Search</button>
								
				&nbsp;
						
								${user_name} / <a href="logout">Logout</a></span>
				
					</div>
					

				</div>
			
				<!-- <div id="topheader">
					
						<ul>
							<li>Gift Card</li>
							<li>About</li>
							<li>Contact Us</li>
							<li><a class="viewCart" href="viewCart">View Cart</a></li>
							<li><a class="viewCart" href="orderDetails">Order Detail</a></li>
						</ul>
					
				</div>


				<div id="branding">
					<div id="brandTag">
						<img src="">
						<a href="/cosho/home.jsp">Cosho</a>
					</div>
					<nav>
						<ul>
							<li>Electronics</li>
							<li>Clothes</li>
							<li>Sports</li>
							<li>Books</li>
						</ul>
						<div id="homeSearch">
							<input type="search" name="search" placeholder="Search">
							<button type="submit" class="button_1">Search</button>
							<i class="fa fa-user" style="font-size:30px;color:#94969F;float: right;padding-left: 10px">
								<div id="wrapper" onMouseOver="show_sidebar()" onMouseOut="hide_sidebar()">
							 <div id="sidebar">
							 	<a href="login.jsp">Login / </a> <a href="register.jsp">Signup</a>
							 </div>
  							
						</div>
							</i>	
						</div>
						
					</nav>
				</div> -->
				
			</div>
		</header>
		
		
		
		
		<section id="cart">
			<div class="cart-container">
				<div class="cart-list-container">
					<div class="cart-list">
						<c:forEach items="${list}" var="list">
					
							<div class="cart-list-item">
	
								<div class="cart-list-item-img">
									<img class="manImg2" src="<c:url value="/resources/img/productListImg/${list.product_image_name}" />" />   
								</div>	
								<div class="cart-list-item-description">
									<p class="brandName-title">${list.product_description}</p>
									<i class='fas fa-rupee-sign'></i> <span> ${list.product_cost}</span>
									<p class="distributer-patners">sold By: Blumentor</p>
									<div class="cart-remove-item-option">
										<p><a href="<c:url value="deleteItemFromCart"> <c:param name="product_id" value="${list.product_id}"/>
            								</c:url> ">Remove</a>
            							</p>
									</div>
								</div>
	
							</div>

						</c:forEach>
						
					</div>
					<div class="cart-items-cost">
						<div class="price-detail">
							<p class="price-header">PRICE DETAILS</p>
							<p class="price-detail-price">Bag Total &nbsp; &nbsp; &nbsp;<span class="price-detail-price-span"><i class='fas fa-rupee-sign'></i> ${total_Amount}</span></p>
							<p class="price-detail-price">Bag discount &nbsp; &nbsp; &nbsp;<span class="price-detail-price-span" style="color: #0bc6a0"><i class='fas fa-rupee-sign'></i> 0</span></p>
							<p class="price-detail-price">Estimated Tax <i class='fas fa-info-circle'></i>&nbsp;&nbsp;<span class="price-detail-price-span"><i class='fas fa-rupee-sign'></i> 215</span></p>
							<p class="price-detail-price">Coupon Discount &nbsp; &nbsp; &nbsp;<span class="price-detail-price-span" style="color: #526cd0"><i class='fas fa-rupee-sign'></i> 621</span></p>
							<p class="price-detail-price">Delivery Charges &nbsp; &nbsp; &nbsp;<span class="price-detail-price-span" style="color: #0bc6a0">FREE</span></p>
						</div>
						<div>
							<p class="price-total-price">Total &nbsp; &nbsp; &nbsp;<span class="price-detail-price-span"><i class='fas fa-rupee-sign'></i> ${totalAmountAfterDiscount} </span></p>
							<a href="shipping">
								<button type="button" class="place-order-button">
									&nbsp;Place Order 
								</button>
							</a>
						</div>
						
					</div>

				</div>
			</div>
			
		</section>





	<%-- <H5> PRODUCT DESCRIPTION ${mailid}</H5>
<tr>
<td><h3>PRODUCT DESCRIPTION:${product_description}</h3></td>
<td><h3>Rs.${product_cost }</h3></td>
<td><h3>Item Left In Stock:${item_left_in_stack}</h3></td>
<td><img src="${product_image}"></h3></td>
<a href="addToCart/${product_id}"><input type="button" value="ADD TO CART"   ><br><br>

   </tr> --%>
   
   
   <footer>
			<div class="container">
				<div class="footerDisplay1">
					<hr>
					<h6>POPULAR SEARCHES</h6>
					<p>Nike | Puma | Adidas | Fila | Lee | United Colors of Benetton | Wrangler | Fastrack | Woodland | Yepme | Levis | Tommy Hilfiger | peter-england | fabindia | nike shoes | tops | shirts | jackets | myntra coupons | kurtis | shoes | tunics | dresses | Watches | saree | kurtas | bags | T-shirts | designer saree | sunglasses | jeans | trousers | adidas | shoes | casual shoes | sports shoes | fastrack watches | ethnic wear | woodland-shoes | mobile app | puma shoes | accessories | anarkali suit | running shoes | reebok | formal wear | cat | jewellery</p>
					<div class="desktopCopyright" >
						<p >&copy; 2018 www.cosho.com. All right reserved</p>
					</div>
					<div class="desktopCopyright1">
						<p >All right reserved by cognizant &copy;</p>
					</div>

					
				</div>
			</div>
		</footer>




		<script type="text/javascript">
			
			


			function show_sidebar()
			{
				document.getElementById('sidebar').style.visibility="visible";
			}

			function hide_sidebar()
			{
				document.getElementById('sidebar').style.visibility="hidden";
			}



		</script>
   
   
   
   
</body>
</html>