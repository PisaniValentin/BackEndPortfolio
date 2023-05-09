
package com.miPortfolio.miPortfolio.Service;

import com.miPortfolio.miPortfolio.Model.Education;
import com.miPortfolio.miPortfolio.Repository.EducationRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducationService implements IEducationService {

   @Autowired
    public EducationRepository educationRepo;

    @Override
    public void addEducation(Education education) {
        educationRepo.save(education);
    }

    @Override
    public void deleteEducation(Integer id) {
        educationRepo.deleteById(id);
    }

    @Override
    public Optional<Education> find(Integer id) {
        return educationRepo.findById(id);
    }
    @Override
    public void updateOrder(Integer educationId, Integer id, Integer newEducationOrder){
        Optional<Education> OptionalEducation = educationRepo.findById(educationId);
        if(OptionalEducation.isPresent()){
            Education education = OptionalEducation.get();
            education.setEducationOrder(newEducationOrder);
            educationRepo.save(education);
        }
    }
}
