package ec.edu.espe.segundoparcial.examenloachamin.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import ec.edu.espe.segundoparcial.examenloachamin.domain.Empresa;

public interface EmpresaRepository extends MongoRepository<Empresa, String> {
    
    Empresa findByIdEmpresa(String idEmpresa);
    Empresa findByRuc(String ruc);
    
}
