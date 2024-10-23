package com.team_1.toDo_Application.service;

import com.team_1.toDo_Application.entity.Project;
import com.team_1.toDo_Application.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    // Get all projects
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    // Get a project by ID
    public Project getProjectById(Long id) {
        return projectRepository.findById(id).orElse(null);
    }

    // Create a new project
    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    // Update a project by ID
    public Project updateProject(Long id, Project projectDetails) {
        return projectRepository.findById(id)
                .map(project -> {
                    project.setTitle(projectDetails.getTitle());
                    project.setDescription(projectDetails.getDescription());
                    return projectRepository.save(project);
                })
                .orElse(null);
    }

    // Delete a project by ID
    public boolean deleteProject(Long id) {
        if (projectRepository.existsById(id)) {
            projectRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
