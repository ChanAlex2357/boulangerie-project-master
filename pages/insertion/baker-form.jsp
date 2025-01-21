
    <div class="py-4 px-3 px-md-4">
        <div class="mb-3 mb-md-4 d-flex justify-content-between">
            <div class="h3 mb-0">Insertion vendeur</div>
        </div>
    </div> 
    <div class="card-body">
        <div class="row">
            <form method="POST" action="/boulangerie/bakers" class="offset-2 col-8">
                <div class="form-group">
                    <label for="">Nom</label>
                    <input type="text" name="name" required>
                </div>
                <div class="form-group">
                    <label for="">Date embauche</label>
                    <input type="date" name="dateEmbauche" required>
                </div>
                <div class="form-group">
                    <label for="">Commission</label>
                    <input type="text" value="5" name="commission">
                </div>
                <div class="form-group">
                    <input type="submit" class="btn btn-soft-success offset-4 mt-4 col-4" value="Add">
                </div>
            </form>
        </div>
    </div>