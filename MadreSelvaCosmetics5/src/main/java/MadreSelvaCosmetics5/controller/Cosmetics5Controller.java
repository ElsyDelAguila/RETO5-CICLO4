package MadreSelvaCosmetics5.controller;

import MadreSelvaCosmetics5.model.Cosmetics5;
import MadreSelvaCosmetics5.service.Cosmetics5Service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Elsy Del Águila
 */
@RestController
@RequestMapping("/api/cosmetics")
@CrossOrigin("*")
public class Cosmetics5Controller {

    @Autowired
    private Cosmetics5Service cosmetics5Service;

    @GetMapping("/all")
    public List<Cosmetics5> getAll() {
        return cosmetics5Service.getAll();
    }

    @GetMapping("/{reference}")
    public Optional<Cosmetics5> getcosmetics5(@PathVariable("reference") String reference) {
        return cosmetics5Service.getcosmetics5(reference);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Cosmetics5 create(@RequestBody Cosmetics5 gadget) {
        return cosmetics5Service.create(gadget);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Cosmetics5 update(@RequestBody Cosmetics5 gadget) {
        return cosmetics5Service.update(gadget);
    }

    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("reference") String reference) {
        return cosmetics5Service.delete(reference);
    }

    @GetMapping("/price/{price}")
    public List<Cosmetics5> productsByPrice(@PathVariable("price") double precio) {
        return cosmetics5Service.productsByPrice(precio);
    }

    @GetMapping("/description/{description}")
    public List<Cosmetics5> findByDescriptionLike(@PathVariable("description") String description) {
        return cosmetics5Service.findByDescriptionLike(description);
    }
}
