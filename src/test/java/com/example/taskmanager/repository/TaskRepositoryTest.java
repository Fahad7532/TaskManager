package com.example.taskmanager.repository;

import com.example.taskmanager.model.Task;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class TaskRepositoryTest {

    @Autowired
    private TaskRepository taskRepository;

    @Test
    void testSaveAndFindTask() {
        Task task = new Task();
        task.setTitle("Test Task");
        task.setDescription("This is a test task.");
        task.setCompleted(false);

        Task savedTask = taskRepository.save(task);
        assertNotNull(savedTask.getId());

        List<Task> tasks = taskRepository.findAll();
        assertEquals(1, tasks.size());
        assertEquals("Test Task", tasks.get(0).getTitle());
    }

    @Test
    void testDeleteTask() {
        Task task = new Task();
        task.setTitle("Task to Delete");
        task.setDescription("Task will be deleted.");
        task.setCompleted(false);

        Task savedTask = taskRepository.save(task);
        taskRepository.deleteById(savedTask.getId());

        List<Task> tasks = taskRepository.findAll();
        assertTrue(tasks.isEmpty());
    }
}
