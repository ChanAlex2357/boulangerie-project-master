<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="bakery.model.Baker"%>

<%
    Baker[] bakers = (Baker[]) request.getAttribute("bakers");
%>
<div class="py-4 px-3 px-md-4">
    <div class="mb-3 mb-md-4 d-flex justify-content-between">
        <div class="h6 mb-0">/Liste/Baker</div>
    </div>

    <div class="card mb-4">
        <div class="card-body">
            <h4 class="card-title">Liste des vendeurs</h4>

            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th scope="col">Id Baker</th>
                        <th scope="col">Nom/th>
                        <th scope="col">Date d embauche</th>
                        <th scope="col">Commission</th>
                    </tr>
                </thead>
                <tbody>
                    <%                                            
                        for (int i = 0; i < bakers.length; i++) {
                    %>
                    <tr>
                        <th scope="row"> <%=bakers[i].getId()%> </th>
                        <td><%=bakers[i].getName()%></td>
                        <td><%=bakers[i].getHireDate()%></td>
                        <td><%=bakers[i].getCommission()%></td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        </div>
    </div>
</div>
