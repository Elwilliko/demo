package com.many.demo.Services;

import com.many.demo.Dao.ProductoDao;
import com.many.demo.Modules.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService{

    @Autowired
    private ProductoDao productoDao;

    @Override
    public Producto save(Producto producto) {
        return productoDao.save(producto);
    }

    @Override
    public Producto findById(long id) {
        return productoDao.findById(id).orElse(null);
    }

    @Override
    public List<Producto> findAll() {
        return productoDao.findAll();
    }

    @Override
    public void delete(long id) {
        productoDao.deleteById(id);

    }
}
