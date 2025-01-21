<div class="py-4 px-3 px-md-4">
    <div class="mb-3 mb-md-4 d-flex justify-content-between">
        <div class="h3 mb-0">Insertion Unite</div>
    </div>
</div> 
<div class="card-body">
    <div class="row">
        <form method="POST" action="/boulangerie/units" class="offset-2 col-8">
            <div class="form-group">
                <label for="unitName">Value</label>
                <input type="text" id="unitName" name="val" placeholder="Entrer le symbol" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="unitDescription">Description</label>
                <input type="text" id="unitDescription" name="description" placeholder="Entrer la description" class="form-control">
            </div>
            <div class="form-group">
                <input type="hidden" name="action" value="Enregister">
                <input type="submit" class="btn btn-soft-success offset-4 mt-4 col-4" value="VALIDER">
            </div>
        </form>
    </div>
</div>