<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
    <%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contact App - Login Form</title>
<s:url value="/static/css/style.css" var="url_css"></s:url>
<link href="${url_css}" rel="stylesheet">
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
    <h3>User Login</h3>
      <c:if test="${param.act eq 'reg' }">
          <p class="success">Registration Successfully...To Continue Login</p>
    </c:if>
        <s:url value="/login" var="url_login"/>
        <h3 align="center">User Login</h3>
       <f:form action="${url_login}" modelAttribute="command">
       		<table border="1" align="center">
       		     <tr>
       		         <td>Username</td>
       		         <td><f:input path="loginName"/></td>
       		     </tr>
       		      <tr>
       		         <td>Password</td>
       		         <td><f:password path="password"/></td>
       		     </tr>
       		      <tr>
       		         <td colspan="2" align="right">
       		            <button>Login</button>
       		            <s:url var="url_regi" value="/regi_form"/>
       		            <a href="${url_regi}">New User Registration</a>
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
</body>
</html>