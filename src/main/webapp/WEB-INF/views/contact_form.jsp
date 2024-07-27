<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
    <%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contact App - Contact  Form</title>
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
        
        <s:url value="/user/saveContact" var="url_regi_contact"/>
        <h3 align="center">User Registration</h3>
       <f:form action="${url_regi_contact}" modelAttribute="command">
       		<table border="1" align="center">
       		      <tr>
       		         <td>Name</td>
       		         <td><f:input path="name"/></td>
       		     </tr>
       		      <tr>
       		         <td>Phone</td>
       		         <td><f:input path="phone"/></td>
       		     </tr>
       		      <tr>
       		         <td>Email</td>
       		         <td><f:input path="email"/></td>
       		     </tr>
       		      <tr>
       		         <td>Address</td>
       		         <td><f:textarea path="address"/></td>
       		     </tr>
       		      <tr>
       		         <td>Remark</td>
						<td><f:textarea path="remark"/></td>       		
  				   </tr>
       		      <tr>
       		         <td colspan="2" align="right">
       		            <button>Save</button>
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