<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
    <%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contact App - Registration  Form</title>
<s:url value="/static/css/style.css" var="url_css"></s:url>
<link href="${url_css}" rel="stylesheet">
<s:url value="/static/js/jquery-3.7.1.min.js" var="url_jqlib"/>
<script src="${url_jqlib}" type="text/javascript"></script>
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
    
    <c:if test="${err!=null }">
          <p class="error">${err}</p>
    </c:if>
        
        <s:url value="/register" var="url_register"/>
        <h3 align="center">User Registration</h3>
       <f:form action="${url_register}" modelAttribute="command">
       		<table border="1" align="center">
       		      <tr>
       		         <td>Name</td>
       		         <td><f:input path="user.name"/></td>
       		     </tr>
       		      <tr>
       		         <td>Phone</td>
       		         <td><f:input path="user.phone"/></td>
       		     </tr>
       		      <tr>
       		         <td>Email</td>
       		         <td><f:input path="user.email"/></td>
       		     </tr>
       		      <tr>
       		         <td>Address</td>
       		         <td><f:textarea path="user.address"/></td>
       		     </tr>
       		     <tr>
       		         <td>Username</td>
       		         <td><f:input path="user.loginName" id="id_loginName"/>
       		             <button type="button" id="id_check_avail">Check Availability</button>
       		         	<div id="id_res_div" class="error "></div>
       		         </td>
       		     
       		     </tr>
       		      <tr>
       		         <td>Password</td>
       		         <td><f:password path="user.password"/></td>
       		     </tr>
       		      <tr>
       		         <td colspan="2" align="right">
       		            <button>Register</button>
       		         </td>
       		     </tr>
       		</table>
       </f:form>
    </td>
    </tr>
    <tr>
        <td height="25px">
            <jsp:include page="include/footer.jsp"/>
        </td>
    </tr>
</table>
<script type="text/javascript">
      $(document).ready(function () {
    	  $("#id_check_avail").click(function(){
    		  $.ajax({
    			  url : 'check_avail',
    			  data : {loginName : $("#id_loginName").val()} ,
    			  success :function(data){
    				  	$("#id_res_div").html(data);
    			  }
    		  });
    	  });
      });
</script>
</body>
</html>