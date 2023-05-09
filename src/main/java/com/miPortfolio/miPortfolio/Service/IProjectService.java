package com.miPortfolio.miPortfolio.Service;

import com.miPortfolio.miPortfolio.Model.Project;
import java.util.Optional;


public interface IProjectService {
    public void addProject(Project proj);
    public void deleteProject(Integer id);
    public Optional<Project> find(Integer id);
    public void updateOrder(Integer projectId, Integer id, Integer newProjectOrder);
}
