package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {
	@FXML TextField txtUserName;
	@FXML TextField txtPassword;
	@FXML Label lblErrorMsg;
	
	@FXML TextField txtUserNamePatient;
	@FXML TextField txtPasswordPatient;
	@FXML Label lblErrorMsgPatient;

	@FXML
    void initialize() {	
	}
	
	public void loginClick(ActionEvent event) throws IOException {
		String userName = txtUserName.getText();
		String password = txtPassword.getText();
		
		if(userName.equalsIgnoreCase("Doctor") && password.equals("123")) {
			InsulinSimulatorController.isAutoMode = false;
			Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
			window.close();
		}
		else {
			lblErrorMsg.setText("Login Failed.");
		}
	}
	
	public void btnCancelClick(ActionEvent event) {
		InsulinSimulatorController.isAutoMode = true;
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.close();
	}
	public void loginClickPatient(ActionEvent event) throws IOException {
		String userName = txtUserNamePatient.getText();
		String password = txtPasswordPatient.getText();
		
		if(userName.equals("Patient") && password.equals("123")) {
			InsulinSimulatorController.isAutoMode = true;
			Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
			window.close();
			
			Parent root = FXMLLoader.load(getClass().getResource("/application/InsulinSimulatorMasterForm.fxml"));
			Scene scene = new Scene(root);	
			Stage rootWindow = new Stage();
			rootWindow.setScene(scene);
			rootWindow.setTitle("Insulin Simulator Pump");
			rootWindow.show();
			
		}
		else {
			lblErrorMsgPatient.setText("Login Failed.");
		}
	}
	
	public void btnCancelClickPatient(ActionEvent event) {
		txtUserNamePatient.setText(null);
		txtPasswordPatient.setText(null);
	}
}
