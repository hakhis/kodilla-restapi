package com.crud.tasks.controller;

import com.crud.tasks.domain.TaskDTO;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/task")
public class TaskController {
    @Autowired
    private DbService service;
    @Autowired
    private TaskMapper taskMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getTasks")
    public List<TaskDTO> getTasks(){
        return taskMapper.mapToTaskDTOList(service.getAllTasks());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getTask")
    public TaskDTO getTask(@RequestParam Long taskId){
        return taskMapper.mapToTaskDTO();
//        return new TaskDTO(1L, "test_title", "test_content");
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteTask")
    public void deleteTask(@RequestParam Long taskId) {

    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateTask")
    public TaskDTO updateTask(@RequestBody TaskDTO taskDTO){
        return new TaskDTO(1L, "edited_test_title", "edited_test_content");
    }

    @RequestMapping(method = RequestMethod.POST, value = "createTask")
    public void createTask(@RequestBody TaskDTO taskDTO){

    }
}
