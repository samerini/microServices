package fr.dauphine.miage.msa.TPP2.DAO2;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;


@RestController
public class MontantDeChangeController {

    private final MontantDeChangeRepository repository;

    @Autowired
    public MontantDeChangeController(MontantDeChangeRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/ /{id}")

    public MontantDeChange retrouveMontantDeChange(@PathVariable Long id) {
        return repository.findById(id).get();
    }

    @GetMapping("/transaction-de-change/getAll")
    public Collection<MontantDeChange> findAll() {
        return repository.findAll();
    }


    @DeleteMapping("/transaction-de-change/delete")
    public void deletePlace(@RequestBody MontantDeChange montantDeChange) {
        repository.delete(montantDeChange);
    }

    @PostMapping("transaction-de-change/update/{id}")
    public MontantDeChange updateMontantDeChange(@PathVariable Long id, @RequestBody MontantDeChange montantDeChange) {
        montantDeChange.setIdTransaction(id);

        return repository.saveAndFlush(montantDeChange);
    }

    @PostMapping("/transaction-de-change/create")
    public MontantDeChange createMontantDeChange(@RequestBody MontantDeChange montantDeChange) throws JSONException {

        final String uri = "http://devise-change:8000/devise-change/source/eur/dest/usd";

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);

        System.out.println(result);

        JSONObject object = new JSONObject(result);
        double to =  object.getDouble("taux");

        montantDeChange.setTaux(to);

        return repository.save(montantDeChange);
    }

}