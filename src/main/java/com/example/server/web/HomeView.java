package com.example.server.web;

import com.example.server.UserNation;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import java.util.List;

@Route
@RouteAlias(value = "/")
public class HomeView extends VerticalLayout {

  public HomeView (RestService restService) {
    welcome();
    leaderboard(restService);
  }

  private void welcome() {
    H1 title = new H1("Welcome to the website");
    add(title);
  }

  private void leaderboard(RestService restService) {
    Grid<UserNation> grid = new Grid<>(UserNation.class, false);

    List<UserNation> userInfos = restService.getAllInfos().stream().toList();

    grid.addColumn(UserNation::getName).setHeader("Username").setSortable(true);
    grid.addColumn(UserNation::getHighestAmountEnergy).setHeader("Energy").setSortable(true);
    grid.addColumn(UserNation::getHighestAmountMineral).setHeader("Minerals").setSortable(true);
    grid.addColumn(UserNation::getHighestAmountAlloy).setHeader("Alloy").setSortable(true);
    grid.addColumn(UserNation::getHighestAmountFood).setHeader("Food").setSortable(true);
    grid.addColumn(UserNation::getHighestAmountYaoi).setHeader("Yaoi").setSortable(true);


    grid.setItems(userInfos);
    grid.addThemeVariants(GridVariant.LUMO_COLUMN_BORDERS);
    add(grid);
  }

}
