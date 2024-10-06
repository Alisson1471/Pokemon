package Pokemon.Domain.PokemonInfos;

import Pokemon.Deserializer.TypesDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Types;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Pokemon {
    private String name;

    @JsonDeserialize(using = TypesDeserializer.class)
    private List<TypesPokemon> types;

}
