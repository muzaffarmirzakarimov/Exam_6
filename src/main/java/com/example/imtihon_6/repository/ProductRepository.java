package com.example.imtihon_6.repository;

import com.example.imtihon_6.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer>{

    boolean existsByName(String name);
}
