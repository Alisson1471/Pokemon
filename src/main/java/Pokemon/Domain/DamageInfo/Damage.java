package Pokemon.Domain.DamageInfo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Damage {
    private DoubleDamages damage_relations;

    public Damage() {}
}
