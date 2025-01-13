
    <h1>Formulaire de vente</h1>

    <!-- Formulaire avec date et client -->
    <form>
        <label for="date">Date :</label>
        <input type="date" id="date" name="date" required><br><br>

        <label for="client">Choisir un client :</label>
        <select id="client" name="client">
        </select><br><br>
    
    <input type="submit" value="Valider">
    <!-- Tableau des produits et quantités -->
    <h2>Details produits vente</h2>
    <table id="productTable" class="table">
        <thead>
            <tr>
                <th>Produit</th>
                <th>Quantite</th>
                <th>Supprimer</th>
            </tr>
        </thead>
        <tbody>
            <!-- Les lignes du tableau seront générées par JavaScript -->
        </tbody>
    </table>
    </form>

    <button type="button" onclick="ajouterLigne()">Ajouter une ligne</button>

    <script>
        const produits = ['Produit A', 'Produit B', 'Produit C', 'Produit D'];
        function ajouterLigne() {
            const tbody = document.querySelector('#productTable tbody');
            const tr = document.createElement('tr');
            const tdProduit = document.createElement('td');
            const selectProduit = document.createElement('select');
            produits.forEach(produit => {
                const option = document.createElement('option');
                option.value = produit;
                option.textContent = produit;
                selectProduit.appendChild(option);
            });
            tdProduit.appendChild(selectProduit);
            tr.appendChild(tdProduit);
            const tdQuantite = document.createElement('td');
            const inputQuantite = document.createElement('input');
            inputQuantite.type = 'number';
            inputQuantite.name = 'quantite';
            inputQuantite.min = 1; // Quantité minimum de 1
            tdQuantite.appendChild(inputQuantite);
            tr.appendChild(tdQuantite);
            const tdSupprimer = document.createElement('td');
            const boutonSupprimer = document.createElement('button');
            boutonSupprimer.textContent = 'Supprimer';
            boutonSupprimer.onclick = function() {
                tbody.removeChild(tr);
            };
            tdSupprimer.appendChild(boutonSupprimer);
            tr.appendChild(tdSupprimer);
            tbody.appendChild(tr);
        }
    </script>


