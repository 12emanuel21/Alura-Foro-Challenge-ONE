package API.REST.ForoAlura.Topico;

import jakarta.validation.constraints.NotBlank;



public record RegistroTopico(@NotBlank String titulo,
                             @NotBlank String mensaje,
                             @NotBlank String fecha,
                             @NotBlank String autor,
                             @NotBlank String curso) {
}
