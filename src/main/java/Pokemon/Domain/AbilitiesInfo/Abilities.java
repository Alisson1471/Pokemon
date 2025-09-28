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

    //Classe interna
    @Getter
    @Setter
    @AllArgsConstructor
    @ToString
    public static class Ability {
        private AbilityInfo ability;

        public Ability() {}

        public AbilityInfo getAbility() {
            return ability;
        }

        //Classe interna
        @Getter
        @Setter
        @AllArgsConstructor
        @ToString
        public class AbilityInfo {
            private String name;

            public AbilityInfo(){}
        }
    }
}
