    <form action="#" method="get">
    <select id="ingredient" name="ingredient">
        <option value="">Type de produit</option>
    </select>
    <select id="ingredient" name="ingredient">
        <option value="">Type de recette</option>
    </select>
    <input type="text" id="name" name="name" placeholder="Nom de l'article">
    <label for="priceMin">Prix min :</label>
    <input type="number" id="priceMin" name="priceMin" min="0" step="0.1">
    <label for="priceMax">Prix max :</label>
    <input type="number" id="priceMax" name="priceMax" min="0" step="0.1">
    <button type="submit">Filtrer</button>
</form>
    <h1>Tableau des informations</h1>
    <table class="table">
        <thead>
            <tr>
                <th>ID</th>
                <th>Date</th>
                <th>Montant</th>
                <th>Client</th>
                <th>Details</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>001</td>
                <td>2025-01-01</td>
                <td>1000</td>
                <td>Jean Dupont</td>
                <td><a href="${pageContext.request.contextPath}/vente-details">Voir les details</a></td>
            </tr>
        </tbody>
    </table>
