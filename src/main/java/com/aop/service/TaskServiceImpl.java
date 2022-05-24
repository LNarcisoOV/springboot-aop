package com.aop.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.aop.exception.TaskException;

@Service
public class TaskServiceImpl implements TaskService{
	
	public String getTask() {
		throw new TaskException("An error occurred trying to get task", HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
