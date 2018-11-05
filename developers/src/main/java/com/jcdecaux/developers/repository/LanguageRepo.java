package com.jcdecaux.developers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jcdecaux.developers.model.Lang;

@Repository
public interface LanguageRepo extends JpaRepository<Lang, Long>{

}
