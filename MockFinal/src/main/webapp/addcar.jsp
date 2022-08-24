<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Car</title>
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
                <i class='bx bxs-car' ></i>
                <div class="logo_name">Car</div>
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
                <a href="add-car">
                    <i class='bx bx-plus-medical'></i>
                    <span class="link_name">Add Car</span>
                </a>
            </li>
            <li>
                <a href="car">
                    <i class='bx bx-list-ul' ></i>
                    <span class="link_name">Car List</span>
                </a>
            </li>
        </ul>
    </div>

    <div class="home_content">
        <div class="text">Add Car</div>
        <hr>
        <form:form style="margin-left: 20px;" id="myform" action="add-car" method="post" modelAttribute="car" >
            <div class="row mb-3">
                <label for="licenseplate" class="col-sm-3 col-form-label">License Plate</label>
                <div class="col-sm-5">
                  <form:input type="text" class="form-control" name="licenseplate" path="licensePlate" placeholder="Enter License Plate" />
                </div>
            </div>
            <div class="row mb-3">
                <label for="cartype" class="col-sm-3 col-form-label">Car Type</label>
                <div class="col-sm-5">
                  <form:input type="text" class="form-control" name="cartype" path="carType" placeholder="Enter Car Type" />
                </div>
            </div>
            <div class="row mb-3">
                <label for="carcolor" class="col-sm-3 col-form-label">Car Color</label>
                <div class="col-sm-5">
                  <form:input type="text" class="form-control" name="carcolor" path="carColor" placeholder="Enter Address" />
                </div>
            </div>
            <div class="row mb-3">
                <label for="company" class="col-sm-3 col-form-label" >Company</label>
                <div class="col-sm-5">
                  <form:select class="form-select" name="company" path="company">
                    <option value="employee">Employee</option>
                    <option value="parking">Parking</option>
                    <option value="service">Service</option>
                  </form:select>      
                </div>
            </div>
            <div class="row mb-3">
                <label for="parkinglot" class="col-sm-3 col-form-label" >Parking Lot</label>
                <div class="col-sm-5">
                  <select class="form-select" name="parking">
                    <c:forEach items="${listparking}" var="list">
		  				<option value="${list.id}">${list.parkName}</option>
		  			</c:forEach>
                  </select>      
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