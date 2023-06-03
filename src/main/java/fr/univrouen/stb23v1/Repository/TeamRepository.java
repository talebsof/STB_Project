package fr.univrouen.stb23v1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.univrouen.stb23v1.model.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
