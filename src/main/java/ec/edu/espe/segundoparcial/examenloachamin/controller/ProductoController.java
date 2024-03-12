package ec.edu.espe.segundoparcial.examenloachamin.controller;



import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.segundoparcial.examenloachamin.domain.Comentarios.Comentario;
import ec.edu.espe.segundoparcial.examenloachamin.domain.Producto;
import ec.edu.espe.segundoparcial.examenloachamin.services.ProductoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/v1/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @PostMapping("/crear")
    public ResponseEntity<Void> crearProducto(@RequestBody Producto producto) {
        productoService.crearProducto(producto);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{codigoProducto}/comentarios/agregar")
    public ResponseEntity<Void> agregarComentario(@PathVariable String codigoProducto,
            @RequestBody Comentario comentario) {
        productoService.agregarComentario(codigoProducto, comentario);
        return ResponseEntity.noContent().build();
    }
    

}
