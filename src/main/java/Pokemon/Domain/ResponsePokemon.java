package Pokemon.Domain;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ResponsePokemon {
    private String image;
    private String name;
    private int id;
    private List<String> types;
    private List<String> abilities;
    private List<String> double_damage_from;
    private List<String> double_damage_to;


}
