package com.openjobs.insightful.mapper;

import com.openjobs.insightful.dto.SharedSettings;
import com.openjobs.insightful.dto.SharedSettingsResponse;
import com.openjobs.insightful.model.enums.SettingsMode;
import com.openjobs.insightful.model.enums.SharedSettingsType;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {PrivilegeMapper.class})
public interface SettingsMapper {

    @Mappings({
            @Mapping(target = "type", source = "type")
    })
    SharedSettings toEntity(SharedSettingsResponse response);

    @ValueMappings({
            @ValueMapping(source = "OFFICE", target = "MANUAL"),
            @ValueMapping(source = "PERSONAL", target = "UNLIMITED")
    })
    SettingsMode map(SharedSettingsType type);

    @ValueMappings({
            @ValueMapping(source = "MANUAL", target = "OFFICE"),
            @ValueMapping(source = "UNLIMITED", target = "PERSONAL")
    })
    SharedSettingsType map(SettingsMode mode);

    SharedSettingsResponse toResponse(SharedSettings entity);
}
