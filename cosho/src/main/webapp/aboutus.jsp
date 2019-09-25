<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	 <meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta name="viewport" content="width=device-width">
		<title>Cosho Home Page</title>
		<!-- <spring:url value="/resources/css/style.css" var="styleCss" /> -->
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/headerFooter.css" />">
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/aboutus.css" />">
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/w3.css" />">
		<link rel="stylesheet" type="text/css"  href="<c:url value="/resources/css/font-awesome.css" />">
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.css" /> ">
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
							<!-- <li><a class="viewCart" href="aboutus.jsp">About</a></li> -->
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
			
			
				<%-- <div id="topheader">
					
						<ul>
						<li><a class="viewCart" href="giftcard.jsp">gift card</a></li>
								<li><a class="viewCart" href="aboutus.jsp">About </a></li>
							<li><a class="viewCart" href="contactus.jsp">contact us</a></li>
							<li><a class="viewCart" href="viewCart">View Cart</a></li>
							<li><a class="viewCart" href="orderDetails">Order Details</a></li>
						</ul>
					
				</div>


				<div id="branding">
					<div id="brandTag">
						<img src="">
						<a href="home.jsp">Cosho</a><br>
					<a> WELCOME ${user_name}! </a>
					
					</div>
					<nav>
					



							
						<li>	 <a href="<c:url value="product12">
            <c:param name="productCategoryId" value="pdca102"/>
            </c:url> ">clothes</a></li>
							
							
							
							<li><a href="<c:url value="product12">
            <c:param name="productCategoryId" value="pdca103"/>
            </c:url> ">Sports</a></li>
							<li>ELECTRONICS</li>
							<li>BOOKS</li>
						</ul>
						<div id="homeSearch">
							<input type="search" name="search" placeholder="Search">
							<button type="submit" class="button_1">Search</button>
							<i class="fa fa-user" style="font-size:30px;color:#94969F;float: right;padding-left: 10px">
								<div id="wrapper" onMouseOver="show_sidebar()" onMouseOut="hide_sidebar()">
							 <div id="sidebar">
							 	<a href="login.jsp">Login / </a> <a href="logout">Logout</a>
  								
							 </div>
  							
						</div>
							</i>	
						</div>
						
					</nav>
				</div> --%>
				
			</div>
		</header>

		<center><p class="title">CoSho/About</p></center>
		<div class="container">
			<h4>Introduction</h4>
			<p>Cosho is a one stop shop for all your fashion and lifestyle needs. Being India's largest e-commerce store for fashion and lifestyle products, Cosho aims at providing a hassle free and enjoyable 
				shopping experience to shoppers across the country with the widest range of brands and products on its portal. The brand is making a conscious effort to bring the power of fashion to shoppers with 
				an array of the latest and trendiest products available in the country.</p>
			<hr>
			<h4>Value proposition</h4>
			<p>Cosho's value proposition revolves around giving consumers the power and ease of purchasing fashion and lifestyle products online. Offerings such as the largest in-season product catalogue, 
				100% authentic products, cash on delivery and 30 day return policy make Cosho, the preferred shopping destination in the country. To make online shopping easier for you, a dedicated customer 
				connect team is on standby to answer your queries 24x7.</p>
			<hr>
			<h4>Brands</h4>
			<p>Cosho understands its shoppers needs and caters to them with choice of apparel, accessories, cosmetics and footwear from over 500 leading Indian and international brands. Prominent brands include 
				Adidas, Nike, Puma, Catwalk, Inc 5, United Colors of Benetton, FCUK, Timberland, Avirate, FabIndia and Biba to name a few. You can also shop from some recently introduced labels such as - Roadster, 
				Sher Singh, Dressberry, Kook N Keech and ETC.</p>
			
			<hr>
			<h4>Recognitions</h4>
			<ul>
				<li>Awarded 'Fashion eRetailer of the Year 2018' by Franchise India - Indian eRetail Awards</li>
				<li>Awarded 'Best E-commerce Website for 2018' by IAMAI - India Digital Awards</li>
				<li>Awarded 'Images Most Admired Retailer of the Year: Non-Store Retail' for 2018 by Images Group</li>
				<li>Awarded 'Best E-commerce Partner of the year 2017-18' by Puma India</li>
			<!-- <p>Awarded 'Fashion eRetailer of the Year 2013' by Franchise India – Indian eRetail Awards
			Awarded 'Best E-commerce Website for 2012' by IAMAI – India Digital Awards
			Awarded 'Images Most Admired Retailer of the Year: Non–Store Retail' for 2012 by Images Group
			Awarded 'Best E-commerce Partner of the year 2011-12' by Puma India</p> -->
			</ul>
		</div>
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
</body>
</html>