package Pokemon.Domain.Generates;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection = "generations")
public class Generation {

    @Id
    private Integer id;
    private String nome;
    private String imageUrl;
    private int offset;
    private int limit;

}
