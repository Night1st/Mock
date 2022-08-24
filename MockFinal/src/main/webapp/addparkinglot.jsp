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
                <i class='bx bxs-parking' ></i>
                <div class="logo_name">Parking Lot</div>
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
                <a href="add-parkinglot">
                    <i class='bx bx-plus-medical'></i>
                    <span class="link_name">Add Parking Lot</span>
                </a>
            </li>
            <li>
                <a href="parkinglot">
                    <i class='bx bx-list-ul' ></i>
                    <span class="link_name">Parking Lot List</span>
                </a>
            </li>
        </ul>
    </div>

    <div class="home_content">
        <div class="text">Add Parking Lot</div>
        <hr>
        <form:form style="margin-left: 20px;" id="myform" action="add-parkinglot" method="post" modelAttribute="parkingLot">
            <div class="row mb-3">
                <label for="parkingname" class="col-sm-3 col-form-label">Parking Name</label>
                <div class="col-sm-5">
                  <form:input type="text" class="form-control" name="parkingname" path="parkName" placeholder="Enter Parking Lot" />
                </div>
            </div>
            <div class="row mb-3">
                <label for="place" class="col-sm-3 col-form-label" >Place</label>
                <div class="col-sm-5">
                  <form:select class="form-select" name="place" path="parkPlace">
                    <option value="east">East</option>
                    <option value="west">West</option>
                    <option value="south">South</option>
                    <option value="north">North</option>
                  </form:select>      
                </div>
            </div>
            <div class="row mb-3">
                <label for="area" class="col-sm-3 col-form-label">Area</label>
                <div class="col-sm-5">
                  <form:input type="text" class="form-control" name="area" path="parkArea" placeholder="Enter Area" />
                </div>
            </div>
            <div class="row mb-3">
                <label for="price" class="col-sm-3 col-form-label">Price</label>
                <div class="col-sm-5">
                  <form:input type="text" class="form-control" name="price" path="parkPrice" placeholder="Enter Price" />
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