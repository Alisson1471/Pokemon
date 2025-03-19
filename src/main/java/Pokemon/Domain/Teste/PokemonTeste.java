package Pokemon.Domain.Teste;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import lombok.*;

import java.util.List;

@Document(collection = "pokemons")  // Mapeia para a coleção 'pokemons'
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PokemonTeste {

    @Id
    private String id;  // O campo _id no MongoDB

    @Field("nome")
    private String nome;  // Nome do Pokémon

    @Field("types")
    private List<TypeWrapper> types;  // Lista de tipos do Pokémon

    // Classe interna para mapear cada tipo
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    public static class TypeWrapper {

        @Field("slot")
        private int slot;  // A posição do tipo no array

        @Field("type")
        private Type type;  // Detalhes do tipo (name e url)

        // Classe interna para mapear as propriedades de "type"
        @Getter
        @Setter
        @NoArgsConstructor
        @AllArgsConstructor
        @ToString
        public static class Type {

            @Field("name")
            private String name;  // Nome do tipo (ex: "fire", "flying")

            @Field("url")
            private String url;   // URL do tipo na API
        }
    }
}