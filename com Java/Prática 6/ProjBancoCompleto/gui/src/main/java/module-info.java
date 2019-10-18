module gui {
    requires javafx.controls;
    requires javafx.fxml;

    opens br.com.guilherme.gui to javafx.fxml;
    exports br.com.guilherme.gui;
}