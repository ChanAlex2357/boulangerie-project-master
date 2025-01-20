<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="bakery.model.Customer"%>

<%
    Customer[] customers = (Customer[]) request.getAttribute("customers");
%>
<div class="py-4 px-3 px-md-4">
    <div class="mb-3 mb-md-4 d-flex justify-content-between">
        <div class="h6 mb-0">/Liste/Customer</div>
    </div>
    <form action="/boulangerie/customers" method="get">
        <div class="form-inline">
            <div class="form-group mx-3 gap-2">
                <label for="">Date Min</label>
                <input type="date" name="dmin" class="form-control" id="">
            </div>
            <div class="form-group mx-3 gap-2">
                <label for="">Date Max</label>
                <input type="date" name="dmax" class="form-control" id="">
            </div>
        </div>
        <div class="mt-3">
            <input type="submit" class="btn btn-primary" value="Filter">
        </div>
    </form>
    <div class="card mb-4">
        <div class="card-body">
            <h4 class="card-title">List of customers</h4>

            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th scope="col">Id of customers</th>
                        <th scope="col">Name</th>
                        <th scope="col">Phone</th>
                        <th scope="col">Address</th>
                    </tr>
                </thead>
                <tbody>
                    <%                                            
                        for(Customer customer : customers) {
                    %>
                    <tr>
                        <th scope="row"> <%=customer.getId()%> </th>
                        <td><%=customer.getName()%></td>
                        <td><%=customer.getPhone()%></td>
                        <td><%=customer.getAddress()%></td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        </div>
    </div>
</div>
