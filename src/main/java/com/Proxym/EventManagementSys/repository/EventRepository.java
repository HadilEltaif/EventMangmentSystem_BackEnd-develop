package com.Proxym.EventManagementSys.repository;

import com.Proxym.EventManagementSys.model.Event;
import com.Proxym.EventManagementSys.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface EventRepository extends JpaRepository<Event,Long> {
    //Optional<Event> findByKeyword(String keyword);



}
