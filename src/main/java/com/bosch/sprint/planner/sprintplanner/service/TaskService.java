package com.bosch.sprint.planner.sprintplanner.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bosch.sprint.planner.sprintplanner.TaskRepository;
import com.bosch.sprint.planner.sprintplanner.model.Tasks;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepository taskRepo;
	
	public List<Tasks> listAll(){
		
		return taskRepo.findAll();
	}
	
	public void save(Tasks tasks) {
		
		taskRepo.save(tasks);
	}

	public Tasks get(Long id) {
		
		return taskRepo.findOne(id);
	}
	
	public void delete(Long id) {
		
		taskRepo.delete(id);
	}
}
