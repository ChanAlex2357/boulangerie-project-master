<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String pagePath = request.getParameter("page");
%>
<%@include file="static/header.jsp" %>

    <main id="main" class="main">
        <jsp:include page="<%=pagePath%>" />
    </main><!-- End #main -->
  
<%@include file="static/footer.jsp" %>