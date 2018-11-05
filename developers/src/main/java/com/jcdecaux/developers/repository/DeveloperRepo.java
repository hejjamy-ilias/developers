package com.jcdecaux.developers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jcdecaux.developers.model.Developer;

@Repository
public interface DeveloperRepo extends JpaRepository<Developer, Long>{

}
