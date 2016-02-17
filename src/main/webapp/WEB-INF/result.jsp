<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<link href='http://fonts.googleapis.com/css?family=Varela+Round'
	rel='stylesheet' type='text/css'>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1" />

	<link rel="stylesheet" type="text/css" href="table.css">
	
</head>
<body>

<div class="container">
    <div class="row">
     <form action="/Hibernate/Delete" method="get">
        <div class="panel panel-primary filterable">
            <div class=" grey">
                <h3 class="panel-title "><b>Employees</b></h3>  
            </div>
           <c:if test=""></c:if>
            <div align="center">
            <table class="table">
                <thead>
                <tr>
                    	<td><b>Select</b></td>
                        <td><b>ID</b></td>
                        <td><b>Age</b></td>
                        <td><b>First Name</b></td>
                        <td><b>Last Name</b></td>
                        <td><b>Address</b></td>
                    </tr>
                    <tr class="filters">
                    <c:forEach var ="i" begin="1" end = "6">
                    	<th><input type="text"disabled></th>
                        </c:forEach>
                    </tr>
                </thead>
                
                <tbody>
                <c:forEach var="i" begin="1" end="${employee.size()}">
                    <tr>
                    	<td><input type="checkbox" name="check" value="${employee[i-1].id}"/></td>
                        <td>${employee[i-1].id}</td>
                        <td>${employee[i-1].age}</td>
                        <td>${employee[i-1].fname}</td>
                        <td>${employee[i-1].lname}</td>
                        <td>${employee[i-1].address}</td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <div>
        <div align="center">
   <!--      <input type="submit" class="btn login-group " method ="post" value="View"> -->
			<input type="submit" class="btn login-group " value="Delete" onclick="return confirm('Confirm Delete?')"/>
				
			
			
			</div>
			</div>
			</div>
			</form>
    </div>
</div>

</body>
</html>


