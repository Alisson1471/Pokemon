package Pokemon.Deserializer;

import Pokemon.Domain.PokemonInfos.TypesPokemon;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TypesDeserializer extends JsonDeserializer<List<TypesPokemon>> {
    @Override
    public List<TypesPokemon> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode node = p.getCodec().readTree(p);
        List<TypesPokemon> types = new ArrayList<>();

        if (node.isArray()) {
            for (JsonNode item : node) {
                TypesPokemon type = p.getCodec().treeToValue(item, TypesPokemon.class);
                types.add(type);
            }
        } else {
            TypesPokemon type = p.getCodec().treeToValue(node, TypesPokemon.class);
            types.add(type);
        }

        return types;
    }
}

