package fr.dauphine.miage.msa.TP;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Collection;

@RestController
public class ChangeController {
    @Autowired
    private Environment environment;
    @Autowired
    private TauxChangeRepository repository;
    @GetMapping("/devise-change/source/{source}/dest/{dest}")
    public TauxChange retrouveTauxChange(@PathVariable String source, @PathVariable String dest){
        TauxChange tauxChange = repository.findBySourceAndDest(source.toUpperCase(), dest.toUpperCase());
        return tauxChange;
    }


    @PostMapping("/devise-change")
    public TauxChange createTauxChange(@RequestBody TauxChange tauxChange) {
        return repository.save(tauxChange);
    }

    @GetMapping ("/devise-change/getAll")
    public Collection<TauxChange> findAll() {
        return repository.findAll();
    }


    @DeleteMapping ("/devise-change/delete")
    public void deletePlace(@RequestBody TauxChange tauxChange) {
        repository.delete(tauxChange);
    }
//
    @PostMapping ("/devise-change/update/{id}")
    public TauxChange updateTauxChange(@PathVariable Long id, @RequestBody TauxChange tauxChange) {
        tauxChange.setId(id);

        return repository.saveAndFlush (tauxChange);
    }

}

