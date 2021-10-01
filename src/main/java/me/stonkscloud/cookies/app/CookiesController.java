package me.stonkscloud.cookies.app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CookiesController {

    @FXML
    private Label display;
    private int cookies = 0;

    @FXML
    public void actionEvent(ActionEvent actionEvent) {
        if (actionEvent.getSource() instanceof Button button) {
            this.setCookies(this.getCookies() + 1);
            if (display != null) display.setText(String.valueOf(this.getCookies()));
            button.setScaleX(0.8);
            button.setScaleY(0.8);
            button.setScaleZ(0.8);
            Executors.newSingleThreadScheduledExecutor().schedule(() -> {
                button.setScaleX(1.0);
                button.setScaleY(1.0);
                button.setScaleZ(1.0);
            }, 15, TimeUnit.MILLISECONDS);
        }
    }

    public void setCookies(int cookies) {
        this.cookies = cookies;
    }

    public int getCookies() {
        return cookies;
    }

}
