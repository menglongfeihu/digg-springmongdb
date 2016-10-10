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
			<json:array  name="data" var="item" items="${pList}">
				<json:object>
					<json:property name="uid" value="${item.uid}"></json:property>
					<json:property name="score" value="${item.score}"></json:property>
				</json:object>
			</json:array>
		</json:object>


