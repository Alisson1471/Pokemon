package Pokemon.Domain.PokemonInfos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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

    // Classe interna para mapear os sprites
    @Getter
    @Setter
    @AllArgsConstructor
    @ToString
    public static class Sprites{

        private String front_default;

        public Sprites() {}

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
