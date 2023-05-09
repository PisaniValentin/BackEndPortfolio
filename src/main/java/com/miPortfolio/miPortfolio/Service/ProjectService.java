package com.miPortfolio.miPortfolio.Service;

import com.miPortfolio.miPortfolio.Model.Project;
import com.miPortfolio.miPortfolio.Repository.ProjectRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService implements IProjectService {

    @Autowired
    public ProjectRepository projectRepo;

    @Override
    public void addProject(Project proj) {
        projectRepo.save(proj);
    }

    @Override
    public void deleteProject(Integer id) {
        projectRepo.deleteById(id);
    }

    @Override
    public Optional<Project> find(Integer id) {
        return projectRepo.findById(id);
    }
    @Override
    public void updateOrder(Integer projectId, Integer id, Integer newProjectOrder){
        Optional<Project> OptionalProject = projectRepo.findById(projectId);
        if(OptionalProject.isPresent()){
            Project project = OptionalProject.get();
            project.setProjectOrder(newProjectOrder);
            projectRepo.save(project);
        }
    }

}
