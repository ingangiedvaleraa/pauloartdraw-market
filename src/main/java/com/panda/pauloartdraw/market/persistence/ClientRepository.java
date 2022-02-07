package com.panda.pauloartdraw.market.persistence;

import com.panda.pauloartdraw.market.domain.dto.ClientDto;
import com.panda.pauloartdraw.market.domain.repository.DomainClientRepository;
import com.panda.pauloartdraw.market.persistence.crud.ClientCrudRepository;
import com.panda.pauloartdraw.market.persistence.entity.Client;
import com.panda.pauloartdraw.market.persistence.mapper.ClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository implements DomainClientRepository {

    @Autowired
    private ClientCrudRepository clientRepo;

    @Autowired
    private ClientMapper mapper;

    @Override
    public List<ClientDto> getAll() {
        List<Client> clients = (List<Client>) clientRepo.findAll();
        return mapper.toDomainClients(clients);
    }

    @Override
    public Optional<List<ClientDto>> getByRol(int rolId) {
        List<Client> clients = clientRepo.findByRolIdOrderByFirstname(rolId);
        return Optional.of(mapper.toDomainClients(clients));
    }

    @Override
    public Optional<ClientDto> getByEmail(String email) {
        return clientRepo.findByEmail(email).map(client -> mapper.toDomainClient(client));
    }

    @Override
    public Optional<ClientDto> getClient(int id) {
        return clientRepo.findById(id).map(client -> mapper.toDomainClient(client));
    }

    @Override
    public ClientDto save(ClientDto client) {
        Client client1 = mapper.toClient(client);
        return mapper.toDomainClient(clientRepo.save(client1));
    }

    @Override
    public void delete(int id) {
        clientRepo.deleteById(id);
    }
}
