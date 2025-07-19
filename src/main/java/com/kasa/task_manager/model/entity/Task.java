package com.kasa.task_manager.model.entity;

import com.kasa.task_manager.model.enums.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "tasks")
public class Task {
    String id;
    String userId;
    String title;
    String description;
    LocalDate dueDate;
    TaskStatus taskStatus;
}
