package Pokemon.Domain.mobile;

import Pokemon.Domain.PokemonInfos.Pokemon2;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PokemonMobileResponse {

    private int id;
    private String name;
    private String imageUrl;
    private List<PokemonMobile.Stats> stats;
    private List<Enconteur> enconteurs;
    private List<String> types;
    private List<String> abilities;
    private List<EvolutionPair> chains;


    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    public static class Enconteur {
        private String locationName;
        private int maxChance;
    }

}
