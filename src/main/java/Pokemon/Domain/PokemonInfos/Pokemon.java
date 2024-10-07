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
public class Pokemon {
    private String name;

    private List<TypesPokemon> types;

}
