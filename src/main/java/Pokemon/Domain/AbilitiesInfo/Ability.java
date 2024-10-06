package Pokemon.Domain.AbilitiesInfo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Ability {
    private AbilityInfo ability;

    public Ability() {}
}
