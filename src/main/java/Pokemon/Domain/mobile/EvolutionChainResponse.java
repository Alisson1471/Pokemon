package Pokemon.Domain.mobile;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EvolutionChainResponse {
    private int id;

    // O campo 'chain' é o início da árvore de evolução
    private ChainLink chain;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    public static class ChainLink {
        private PokemonSpecies species;

        @JsonProperty("evolves_to")
        private List<ChainLink> evolvesTo;

        // O detalhe de como o Pokémon anterior evoluiu para este
        @JsonProperty("evolution_details")
        private List<EvolutionDetail> evolutionDetails;

        @Getter
        @Setter
        @NoArgsConstructor
        @AllArgsConstructor
        @ToString
        public static class PokemonSpecies {
            private String name;
            private String url;
        }

        @Getter
        @Setter
        @NoArgsConstructor
        @AllArgsConstructor
        @ToString
        public static class EvolutionDetail {
            private NamedApiResource trigger; // O 'trigger' (por exemplo, "level-up")

            @Getter
            @Setter
            @NoArgsConstructor
            @AllArgsConstructor
            @ToString
            public static class NamedApiResource {
                private String name;
                private String url;
            }
        }
    }

}
