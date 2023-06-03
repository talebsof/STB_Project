package fr.univrouen.stb23v1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.univrouen.stb23v1.model.Features;

public interface FeaturesRepository extends JpaRepository<Features, Long> {
    // Add custom query methods or overrides if needed
}