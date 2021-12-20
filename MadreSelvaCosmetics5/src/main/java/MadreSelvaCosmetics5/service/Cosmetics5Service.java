package MadreSelvaCosmetics5.service;

import MadreSelvaCosmetics5.model.Cosmetics5;
import MadreSelvaCosmetics5.repository.Cosmetics5Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 *
 * @author Elsy Del Águila
 */
@Service
public class Cosmetics5Service {

    @Autowired
    private Cosmetics5Repository cosmetics5Repository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Cosmetics5> getAll() {
        return cosmetics5Repository.getAll();
    }

    public Optional<Cosmetics5> getcosmetics5(String reference) {
        return cosmetics5Repository.getcosmetics5(reference);
    }

    public Cosmetics5 create(Cosmetics5 cosmetics5) {
        if (cosmetics5.getReference() == null) {
            return cosmetics5;
        } else {
            return cosmetics5Repository.create(cosmetics5);
        }
    }

    public Cosmetics5 update(Cosmetics5 cosmetics5) {

        if (cosmetics5.getReference() != null) {
            Optional<Cosmetics5> cosmetics5Db = cosmetics5Repository.getcosmetics5(cosmetics5.getReference());
            if (!cosmetics5Db.isEmpty()) {
                if (cosmetics5.getBrand() != null) {
                    cosmetics5Db.get().setBrand(cosmetics5.getBrand());
                }

                if (cosmetics5.getCategory() != null) {
                    cosmetics5Db.get().setCategory(cosmetics5.getCategory());
                }

                if (cosmetics5.getName() != null) {
                    cosmetics5Db.get().setName(cosmetics5.getName());
                }

                if (cosmetics5.getDescription() != null) {
                    cosmetics5Db.get().setDescription(cosmetics5.getDescription());
                }
                if (cosmetics5.getPrice() != 0.0) {
                    cosmetics5Db.get().setPrice(cosmetics5.getPrice());
                }
                if (cosmetics5.getQuantity() != 0) {
                    cosmetics5Db.get().setQuantity(cosmetics5.getQuantity());
                }
                if (cosmetics5.getPhotography() != null) {
                    cosmetics5Db.get().setPhotography(cosmetics5.getPhotography());
                }
                cosmetics5Db.get().setAvailability(cosmetics5.isAvailability());
                cosmetics5Repository.update(cosmetics5Db.get());
                return cosmetics5Db.get();
            } else {
                return cosmetics5;
            }
        } else {
            return cosmetics5;
        }
    }

    public boolean delete(String reference) {
        Boolean aBoolean = getcosmetics5(reference).map(cosmetics5 -> {
            cosmetics5Repository.delete(cosmetics5);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    public List<Cosmetics5> productsByPrice(double precio) {
        return cosmetics5Repository.productsByPrice(precio);
    }

    public List<Cosmetics5> findByDescriptionLike(String description) {
        return cosmetics5Repository.findByDescriptionLike(description);
    }
}
