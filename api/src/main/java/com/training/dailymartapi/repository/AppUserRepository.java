package com.training.dailymartapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.dailymartapi.model.AppUser;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

}
