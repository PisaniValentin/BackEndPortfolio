package com.miPortfolio.miPortfolio.Service;

import com.miPortfolio.miPortfolio.Model.Education;
import java.util.Optional;

public interface IEducationService {

    public void addEducation(Education education);

    public void deleteEducation(Integer id);

    public Optional<Education> find(Integer id);

    public void updateOrder(Integer educationId, Integer id, Integer newEducationOrder);
}
