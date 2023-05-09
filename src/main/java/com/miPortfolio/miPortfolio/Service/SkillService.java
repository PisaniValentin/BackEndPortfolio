package com.miPortfolio.miPortfolio.Service;

import com.miPortfolio.miPortfolio.Model.Skill;
import com.miPortfolio.miPortfolio.Repository.SkillRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillService implements ISkillService {

    @Autowired
    public SkillRepository skillRepo;

    @Override
    public void addSkill(Skill skill) {
        skillRepo.save(skill);
    }

    @Override
    public void deleteSkill(Integer id) {
        skillRepo.deleteById(id);
    }

    @Override
    public Optional<Skill> find(Integer id) {
       return skillRepo.findById(id);
    }

}
