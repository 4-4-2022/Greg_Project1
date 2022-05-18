package com.provider.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.provider.entities.DisplayWeek;

@Repository
public interface WeekRepository extends JpaRepository<DisplayWeek, Long> {

}
