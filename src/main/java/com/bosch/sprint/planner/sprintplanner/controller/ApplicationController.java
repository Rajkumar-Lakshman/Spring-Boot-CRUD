package com.bosch.sprint.planner.sprintplanner.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bosch.sprint.planner.sprintplanner.model.Tasks;
import com.bosch.sprint.planner.sprintplanner.service.TaskService;

@Controller
public class ApplicationController {
	
	@Autowired
	private TaskService service;
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
		
		List<Tasks> listTasks = service.listAll();
		model.addAttribute("listTasks", listTasks);
		
		return "index";
	}
	
	@RequestMapping("/new")
	public String showNewTaskForm(Model model) {
		
		Tasks tasks = new Tasks();
		model.addAttribute("tasks", tasks);
		
		return "new_task";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveTask(@ModelAttribute("tasks") Tasks tasks) {
		
		service.save(tasks);
		
		return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
	public  ModelAndView showEditTaskForm(@PathVariable(value="id") Long id) {
		
		ModelAndView mav = new ModelAndView("edit_task");
		Tasks tasks = service.get(id);
		mav.addObject("tasks", tasks);
		
		return mav;
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteTask(@PathVariable(value="id") Long id) {
		
		service.delete(id);
		
		return "redirect:/";
	}
		
}
