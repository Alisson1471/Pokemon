package Pokemon.Domain;

import Pokemon.Domain.Pokemons.PokemonsDex;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class ResponsePokemons {

    private List<ResponseInfos> results;


    public ResponsePokemons() {}

    @Getter
    @Setter
    @AllArgsConstructor
    @ToString
    public static class ResponseInfos{

        private String image;

        private int id;

        private String name;

        public ResponseInfos() {}
    }

}
