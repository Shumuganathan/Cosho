<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	 <meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta name="viewport" content="width=device-width">
		<title>Cosho Home Page</title>
		<!-- <spring:url value="/resources/css/style.css" var="styleCss" /> -->
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/headerFooter.css" />">
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
						<a href="home.jsp">Cosho</a>
					</div>
					<nav>
						<ul>
							<li><a href="product12/pdca103" >Clothes</a></li>
							<li>Sports</li>
							<li>Electronics</li>
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


		<section id="showcase">
			<div class="container1">
				<div class=" slideShow">
  					<img class="mySlides" src="<c:url value="/resources/img/slideShow/slideImg1.jpg" />" />
  					<img class="mySlides" src="<c:url value="/resources/img/slideShow/slideImg2.jpg" />" />
  					<img class="mySlides" src="<c:url value="/resources/img/slideShow/slideImg3.jpg" />" />
  					<img class="mySlides" src="<c:url value="/resources/img/slideShow/slideImg4.jpg" />" />
  					<img class="mySlides" src="<c:url value="/resources/img/slideShow/slideImg5.jpg" />" />
  					<img class="mySlides" src="<c:url value="/resources/img/slideShow/slideImg6.jpg" />" />
  					<div class="w3-center w3-container w3-section w3-large w3-text-white " style="width:100%;">
    					<span class="w3-badge demo w3-border w3-transparent w3-hover-grey" onclick="currentDiv(1)"></span>
    					<span class="w3-badge demo w3-border w3-transparent w3-hover-grey" onclick="currentDiv(2)"></span>
    					<span class="w3-badge demo w3-border w3-transparent w3-hover-grey" onclick="currentDiv(3)"></span>
    					<span class="w3-badge demo w3-border w3-transparent w3-hover-grey" onclick="currentDiv(4)"></span>
    					<span class="w3-badge demo w3-border w3-transparent w3-hover-grey" onclick="currentDiv(5)"></span>
    					<span class="w3-badge demo w3-border w3-transparent w3-hover-grey" onclick="currentDiv(6)"></span>    					
  					</div>  					
				</div>
				<!-- <h1>Cognizant Ecommerce Site</h1>
				<p>The place where you can save your time. All in one shop with exciting offers. Smart deal and quality Product</p> -->
			</div>
		</section>



		<section class="sampleDisplay">
			
			<div class="container1">
				<div class="displayContainer">
					<div class="display">
						<img class="myImg" src="<c:url value="/resources/img/display1/displayImg1.jpg" />" />
					</div>
					<div class="display">
						<img class="myImg" src="<c:url value="/resources/img/display1/displayImg2.jpg" />" />
					</div>
					<div class="display">
						<img class="myImg" src="<c:url value="/resources/img/display1/displayImg3.jpg" />" />
					</div>
					<div class="display">
						<img class="myImg" src="<c:url value="/resources/img/display1/displayImg4.jpg" />" />
					</div>
					<!-- <img class="myImg" src="./img/img2.jpg" >
					<img class="myImg" src="./img/img3.jpg" >
					<img class="myImg" src="./img/img4.jpg" >-->
				</div>
				
			</div>
		</section>


		<section id="banckoffers">
			<div class="container1">
				<div class=" offerSlideShow">
  					<img class="offerSlides" src="<c:url value="/resources/img/offerSlides/bankoffer1.jpg" />" />
  					<img class="offerSlides" src="<c:url value="/resources/img/offerSlides/bankoffer2.jpg" />" />
  					<div class="w3-center w3-container w3-section w3-large w3-text-white " style="width:100%;">
    					<span class="w3-badge demo w3-border w3-transparent w3-hover-white" onclick="currentDiv1(1)"></span>
    					<span class="w3-badge demo w3-border w3-transparent w3-hover-white" onclick="currentDiv1(2)"></span>    					
  					</div>  					
				</div>
			</div>
		</section>




		<section id="sampleDisplay1">
			
			<div class="container1">
				
				<div class="displayContainer">
					<div class="display" style="padding-bottom: 0; max-width: 100%">
						<img class="myImg" src="<c:url value="/resources/img/display2/display2Header.jpg" />" />
					</div>
					<div class="display1">
						<img class="myImg" src="<c:url value="/resources/img/display2/display2Img1.jpg" />" />
					</div>
					<div class="display1">
						<img class="myImg" src="<c:url value="/resources/img/display2/display2Img2.jpg" />" />
					</div>
					<div class="display1">
						<img class="myImg" src="<c:url value="/resources/img/display2/display2Img3.jpg" />" />
					</div>
					<div class="display1">
						<img class="myImg" src="<c:url value="/resources/img/display2/display2Img4.jpg" />" />
					</div>
					<div class="display1">
						<img class="myImg" src="<c:url value="/resources/img/display2/display2Img5.jpg" />" />
					</div>
					<div class="display1">
						<img class="myImg" src="<c:url value="/resources/img/display2/display2Img6.jpg" />" />
					</div>
					<div class="display1">
						<img class="myImg" src="<c:url value="/resources/img/display2/display2Img7.jpg" />" />
					</div>
					<div class="display1">
						<img class="myImg" src="<c:url value="/resources/img/display2/display2Img8.jpg" />" />
					</div>
					<!-- <div class="display1">
						<img class="myImg" src="./img/img5.jpg" >
					</div>
					<div class="display1">
						<img class="myImg" src="./img/img24.jpg" >
					</div>
					<div class="display1">
						<img class="myImg" src="./img/img25.jpg" >
					</div>
					<div class="display1">
						<img class="myImg" src="./img/img27.jpg" >
					</div> -->
					<!-- <img class="myImg" src="./img/img2.jpg" >
					<img class="myImg" src="./img/img3.jpg" >
					<img class="myImg" src="./img/img4.jpg" >-->
				</div>
				
			</div>
		</section>



		


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
			
			var slideIndex = 0;
			var slideIndex1 =0;
			var slides = document.getElementsByClassName("mySlides");
			var offerSlides = document.getElementsByClassName("offerSlides");
			
			showSlides();
			showOffreSlides();


			function showSlides() {    
			    var i;    
			    for (i = 0; i < slides.length; i++) {
			        slides[i].style.display = "none"; 
			    }
			    slideIndex++;
			    if (slideIndex> slides.length) {slideIndex = 1} 
			    slides[slideIndex-1].style.display = "block"; 
			    setTimeout(showSlides, 5000); // Change image every 5 seconds
			}

			function currentDiv(no) {
			    var i;    
			    for (i = 0; i < slides.length; i++) {
			        slides[i].style.display = "none"; 
			    }
			    slideIndex = no;
			    slides[no-1].style.display = "block";
			}


			function showOffreSlides() {    
			    var i;    
			    for (i = 0; i < offerSlides.length; i++) {
			        offerSlides[i].style.display = "none"; 
			    }
			    slideIndex1++;
			    if (slideIndex1> offerSlides.length) {slideIndex1 = 1} 
			    offerSlides[slideIndex1-1].style.display = "block"; 
			    setTimeout(showOffreSlides, 5000); // Change image every 5 seconds
			}

			function currentDiv1(no) {
			    var i;    
			    for (i = 0; i < offerSlides.length; i++) {
			        offerSlides[i].style.display = "none"; 
			    }
			    slideIndex1 = no;
			    offerSlides[no-1].style.display = "block";
			}


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