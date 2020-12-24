package com.nosql.lada.SQLRepository;

import com.nosql.lada.SQLEntity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, String> {

    List<Company> findAllByCompanyName(String name);
    Optional<Company> findFirstByCompanyName(String name);
}
