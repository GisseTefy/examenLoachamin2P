package ec.edu.espe.segundoparcial.examenloachamin.services;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import ec.edu.espe.segundoparcial.examenloachamin.dao.ProductoRepository;
import ec.edu.espe.segundoparcial.examenloachamin.domain.Comentarios;
import ec.edu.espe.segundoparcial.examenloachamin.domain.Comentarios.Comentario;
import ec.edu.espe.segundoparcial.examenloachamin.domain.Producto;

public class ProductoService {
    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Transactional
    public void crearProducto(Producto producto) {
        producto.setId(UUID.randomUUID().toString());
        producto.setFechaCreacion(LocalDateTime.now());
        productoRepository.save(producto);
    }

    @Transactional
    public void agregarComentario(String codigoProducto, Comentarios.Comentario comentario) {
        Producto producto = productoRepository.findByCodigoProducto(codigoProducto);
        if (producto != null) {
            producto.getComentarios().add(comentario);
            productoRepository.save(producto);
        }
    }
}
