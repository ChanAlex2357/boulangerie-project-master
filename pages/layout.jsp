<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String page = (String)request.getAttribute("page");
%>
<%@include file="static/header.jsp" %>


    <main id="main" class="main">
        <%@include file=page %>
    </main><!-- End #main -->
  
<%@include file="static/footer.jsp" %>