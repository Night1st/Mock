<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@	taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
                <i class='bx bxs-plane-alt' ></i>
                <div class="logo_name">Plane</div>
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
                <a href="trip">
                    <i class='bx bx-list-ul' ></i>
                    <span class="link_name">Trip List</span>
                </a>
            </li>
            <li>
                <a href="add-trip">
                    <i class='bx bx-plus-medical'></i>
                    <span class="link_name">Add Trip</span>
                </a>
            </li>
        </ul>
    </div>

    <div class="home_content">
        <div class="text">Add Trip</div>
        <hr>
        <form:form style="margin-left: 20px;" id="myform" action="add-trip" method="post" modelAttribute="trip">
            <div class="row mb-3">
                <label for="destination" class="col-sm-3 col-form-label">Destination</label>
                <div class="col-sm-5">
                  <form:input type="text" class="form-control" name="destination" path="destination" placeholder="Enter Destination" />
                </div>
            </div>
            <div class="row mb-3">
                <label for="departuretime" class="col-sm-3 col-form-label">Departure Time</label>
                <div class="col-sm-5">
                  <form:input type="time" class="form-control" name="departuretime" path="departureTime" />
                </div>
            </div>
            <div class="row mb-3">
                <label for="driver" class="col-sm-3 col-form-label">Driver</label>
                <div class="col-sm-5">
                  <form:input type="text" class="form-control" name="driver" path="driver" placeholder="Enter Driver" />
                </div>
            </div>
            <div class="row mb-3">
                <label for="cartype" class="col-sm-3 col-form-label">Car Type</label>
                <div class="col-sm-5">
                  <form:input type="text" class="form-control" name="cartype" path="carType" placeholder="Enter Car Type" />
                </div>
            </div>
            <div class="row mb-3">
                <label for="ticketnumber" class="col-sm-3 col-form-label">Maximum Online Ticket Number</label>
                <div class="col-sm-5">
                  <form:input type="number" class="form-control" name="ticketnumber" path="bookedTicketNumber" />
                </div>
            </div>
            <div class="row mb-3">
                <label for="departuredate" class="col-sm-3 col-form-label">Departure Date</label>
                <div class="col-sm-5">
                  <form:input type="date" class="form-control" name="departuredate" path="departureDate" />
                </div>
            </div>
            
            <button type="button" class="btn btn-primary">Back</button>
            <button type="button" class="btn btn-warning">Reset</button>
            <button type="submit" class="btn btn-success">Add</button>
          </form:form>
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