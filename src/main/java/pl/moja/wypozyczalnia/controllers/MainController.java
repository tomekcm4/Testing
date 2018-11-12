package pl.moja.wypozyczalnia.controllers;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import pl.moja.wypozyczalnia.utils.DialogsUtils;
import pl.moja.wypozyczalnia.utils.FxmlUtils;

import java.util.Locale;
import java.util.Optional;

public class MainController {

	@FXML
	private BorderPane borderPane;

	@FXML
	private TopMenuButtonsController topMenuButtonsController;
	
	
	

	@FXML
	private void initialize() {
		topMenuButtonsController.setMainController(this);
	}

	public void setCenter(String fxmlPath) {
		borderPane.setCenter(FxmlUtils.fxmlLoader(fxmlPath));
	}

	public void closeApplication() {
		Optional<ButtonType> result = DialogsUtils.confirmationDialog();
		if (result.get() == ButtonType.OK) {
			Platform.exit();
			System.exit(0);
		}
	}

	public MainController() {

	}

	public void setPl(ActionEvent actionEvent) {

		Locale.setDefault(new Locale("pl"));
		Stage stage = (Stage) borderPane.getScene().getWindow();

	}

	public void setEn(ActionEvent actionEvent) {

		Locale.setDefault(new Locale("en"));
		Stage stage = (Stage) borderPane.getScene().getWindow();

		
	}

	public void setAlwaysOnTop(ActionEvent actionEvent) {
		Stage stage = (Stage) borderPane.getScene().getWindow();
		boolean value = ((CheckMenuItem) actionEvent.getSource()).selectedProperty().get();
		stage.setAlwaysOnTop(value);
	}

	public void about() {
		DialogsUtils.dialogAboutApplication();
	}
}
