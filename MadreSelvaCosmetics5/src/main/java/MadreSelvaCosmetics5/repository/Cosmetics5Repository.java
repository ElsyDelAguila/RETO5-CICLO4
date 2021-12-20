package MadreSelvaCosmetics5.repository;

import MadreSelvaCosmetics5.model.Cosmetics5;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import MadreSelvaCosmetics5.repository.crud.Cosmetics5CrudRepository;

/**
 *
 * @author Elsy Del Águila
 */
@Repository
public class Cosmetics5Repository {

    @Autowired
    private Cosmetics5CrudRepository repository;

    public List<Cosmetics5> getAll() {
        return repository.findAll();
    }

    public Optional<Cosmetics5> getcosmetics5(String reference) {
        return repository.findById(reference);
    }

    public Cosmetics5 create(Cosmetics5 cosmetics5) {
        return repository.save(cosmetics5);
    }

    public void update(Cosmetics5 cosmetics5) {
        repository.save(cosmetics5);
    }

    public void delete(Cosmetics5 cosmetics5) {
        repository.delete(cosmetics5);
    }

    public List<Cosmetics5> productsByPrice(double precio) {
        return repository.findByPriceLessThanEqual(precio);
    }

    public List<Cosmetics5> findByDescriptionLike(String description) {
        return repository.findByDescriptionLike(description);
    }
}
