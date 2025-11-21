package com.openjobs.insightful.model;
import com.openjobs.insightful.dto.Privileges;
import com.openjobs.insightful.dto.WeekDays;
import com.openjobs.insightful.model.enums.PrivilegeLevel;
import com.openjobs.insightful.model.enums.TrackingType;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.util.List;

@Data
@NoArgsConstructor
//@AllArgsConstructor
//@Builder
@EqualsAndHashCode(callSuper = true)
public class NetworkSettings extends BaseSettings {

    @NotNull
    private List<Network> network; // List of router MAC addresses

//    @Builder
    public NetworkSettings(Integer idle, Integer breaks, Integer screenshots,
                           WeekDays days, Boolean icon, Boolean timer, Boolean clocker,
                           Privileges privileges, List<Network> network) {
        super(TrackingType.NETWORK, idle, breaks, screenshots, days, icon, timer, clocker, privileges);
        this.network = network;
    }
}
