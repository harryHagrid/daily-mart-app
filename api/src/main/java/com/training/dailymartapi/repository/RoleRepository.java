package com.training.dailymartapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.dailymartapi.model.AppRole;

@Repository
public interface RoleRepository extends JpaRepository<AppRole, Long>{

}
