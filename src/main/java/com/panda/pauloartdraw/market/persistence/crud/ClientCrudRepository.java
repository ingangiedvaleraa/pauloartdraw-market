package com.panda.pauloartdraw.market.persistence.crud;

import com.panda.pauloartdraw.market.persistence.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ClientCrudRepository extends JpaRepository<Client, Integer> {

    //@Query(value = "SELECT * FROM client WHERE rol_id = ?", nativeQuery = true)
    List<Client> findByRolIdOrderByFirstname(int rolId);

    Optional<Client> findByEmail(String email);

}
