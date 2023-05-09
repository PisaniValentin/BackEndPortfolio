
package com.miPortfolio.miPortfolio.Repository;
import com.miPortfolio.miPortfolio.Model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Integer>{
    
}
