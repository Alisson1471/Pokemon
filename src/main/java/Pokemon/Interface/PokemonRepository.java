package Pokemon.Interface;

import Pokemon.Domain.Teste.PokemonTeste;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PokemonRepository extends MongoRepository<PokemonTeste, Integer> {

    @Query("{ 'types.type.name': ?0 }")
    List<PokemonTeste> findByTypeName(String typeName);

}
