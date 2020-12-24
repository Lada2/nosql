package com.nosql.lada.SQLRepository;


import com.nosql.lada.SQLEntity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BrandRepository  extends JpaRepository<Brand, String> {

    List<Brand> findAllByName(String name);
    Optional<Brand> findFirstByName(String name);
}
