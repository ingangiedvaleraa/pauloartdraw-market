package com.panda.pauloartdraw.market.persistence.crud;

import com.panda.pauloartdraw.market.persistence.entity.Invoice;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface InvoiceCrudRepository extends CrudRepository<Invoice, Integer> {

    Optional<List<Invoice>> findByClientId(String clientId);
}
