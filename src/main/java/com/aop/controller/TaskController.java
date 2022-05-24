package com.aop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aop.exception.TaskException;
import com.aop.service.TaskService;

@RestController
@RequestMapping("/task")
public class TaskController {

	@Autowired
	private TaskService taskService;

	@GetMapping
	public ResponseEntity<String> get() {
		try {
			String task = taskService.getTask();
			return new ResponseEntity<String>(task, HttpStatus.OK);
		} catch (TaskException taskException) {
			return new ResponseEntity<String>(taskException.getMessage(), taskException.getHttpStatus());
		}

	}

}
