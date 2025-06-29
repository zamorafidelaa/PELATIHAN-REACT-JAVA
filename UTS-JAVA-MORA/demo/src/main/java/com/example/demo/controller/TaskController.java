package com.example.demo.controller;

import com.example.demo.model.Task;
import com.example.demo.model.Project;
import com.example.demo.repository.TaskRepository;
import com.example.demo.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @GetMapping("/all")
    public Map<String, Object> getAll() {
        Map<String, Object> response = new LinkedHashMap<>();
        List<Task> tasks = taskRepository.findAll();
        response.put("message", "Berhasil mengambil semua data task");
        response.put("data", tasks);
        return response;
    }

    @GetMapping("/by-id/{id}")
    public Map<String, Object> getById(@PathVariable Long id) {
        Map<String, Object> response = new LinkedHashMap<>();
        Task task = taskRepository.findById(id).orElse(null);
        if (task == null) {
            response.put("message", "Task dengan ID " + id + " tidak ditemukan");
            response.put("data", null);
        } else {
            response.put("message", "Berhasil mengambil task dengan ID " + id);
            response.put("data", task);
        }
        return response;
    }

    @PostMapping("/create")
    public Map<String, Object> create(@RequestBody Task task) {
        Map<String, Object> response = new LinkedHashMap<>();
        Project project = projectRepository.findById(task.getProject().getId()).orElse(null);
        if (project == null) {
            response.put("message", "Project dengan ID " + task.getProject().getId() + " tidak ditemukan");
            response.put("data", null);
            return response;
        }
        task.setProject(project);
        Task saved = taskRepository.save(task);
        response.put("message", "Task berhasil ditambahkan");
        response.put("data", saved);
        return response;
    }

    @PutMapping("/update/{id}")
    public Map<String, Object> update(@PathVariable Long id, @RequestBody Task task) {
        Map<String, Object> response = new LinkedHashMap<>();
        Project project = projectRepository.findById(task.getProject().getId()).orElse(null);
        if (project == null) {
            response.put("message", "Project dengan ID " + task.getProject().getId() + " tidak ditemukan");
            response.put("data", null);
            return response;
        }
        task.setId(id);
        task.setProject(project);
        Task saved = taskRepository.save(task);
        response.put("message", "Task dengan ID " + id + " berhasil diperbarui");
        response.put("data", saved);
        return response;
    }

    @DeleteMapping("/delete/{id}")
    public Map<String, Object> delete(@PathVariable Long id) {
        Map<String, Object> response = new LinkedHashMap<>();
        taskRepository.deleteById(id);
        response.put("message", "Task dengan ID " + id + " berhasil dihapus");
        return response;
    }

    @GetMapping("/search")
    public Map<String, Object> searchAndSort(
            @RequestParam(required = false) String status,
            @RequestParam(required = false) Long projectId,
            @RequestParam(required = false, defaultValue = "asc") String sort) {

        Map<String, Object> response = new LinkedHashMap<>();
        List<Task> tasks = taskRepository.findAll();

        if (status != null) {
            tasks = tasks.stream()
                    .filter(t -> t.getStatus() != null && t.getStatus().equalsIgnoreCase(status))
                    .collect(Collectors.toList());
        }

        if (projectId != null) {
            tasks = tasks.stream()
                    .filter(t -> t.getProject() != null && t.getProject().getId().equals(projectId))
                    .collect(Collectors.toList());
        }

        if (sort.equalsIgnoreCase("asc")) {
            tasks.sort((a, b) -> a.getName().compareToIgnoreCase(b.getName()));
            response.put("message", "Hasil pencarian task diurutkan ascending");
        } else if (sort.equalsIgnoreCase("desc")) {
            tasks.sort((a, b) -> b.getName().compareToIgnoreCase(a.getName()));
            response.put("message", "Hasil pencarian task diurutkan descending");
        } else {
            response.put("message", "Parameter sort tidak valid (gunakan 'asc' atau 'desc')");
            response.put("data", null);
            return response;
        }

        response.put("data", tasks);
        return response;
    }
}
