package Pokemon.UseCase;

import Pokemon.Domain.AbilitiesInfo.Abilities;
import Pokemon.Domain.BuscaAtributo.TypesAtributes;
import Pokemon.Domain.DamageInfo.Damage;
import Pokemon.Domain.Generates.Generate;
import Pokemon.Domain.PokemonInfos.Pokemon2;
import Pokemon.Domain.PokemonInfos.Pokemon2Response;
import Pokemon.Domain.Pokemons.PokemonsDex;
import Pokemon.Domain.ResponsePokemons;
import Pokemon.Domain.Teste.PokemonTeste;
import Pokemon.Domain.mobile.Encounteurs;
import Pokemon.Domain.mobile.PokemonMobile;
import Pokemon.Domain.mobile.PokemonMobileResponse;
import Pokemon.Interface.PokemonClient;
import Pokemon.Interface.PokemonImageClient;
import Pokemon.Interface.PokemonRepository;
import Pokemon.adapter.Adapter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FetchPokemonUseCase {

    private final PokemonClient pokemon;

    private final PokemonImageClient pokemonimage;

    public PokemonsDex getPokemons(int offset, int limit) {
        try{
            PokemonsDex pokemons = pokemon.getPokemons(offset, limit);
            if (pokemons == null) {
                throw new RuntimeException("Personagem não encontrado!");
            }
            for (int i = 0; i < pokemons.getResults().size(); i++) {
                pokemons.getResults().get(i).setId(i + 1 + offset);
            }
            return pokemons;
        }catch (NullPointerException ex){
            throw new RuntimeException("Algo está errado com o que digitou!");
        }
    }

    public List<Pokemon2Response> transitionForResponse(int offset, int limit) {
        PokemonsDex pokemons = getPokemons(offset, limit);
        List<Pokemon2Response> response = new ArrayList<>();
        for (int i = 0; i < pokemons.getResults().size(); i++) {
            Pokemon2 pokemon = getPokemon(pokemons.getResults().get(i).getName());
            List<String> tipos = new ArrayList<>();
            pokemon.getTypes().forEach(p -> {
                    tipos.add(p.getType().getName());
            });
            Pokemon2Response info = new Pokemon2Response(pokemons.getResults().get(i).getId(),
                    pokemons.getResults().get(i).getName(),
                    pokemon.getSprites().getOther().getOfficialArtwork().getFrontDefault(),
                    tipos);
            response.add(info);
        }
        return response;
    }

    public Pokemon2 getPokemon(String name) {
        Pokemon2 pokemon1 = this.pokemon.getPokemonsInfosMobile(name.toLowerCase());
        if ((pokemon1.getName()).equals(this.pokemon.getPokemon(name.toLowerCase()).getName())){
            return pokemon1;
        } return null;
    }

    public PokemonMobileResponse getPokemonInfo(String name) {
        PokemonMobile pokemon1 = this.pokemon.getPokemonInfos(name.toLowerCase());
        if ((pokemon1.getName()).equals(this.pokemon.getPokemonInfos(name.toLowerCase()).getName())) {

            List<String> tipos = new ArrayList<>();
            pokemon1.getTypes().forEach(p -> {
                tipos.add(p.getType().getName());
            });

            List<PokemonMobileResponse.Enconteur> enconteursResponse = new ArrayList<>();
            this.pokemon.getPokemonEncountersMobile(pokemon1.getId()).forEach(p -> {
                PokemonMobileResponse.Enconteur encounter = new PokemonMobileResponse.Enconteur(
                        p.getLocationArea().getName(),
                        p.getVersionDetails().getFirst().getMaxChance()
                );
                enconteursResponse.add(encounter);
            });

            PokemonMobileResponse response = new PokemonMobileResponse(
                    pokemon1.getId(),
                    pokemon1.getName(),
                    pokemon1.getSprites().getOther().getOfficialArtwork().getFrontDefault(),
                    pokemon1.getStats(),
                    enconteursResponse,
                    tipos);

            return response;
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

    private final Adapter adapter;

    public List<String> getPokemonsByType(String type){
        return adapter.fetchNamesByType(type);
    }
}
