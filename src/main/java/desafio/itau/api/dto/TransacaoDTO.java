package desafio.itau.api.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TransacaoDTO {

    @NotNull
    @Min(0)
    private Double valor;

    @NotNull
    @Past
    private OffsetDateTime dataHora;
}
