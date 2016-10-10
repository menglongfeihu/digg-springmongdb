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
<json:property name="vid" value="${vid}"></json:property>
<json:property name="tvid" value="${tvid}"></json:property>
<json:property name="type" value="${type}"></json:property>
<json:property name="upCount" value="${upCount}"></json:property>
<json:property name="downCount" value="${downCount}"></json:property>
</json:object>
)

