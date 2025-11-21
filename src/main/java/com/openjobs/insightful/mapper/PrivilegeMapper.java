package com.openjobs.insightful.mapper;

import com.openjobs.insightful.model.enums.PrivilegeLevel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ValueMapping;
import org.mapstruct.ValueMappings;

@Mapper(componentModel = "spring")
public interface PrivilegeMapper {

    @ValueMappings({
            @ValueMapping(source = MappingConstants.NULL, target = "NONE"),
            @ValueMapping(source = "none", target = "NONE"),
            @ValueMapping(source = "read", target = "READ"),
            @ValueMapping(source = "write", target = "WRITE"),
            // any unknown → NONE
            @ValueMapping(source = MappingConstants.ANY_REMAINING, target = "NONE")
    })
    PrivilegeLevel toEnum(String val);

    default String toString(PrivilegeLevel level) {
        return level == null ? "none" : level.toValue();
    }
}
