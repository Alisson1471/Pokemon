package Pokemon.Interface;

import Pokemon.Domain.AbilitiesInfo.Abilities;
import Pokemon.Domain.BuscaAtributo.TypesAtributes;
import Pokemon.Domain.DamageInfo.Damage;
import Pokemon.Domain.PokemonInfos.Pokemon2;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "pokeapi", url = "https://pokeapi.co/api/v2")
public interface PokemonClient {

    //Pego o nome do Pokemon e o tipo dele
    @GetMapping("/pokemon-form/{name}")
    Pokemon2 getPokemon(@PathVariable("name") String name);

    //Pego as abilidades
    @GetMapping("/pokemon/{name}")
    Abilities getPokemonAbilities(@PathVariable("name") String name);

    //Pego os atributos que tem double_damage conforme o tipo do pokémon
    @GetMapping("/type/{id}")
    Damage getPokemonDamage(@PathVariable("id") int id);

    //Encontra todos os tipos de pokémon e será usado para saber qual o id do tipo
    @GetMapping("/type")
    TypesAtributes getPokemonTypes();

}
