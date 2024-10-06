package Pokemon.Domain.PokemonInfos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@ToString
public class TypesPokemon {
    @JsonProperty("type")
    private List<TypePokemon> type;

    @JsonCreator
    public TypesPokemon(@JsonProperty("type") List<TypePokemon> type) {
        this.type = type;
    }

}
