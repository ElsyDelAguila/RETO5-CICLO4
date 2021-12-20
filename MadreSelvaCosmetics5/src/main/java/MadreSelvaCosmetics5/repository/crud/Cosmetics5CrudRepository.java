package MadreSelvaCosmetics5.repository.crud;

import MadreSelvaCosmetics5.model.Cosmetics5;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import java.util.List;

/**
 *
 * @author Elsy Del Águila
 */
public interface Cosmetics5CrudRepository extends MongoRepository<Cosmetics5, String> {
    public List<Cosmetics5> findByPriceLessThanEqual(double precio);
    @Query("{'description':{'$regex':'?0','$options':'i'}}")
    public List<Cosmetics5> findByDescriptionLike(String description);
}

