package Pokemon.Domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class RequestPokemons {

    private int offset;
    private int limit;

    public RequestPokemons() {}

}
