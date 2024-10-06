package Pokemon.Domain.BuscaAtributo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class TypesAtributes {
    private String count;
    private List<Atributes> results;

    public TypesAtributes() {}
}
