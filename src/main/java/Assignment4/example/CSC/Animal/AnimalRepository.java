package Assignment4.example.CSC.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository 
public interface AnimalRepository  extends JpaRepository<Animal, Integer>{

    List<Animal> findBySpecies(String species);


    @Query(value = "SELECT * FROM animals a WHERE a.name LIKE %:keyword%", nativeQuery = true)
    List<Animal> findByNameContaining(@Param("keyword") String keyword);



}
