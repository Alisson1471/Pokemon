package Pokemon.adapter;

import Pokemon.Domain.Teste.PokemonTeste;
import Pokemon.Interface.PokemonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class Adapter {
    private final PokemonRepository pokemonRepository;

    public List<String> fetchNamesByType(String type) {
        List<String> names = new ArrayList<>();
        for (int i = 0; i < pokemonRepository.findByTypeName(type).size(); i++) {
            names.add(pokemonRepository.findByTypeName(type).get(i).getNome());
        }
        return names;
    }
}
