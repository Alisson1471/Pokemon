package Pokemon.Domain;

import Pokemon.Domain.PokemonInfos.Pokemon2;
import Pokemon.Domain.Pokemons.PokemonsDex;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class ResponsePokemons {

    private List<Pokemon2> results;


    public ResponsePokemons() {}

}
