<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
        <div class="text">Add Ticket</div>
        <hr>
        <form style="margin-left: 20px;" id="myform" action="add-ticket" method="post" modelAttribute="ticket">
            <div class="row mb-3">
                <label for="customer" class="col-sm-3 col-form-label">Customer</label>
                <div class="col-sm-5">
                  <form:input type="text" class="form-control" name="customer" path="customerName" placeholder="Enter Customer Name" />
                </div>
            </div>
            <div class="row mb-3">
                <label for="bookingtime" class="col-sm-3 col-form-label">Booking Time</label>
                <div class="col-sm-5">
                  <form:input type="time" class="form-control" name="bookingtime" path="bookingTime" />
                </div>
            </div>
            <div class="row mb-3">
                <label for="trips" class="col-sm-3 col-form-label" >Trip</label>
                <div class="col-sm-5">
                  <select class="form-select" name="trips">
                  	<c:forEach items="${tripList}" var="list">
		  				<option value="${list.id}">${list.destination}</option>
		  			</c:forEach>  
                  </select>      
                </div>
            </div>
            <div class="row mb-3">
                <label for="licenseplate" class="col-sm-3 col-form-label" >License Plate</label>
                <div class="col-sm-5">
                  <select class="form-select" id="licenseplate">
                  	<c:forEach items="${carList}" var="list">
		  				<option value="${list.licensePlate}">${list.licensePlate}</option>
		  			</c:forEach>  
                  </select>      
                </div>
            </div>
            
            <button type="button" class="btn btn-primary">Back</button>
            <button type="button" class="btn btn-warning">Reset</button>
            <button type="submit" class="btn btn-success">Add</button>
          </form>
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