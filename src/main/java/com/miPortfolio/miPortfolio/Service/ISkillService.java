package com.miPortfolio.miPortfolio.Service;

import com.miPortfolio.miPortfolio.Model.Skill;
import java.util.Optional;

public interface ISkillService {

    public void addSkill(Skill skill);

    public void deleteSkill(Integer id);

    public Optional<Skill> find(Integer id);
}
