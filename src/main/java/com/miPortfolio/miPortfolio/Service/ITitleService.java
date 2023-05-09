package com.miPortfolio.miPortfolio.Service;

import com.miPortfolio.miPortfolio.Model.Title;
import java.util.Optional;

public interface ITitleService {

    public void addTitle(Title title);

    public void deleteTitle(Integer id);

    public Optional<Title> find(Integer id);

    public void updateOrder(Integer titletId, Integer id, Integer newTitleOrder);
}
