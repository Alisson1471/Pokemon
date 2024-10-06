package Pokemon.UseCase;

import Pokemon.Domain.AbilitiesInfo.Abilities;
import Pokemon.Domain.BuscaAtributo.TypesAtributes;
import Pokemon.Domain.DamageInfo.Damage;
import Pokemon.Domain.PokemonInfos.Pokemon2;
import Pokemon.Interface.PokemonClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FetchPokemonUseCase {

    @Autowired
    private PokemonClient pokemon;

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
        System.out.println(typesAtributes.getResults().toString());
        System.out.println(this.pokemon.getPokemonTypes().getResults().toString());
        if ((this.pokemon.getPokemonTypes().getResults().toString()).equals((typesAtributes.getResults().toString()))){
            return typesAtributes;
        } return null;
    }
}
