package com.panda.pauloartdraw.market.persistence.mapper;

import com.panda.pauloartdraw.market.domain.dto.ClientDto;
import com.panda.pauloartdraw.market.persistence.entity.Client;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring", uses = {RolMapper.class})
public interface ClientMapper {

    @Mappings({
            @Mapping(source = "rolId", target = "rolId"),
            @Mapping(source = "rol", target = "rol"),
    })
    ClientDto toDomainClient(Client client);
    List<ClientDto> toDomainClients(List<Client> clients);

    @InheritInverseConfiguration
    Client toClient(ClientDto client);
}
