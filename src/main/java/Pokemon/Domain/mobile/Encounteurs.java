package Pokemon.Domain.mobile;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Encounteurs {
    @JsonProperty("location_area")
    private LocationArea locationArea;

    @JsonProperty("version_details")
    private List<VersionDetails> VersionDetails;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    public static class LocationArea {
        private String name;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    public static class VersionDetails {

        @JsonProperty("max_chance")
        private int maxChance;

    }

}
