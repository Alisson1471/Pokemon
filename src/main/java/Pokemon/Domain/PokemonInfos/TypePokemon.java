package Pokemon.Domain.PokemonInfos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@ToString
public class TypePokemon {
    private String name;

    @JsonCreator
    public TypePokemon(@JsonProperty("name") String name) {
        this.name = name;
    }
}
