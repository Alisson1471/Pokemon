package Pokemon.mapper;

import Pokemon.Domain.mobile.EvolutionChainResponse;
import Pokemon.Domain.mobile.EvolutionPair;
import Pokemon.Interface.PokemonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EvolutionMapper {

    @Autowired
    private PokemonClient pokemonClient;

    // Metodo principal para iniciar a extração
    public List<EvolutionPair> extractEvolutionPairs(EvolutionChainResponse response) {
        List<EvolutionPair> evolutionPairs = new ArrayList<>();

        // Começa a recursão a partir do primeiro ChainLink
        // O primeiro ChainLink (por exemplo, Eevee) é o "nó pai" inicial.
        mapPairsRecursive(response.getChain(), evolutionPairs);

        return evolutionPairs;
    }

    // Metodo recursivo para percorrer a árvore
    private void mapPairsRecursive(EvolutionChainResponse.ChainLink parentLink, List<EvolutionPair> pairsList) {

        // Se o ChainLink atual não tem evoluções, a recursão para.
        if (parentLink == null || parentLink.getEvolvesTo() == null || parentLink.getEvolvesTo().isEmpty()) {
            return;
        }

        // Os dados do Pokémon ATUAL (o nó pai).
        String parentName = parentLink.getSpecies().getName();
        String parentUrl = pokemonClient.getPokemonInfos(String.valueOf(extrairIdComSplit(parentLink.getSpecies().getUrl()))).getSprites().getOther().getOfficialArtwork().getFrontDefault();

        // Itera sobre as evoluções (os nós filhos)
        for (EvolutionChainResponse.ChainLink childLink : parentLink.getEvolvesTo()) {

            // Os dados do Pokémon EVOLUÍDO (o nó filho).
            String childName = childLink.getSpecies().getName();
            String childUrl = pokemonClient.getPokemonInfos(String.valueOf(extrairIdComSplit(childLink.getSpecies().getUrl()))).getSprites().getOther().getOfficialArtwork().getFrontDefault();

            // 1. Cria o par [Pai, Filho] e adiciona à lista
            EvolutionPair pair = new EvolutionPair(
                    parentName, parentUrl,
                    childName, childUrl
            );
            pairsList.add(pair);

            // 2. Chama a recursão: o filho atual se torna o novo pai
            // para buscar suas possíveis evoluções (evolução tripla, etc.)
            mapPairsRecursive(childLink, pairsList);
        }
    }

    public int extrairIdComSplit(String evolutionChainUrl) {
        // 1. Garante que não há barra no final para evitar um array vazio na última posição
        if (evolutionChainUrl.endsWith("/")) {
            evolutionChainUrl = evolutionChainUrl.substring(0, evolutionChainUrl.length() - 1);
        }

        // 2. Divide a string por barras ("/")
        String[] partes = evolutionChainUrl.split("/");

        // 3. O ID será a última parte (penúltimo elemento do array original se você não remover a barra final)
        String idString = partes[partes.length - 1];

        // 4. Converte a string do ID para inteiro
        return Integer.parseInt(idString);
    }

}