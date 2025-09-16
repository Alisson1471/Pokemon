package Pokemon.Domain.PokemonInfos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Pokemon2 {

    private int id;

    private String name;

    private Sprites sprites;

    private List<TypeSlot> types;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    public static class Sprites {

        @JsonProperty("other")
        private OthersSprites other;

        @Getter
        @Setter
        @AllArgsConstructor
        @NoArgsConstructor
        @ToString
        public static class OthersSprites {

            @JsonProperty("official-artwork")
            private OfficialArtwork officialArtwork;

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

    // Classe interna para mapear os tipos
    @Getter
    @Setter
    @AllArgsConstructor
    @ToString
    public static class TypeSlot {

        private TypeInfo type;

        public  TypeSlot() {}

        // Classe interna para mapear o 'type'
        @Getter
        @Setter
        @AllArgsConstructor
        @ToString
        public static class TypeInfo {

            private String name;

            public TypeInfo() {}

        }
    }
}
