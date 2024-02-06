package ec.edu.espe.segundoparcial.examenloachamin.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import ec.edu.espe.segundoparcial.examenloachamin.domain.Producto;

public interface ProductoRepository extends MongoRepository<Producto, String> {
    

    Producto findByCodigoProducto(String codigoProducto);
    Producto findByRucEmpresa(String rucEmpresa);

}
