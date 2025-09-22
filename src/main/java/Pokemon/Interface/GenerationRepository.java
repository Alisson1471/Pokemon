package Pokemon.Interface;

import Pokemon.Domain.Generates.Generation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GenerationRepository extends MongoRepository<Generation, Integer> {
}
