package fr.univrouen.stb23v1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import fr.univrouen.stb23v1.model.STB;


public interface STBRepository extends JpaRepository<STB, Long> {
    List<STB> findAll();
    boolean existsByTitleAndVersionAndDate(String title, String version, String date);

}



