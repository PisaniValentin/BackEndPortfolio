
package com.miPortfolio.miPortfolio.Repository;

import com.miPortfolio.miPortfolio.Model.Title;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TitleRepository extends JpaRepository<Title,Integer>{
    
}
