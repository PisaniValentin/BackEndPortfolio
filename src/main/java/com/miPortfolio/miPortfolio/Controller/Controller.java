package com.miPortfolio.miPortfolio.Controller;

import com.miPortfolio.miPortfolio.Model.Education;
import com.miPortfolio.miPortfolio.Model.Persona;
import com.miPortfolio.miPortfolio.Model.Project;
import com.miPortfolio.miPortfolio.Model.Skill;
import com.miPortfolio.miPortfolio.Model.Title;
import com.miPortfolio.miPortfolio.Repository.PersonaRepository;
import com.miPortfolio.miPortfolio.Service.IEducationService;
import com.miPortfolio.miPortfolio.Service.IPersonaService;
import com.miPortfolio.miPortfolio.Service.IProjectService;
import com.miPortfolio.miPortfolio.Service.ISkillService;
import com.miPortfolio.miPortfolio.Service.ITitleService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private IPersonaService personService;
    @Autowired
    private IProjectService projectService;
    @Autowired
    private ITitleService titleService;
    @Autowired
    private IEducationService educationService;
    @Autowired
    private ISkillService skillService;

    @GetMapping("/api/user/{id}")
    @ResponseBody
    public Persona user(@PathVariable Integer id) {
        return (personService.find(id));
    }

    /*
    @GetMapping("/api/user/username")
    @ResponseBody
    public Persona user(){
        return personService.find(@RequestBody Persona user.id);
    }
     */
    @PostMapping("/api/user/login")
    @ResponseBody
    public Persona login(@RequestBody Persona user) {
        return personService.login(user);
    }

    @PostMapping("/api/{id}/add")
    public void addUser(@RequestBody Persona user) {
        personService.addUser(user);
    }

    @PostMapping("/api/{id}/add/project")
    public void addProyect(@RequestBody Project project, @PathVariable Integer id) {
        Persona persona = personService.find(id);
        project.setPersona(persona);
        project.setProjectOrder(persona.getProjectQuantity() + 1);
        Integer numero = persona.getProjectQuantity() + 1;
        persona.setProjectQuantity(numero);
        projectService.addProject(project);
        persona.getProjects().add(project);
    }

    @PostMapping("/api/{id}/add/title")
    public void addTitle(@RequestBody Title title, @PathVariable Integer id) {
        Persona persona = personService.find(id);
        title.setPersona(persona);
        title.setTitleOrder(persona.getTitleQuantity() + 1);
        Integer numero = persona.getTitleQuantity() + 1;
        persona.setTitleQuantity(numero);
        titleService.addTitle(title);
        persona.getTitles().add(title);
    }

    @PostMapping("/api/{id}/add/education")
    public void addEducation(@RequestBody Education education, @PathVariable Integer id) {
        Persona persona = personService.find(id);
        education.setPersona(persona);
        education.setEducationOrder(persona.getEducationQuantity() + 1);
        Integer numero = persona.getEducationQuantity() + 1;
        persona.setEducationQuantity(numero);
        educationService.addEducation(education);
        persona.getEducation().add(education);
    }

    @PostMapping("/api/{id}/updateProject/{projectID}/{newOrder}")
    public void updateProject(@PathVariable Integer projectID, @PathVariable Integer id, @PathVariable Integer newOrder) {
        Optional<Project> OptionalProject = projectService.find(projectID);
        Persona persona = personService.find(id);
        if (OptionalProject.isPresent()) {
            Project project = OptionalProject.get();
            project.setPersona(persona);
            projectService.updateOrder(projectID, id, newOrder);
        }
    }

    @PostMapping("/api/{id}/updateTitle/{titleID}/{newOrder}")
    public void updateTitle(@PathVariable Integer titleID, @PathVariable Integer id, @PathVariable Integer newOrder) {
        Optional<Title> OptionalTitle = titleService.find(titleID);
        Persona persona = personService.find(id);
        if (OptionalTitle.isPresent()) {
            Title project = OptionalTitle.get();
            project.setPersona(persona);
            titleService.updateOrder(titleID, id, newOrder);
        }
    }

    @PostMapping("/api/{id}/updateEducation/{educationID}/{newOrder}")
    public void updateEducation(@PathVariable Integer educationID, @PathVariable Integer id, @PathVariable Integer newOrder) {
        Optional<Education> OptionalEducation = educationService.find(educationID);
        Persona persona = personService.find(id);
        if (OptionalEducation.isPresent()) {
            Education education = OptionalEducation.get();
            education.setPersona(persona);
            educationService.updateOrder(educationID, id, newOrder);
        }
    }

    @PostMapping("/api/{id}/deleteEducation/{educationID}")
    public void deleteEducation(@PathVariable Integer educationID, @PathVariable Integer id) {
        Persona persona = personService.find(id);
        Optional<Education> OptionalEducation = educationService.find(educationID);
        if (OptionalEducation.isPresent()) {
            Education education = OptionalEducation.get();
            educationService.deleteEducation(educationID);
            Integer numero = persona.getEducationQuantity() - 1;
            persona.setEducationQuantity(numero);
            persona.getEducation().remove(education);
            personService.addUser(persona);
        }
    }

    @PostMapping("/api/{id}/deleteProject/{projectID}")
    public void deleteProject(@PathVariable Integer projectID, @PathVariable Integer id) {
        Persona persona = personService.find(id);
        Optional<Project> OptionalProject = projectService.find(projectID);
        if (OptionalProject.isPresent()) {
            Project project = OptionalProject.get();
            projectService.deleteProject(projectID);
            Integer numero = persona.getProjectQuantity() - 1;
            persona.setProjectQuantity(numero);
            persona.getProjects().remove(project);
            personService.addUser(persona);
        }
    }

    @PostMapping("/api/{id}/editEducation/{educationID}")
    public void editEducation(@PathVariable Integer id, @PathVariable Integer educationID, @RequestBody Education newEducation) {
        Persona persona = personService.find(id);
        Optional<Education> OptionalEducation = educationService.find(educationID);
        if (OptionalEducation.isPresent()) {
            Education education = OptionalEducation.get();
            education.setInstitute(newEducation.getInstitute());
            education.setName(newEducation.getName());
            education.setFinishedIn(newEducation.getFinishedIn());
            education.setStartedIn(newEducation.getStartedIn());
            educationService.addEducation(education);
        }
    }

    @PostMapping("/api/{id}/editProject/{projectID}")
    public void editProject(@PathVariable Integer id, @PathVariable Integer projectID, @RequestBody Project newProject) {
        Optional<Project> OptionalProject = projectService.find(projectID);
        if (OptionalProject.isPresent()) {
            Project project = OptionalProject.get();
            project.setUrl(newProject.getUrl());
            project.setName(newProject.getName());
            project.setDescription(newProject.getDescription());
            projectService.addProject(project);
        }
    }

    @PostMapping("/api/{id}/editPersonTitle/{titleID}")
    public void editTitle(@PathVariable Integer titleID, @PathVariable Integer id, @RequestBody Title newTitle) {
        Optional<Title> OptionalTitle = titleService.find(titleID);
        if (OptionalTitle.isPresent()) {
            Title title = OptionalTitle.get();
            title.setTitleName(newTitle.getTitleName());
            titleService.addTitle(title);
        }
    }

    @PostMapping("/api/{id}/deletePersonTitle/{titleID}")
    public void deleteTitle(@PathVariable Integer titleID, @PathVariable Integer id) {
        Persona persona = personService.find(id);
        Optional<Title> OptionalTitle = titleService.find(titleID);
        if (OptionalTitle.isPresent()) {
            Title title = OptionalTitle.get();
            titleService.deleteTitle(titleID);
            Integer numero = persona.getTitleQuantity() - 1;
            persona.setTitleQuantity(numero);
            persona.getTitles().remove(title);
            personService.addUser(persona);
        }
    }
    
    @PostMapping("/api/{id}/saveExperience")
    public void saveExperience(@RequestBody String newExp, @PathVariable Integer id){
         Persona persona = personService.find(id);
         persona.setExperience(newExp);
         personService.addUser(persona);
    }
    
    @PostMapping("/api/{id}/saveSkill")
    public void createSkill(@RequestBody Skill skill, @PathVariable Integer id){
        Persona persona = personService.find(id);
        persona.getSkills().add(skill);
        skill.setPersona(persona);
        skillService.addSkill(skill);
    }
    @PostMapping("/api/{id}/deleteSkill/{skillID}")
    public void deleteSkill(@PathVariable Integer skillID, @PathVariable Integer id){
        Persona persona = personService.find(id);
         Optional<Skill> OptionalSkill = skillService.find(skillID);
        if (OptionalSkill.isPresent()) {
            Skill skill = OptionalSkill.get();
            persona.getSkills().remove(skill);
            skillService.deleteSkill(skillID);
        }
    }
    
    @PostMapping("/api/{id}/editSkill/{skillID}")
    public void editSkill(@RequestBody Skill updatedSkill,@PathVariable Integer skillID){
        Optional<Skill> OptionalSkill = skillService.find(skillID);
        if (OptionalSkill.isPresent()) {
            Skill skill = OptionalSkill.get();
            skill.setName(updatedSkill.getName());
            skill.setPercentage(updatedSkill.getPercentage());
            skill.setColor(updatedSkill.getColor());
            skillService.addSkill(skill);
        }
    }

}
