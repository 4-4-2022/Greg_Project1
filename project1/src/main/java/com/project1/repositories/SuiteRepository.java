package com.project1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project1.entities.DisplaySuite;

@Repository
public interface SuiteRepository extends JpaRepository<DisplaySuite, Long> {

}
