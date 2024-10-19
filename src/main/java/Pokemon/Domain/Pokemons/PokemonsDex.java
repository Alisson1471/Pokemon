package Pokemon.Domain.Pokemons;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class PokemonsDex {
    private List<PokemonName> results;

    public PokemonsDex() {}

    @Getter
    @Setter
    @AllArgsConstructor
    @ToString
    public static class PokemonName {

        private int id;

        private String name;

        public PokemonName() {}
    }
}
