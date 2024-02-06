package ec.edu.espe.segundoparcial.examenloachamin.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import ec.edu.espe.segundoparcial.examenloachamin.domain.Comentarios.Comentario;

public interface ComentarioRepository extends MongoRepository<Comentario, String> {
    
    List<Comentario> findAllByUsuario(String usuario);
}
