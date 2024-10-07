package Pokemon.UseCase;

import Pokemon.Domain.AbilitiesInfo.Abilities;
import Pokemon.Domain.BuscaAtributo.TypesAtributes;
import Pokemon.Domain.DamageInfo.Damage;
import Pokemon.Domain.PokemonInfos.Pokemon2;
import Pokemon.Interface.PokemonClient;
import Pokemon.Interface.PokemonImageClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class FetchPokemonUseCase {

    @Autowired
    private PokemonClient pokemon;

    @Autowired
    private PokemonImageClient pokemonimage;

    public Pokemon2 getPokemon(String name) {
        Pokemon2 pokemon1 = this.pokemon.getPokemon(name.toLowerCase());
        if ((pokemon1.getName()).equals(this.pokemon.getPokemon(name.toLowerCase()).getName())){
            return pokemon1;
        } return null;
    }


    public Abilities getPokemonAbilities(String name) {
        Abilities abilities = this.pokemon.getPokemonAbilities(name.toLowerCase());
        if ((abilities.getAbilities().toString()).equals(this.pokemon.getPokemonAbilities(name.toLowerCase()).getAbilities().toString())){
            return abilities;
        } return null;
    }

    public Damage getPokemonDamage(int id) {
        Damage damage = this.pokemon.getPokemonDamage(id);
        if ((damage.getDamage_relations().toString()).equals(pokemon.getPokemonDamage(id).getDamage_relations().toString())){
            return damage;
        } return null;
    }

    public TypesAtributes getPokemonTypes() {
        TypesAtributes typesAtributes = this.pokemon.getPokemonTypes();
        if ((this.pokemon.getPokemonTypes().getResults().toString()).equals((typesAtributes.getResults().toString()))){
            return typesAtributes;
        } return null;
    }

    public byte[] getPokemonImage(int id){
        byte[] pokemonImage = this.pokemonimage.getPokemonImage(id);
        if(Arrays.equals(this.pokemonimage.getPokemonImage(id), pokemonImage)){
            return pokemonImage;
        }return null;
    }
}
