package Assignment4.example.CSC.Animal;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;


//@RestController
@RestController
@RequestMapping("/animals")
public class AnimalController {

    @Autowired
    private AnimalService service;


    //http://localhost:8080/animals/all
    @GetMapping("/all")
    public List<Animal> getAllAnimals() {
        return service.getAllAnimals();
    }

    //http://localhost:8080/animals/{id}
    @GetMapping("/{animalId}")
    public Animal getOneAnimal(@PathVariable int animalId) {
        return service.getAnimalById(animalId);
    }
    
    //http://localhost:8080/animals/new
    @PostMapping("/new")
    public List<Animal> addAnimal(@RequestBody Animal animal) {
        service.addAnimal(animal);
        return service.getAllAnimals();
    }


    //http://localhost:8080/animals/search_name?name=
    @GetMapping("/name_search")
    public List<Animal> searchByName(@RequestParam(name = "name", defaultValue = "") String keyword) {
        return service.searchByName(keyword);
    }

    //http://localhost:8080/animals/search_species?species=
    @GetMapping("/search_species")
    public List<Animal> searchBySpecies(@RequestParam(name = "species", defaultValue = "") String species) {
        return service.searchBySpecies(species);
    }
    
    //http://localhost:8080/animals/update/{id}
    @PutMapping("/update/{animalId}")
    public Animal updateAnimal(@PathVariable int animalId, @RequestBody Animal animal) {
        service.updateAnimal(animalId, animal);

        return service.getAnimalById(animalId);
    }
    
    //http://localhost:8080/animals/delete/{id}
    @DeleteMapping("/delete/{animalId}")
    public List<Animal> deleteAnimalById(@PathVariable int animalId) {
        service.deleteAnimal(animalId);
        return service.getAllAnimals();
    }




    





}
