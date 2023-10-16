package ch.zli.m223.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.zli.m223.model.impl.RoleImpl;

public interface BookingRepository extends JpaRepository<RoleImpl, Long>{
    
}
