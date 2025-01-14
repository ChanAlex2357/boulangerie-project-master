<%
    String pagePath = request.getParameter("page");
%>
<jsp:include page="header.jsp"/>
    <div class="content">
        <jsp:include page="<%= pagePath %>" />
        <jsp:include page="layout/footer.jsp" />
    </div>
<jsp:include page="footer.jsp"/>