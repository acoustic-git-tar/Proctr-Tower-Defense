package com.closednotes.proctr;

import com.closednotes.proctr.objects.Player;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class TDController {
    @FXML
    private Label errorText;
    protected static boolean windowOpened = false;
    protected static Player player;
    @FXML
    protected void onShopButtonClick() throws IOException {
        player = new Player("Joe", Difficulty.CLOSED_NOTES);
        if (!windowOpened) {
            windowOpened = true;
            errorText.setText("");
            FXMLLoader loader = new FXMLLoader(TDApplication.class.getResource("shop-view.fxml"));
            Scene shopScene = new Scene(loader.load(), 320, 240);
            Stage shopStage = new Stage();
            shopStage.setTitle("Shop");
            shopStage.setScene(shopScene);
            shopStage.show();
            shopStage.setOnCloseRequest(windowEvent -> windowOpened = false);
        } else {
            errorText.setTextFill(Color.RED);
            errorText.setText("Shop already opened!");
        }
    }

    @FXML
    protected void onExitButtonClick() {
        Platform.exit();
    }
}