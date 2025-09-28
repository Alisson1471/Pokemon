package Pokemon.Domain.mobile;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EvolutionPair {
    // A pré-evolução (ou Pokémon base)
    private String fromName;
    private String fromUrl;

    // A evolução
    private String toName;
    private String toUrl;
}