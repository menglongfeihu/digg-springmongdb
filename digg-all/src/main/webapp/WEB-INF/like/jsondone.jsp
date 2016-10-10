<%@page language="java" %><%@include file="../includes/includes.jsp"%>
<%
	String encode=request.getParameter("encode");
	if(encode==null){
	    encode="UTF-8";
	}
	response.setContentType("text/html;charset="+encode);
%>
${callback}(
<json:object>
<json:property name="status" value="${status}"></json:property>
<json:property name="statusText" value="${statusText}"></json:property>
<json:property name="liked" value="${liked}"></json:property>
<json:property name="upCount" value="${upCount}"></json:property>
</json:object>
)

