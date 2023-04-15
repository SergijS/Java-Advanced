package com.example.ProjectShop.repository;

import com.example.ProjectShop.entity.Shops;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface ShopRepository extends CrudRepository<Shops, Long> {

}
