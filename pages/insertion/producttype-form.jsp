<div class="py-4 px-3 px-md-4">
    <div class="mb-3 mb-md-4 d-flex justify-content-between">
        <div class="h3 mb-0">Insertion Type de Produit</div>
    </div>
</div> 
<div class="card-body">
    <div class="row">
        <form method="POST" action="/boulangerie/producttypes" class="offset-2 col-8">
            <div class="form-group">
                <label for="productTypeValue">Value</label>
                <input type="text" id="productTypeValue" name="value" placeholder="Entrer le nom du type de produit" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="productTypeDescription">Description</label>
                <input type="text" id="productTypeDescription" name="description" placeholder="Entrer la description du type de produit" class="form-control">
            </div>
            <div class="form-group">
                <input type="hidden" name="action" value="insert">
                <input type="submit" class="btn btn-soft-success offset-4 mt-4 col-4" value="VALIDER">
            </div>
        </form>
    </div>
</div>
