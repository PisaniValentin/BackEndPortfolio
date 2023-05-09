
package com.miPortfolio.miPortfolio.Service;

import com.miPortfolio.miPortfolio.Model.Project;
import com.miPortfolio.miPortfolio.Model.Title;
import com.miPortfolio.miPortfolio.Repository.TitleRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TitleService implements ITitleService {

 @Autowired
    public TitleRepository titleRepo;

    @Override
    public void addTitle(Title title) {
        titleRepo.save(title);
    }

    @Override
    public void deleteTitle(Integer id) {
        titleRepo.deleteById(id);
    }

    @Override
    public Optional<Title> find(Integer id) {
        return titleRepo.findById(id);
    }
    
     @Override
    public void updateOrder(Integer titleId, Integer id, Integer newTitleOrder){
        Optional<Title> OptionalTitle = titleRepo.findById(titleId);
        if(OptionalTitle.isPresent()){
            Title title = OptionalTitle.get();
            title.setTitleOrder(newTitleOrder);
            titleRepo.save(title);
        }
    }
}
