package Pokemon.Interface;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "pokeimage", url = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon")
public interface PokemonImageClient {

    @GetMapping(value = "/{id}.png", produces = "image/png")
    byte[] getPokemonImage(@PathVariable("id") int id);
}
