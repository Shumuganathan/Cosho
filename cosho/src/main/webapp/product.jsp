<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head> <meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta name="viewport" content="width=device-width">
		<title>Cosho Home Page</title>
		<!-- <spring:url value="/resources/css/style.css" var="styleCss" /> -->
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/headerFooter.css" />">
		<%-- <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style1.css" />"> --%>
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/product.css" />">
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/w3.css" />">
		<link rel="stylesheet" type="text/css"  href="<c:url value="/resources/css/font-awesome.css" />">
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.css" /> ">
		<!-- <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script> -->
		<script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
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
					
					
							<c:set var = "UserName" scope = "session" value = "${user_name}"/>
								<c:choose>
         
							         <c:when test = "${empty UserName}">
							            <a href="login.jsp">Login</a> / <a href="signUp.jsp">Signup</a></span>
							         </c:when>
							         <c:otherwise>
							            ${user_name} / <a href="logout">Logout</a></span>
							         </c:otherwise>
							     </c:choose>
								 <!-- <span class="Stooltiptext"><a href="login.jsp">Login</a> / <a href="signUp.jsp">Signup</a></span> -->
							</i>
				
						</div>

					

				</div>
			
				<!-- <div id="topheader">
					
						<ul>
							<li>Gift Card</li>
							<li>About</li>
							<li>Contact Us</li>
							<li><a class="viewCart" href="viewCart">View Cart</a></li>
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

		
		
		<section id="login">
			<div class="product-container">
				<div class="product-list-container">
				
				<c:forEach items="${list}" var="list">
				
					<div class="product-list">
						<img class="manImg1" src="<c:url value="/resources/img/productListImg/${list.product_image_name}" />" />
						<p class="Brand-Name">${list.brand_name}</p>
						<p class="Product-Name">${list.product_name}</p>
						<p class="Product-Price">Rs. ${list.product_cost}</p>
						<span class="cart-view">
							<a href="<c:url value="addToCart"> <c:param name="product_id" value="${list.product_id}" /> 
								</c:url>"><input type="button" value="Add To Cart"></a> &nbsp; &nbsp; 
	        			 	<a href="<c:url value="viewItem"> <c:param name="product_id" value="${list.product_id}" /> 
	        			 		</c:url>"><input type="button" value="View"></a> 
						</span>
						
					</div>
					
				</c:forEach>
					
						<!-- <h1>this is saket</h1> -->
						
				</div>
			</div>
			
		</section>

      <%-- <H5> PRODUCT LISTS ${mailid}</H5>
        <c:forEach items="${list}" var="list">
       <tr>   

<td>   ${list.product_name} </td><br>
  <td> <h4>Product Description:</h4> ${list.product_description} </td><br></ol>
    <td> <h4>Rs.${list.product_cost} </h4></td>
        <td> <h4> Item Left In Stock: ${list.item_left_in_stock} </h4></td>
        	<td>
	        	<tr>
	        			 <a href="addToCart/${list.product_id}"><input type="button" value="ADD TO CART"   ></a> &nbsp; &nbsp; 
	        			 <a href="viewItem/${list.product_id}"><input type="button" value="View"></a> 
	        	</tr>
        	</td><br><br>
        </tr>
    
        </c:forEach> --%>
        
        
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

				<!-- <section id="banckOffers1">
			<div class="container">
				<h1>Mobikwik | Flat 10% SuperCashh Upto Rs 250</h1>	
			</div>
		</section> -->
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