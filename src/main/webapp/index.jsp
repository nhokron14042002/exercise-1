<%@page import="entity.Category"%>
<%@page import="entity.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

<title>Electro - HTML Ecommerce Template</title>

<!-- Google font -->
<link
	href="https://fonts.googleapis.com/css?family=Montserrat:400,500,700"
	rel="stylesheet">

<!-- Bootstrap -->
<link type="text/css" rel="stylesheet" href="css/bootstrap.min.css" />

<!-- Slick -->
<link type="text/css" rel="stylesheet" href="css/slick.css" />
<link type="text/css" rel="stylesheet" href="css/slick-theme.css" />

<!-- nouislider -->
<link type="text/css" rel="stylesheet" href="css/nouislider.min.css" />

<!-- Font Awesome Icon -->
<link rel="stylesheet" href="css/font-awesome.min.css">

<!-- Custom stlylesheet -->
<link type="text/css" rel="stylesheet" href="css/style.css" />

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
		  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
		  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		<![endif]-->

</head>
<body>
	 <jsp:include page="Menuheader.jsp"></jsp:include>

	<!-- NAVIGATION -->
	<nav id="navigation">
		<!-- container -->
		<div class="container">
			<!-- responsive-nav -->
			<div id="responsive-nav">
				<!-- NAV -->
				<ul class="main-nav nav navbar-nav">
					<li class="active"><a href="HomeControl">Home</a></li>
					<li><a href="HomeControl">Hot Deals</a></li>
					<li><a href="CategoryControl">Categories</a></li>
					<%
					ArrayList<Category> dsloaigiay1 = (ArrayList<Category>) request.getAttribute("listCC");
					if (dsloaigiay1 != null) {
		   				for (Category l : dsloaigiay1) {
					%>

					<li><a href="HomeControl?cid=<%=l.getCid()%>"><%=l.getCname()%></a></li>


					<%
					}
					}
					%>
				</ul>
				<!-- /NAV -->
			</div>
			<!-- /responsive-nav -->
		</div>
		<!-- /container -->
	</nav>
	<!-- /NAVIGATION -->

	<!-- SECTION -->
	<div class="section">
		<!-- container -->
		<div class="container">
			<!-- row -->
			<div class="row">

				<%
				ArrayList<Product> dsspshopnow = (ArrayList<Product>) request.getAttribute("listP");
				if (dsspshopnow != null) {
					for (Product l : dsspshopnow )
				%>
				<!-- shop -->
				<div class="col-md-4 col-xs-6">
					<div class="shop">
						<div class="shop-img">
							<img src="<%=dsspshopnow.get(12).getImage()%>" alt="">
						</div>
						<div class="shop-body">
							<h3>
								<%=dsspshopnow.get(12).getName()%><br>Collection
							</h3>
							<a href="#" class="cta-btn">Shop now <i
								class="fa fa-arrow-circle-right"></i></a>
						</div>
					</div>
				</div>
				<!-- /shop -->

				<!-- shop -->
				<div class="col-md-4 col-xs-6">
					<div class="shop">
						<div class="shop-img">
							<img src="<%=dsspshopnow.get(5).getImage()%>" alt="">
						</div>
						<div class="shop-body">
							<h3>
								<%=dsspshopnow.get(2).getName()%><br>Collection
							</h3>
							<a href="#" class="cta-btn">Shop now <i
								class="fa fa-arrow-circle-right"></i></a>
						</div>
					</div>
				</div>
				<!-- /shop -->

				<!-- shop -->
				<div class="col-md-4 col-xs-6">
					<div class="shop">
						<div class="shop-img">
							<img src="<%=dsspshopnow.get(9).getImage()%>" alt="">
						</div>
						<div class="shop-body">
							<h3>
								<%=dsspshopnow.get(3).getName()%><br>Collection
							</h3>
							<a href="#" class="cta-btn">Shop now <i
								class="fa fa-arrow-circle-right"></i></a>
						</div>
					</div>
				</div>
				<!-- /shop -->
				<%
				}
				%>




			</div>
			<!-- /row -->
		</div>
		<!-- /container -->
	</div>
	<!-- /SECTION -->

	<!-- SECTION -->
	<div class="section">
		<!-- container -->
		<div class="container">
			<!-- row -->
			<div class="row">

				<!-- section title -->
				<div class="col-md-12">
					<div class="section-title">
						<h3 class="title">New Products</h3>
						<div class="section-nav">
							<ul class="section-tab-nav tab-nav">

								<%
								ArrayList<Category> dsloaigiay = (ArrayList<Category>) request.getAttribute("listCC");
								if (dsloaigiay != null) {
									for (Category l : dsloaigiay) {
								%>
								<li><a href="HomeControl?cid=<%=l.getCid()%>"><%=l.getCname()%></a></li>

								<%
								}
								}
								%>

							</ul>
						</div>
					</div>
				</div>
				<!-- /section title -->

				<!-- Products tab & slick -->
				<div class="col-md-12">
					<div class="row">
						<div class="products-tabs">
							<!-- tab -->
							<div id="tab1" class="tab-pane active">
								<div class="products-slick" data-nav="#slick-nav-1">

									<%
									ArrayList<Product> dssp = (ArrayList<Product>) request.getAttribute("listcid");
									if (dssp != null) {
										for (Product l : dssp) {
									%>



									<!-- product -->
									<div class="product">
										<div class="product-img">
											<img src="<%=l.getImage()%>" alt="loianh">
											<div class="product-label">
												<span class="sale">-30%</span> <span class="new">NEW</span>
											</div>
										</div>
										<div class="product-body">
											<p class="product-category"><%=l.getTitle()%></p>
											<h3 class="product-name">
												<a href="DetailControl?pid=<%=l.getId()%>"><%=l.getName()%></a>
											</h3>
											<h4 class="product-price"><%=l.getPrice()%><del
													class="product-old-price">$990.00</del>
											</h4>
											<div class="product-rating">
												<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
													class="fa fa-star"></i> <i class="fa fa-star"></i> <i
													class="fa fa-star"></i>
											</div>
											<div class="product-btns">
												<button class="add-to-wishlist">
													<i class="fa fa-heart-o"></i><span class="tooltipp">add
														to wishlist</span>
												</button>
												<button class="add-to-compare">
													<i class="fa fa-exchange"></i><span class="tooltipp">add
														to compare</span>
												</button>
												<button class="quick-view">
													<i class="fa fa-eye"></i><span class="tooltipp">quick
														view</span>
												</button>
											</div>
										</div>
										<div class="add-to-cart">
											<button class="add-to-cart-btn">
												<i class="fa fa-shopping-cart"></i> add to cart
											</button>
										</div>
									</div>
									<!-- /product -->

									<%
									}
									}
									%>


								</div>
								<div id="slick-nav-1" class="products-slick-nav"></div>
							</div>
							<!-- /tab -->
						</div>
					</div>
				</div>
				<!-- Products tab & slick -->
			</div>
			<!-- /row -->
		</div>
		<!-- /container -->
	</div>
	<!-- /SECTION -->

	<!-- HOT DEAL SECTION -->
	<div id="hot-deal" class="section">
		<!-- container -->
		<div class="container">
			<!-- row -->
			<div class="row">
				<div class="col-md-12">
					<div class="hot-deal">
						<ul class="hot-deal-countdown">
							<li>
								<div>
									<h3>02</h3>
									<span>Days</span>
								</div>
							</li>
							<li>
								<div>
									<h3>10</h3>
									<span>Hours</span>
								</div>
							</li>
							<li>
								<div>
									<h3>34</h3>
									<span>Mins</span>
								</div>
							</li>
							<li>
								<div>
									<h3>60</h3>
									<span>Secs</span>
								</div>
							</li>
						</ul>
						<h2 class="text-uppercase">hot deal this week</h2>
						<p>New Collection Up to 50% OFF</p>
						<a class="primary-btn cta-btn" href="#">Shop now</a>
					</div>
				</div>
			</div>
			<!-- /row -->
		</div>
		<!-- /container -->
	</div>
	<!-- /HOT DEAL SECTION -->

	<!-- SECTION -->
	<div class="section">
		<!-- container -->
		<div class="container">
			<!-- row -->
			<div class="row">

				<!-- section title -->
				<div class="col-md-12">
					<div class="section-title">
						<h3 class="title">Top selling</h3>
						<div class="section-nav">
							<ul class="section-tab-nav tab-nav">

								<%
								ArrayList<Category> dsloaigiaytopselling = (ArrayList<Category>) request.getAttribute("listCC");
								if (dsloaigiaytopselling != null) {
									for (Category l : dsloaigiaytopselling) {
								%>
								<li><a href="HomeControl?cid=<%=l.getCid()%>"><%=l.getCname()%></a></li>

								<%
								}
								}
								%>


							</ul>
						</div>
					</div>
				</div>
				<!-- /section title -->

				<!-- Products tab & slick -->
				<div class="col-md-12">
					<div class="row">
						<div class="products-tabs">
							<!-- tab -->
							<div id="tab2" class="tab-pane fade in active">
								<div class="products-slick" data-nav="#slick-nav-2">
									<%
									ArrayList<Product> dsproduct = (ArrayList<Product>) request.getAttribute("listP");
									if (dsproduct != null) {
										for (Product l : dsproduct) {
									%>
									<!-- product -->
									<div class="product">
										<div class="product-img">
											<img src="<%=l.getImage()%>" alt="">
											<div class="product-label">
												<span class="sale">-30%</span> <span class="new">NEW</span>
											</div>
										</div>
										<div class="product-body">
											<p class="product-category"><%=l.getTitle()%></p>
											<h3 class="product-name">
												<a href="DetailControl?pid=<%=l.getId()%>"><%=l.getName()%></a>
											</h3>
											<h4 class="product-price">
												<%=l.getPrice()%>
												<del class="product-old-price">$990.00</del>
											</h4>
											<div class="product-rating">
												<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
													class="fa fa-star"></i> <i class="fa fa-star"></i> <i
													class="fa fa-star"></i>
											</div>
											<div class="product-btns">
												<button class="add-to-wishlist">
													<i class="fa fa-heart-o"></i><span class="tooltipp">add
														to wishlist</span>
												</button>
												<button class="add-to-compare">
													<i class="fa fa-exchange"></i><span class="tooltipp">add
														to compare</span>
												</button>
												<button class="quick-view">
													<i class="fa fa-eye"></i><span class="tooltipp">quick
														view</span>
												</button>
											</div>
										</div>
										<div class="add-to-cart">
											<button class="add-to-cart-btn">
												<i class="fa fa-shopping-cart"></i> add to cart
											</button>
										</div>
									</div>
									<!-- /product -->
									<%
									}
									}
									%>





								</div>
								<div id="slick-nav-2" class="products-slick-nav"></div>
							</div>
							<!-- /tab -->
						</div>
					</div>
				</div>
				<!-- /Products tab & slick -->
			</div>
			<!-- /row -->
		</div>
		<!-- /container -->
	</div>
	<!-- /SECTION -->

	<!-- SECTION -->
	<div class="section">
		<!-- container -->
		<div class="container">
			<!-- row -->
			<div class="row">





				<div class="col-md-4 col-xs-6">
				
				 <%
									ArrayList<Product> dsproducttop1 = (ArrayList<Product>) request.getAttribute("listP");
									if (dsproducttop1 != null) {
										
				 %>
							  
				 <div class="section-title">
						<h4 class="title">Top selling</h4>
						<div class="section-nav">
							<div id="slick-nav-3" class="products-slick-nav"></div>
						</div>
					</div>
                  
					<div class="products-widget-slick" data-nav="#slick-nav-3">
						<div>
                             

							<!-- product widget -->
							<div class="product-widget">
								<div class="product-img">
									<img src="<%=dsproducttop1.get(0).getImage()%>" alt="">
								</div>
								<div class="product-body">
									<p class="product-category"><%=dsproducttop1.get(0).getTitle()%></p>
									<h3 class="product-name">
										<a href="DetailControl?pid=<%=dsproducttop1.get(0).getId()%>"><%=dsproducttop1.get(0).getName()%></a>
									</h3>
									<h4 class="product-price">
										<%=dsproducttop1.get(0).getPrice()%>
										<del class="product-old-price">$990.00</del>
									</h4>
								</div>
							</div>
							<!-- /product widget -->

							<!-- product widget -->
							<div class="product-widget">
								<div class="product-img">
									<img src="<%=dsproducttop1.get(1).getImage()%>" alt="">
								</div>
								<div class="product-body">
									<p class="product-category"><%=dsproducttop1.get(1).getTitle()%></p>
									<h3 class="product-name">
										<a href="DetailControl?pid=<%=dsproducttop1.get(1).getId()%>"><%=dsproducttop1.get(1).getName()%></a>
									</h3>
									<h4 class="product-price">
										<%=dsproducttop1.get(1).getPrice()%>
										<del class="product-old-price">$990.00</del>
									</h4>
								</div>
							</div>
							<!-- /product widget -->

							<!-- product widget -->
							<div class="product-widget">
								<div class="product-img">
									<img src="<%=dsproducttop1.get(2).getImage()%>" alt="">
								</div>
								<div class="product-body">
									<p class="product-category"><%=dsproducttop1.get(2).getTitle()%></p>
									<h3 class="product-name">
										<a href="DetailControl?pid=<%=dsproducttop1.get(2).getId()%>"><%=dsproducttop1.get(2).getName()%></a>
									</h3>
									<h4 class="product-price">
										<%=dsproducttop1.get(2).getPrice()%>
										<del class="product-old-price">$990.00</del>
									</h4>
								</div>
							</div>
							<!-- /product widget -->
						</div>

						<div>
							<!-- product widget -->
							<div class="product-widget">
								<div class="product-img">
									<img src="<%=dsproducttop1.get(3).getImage()%>" alt="">
								</div>
								<div class="product-body">
									<p class="product-category"><%=dsproducttop1.get(3).getTitle()%></p>
									<h3 class="product-name">
										<a href="DetailControl?pid=<%=dsproducttop1.get(3).getId()%>"><%=dsproducttop1.get(3).getName()%></a>
									</h3>
									<h4 class="product-price">
										<%=dsproducttop1.get(3).getPrice()%>
										<del class="product-old-price">$990.00</del>
									</h4>
								</div>
							</div>
							<!-- /product widget -->

							<!-- product widget -->
							<div class="product-widget">
								<div class="product-img">
									<img src="<%=dsproducttop1.get(4).getImage()%>" alt="">
								</div>
								<div class="product-body">
									<p class="product-category"><%=dsproducttop1.get(4).getTitle()%></p>
									<h3 class="product-name">
										<a href="DetailControl?pid=<%=dsproducttop1.get(4).getId()%>"><%=dsproducttop1.get(4).getName()%></a>
									</h3>
									<h4 class="product-price">
										<%=dsproducttop1.get(4).getPrice()%>
										<del class="product-old-price">$990.00</del>
									</h4>
								</div>
							</div>
							<!-- /product widget -->

							<!-- product widget -->
							<div class="product-widget">
								<div class="product-img">
									<img src="<%=dsproducttop1.get(5).getImage()%>" alt="">
								</div>
								<div class="product-body">
									<p class="product-category"><%=dsproducttop1.get(5).getTitle()%></p>
									<h3 class="product-name">
										<a href="DetailControl?pid=<%=dsproducttop1.get(5).getId()%>"><%=dsproducttop1.get(5).getName()%></a>
									</h3>
									<h4 class="product-price">
										<%=dsproducttop1.get(5).getPrice()%>
										<del class="product-old-price">$990.00</del>
									</h4>
								</div>
							</div>
							<!-- /product widget -->
						</div>
					</div>
				</div>

				<div class="col-md-4 col-xs-6">
					<div class="section-title">
						<h4 class="title">Top selling</h4>
						<div class="section-nav">
							<div id="slick-nav-4" class="products-slick-nav"></div>
						</div>
					</div>

					<div class="products-widget-slick" data-nav="#slick-nav-4">
						<div>
							<!-- product widget -->
							<div class="product-widget">
								<div class="product-img">
									<img src="<%=dsproducttop1.get(6).getImage()%>" alt="">
								</div>
								<div class="product-body">
									<p class="product-category"><%=dsproducttop1.get(6).getTitle()%></p>
									<h3 class="product-name">
										<a href="DetailControl?pid=<%=dsproducttop1.get(6).getId()%>"><%=dsproducttop1.get(6).getName()%></a>
									</h3>
									<h4 class="product-price">
										<%=dsproducttop1.get(6).getPrice()%>
										<del class="product-old-price">$990.00</del>
									</h4>
								</div>
							</div>
							<!-- /product widget -->

							<!-- product widget -->
							<div class="product-widget">
								<div class="product-img">
									<img src="<%=dsproducttop1.get(7).getImage()%>" alt="">
								</div>
								<div class="product-body">
									<p class="product-category"><%=dsproducttop1.get(7).getTitle()%></p>
									<h3 class="product-name">
										<a href="DetailControl?pid=<%=dsproducttop1.get(7).getId()%>"><%=dsproducttop1.get(7).getName()%></a>
									</h3>
									<h4 class="product-price">
										<%=dsproducttop1.get(7).getPrice()%>
										<del class="product-old-price">$990.00</del>
									</h4>
								</div>
							</div>
							<!-- /product widget -->

							<!-- product widget -->
							<div class="product-widget">
								<div class="product-img">
									<img src="<%=dsproducttop1.get(8).getImage()%>" alt="">
								</div>
								<div class="product-body">
									<p class="product-category"><%=dsproducttop1.get(8).getTitle()%></p>
									<h3 class="product-name">
										<a href="DetailControl?pid=<%=dsproducttop1.get(8).getId()%>"><%=dsproducttop1.get(8).getName()%></a>
									</h3>
									<h4 class="product-price">
										<%=dsproducttop1.get(8).getPrice()%>
										<del class="product-old-price">$990.00</del>
									</h4>
								</div>
							</div>
							<!-- /product widget -->
						</div>

						<div>
							<!-- product widget -->
							<div class="product-widget">
								<div class="product-img">
									<img src="<%=dsproducttop1.get(9).getImage()%>" alt="">
								</div>
								<div class="product-body">
									<p class="product-category"><%=dsproducttop1.get(9).getTitle()%></p>
									<h3 class="product-name">
										<a href="DetailControl?pid=<%=dsproducttop1.get(9).getId()%>"><%=dsproducttop1.get(9).getName()%></a>
									</h3>
									<h4 class="product-price">
										<%=dsproducttop1.get(9).getPrice()%>
										<del class="product-old-price">$990.00</del>
									</h4>
								</div>
							</div>
							<!-- /product widget -->

							<!-- product widget -->
							<div class="product-widget">
								<div class="product-img">
									<img src="<%=dsproducttop1.get(10).getImage()%>" alt="">
								</div>
								<div class="product-body">
									<p class="product-category"><%=dsproducttop1.get(10).getTitle()%></p>
									<h3 class="product-name">
										<a href="DetailControl?pid=<%=dsproducttop1.get(10).getId()%>"><%=dsproducttop1.get(10).getName()%></a>
									</h3>
									<h4 class="product-price">
										<%=dsproducttop1.get(10).getPrice()%>
										<del class="product-old-price">$990.00</del>
									</h4>
								</div>
							</div>
							<!-- /product widget -->

							<!-- product widget -->
							<div class="product-widget">
								<div class="product-img">
									<img src="<%=dsproducttop1.get(11).getImage()%>" alt="">
								</div>
								<div class="product-body">
									<p class="product-category"><%=dsproducttop1.get(11).getTitle()%></p>
									<h3 class="product-name">
										<a href="DetailControl?pid=<%=dsproducttop1.get(11).getId()%>"><%=dsproducttop1.get(11).getName()%></a>
									</h3>
									<h4 class="product-price">
										<%=dsproducttop1.get(11).getPrice()%>
										<del class="product-old-price">$990.00</del>
									</h4>
								</div>
							</div>
							<!-- /product widget -->
						</div>
					</div>
				</div>
				 <%
										}
									
							  
				 %>
				
					

				<div class="clearfix visible-sm visible-xs"></div>

				<div class="col-md-4 col-xs-6">
				<%
									ArrayList<Product> dsproducttop2 = (ArrayList<Product>) request.getAttribute("listP");
									if (dsproducttop2 != null) {
										
				 %>
					<div class="section-title">
						<h4 class="title">Top selling</h4>
						<div class="section-nav">
							<div id="slick-nav-5" class="products-slick-nav"></div>
						</div>
					</div>

					<div class="products-widget-slick" data-nav="#slick-nav-5">
						<div>
							<!-- product widget -->
							<div class="product-widget">
								<div class="product-img">
									<img src="<%=dsproducttop1.get(12).getImage()%>" alt="">
								</div>
								<div class="product-body">
									<p class="product-category"><%=dsproducttop1.get(12).getTitle()%></p>
									<h3 class="product-name">
										<a href="DetailControl?pid=<%=dsproducttop1.get(12).getId()%>"><%=dsproducttop1.get(12).getName()%></a>
									</h3>
									<h4 class="product-price">
										<%=dsproducttop1.get(12).getPrice()%>
										<del class="product-old-price">$990.00</del>
									</h4>
								</div>
							</div>
							<!-- /product widget -->

							<!-- product widget -->
							<div class="product-widget">
								<div class="product-img">
									<img src="<%=dsproducttop1.get(13).getImage()%>" alt="">
								</div>
								<div class="product-body">
									<p class="product-category"><%=dsproducttop1.get(13).getTitle()%></p>
									<h3 class="product-name">
										<a href="DetailControl?pid=<%=dsproducttop1.get(13).getId()%>"><%=dsproducttop1.get(13).getName()%></a>
									</h3>
									<h4 class="product-price">
										<%=dsproducttop1.get(13).getPrice()%>
										<del class="product-old-price">$990.00</del>
									</h4>
								</div>
							</div>
							<!-- /product widget -->

							<!-- product widget -->
							<div class="product-widget">
								<div class="product-img">
									<img src="<%=dsproducttop1.get(14).getImage()%>" alt="">
								</div>
								<div class="product-body">
									<p class="product-category"><%=dsproducttop1.get(14).getTitle()%></p>
									<h3 class="product-name">
										<a href="DetailControl?pid=<%=dsproducttop1.get(14).getId()%>"><%=dsproducttop1.get(14).getName()%></a>
									</h3>
									<h4 class="product-price">
										<%=dsproducttop1.get(14).getPrice()%>
										<del class="product-old-price">$990.00</del>
									</h4>
								</div>
							</div>
							<!-- /product widget -->
						</div>

						<div>
							<!-- product widget -->
							<div class="product-widget">
								<div class="product-img">
									<img src="<%=dsproducttop1.get(15).getImage()%>" alt="">
								</div>
								<div class="product-body">
									<p class="product-category"><%=dsproducttop1.get(15).getTitle()%></p>
									<h3 class="product-name">
										<a href="DetailControl?pid=<%=dsproducttop1.get(15).getId()%>"><%=dsproducttop1.get(15).getName()%></a>
									</h3>
									<h4 class="product-price">
										<%=dsproducttop1.get(15).getPrice()%>
										<del class="product-old-price">$990.00</del>
									</h4>
								</div>
							</div>
							<!-- /product widget -->

							<!-- product widget -->
							<div class="product-widget">
								<div class="product-img">
									<img src="<%=dsproducttop1.get(16).getImage()%>" alt="">
								</div>
								<div class="product-body">
									<p class="product-category"><%=dsproducttop1.get(16).getTitle()%></p>
									<h3 class="product-name">
										<a href="DetailControl?pid=<%=dsproducttop1.get(16).getId()%>"><%=dsproducttop1.get(16).getName()%></a>
									</h3>
									<h4 class="product-price">
										<%=dsproducttop1.get(16).getPrice()%>
										<del class="product-old-price">$990.00</del>
									</h4>
								</div>
							</div>
							<!-- /product widget -->

							<!-- product widget -->
							<div class="product-widget">
								<div class="product-img">
									<img src="<%=dsproducttop1.get(17).getImage()%>" alt="">
								</div>
								<div class="product-body">
									<p class="product-category"><%=dsproducttop1.get(17).getTitle()%></p>
									<h3 class="product-name">
										<a href="DetailControl?pid=<%=dsproducttop1.get(17).getId()%>"><%=dsproducttop1.get(17).getName()%></a>
									</h3>
									<h4 class="product-price">
										<%=dsproducttop1.get(17).getPrice()%>
										<del class="product-old-price">$990.00</del>
									</h4>
								</div>
							</div>
							<!-- /product widget -->
							
							
						</div>
						
						<%
									}
										
				 %>
					</div>
				</div>

			</div>
			<!-- /row -->
		</div>
		<!-- /container -->
	</div>
	<!-- /SECTION -->

	<!-- NEWSLETTER -->
	<div id="newsletter" class="section">
		<!-- container -->
		<div class="container">
			<!-- row -->
			<div class="row">
				<div class="col-md-12">
					<div class="newsletter">
						<p>
							Sign Up for the <strong>NEWSLETTER</strong>
						</p>
						<form>
							<input class="input" type="email" placeholder="Enter Your Email">
							<button class="newsletter-btn">
								<i class="fa fa-envelope"></i> Subscribe
							</button>
						</form>
						<ul class="newsletter-follow">
							<li><a href="#"><i class="fa fa-facebook"></i></a></li>
							<li><a href="#"><i class="fa fa-twitter"></i></a></li>
							<li><a href="#"><i class="fa fa-instagram"></i></a></li>
							<li><a href="#"><i class="fa fa-pinterest"></i></a></li>
						</ul>
					</div>
				</div>
			</div>
			<!-- /row -->
		</div>
		<!-- /container -->
	</div>
	<!-- /NEWSLETTER -->

	 <jsp:include page="Menufooter.jsp"></jsp:include>
	<!-- jQuery Plugins -->
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/slick.min.js"></script>
	<script src="js/nouislider.min.js"></script>
	<script src="js/jquery.zoom.min.js"></script>
	<script src="js/main.js"></script>

</body>
</html>
