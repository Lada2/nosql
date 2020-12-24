package com.nosql.lada.SQLRepository;


import com.nosql.lada.SQLEntity.Form;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FormRepository extends JpaRepository<Form, String> {

    List<Form> findAllByName(String name);
    Optional<Form> findFirstByName(String name);
}
