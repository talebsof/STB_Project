package fr.univrouen.stb23v1.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import fr.univrouen.stb23v1.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
