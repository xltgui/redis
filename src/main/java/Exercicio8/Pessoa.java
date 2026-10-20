package Exercicio8;

import java.io.Serializable;

public record Pessoa(
        Long id,
        String nome,
        String telefone
) implements Serializable {
}
