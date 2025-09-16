package Pokemon.Interface;

import Pokemon.Domain.AbilitiesInfo.Abilities;
import Pokemon.Domain.BuscaAtributo.TypesAtributes;
import Pokemon.Domain.DamageInfo.Damage;
import Pokemon.Domain.PokemonInfos.Pokemon2;
import Pokemon.Domain.Pokemons.PokemonsDex;
import Pokemon.Domain.mobile.PokemonMobile;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "pokeapi", url = "https://pokeapi.co/api/v2")
public interface PokemonClient {

    //Pego todos os pokemons
    @GetMapping("/pokemon-form")
    PokemonsDex getPokemons(@RequestParam("offset") int offset, @RequestParam("limit") int limit);

    @GetMapping("/pokemon/{name}")
    PokemonMobile getPokemonInfos(@PathVariable String name);

    //Pego o nome do Pokemon e o tipo dele
    @GetMapping("/pokemon-form/{name}")
    Pokemon2 getPokemon(@PathVariable("name") String name);

    @GetMapping("/pokemon/{name}")
    Pokemon2 getPokemonsInfosMobile(@PathVariable String name);

    //Pego as habilidades
    @GetMapping("/pokemon/{name}")
    Abilities getPokemonAbilities(@PathVariable("name") String name);

    //Pego os atributos que tem double_damage conforme o tipo do pokémon
    @GetMapping("/type/{id}")
    Damage getPokemonDamage(@PathVariable("id") int id);

    //Encontra todos os tipos de pokémon e será usado para saber qual o id do tipo
    @GetMapping("/type")
    TypesAtributes getPokemonTypes();

}
