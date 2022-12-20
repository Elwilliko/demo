package com.many.demo.Controllers;

import com.many.demo.Modules.Categoria;
import com.many.demo.Modules.Producto;
import com.many.demo.Services.CategoriaService;
import com.many.demo.Services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.zip.DataFormatException;

//@CrossOrigin(origins = {"*"})
@CrossOrigin
@RestController
@RequestMapping("/api/productos")
public class ProductoContoller {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/listar")
    public ResponseEntity<List<Producto>> listarProducto(){
        return new ResponseEntity<>(productoService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/categorias")
    public ResponseEntity<List<Categoria>> listarCategorias(){
        return new ResponseEntity<>(categoriaService.finAll(), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto){
        return new ResponseEntity<>(productoService.save(producto), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable Long id, @RequestBody Producto producto){
        Producto productoEcontrado = productoService.findById(id);

        if(productoEcontrado == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        try {

            productoEcontrado.setNombre(producto.getNombre());
            productoEcontrado.setPrecio(producto.getPrecio());
            productoEcontrado.setImagen(producto.getImagen());
            productoEcontrado.setCategoria(producto.getCategoria());

            return new ResponseEntity<>(productoService.save(productoEcontrado), HttpStatus.CREATED);

        }catch (DataAccessException e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> actualizarProducto(@PathVariable Long id){
        productoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    }
