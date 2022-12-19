package com.many.demo.Services;

import com.many.demo.Modules.Producto;

import java.util.List;

public interface ProductoService {

    public Producto save(Producto producto);

    public Producto findById(long id);

    public List<Producto> findAll();

    public void delete(long id);
}
