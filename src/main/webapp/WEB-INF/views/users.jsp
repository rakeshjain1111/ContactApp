<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contact App - Login Form</title>
<s:url value="/static/css/style.css" var="url_css"></s:url>
<link href="${url_css}" rel="stylesheet">
<s:url value="/static/js/jquery-3.7.1.min.js" var="url_jqlib"/>
<script src="${url_jqlib}" type="text/javascript"></script>
<script type="text/javascript">
	function changeStatus(uid, lStatus){
		//alert(userId+", "+loginStatus);
		$.ajax({
			url:'changeStatus',
			data:{userId:uid,loginStatus:lStatus} ,
			success: function (data){
				alert(data);
			}
		});
	}
</script>
</head>
<s:url value="/static/img/bg.jpg" var="bg_img"></s:url>

<body background="${bg_img}">
<table border="1" width="80%" align="center">
    <tr>
        <td height="100px">
			<jsp:include page="include/header.jsp"/>
		</td>
    </tr>
    <tr>
        <td height="25px">
			<jsp:include page="include/menu.jsp"/>
		</td>
    </tr>
    <tr>
    <td height="325px">
      <h3>All Users</h3>
 		<table border="1" cellpadding="3">
 		      <tr>
 		      		<td>SID</td>
 		           <td>UserId</td>
 		           <td>Name</td>
 		           <td>Phone</td>
 		           <td>Email</td>
 		           <td>Address</td>
 		           <td>LoginName</td>
 		           <td>Status</td>
 		           <td>Action</td>
 		      </tr>
 		     <c:forEach var="user" items="${usersList}" varStatus="st">
 		     		<tr>
 		     			<td>${st.count}</td>
 		     			<td>${user.userId }</td>
 		     			<td>${user.name }</td>
 		     			<td>${user.phone }</td>
 		     			<td>${user.email }</td>
 		     			<td>${user.address}</td>
 		     			<td>${user.loginName}</td>
 		     			<td>
 		     					<select id="id_${user.userId}" onchange="changeStatus(${user.userId}, $(this).val())">
 		     							<option value="1">Active</option>
 		     							<option value="2">Block</option>
 		     			 		</select>
 		     			 			<script>
 		     			 		   		$('#id_${user.userId}').val(${user.loginStatus})
 		     			 		</script>	
 		     			 		${user.loginStatus}
 		     			 </td>
 		     			<td>ACTION</td>
 		     		</tr>
 		     
 		     </c:forEach>
 		</table>
      
      
      
     </td>
    </tr>
    <tr>
        <td height="25px">
            <jsp:include page="include/footer.jsp"/>
        </td>
    </tr>
</table>
</body>
</html>