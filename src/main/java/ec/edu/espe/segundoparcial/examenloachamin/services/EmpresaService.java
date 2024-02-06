package ec.edu.espe.segundoparcial.examenloachamin.services;


import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ec.edu.espe.segundoparcial.examenloachamin.dao.EmpresaRepository;
import ec.edu.espe.segundoparcial.examenloachamin.domain.Empresa;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EmpresaService {
     private final EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public Empresa obtenerPorRuc(String ruc) {
        log.info("Se va a obtener la empresa con RUC: {}", ruc);
        Empresa empresa = this.empresaRepository.findByRuc(ruc);
        if (empresa != null) {
            log.debug("Empresa obtenida: {}", empresa);
            return empresa;
        } else {
            throw new RuntimeException("No existe la empresa con el RUC: " + ruc);
        }
    }

    @Transactional
    public void crear(Empresa empresa) {
        try {
            empresa.setFechaCreacion(null); 
            empresa.setId(UUID.randomUUID().toString());
            log.debug("ID Empresa generado: {}", empresa.getId());
            this.empresaRepository.save(empresa);
            log.info("Se creó la empresa: {}", empresa);
        } catch (Exception e) {
            throw new RuntimeException("Error al crar la empresa.", e);
        }
    }
}
