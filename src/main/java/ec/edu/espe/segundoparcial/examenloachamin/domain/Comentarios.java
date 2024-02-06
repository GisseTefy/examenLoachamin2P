package ec.edu.espe.segundoparcial.examenloachamin.domain;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Builder
public class Comentarios {
    @Getter
    @Setter
    @NoArgsConstructor
    public static class Comentario {
        private int calificacion;
        private String comentario;
        private String usuario;
        private LocalDateTime fechaComentario;
    }


}
