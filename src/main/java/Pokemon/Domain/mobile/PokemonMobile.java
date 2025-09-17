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
public class PokemonMobile {

    private int id;
    private String name;
    private Sprites sprites;
    private List<Stats> stats;
    private List<TypeSlot> types;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    public static class Stats {
        @JsonProperty("base_stat")
        private int baseStat;
        private Stat stat;

        @Getter
        @Setter
        @AllArgsConstructor
        @NoArgsConstructor
        @ToString
        public static class Stat {
            private String name;
        }
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    public static class TypeSlot {
        private Pokemon2.TypeSlot.TypeInfo type;

        @Getter
        @Setter
        @AllArgsConstructor
        @NoArgsConstructor
        @ToString
        public static class TypeInfo {
            private String name;
        }
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    public static class Sprites{
        @JsonProperty("other")
        private Pokemon2.Sprites.OthersSprites other;

        @Getter
        @Setter
        @AllArgsConstructor
        @NoArgsConstructor
        @ToString
        public static class OthersSprites {

            @JsonProperty("official-artwork")
            private Pokemon2.Sprites.OthersSprites.OfficialArtwork officialArtwork;

            @Getter
            @Setter
            @AllArgsConstructor
            @NoArgsConstructor
            @ToString
            public static class OfficialArtwork {

                @JsonProperty("front_default")
                private String frontDefault;
            }
        }
    }

}
