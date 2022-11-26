package com.Proxym.EventManagementSys.repository;

import com.Proxym.EventManagementSys.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface commentRepository extends JpaRepository<Comment,Long> {
}
