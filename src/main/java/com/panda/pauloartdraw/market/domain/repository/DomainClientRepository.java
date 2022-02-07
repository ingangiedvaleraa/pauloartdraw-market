package com.panda.pauloartdraw.market.domain.repository;

import com.panda.pauloartdraw.market.domain.dto.ClientDto;

import java.util.List;
import java.util.Optional;

public interface DomainClientRepository {

    List<ClientDto> getAll();

    Optional<List<ClientDto>> getByRol(int rolId);

    Optional<ClientDto> getByEmail(String email);

    Optional<ClientDto> getClient(int id);

    ClientDto save(ClientDto client);

    void delete(int id);
}
