package Pokemon.Domain.Generates;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Generate {

    List<Pokemons> pokemon_species;

    public Generate() {}

    //Classe interna
    @Getter
    @Setter
    @AllArgsConstructor
    @ToString
    public static class Pokemons{

        String name;

        public Pokemons(){}
    }

}
