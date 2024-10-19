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
public class Damage {
    private DoubleDamages damage_relations;

    public Damage() {}

    //Classe interna da Classe Damage
    @Getter
    @Setter
    @AllArgsConstructor
    @ToString
    public static class DoubleDamages {
        private List<DoubleDamageFrom> double_damage_from;
        private List<DoubleDamageTo> double_damage_to;
        private List<NoDamageFrom> no_damage_from;
        private List<NoDamageTo> no_damage_to;

        public  DoubleDamages() {}

        //Classe interna da classe DoubleDamages
        @Getter
        @Setter
        @AllArgsConstructor
        @ToString
        public static class DoubleDamageFrom {
            private String name;

            public DoubleDamageFrom() {}
        }

        //Classe interna da classe DoubleDamages
        @Getter
        @Setter
        @AllArgsConstructor
        @ToString
        public static class DoubleDamageTo {
            private String name;

            public DoubleDamageTo() {}
        }

        //Classe interna da classe NoDamageFrom
        @Getter
        @Setter
        @AllArgsConstructor
        @ToString
        public static class NoDamageFrom {
            private String name;

            public NoDamageFrom() {}
        }

        //Classe interna da classe NoDamageTo
        @Getter
        @Setter
        @AllArgsConstructor
        @ToString
        public static class NoDamageTo{
            private String name;

            public NoDamageTo() {}
        }
    }

}
