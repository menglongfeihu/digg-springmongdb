<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%
	response.setHeader("Cache-Control", "no-cache"); //HTTP 1.1
//or response.setHeader("Cache-Control","no-store");//HTTP 1.1
	response.setHeader("Pragma", "no-cache"); //HTTP 1.0
//	response.setDateHeader("Expires", 0); //prevents caching at the proxy server
%>