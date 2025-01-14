<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Liste des Nature Types</title>
    <link rel="stylesheet" href="/boulangerie/css/styles.css">
</head>
<body>
    <div class="container">
        <h1>Liste des Nature Types</h1>
        <table class="table">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Value</th>
                    <th>Description</th>
                </tr>
            </thead>
            <tbody>
                <!-- Populate table rows dynamically -->
                <% 
                    NatureType[] natureTypes = (NatureType[]) request.getAttribute("natureTypes");
                    for (NatureType natureType : natureTypes) {
                %>
                    <tr>
                        <td><%= natureType.getId() %></td>
                        <td><%= natureType.getValue() %></td>
                        <td><%= natureType.getDescription() %></td>
                    </tr>
                <% 
                    }
                %>
            </tbody>
        </table>
    </div>
</body>
</html>
