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
                <i class='bx bxs-cart-add' ></i>
                <div class="logo_name">Booking Office</div>
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
                <a href="bookingoffice">
                    <i class='bx bx-list-ul' ></i>
                    <span class="link_name">Booking Office List</span>
                </a>
            </li>
            <li>
                <a href="add-bookingoffice">
                    <i class='bx bx-plus-medical'></i>
                    <span class="link_name">Add Booking Office</span>
                </a>
            </li>
        </ul>
    </div>

    <div class="home_content">
        <div class="text">Add Booking Office</div>
        <hr>
        <form:form style="margin-left: 20px;" id="myform" action="add-bookingoffice" method="post" modelAttribute="bookingOffice">
            <div class="row mb-3">
                <label for="bookingofficename" class="col-sm-3 col-form-label">Booking Office Name</label>
                <div class="col-sm-5">
                  <form:input type="text" class="form-control" name="bookingofficename" path="officeName" placeholder="Enter Booking Office Name" />
                </div>
            </div>
            <div class="row mb-3">
                <label for="trip" class="col-sm-3 col-form-label" >Trip</label>
                <div class="col-sm-5">
                  <select class="form-control" name="trips">
		  			<c:forEach items="${trip}" var="trip">
		  				<option value="${trip.id}">${trip.destination}</option>
		  			</c:forEach>
	  			</select>    
                </div>
            </div>
            <div class="row mb-3">
                <label for="phone" class="col-sm-3 col-form-label">Phone Number</label>
                <div class="col-sm-5">
                  <form:input type="text" class="form-control" name="phone" path="officePhone" placeholder="Enter Phone Number" />
                </div>
            </div>
            <div class="row mb-3">
                <label for="place" class="col-sm-3 col-form-label" >Place</label>
                <div class="col-sm-5">
                  <form:select class="form-select" name="place" path="officePlace">
                    <option value="counter1">Counter 1</option>
					<option value="counter2">Counter 2</option>
                  </form:select>      
                </div>
            </div>
            <div class="row mb-3">
                <label for="price" class="col-sm-3 col-form-label">Price</label>
                <div class="col-sm-5">
                  <form:input type="number" class="form-control" name="price" path="officePrice" placeholder="Enter Price" />
                </div>
            </div>
            <div class="row mb-3">
                <label for="contractdate" class="col-sm-3 col-form-label">Contract Deadline</label>
                <div class="col-sm-5">
                    <div class="row">
                        <div class="col-sm-4 ">From Date</div>
                        <div class="col-sm-8">
                            <form:input type="date" class="form-control" path="startContractDeadline"/>
                        </div>
                        <div class="col-sm-4 ">To Date</div>
                        <div class="col-sm-8 ">
                            <form:input type="date" class="form-control" path="endContractDeadline" />
                        </div>
                    </div>
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