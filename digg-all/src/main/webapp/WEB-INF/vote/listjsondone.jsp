<%@page language="java" %><%@include file="../includes/includes.jsp"%>
<%
	String encode=request.getParameter("encode");
	if(encode==null){
	    encode="UTF-8";
	}
	response.setContentType("text/html;charset="+encode);
%>
<c:choose>
	<c:when test="${ empty callback}">
        <c:choose>
            <c:when test="${ empty voteList}">
                {""}
            </c:when>
            <c:otherwise>
            {
                "status":${status},
                <c:forEach items="${voteList}" var="item" varStatus="itemStat" >
                    "${item.key}":${item.value}
                    <c:if test="${!itemStat.last}">,</c:if>  
                </c:forEach>
            }
            </c:otherwise>
        </c:choose>
	</c:when>
	<c:otherwise>
        ${callback}(
            <c:choose>
                <c:when test="${ empty voteList}">
                    {""}
                </c:when>
                <c:otherwise>
                {
                    "status":${status},
                    <c:forEach items="${voteList}" var="item" varStatus="itemStat" >
                        "${item.key}":${item.value}
                        <c:if test="${!itemStat.last}">,</c:if>  
                    </c:forEach>
                }
                </c:otherwise>
            </c:choose>
        
        )
	</c:otherwise>
</c:choose>





