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
    <title>Add Employee</title>
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
                <a href="#">
                    <i class='bx bxs-dashboard' ></i>
                    <span class="link_name">Dashboard</span>
                </a>
                
            </li>
            <li>
                <a href="add-employee">
                    <i class='bx bxs-group' ></i>
                    <span class="link_name">User</span>
                </a>
                <!--<span class="tooltip">Dashboard</span>-->
            </li>
            <li>
                <a href="#">
                    <i class='bx bx-bar-chart' ></i>
                    <span class="link_name">Manager</span>
                </a>
                <!--<span class="tooltip">Dashboard</span>-->
            </li>
            <li>
                <a href="#">
                    <i class='bx bxs-parking' ></i>
                    <span class="link_name">Parking</span>
                </a>
                <!--<span class="tooltip">Dashboard</span>-->
            </li>
            <li>
                <a href="#">
                    <i class='bx bxs-car' ></i>
                    <span class="link_name">Car</span>
                </a>
                <!--<span class="tooltip">Dashboard</span>-->
            </li>
            <li>
                <a href="#">
                    <i class='bx bxs-cart-add' ></i>
                    <span class="link_name">Booking</span>
                </a>
                <!--<span class="tooltip">Dashboard</span>-->
            </li>
            <li>
                <a href="#">
                    <i class='bx bxs-plane-alt' ></i>
                    <span class="link_name">Trip</span>
                </a>
                <!--<span class="tooltip">Dashboard</span>-->
            </li>
            <li>
                <a href="#">
                    <i class='bx bxs-coupon' ></i>
                    <span class="link_name">Ticket</span>
                </a>
                <!--<span class="tooltip">Dashboard</span>-->
            </li>
            <li>
                <a href="#">
                    <i class='bx bx-list-ul' ></i>
                    <span class="link_name">List</span>
                </a>
                <!--<span class="tooltip">Dashboard</span>-->
            </li>
        </ul>
    </div>

    <div class="home_content">
        <div class="text">Add Employee</div>
        <hr>
        <form:form style="margin-left: 20px;" id="myform" action="update-employee" method="post" modelAttribute="employee">
            <div class="row mb-3">
                <label for="fullname" class="col-sm-3 col-form-label">Full Name</label>
                <div class="col-sm-5">
                  <form:input type="text" class="form-control" name="fullname" path="employeeName" placeholder="Enter Full Name" />
                </div>
            </div>
            <div class="row mb-3">
                <label for="phone" class="col-sm-3 col-form-label">Phone Number</label>
                <div class="col-sm-5">
                  <form:input type="text" class="form-control" name="phone" path="employeePhone" placeholder="Enter Phone Number" />
                </div>
            </div>
            <div class="row mb-3">
                <label for="birthdate" class="col-sm-3 col-form-label">Date of Birth</label>
                <div class="col-sm-5">
                  <form:input type="date" class="form-control" name="birthdate" path="employeeBirthDate" placeholder="" />
                </div>
            </div>
            <fieldset class="row mb-3">
                <legend class="col-form-label col-sm-3 pt-0">Sex</legend>
                <div class="col-sm-5">
                  <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="gridRadios" id="male" value="option1"  />
                    <label class="form-check-label" for="male">
                      Male
                    </label>
                  </div>
                  <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="gridRadios" id="female" value="option2"  />
                    <label class="form-check-label" for="female">
                      Female
                    </label>
                  </div>
                </div>
              </fieldset>
            <div class="row mb-3">
                <label for="address" class="col-sm-3 col-form-label">Address</label>
                <div class="col-sm-5">
                  <form:input type="text" class="form-control" name="address" path="employeeAddress" placeholder="Enter Address" />
                </div>
            </div>
            <div class="row mb-3">
                <label for="email" class="col-sm-3 col-form-label">Email</label>
                <div class="col-sm-5">
                  <form:input type="email" class="form-control" name="email" path="employeeEmail" placeholder="Enter Email" />
                </div>
            </div>
            <div class="row mb-3">
                <label for="account" class="col-sm-3 col-form-label">Account</label>
                <div class="col-sm-5">
                  <form:input type="text" class="form-control" name="account" path="account" placeholder="Enter Account" />
                </div>
            </div>
            <div class="row mb-3">
              <label for="password" class="col-sm-3 col-form-label">Password</label>
              <div class="col-sm-5">
                <form:input type="password" class="form-control" name="password" path="password" placeholder="Enter Password" />
              </div>
            </div>
            <div class="row mb-3">
                <label for="department" class="col-sm-3 col-form-label" >Department</label>
                <div class="col-sm-5">
                  <form:select class="form-select" id="department" path="department">
                    <option value="employee">Employee</option>
                    <option value="parking">Parking</option>
                    <option value="service">Service</option>
                  </form:select>      
                </div>
            </div>
            
            <button class="btn btn-success">Update</button>
			<button class="btn btn-warning"><a href="delete-employee?id=${id}">Delete</a> </button>
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