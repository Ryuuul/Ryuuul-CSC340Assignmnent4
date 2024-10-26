package Assignment4.example.CSC.Animal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    //return list of all animals
    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    //return animal by id
    public Animal getAnimalById(int animalId) {
        return animalRepository.findById(animalId).orElse(null);
    }

    //add animal to database
    public Animal addAnimal(Animal animal) {
        return animalRepository.save(animal);
    }

    /**
     * Update an existing Animal.
     *
     * @param animalId the unique Animal Id.
     * @param animal   the new Animal details.
     */ 
    public Animal updateAnimal(int animalId, Animal animal) {
        Animal existing = getAnimalById(animalId);
        existing.setName(animal.getName());
        existing.setScientificName(animal.getScientificName());
        existing.setSpecies(animal.getSpecies());
        existing.setHabitat(animal.getHabitat());
        existing.setDescription(animal.getDescription());


        return animalRepository.save(animal);
    }

    //delete existing animal
    public void deleteAnimal(int animalId) {
        animalRepository.deleteById(animalId);
    }

    //search animal by species
    public List<Animal> searchBySpecies(String species) {
        return animalRepository.findBySpecies(species);
    }

    //find animals whose name contains given string
    public List<Animal> searchByName(String keyword) {
        if (keyword == null || keyword.isEmpty()) {
            return animalRepository.findAll();
        }
        return animalRepository.getAnimalsByName(keyword);
    }



    
}
