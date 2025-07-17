package com.kasa.task_manager.service;

import com.kasa.task_manager.entity.Task;

public interface TaskService {
    Task saveTask(Task task);
    void deleteAllTasks();
}
