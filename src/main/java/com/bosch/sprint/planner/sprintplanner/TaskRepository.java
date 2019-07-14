package com.bosch.sprint.planner.sprintplanner;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bosch.sprint.planner.sprintplanner.model.Tasks;

public interface TaskRepository extends JpaRepository<Tasks, Long>{

}
