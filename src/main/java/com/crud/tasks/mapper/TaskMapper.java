package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TaskMapper {
    public Task mapToTask(final TaskDTO taskDTO){
        return new Task(
                taskDTO.getId(),
                taskDTO.getTitle(),
                taskDTO.getContent());
    }

    public TaskDTO mapToTaskDTO(final Task task){
        return new TaskDTO(
                task.getId(),
                task.getTitle(),
                task.getContent());
    }

    public List<TaskDTO> mapToTaskDTOList(final List<Task> taskList){
        return taskList.stream()
                .map(t -> new TaskDTO(t.getId(), t.getTitle(), t.getContent()))
                .collect(Collectors.toList());
    }
}
