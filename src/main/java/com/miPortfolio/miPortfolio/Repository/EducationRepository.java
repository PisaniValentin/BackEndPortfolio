
package com.miPortfolio.miPortfolio.Repository;

import com.miPortfolio.miPortfolio.Model.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationRepository extends JpaRepository<Education,Integer> {
    
}
