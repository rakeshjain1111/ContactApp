<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
    <%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contact App - Contact List</title>
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
        <h3 align="center">Contact List </h3>
         <c:if test="${param.act eq 'del' }">
        		<p>Contact deleted Successfully</p>
        </c:if>
        <c:if test="${param.act eq 'sv' }">
        		<p>Contact Saved Successfully</p>
        </c:if>
         <c:if test="${param.act eq 'up' }">
        		<p>Contact Updated Successfully</p>
        </c:if>
    
     <table width="100%">
     <tr>
     	<td align="right">
     		  <form action="<s:url value="/user/contact_search"/> ">
         			    <input type="text" name="freetext" value="${param.freetext}" placeholder="Enter text to Search">
             <button>Search</button>
        </form>
     	</td>
    </tr>
     </table>
     <form action="<s:url value="/user/bulk_cdelete"/> ">
     				<button>DELETE SELECTED RECORDS</button>
     				<br><br>
    <table border="1" cellpadding="4" align="center">
    	<tr>
    		<td>SELECT</td>
    		<td>CONTACT ID</td>
    		<td>NAME</td>
    		<td>PHONE</td>
    		<td>EMAIL</td>
    		<td>ADDRESS</td>
    		<td>REMARK</td>
    		<td>ACTION</td>
    	</tr>
    	<c:if test="${empty clist}">
        	  <tr>
        	      <td colspan="8" class="errer">No Record Present</td>
        	  </tr>
        </c:if>
    	
    	<c:forEach var="c" items="${clist }" varStatus="st">
		    	  <tr>
		    		<td><input type="checkbox" name="cid" value="${c.contactId }"></td>
		    		<td>${c.contactId }</td>
		    		<td>${c.name}</td>
		    		<td>${c.phone}</td>
		    		<td>${c.email}</td>
		    		<td>${c.address}</td>
		    		<td>${c.remark}</td>
		    		<s:url value="/user/deleteContact" var="url_delete">
		    		    <s:param name="cid" value="${c.contactId}"/>
		    		</s:url>
		    		<s:url value="/user/editContact" var="url_edit">
		    		    <s:param name="cid" value="${c.contactId}"/>
		    		</s:url>
		    		<td><a href="${url_edit}">EDIT</a> | <a href="${url_delete}">DELETE</a></td>
		    	</tr>
    	</c:forEach>
    </table>
     
     </form>
    
    
    
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