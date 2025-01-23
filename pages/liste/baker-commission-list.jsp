<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="bakery.model.BakerCommissionLib"%>

<%
    BakerCommissionLib[] bakerCommissionLibs = (BakerCommissionLib[]) request.getAttribute("bakerCommissionLibs");
%>
<div class="py-4 px-3 px-md-4">
    <div class="mb-3 mb-md-4 d-flex justify-content-between">
        <div class="h6 mb-0">/Liste/BakerCommissionLib</div>
    </div>
    <form action="/boulangerie/BakerCommissionLibs" method="get">
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
            <h4 class="card-title">List of baker by commssion</h4>

            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th scope="col">Name</th>
                        <th scope="col">Commission</th>
                    </tr>
                </thead>
                <tbody>
                    <%                                            
                        for(BakerCommissionLib BakerCommissionLibs : BakerCommissionLib) {
                    %>
                    <tr>
                        <td><%=BakerCommissionLib.getName()%></td>
                        <td><%=BakerCommissionLib.getCommission()%></td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        </div>
    </div>
</div>
