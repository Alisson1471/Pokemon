package Pokemon.Domain.mobile;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PokemonSpeciesResponse {

    @JsonProperty("evolution_chain")
    private EvolutionChain evolutionChain;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    public static class EvolutionChain {
        private String url;
    }
}
