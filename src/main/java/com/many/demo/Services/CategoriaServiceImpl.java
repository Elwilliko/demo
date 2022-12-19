package com.many.demo.Services;

import com.many.demo.Dao.CategoriaDao;
import com.many.demo.Modules.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService{

    @Autowired
    private CategoriaDao categoriaDao;

    @Override
    public List<Categoria> finAll() {
        return categoriaDao.findAll();
    }
}
