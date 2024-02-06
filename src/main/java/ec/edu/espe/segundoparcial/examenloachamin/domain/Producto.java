package ec.edu.espe.segundoparcial.examenloachamin.domain;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import ec.edu.espe.segundoparcial.examenloachamin.domain.Comentarios.Comentario;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@Document(collection = "Producto")
public class Producto {
    @Id
    private String id;

    @Field("codigo_producto")
    private String codigoProducto;

    @Field("ruc_empresa")
    private String rucEmpresa;

    @Field("descripcion")
    private String descripcion;

    @Field("precio")
    private Double precio;

    @Field("comentarios")
    private List<Comentario> comentarios;

    @Field("fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Version
    private Long version;

    

    public Producto(String id) {
        this.id = id;
    }



    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }



    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Producto other = (Producto) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }



    @Override
    public String toString() {
        return "Producto [id=" + id + ", codigoProducto=" + codigoProducto + ", rucEmpresa=" + rucEmpresa
                + ", descripcion=" + descripcion + ", precio=" + precio + ", comentarios=" + comentarios
                + ", fechaCreacion=" + fechaCreacion + ", version=" + version + "]";
    }

    
}
