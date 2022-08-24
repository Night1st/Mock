	<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link 	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
		rel="stylesheet" 
		integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" 
		crossorigin="anonymous">
    
    <link href='https://unpkg.com/boxicons@2.1.2/css/boxicons.min.css' rel='stylesheet'>
    <style><%@include file="/style.css"%></style>
</head>
<body>
    <div class="sidebar">
        <div class="logo_content">
            <div class="logo">
                <i class='bx bxs-coupon' ></i>
                <div class="logo_name">Ticket</div>
            </div>
            <i class='bx bx-menu' id="btn"></i>
        </div>
        <ul class="nav_list">
            <li>
                <a href="homepage.jsp">
                    <i class='bx bxs-dashboard' ></i>
                    <span class="link_name">Home</span>
                </a>
                
            </li>
            <li>
                <a href="ticket">
                    <i class='bx bx-list-ul' ></i>
                    <span class="link_name">Ticket List</span>
                </a>
            </li>
            <li>
                <a href="add-ticket">
                    <i class='bx bx-plus-medical'></i>
                    <span class="link_name">Add Ticket</span>
                </a>
        </ul>
    </div>

    <div class="home_content">
        <div class="text">Ticket List</div>
        <hr>
        <div class="col-md-12">
            <div class="row">
                <div class="col-md-4"></div>
                <div class="col-md-8">
                    <form action="ticket" method="get" id="search">
                        <div class="menu-table">
                            <div class="div-search">
                                <i class='bx bx-search'></i>
                            </div>
                            <input type="text" name="search" placeholder="User Search" class="">
                            <button style="" class="btn-filter">
                                <i class="fa fa-filter"></i>Filter By
                            </button>
                            <select>
                                <option>Trip</option>
                            </select>
                            <button class="btn btn-primary" form="search">Search</button>
                        </div>
                        
                    </form>
                    
                </div>
                <div class="col-sm-12 tables">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th scope="col">No</th>
								<th scope="col">Trip</th>
								<th scope="col">Customer</th>
								<th scope="col">License plate</th>
								<th scope="col">Booking Time</th>
								<th scope="col">Action</th>
                            </tr>
                        </thead>
                        <tbody>
                        	<c:forEach items="${listTicket}" var="list">
								<tr>
									<th scope="row">${list.id}</th>
									<td>${list.trip.destination}</td>
									<td>${list.customerName}</td>
									<td>${list.car.licensePlate}</td>
									<td>${list.bookingTime}</td>
									<td><a onclick="deleteticket(${list.id})"><i class="fa fa-trash"></i> Delete</a></td>
								</tr>
							</c:forEach>
                        </tbody>
                    </table>
                    <div class="pagination">
                        <a href="#">Previous</a>
                        <c:forEach items="${numPage}" var="num"> 
                            <a href="employee?page=${num}">${num}</a>
                        </c:forEach> 
                        <a href="#">Next</a>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script>
        let btn = document.querySelector("#btn")
        let sidebar = document.querySelector(".sidebar");

        btn.onclick = function() {
            sidebar.classList.toggle("active");
        }
        function deleteticket(id){
			var r = confirm("are you sure you want to delete this item ?");
			if(r == true){
				window.location.href = "delete-ticket?id="+id;
			}
		}
    </script>
</body>
</html>