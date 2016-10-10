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
			<json:property name="platform" value="sohu"></json:property>
			<json:array  name="data" var="item" items="${aPlayerList}">
				<json:object>
					<json:property name="name" value="${fn:substring(item.name,0,2)}*"></json:property>
					<json:property name="uid" value="${item.uid}"></json:property>
					<json:property name="tel" value="${fn:substring(item.telephone,0,7)}****"></json:property>
				</json:object>
			</json:array>
		</json:object>


