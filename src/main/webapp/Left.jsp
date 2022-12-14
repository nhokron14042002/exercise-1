<%-- 
    Document   : Detail
    Created on : Dec 29, 2020, 5:43:04 PM
    Author     : trinh
--%>


<%@page import="entity.Category"%>
<%@page import="entity.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detail</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
         <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <style>
            .gallery-wrap .img-big-wrap img {
                height: 450px;
                width: auto;
                display: inline-block;
                cursor: zoom-in;
            }


            .gallery-wrap .img-small-wrap .item-gallery {
                width: 60px;
                height: 60px;
                border: 1px solid #ddd;
                margin: 7px 2px;
                display: inline-block;
                overflow: hidden;
            }

            .gallery-wrap .img-small-wrap {
                text-align: center;
            }
            .gallery-wrap .img-small-wrap img {
                max-width: 100%;
                max-height: 100%;
                object-fit: cover;
                border-radius: 4px;
                cursor: zoom-in;
            }
            .img-big-wrap img{
                width: 100% !important;
                height: auto !important;
            }
        </style>
    </head>
    <body>
       
            
                    <div class="col-sm-3">
                        <div class="card bg-light mb-3">
                            <div class="card-header bg-primary text-white text-uppercase"><i class="fa fa-list"></i> Categories</div>
                            <ul class="list-group category_block">
                            
								<%
								
								ArrayList<Category> dsloaigiaytopselling = (ArrayList<Category>) request.getAttribute("listCC");
								if (dsloaigiaytopselling != null) {
									for (Category l : dsloaigiaytopselling) {
								%>
							
 								<li class="list-group-item text-white"><a href="HomeControl?cid=<%=l.getCid()%>"><%=l.getCname()%></a></li>
								<%
								}
								}
								%>
                               
                           
                        </ul>
                    </div>
                    <div class="card bg-light mb-3">
                    
         
                                 
								<%
								Product lastp= (Product) request.getAttribute("p");
								if (lastp != null) {
									
								%>
								
                        <div class="card-header bg-success text-white text-uppercase">Last product</div>
                        <div class="card-body">
                            <img class="img-fluid" src="<%= lastp.getImage() %>" />
                            <h5 class="card-title"><%= lastp.getTitle() %></h5>
                            <p class="card-text"><%= lastp.getName()%></p>
                            <p class="bloc_left_price"><%= lastp.getPrice() %></p>
                        </div>
                        
                        <%
								}
								
						%>
                    </div>
                </div>
                
            </div>
        </div>
        <!-- Footer -->
    
    </body>
</html>
