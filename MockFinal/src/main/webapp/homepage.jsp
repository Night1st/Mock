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
                <i class='bx bxl-java'></i>
                <div class="logo_name">Mock Project</div>
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
                <a href="employee">
                    <i class='bx bxs-group' ></i>
                    <span class="link_name">Employee</span>
                </a>
            </li>
            <li>
                <a href="car">
                    <i class='bx bxs-car' ></i>
                    <span class="link_name">Car</span>
                </a>
            </li>
            <li>
                <a href="bookingoffice">
                    <i class='bx bxs-cart-add' ></i>
                    <span class="link_name">Booking Office</span>
                </a>
            </li>
            <li>
                <a href="parkinglot">
                    <i class='bx bxs-parking' ></i>
                    <span class="link_name">Parking Lot</span>
                </a>
            </li>
            <li>
                <a href="trip">
                    <i class='bx bxs-plane-alt' ></i>
                    <span class="link_name">Trip</span>
                </a>
            </li>
            <li>
                <a href="ticket">
                    <i class='bx bxs-coupon' ></i>
                    <span class="link_name">Ticket</span>
                </a>
            </li>
        </ul>
    </div>
    <script>
        let btn = document.querySelector("#btn")
        let sidebar = document.querySelector(".sidebar");

        btn.onclick = function() {
            sidebar.classList.toggle("active");
        }
    </script>
</body>
</html>