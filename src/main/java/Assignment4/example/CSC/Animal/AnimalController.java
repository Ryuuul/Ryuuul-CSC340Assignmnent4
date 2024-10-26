package Assignment4.example.CSC.Animal;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



//@RestController
@Controller
@RequestMapping("/animals")
public class AnimalController {

    @Autowired
    private AnimalService service;


    //http://localhost:8080/animals/all
    @GetMapping("/all")
    public String getAllAnimals(Model model) {
        List<Animal> animals = service.getAllAnimals();
        model.addAttribute("animalList", animals); 
        model.addAttribute("title", "All Animals");
        return "animal-list"; 
    }


    //http://localhost:8080/animals/{id}
    @GetMapping("/{animalId}")
    public String getOneAnimal(@PathVariable int animalId, Model model) {
        Animal animal = service.getAnimalById(animalId);
        model.addAttribute("animal", animal); 
        return "animal-details"; 
    }

    //show the creation form
    //http://localhost:8080/animals/new
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("animal", new Animal()); 
        return "animal-create"; 
    }

    @PostMapping("/new")
    public String addAnimal(Animal animal) {
        service.addAnimal(animal);
        return "redirect:/animals/all"; 
    }


    //http://localhost:8080/animals/?keyword=
    @GetMapping("")
    public String searchByName(@RequestParam(name = "name", defaultValue = "Bird") String keyword, Model model) {
        List<Animal> animals = service.searchByName(keyword.trim());
        model.addAttribute("animalList", animals); 
        model.addAttribute("title", "Search Results");
        return "animal-list"; 
    }


    //http://localhost:8080/animals/search_species?species=
    @GetMapping("/search_species")
    public String searchBySpecies(@RequestParam(name = "species", defaultValue = "") String species, Model model) {
        List<Animal> animals = service.searchBySpecies(species);
        model.addAttribute("animalList", animals); 
        return "animal-list"; 
    }


    //http://localhost:8080/animals/update/{id}
    //show the update form
    @GetMapping("/update/{animalId}")
    public String showUpdateForm(@PathVariable int animalId, Model model) {
        model.addAttribute("animal", service.getAnimalById(animalId)); 
        return "animal-update"; 
    }

    
    //update the animal
    
    @PostMapping("/update")
    public String updateAnimal(Animal animal) {
        service.updateAnimal(animal.getAnimalId(), animal);
        return "redirect:/animals/" + animal.getAnimalId();
    }
    
    //http://localhost:8080/animals/delete/{id}
    @GetMapping("/delete/{animalId}")
    public String deleteAnimalById(@PathVariable int animalId) {
        service.deleteAnimal(animalId);
        return "redirect:/animals/all";
    }




    





}
