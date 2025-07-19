package com.kasa.task_manager.repositories;

import com.kasa.task_manager.model.entity.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TaskRepository extends MongoRepository<Task, String> {
}
