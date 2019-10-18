package br.com.guilherme.gui;

import javafx.fxml.FXML;

import java.io.IOException;

public class SecondaryController {

    @FXML
    private void switchToPrimary() throws IOException {
        GUIMain.setRoot("primary");
    }
}
