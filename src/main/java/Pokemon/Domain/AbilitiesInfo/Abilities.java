package Pokemon.Domain.AbilitiesInfo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@ToString
public class Abilities {
    private List<Ability> abilities;

    public Abilities() {}
}
