package Pokemon.Domain;

import Pokemon.Domain.PokemonInfos.Pokemon2;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ResponsePokemon {
    private String name;
    private List<String> types;
    private List<String> abilities;
    private List<String> double_damage_from;
    private List<String> double_damage_to;


}
