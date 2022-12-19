package com.many.demo.Dao;

import com.many.demo.Modules.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoDao extends JpaRepository<Producto, Long> {

}
