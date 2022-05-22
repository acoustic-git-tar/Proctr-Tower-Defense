package com.closednotes.proctr;

import com.closednotes.proctr.objects.tower.Tower;
import com.closednotes.proctr.objects.tower.TowerFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ShopController {
    private Tower tower;
    @FXML
    private Text description;

    @FXML
    protected void onExitShopClick(ActionEvent event) {
        TDController.windowOpened = false;

        ((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
    }
    public void selectTower(ActionEvent event) {
        String towerObject = event.getSource().toString().substring(10, 12);
        tower = TowerFactory.createTower(towerObject);
        description.setText(tower.getDescription());
        description.getText();
    }

    @FXML private Label buyError;
    @FXML
    public void onBuyTowerClick(ActionEvent event) {
        try {
            Tower towerBuy = TDApplication.getPlayer().purchaseTower(tower);
            GameController.setTemp(towerBuy);
            ((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
        } catch (IllegalArgumentException e) {
            buyError.setText(e.getMessage());
        } catch (Exception e) {
            buyError.setText("Select a tower first!");
        }
    }
}
