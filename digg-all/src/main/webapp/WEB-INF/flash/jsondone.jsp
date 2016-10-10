<%@page language="java" %><%@include file="../includes/includes.jsp"%>
<%
	String encode=request.getParameter("encode");
	if(encode==null){
	    encode="UTF-8";
	}
	response.setContentType("text/html;charset="+encode);
%>
<json:object>
<json:property name="code" value="${code}"></json:property>
<json:property name="score" value="${score}"></json:property>
<json:property name="uid" value="${Uid}"></json:property>
<json:property name="rank" value="${Rank}"></json:property>
<json:property name="winning" value="${winning}"></json:property>
</json:object>

