package com.kasa.task_manager.service.impl;

import com.kasa.task_manager.model.entity.Task;
import com.kasa.task_manager.repositories.TaskRepository;
import com.kasa.task_manager.service.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository repository;

    @Override
    public Task saveTask(Task task) {
        log.info("Saving task: {}", task);
        return repository.save(task);
    }

    @Override
    public void deleteAllTasks() {
        log.info("Deleting all tasks");
        repository.deleteAll();
    }
}
