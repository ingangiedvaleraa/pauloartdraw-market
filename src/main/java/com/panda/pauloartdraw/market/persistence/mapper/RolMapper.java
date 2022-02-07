package com.panda.pauloartdraw.market.persistence.mapper;

import com.panda.pauloartdraw.market.domain.dto.RolDto;
import com.panda.pauloartdraw.market.persistence.entity.Rol;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {ClientMapper.class})
public interface RolMapper {

    @Mappings({
            @Mapping(source = "id", target = "id")
    })
    RolDto toDomainRol(Rol rol);

    @InheritInverseConfiguration
    @Mapping(target = "clients", ignore = true)
    Rol toRol(RolDto rol);
}
