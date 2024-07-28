<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>

<s:url var="url_logout" value="/logout"/>
<s:url var="url_regi" value="/regi_form"/>
<s:url var="url_cform" value="/user/contactform"/>
<s:url var="url_clist" value="/user/clist"/>
<c:if test="${sessionScope.userId==null }">
		
		<a href="">Home</a>  |   <a href="">Login</a>  |   <a href="${url_regi}">Register</a>  |  <a href="">About</a>  |  <a href="">ContactUs</a>
</c:if>
<c:if test="${sessionScope.userId!=null && sessionScope.role==1 }">
  <%---Admin Menu --%>
		<a href="">Home</a>  |   <a href="">UserList</a>  |   <a href="${url_logout}">Logout</a>
</c:if>
<c:if test="${sessionScope.userId!=null && sessionScope.role==2 }">
  <%---User Menu --%>
		<a href="">Home</a>  |   <a href="${url_cform}">Add Contact</a>  |   <a href="${url_clist}">Contact List</a>  |  <a href="${url_logout}">Logout</a>  |  <a href="">ContactUs</a>
</c:if>
