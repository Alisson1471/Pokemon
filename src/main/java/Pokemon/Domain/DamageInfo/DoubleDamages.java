package Pokemon.Domain.DamageInfo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class DoubleDamages {
    private List<DoubleDamageFrom> double_damage_from;
    private List<DoubleDamageTo> double_damage_to;

    public  DoubleDamages() {}
}
