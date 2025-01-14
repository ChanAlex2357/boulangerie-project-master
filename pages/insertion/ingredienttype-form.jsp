<div class="py-4 px-3 px-md-4">
    <div class="mb-3 mb-md-4 d-flex justify-content-between">
        <div class="h3 mb-0">Insertion Type d'Ingrédient</div>
    </div>
</div> 
<div class="card-body">
    <div class="row">
        <form method="POST" action="/boulangerie/ingredienttypes" class="offset-2 col-8">
            <div class="form-group">
                <label for="ingredientTypeValue">Value</label>
                <input type="text" id="ingredientTypeValue" name="value" placeholder="Entrer le nom du type d'ingrédient" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="ingredientTypeDescription">Description</label>
                <input type="text" id="ingredientTypeDescription" name="description" placeholder="Entrer la description du type d'ingrédient" class="form-control">
            </div>
            <div class="form-group">
                <label for="ingredientTypeNatureTypeId">Nature Type</label>
                <select id="ingredientTypeNatureTypeId" name="natureTypeId" class="form-control" required>
                    <option value="">Sélectionner le type de nature</option>
                    <!-- Populate options dynamically -->
                    <% 
                        NatureType[] natureTypes = (NatureType[]) request.getAttribute("natureTypes");
                        for (NatureType natureType : natureTypes) {
                    %>
                        <option value="<%=natureType.getId()%>"><%=natureType.getValue()%></option>
                    <% 
                        }
                    %>
                </select>
            </div>
            <div class="form-group">
                <input type="hidden" name="action" value="insert">
                <input type="submit" class="btn btn-soft-success offset-4 mt-4 col-4" value="VALIDER">
            </div>
        </form>
    </div>
</div>
