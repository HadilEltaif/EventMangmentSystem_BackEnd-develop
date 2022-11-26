package com.Proxym.EventManagementSys.repository;

import com.Proxym.EventManagementSys.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface categoryRepository extends JpaRepository<Category,Long> {

}
