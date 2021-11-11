package com.carrental.carrental.repository;

import com.carrental.carrental.models.Mechanic;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MechanicRepository extends JpaRepository<Mechanic, Long> {
    List<Mechanic> getAllByOnRepair(Boolean onRepair, Sort sort);
}
