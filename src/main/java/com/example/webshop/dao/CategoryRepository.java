package com.example.webshop.dao;

import com.example.webshop.models.Category;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

//maps the category class to the database using the Long type as default of ID's
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}

