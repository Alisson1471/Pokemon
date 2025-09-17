package Pokemon.Controller;

import Pokemon.Domain.AbilitiesInfo.Abilities;
import Pokemon.Domain.BuscaAtributo.TypesAtributes;
import Pokemon.Domain.DamageInfo.Damage;
import Pokemon.Domain.Generates.Generate;
import Pokemon.Domain.PokemonInfos.Pokemon2;
import Pokemon.Domain.PokemonInfos.Pokemon2Response;
import Pokemon.Domain.Pokemons.PokemonsDex;
import Pokemon.Domain.RequestPokemons;
import Pokemon.Domain.ResponsePokemons;
import Pokemon.Domain.ResponsePokemon;
import Pokemon.Domain.mobile.PokemonMobile;
import Pokemon.Domain.mobile.PokemonMobileResponse;
import Pokemon.UseCase.FetchPokemonUseCase;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*") // Permite requisições de qualquer origem (pode ser restrito)
@RestController
@RequiredArgsConstructor
@RequestMapping("/test-pokemon")
public class PokemonController {

    private final FetchPokemonUseCase fetchPokemonUseCase;

    @GetMapping("/busca-pokemons")
    public List<Pokemon2Response> getPokemons(@RequestParam("offset") int offset, @RequestParam("limit") int limit) {
        return fetchPokemonUseCase.transitionForResponse(offset, limit);
    }

    @GetMapping("/busca-pokemon-mobile/{name}")
    public PokemonMobileResponse getPokemonInfoMobile(@PathVariable String name) {
        return fetchPokemonUseCase.getPokemonInfo(name);
    }

    @GetMapping("/busca-basica/{name}")
    public ResponseEntity<?> getPokemonInfo(@PathVariable String name) {
        ResponsePokemon pokemonResponse = new ResponsePokemon();
        Pokemon2 pokemon1 = fetchPokemonUseCase.getPokemon(name);
        if (pokemon1 != null) {
            pokemonResponse.setImage(pokemon1.getSprites().getOther().getOfficialArtwork().getFrontDefault());
            pokemonResponse.setName(pokemon1.getName());
            pokemonResponse.setId(pokemon1.getId());
            List<String> list = new ArrayList<>();
            for (int i = 0; i < pokemon1.getTypes().size(); i++) {
                list.add(String.valueOf(pokemon1.getTypes().get(i).getType().getName()));
            }
            pokemonResponse.setTypes(list);
            TypesAtributes typesAtributes = fetchPokemonUseCase.getPokemonTypes();
            if(typesAtributes != null) {
                int[] id = new int[pokemon1.getTypes().size()];
                for (int i = 0; i < pokemonResponse.getTypes().size(); i++) {
                    for (int j = 0; j < Integer.parseInt(typesAtributes.getCount())-1; j++) {
                        if ((typesAtributes.getResults().get(j).getName()).equals(pokemon1.getTypes().get(i).getType().getName())){
                            id[i] = j+1;
                        }
                    }
                    Damage damage = fetchPokemonUseCase.getPokemonDamage(id[i]);
                    if (damage != null) {
                        List<String> list1 = new ArrayList<>();
                        for (int k = 0; k < damage.getDamage_relations().getDouble_damage_from().size(); k++) {
                            list1.add(damage.getDamage_relations().getDouble_damage_from().get(k).getName());
                        }
                        pokemonResponse.setDouble_damage_from(list1);
                        List<String> list2 = new ArrayList<>();
                        for (int k = 0; k < damage.getDamage_relations().getDouble_damage_to().size(); k++) {
                            list2.add(damage.getDamage_relations().getDouble_damage_to().get(k).getName());
                        }
                        pokemonResponse.setDouble_damage_to(list2);
                        List<String> list3 = new ArrayList<>();
                        for (int k = 0; k < damage.getDamage_relations().getNo_damage_from().size(); k++) {
                            list3.add(damage.getDamage_relations().getNo_damage_from().get(k).getName());
                        }
                        pokemonResponse.setNo_damage_from(list3);
                        List<String> list4 = new ArrayList<>();
                        for (int k = 0; k < damage.getDamage_relations().getNo_damage_to().size(); k++) {
                            list4.add(damage.getDamage_relations().getNo_damage_to().get(k).getName());
                        }
                        pokemonResponse.setNo_damage_to(list4);
                        Abilities abilities = fetchPokemonUseCase.getPokemonAbilities(pokemonResponse.getName());
                        List<String> list5 = new ArrayList<>();
                        if (abilities != null) {
                            for (int l = 0; l < abilities.getAbilities().size(); l++) {
                                list5.add(String.valueOf(abilities.getAbilities().get(l).getAbility().getName()));
                            }
                            pokemonResponse.setAbilities(list5);
                        }else{return ResponseEntity.status(404).body("Abilities not found");}
                    }else{return ResponseEntity.status(404).body("Double_Damages not found");}
                }
                return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(pokemonResponse);
            }return ResponseEntity.status(404).body("Types not found");
        }return ResponseEntity.status(404).body("Pokemon not found");
    }

    @SneakyThrows
    @GetMapping("/teste/{name}")
    public ResponseEntity<?> RetornoPokemon(@PathVariable String name){
        ResponsePokemon pokemonResponse = new ResponsePokemon();
        Pokemon2 pokemon1 = fetchPokemonUseCase.getPokemon(name);
        if (pokemon1 != null) {
            pokemonResponse.setName(pokemon1.getName());
            pokemonResponse.setId(pokemon1.getId());
            List<String> list = new ArrayList<>();
            for (int i = 0; i < pokemon1.getTypes().size(); i++) {
                list.add(String.valueOf(pokemon1.getTypes().get(i).getType().getName()));
            }
            pokemonResponse.setTypes(list);
            return ResponseEntity.status(200).body(pokemonResponse);
        }
        return ResponseEntity.status(404).body("Pokemon not found");
    }

    @GetMapping("/busca-imagem")
    public ResponseEntity<?> RetornoPokemonImagem(@RequestBody Pokemon2 poke){
        ResponsePokemon pokemonResponse = new ResponsePokemon();
        Pokemon2 pokemon1 = fetchPokemonUseCase.getPokemon(poke.getName());
        if (pokemon1 != null) {
            pokemonResponse.setImage(pokemon1.getSprites().getOther().getOfficialArtwork().getFrontDefault());
            pokemonResponse.setName(pokemon1.getName());
            pokemonResponse.setId(pokemon1.getId());
            List<String> list = new ArrayList<>();
            for (int i = 0; i < pokemon1.getTypes().size(); i++) {
                list.add(String.valueOf(pokemon1.getTypes().get(i).getType().getName()));
            }
            pokemonResponse.setTypes(list);
            return ResponseEntity.status(200).body(pokemonResponse);
        } return ResponseEntity.status(404).body("Pokemon not found");
    }

    @GetMapping("/busca-tipo/{type}")
    public ResponseEntity<?> RetornoPokemonTipo(@PathVariable String type){
        return ResponseEntity.status(200).body(fetchPokemonUseCase.getPokemonsByType(type));
    }
}
