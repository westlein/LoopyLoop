import javafx.scene.control.TextField;
import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoopyLoop extends Application {
public enum AccountType { Administrator, Student, Staff, Guest}

public static void main(String[] args) {

launch(args);

}

public void start (Stage primaryStage) {

final int LIMIT = 3;
Alert alert = new Alert(AlertType.INFORMATION);
String correctUsername = "WestBoy";
String correctPW = "WestleinWest!";
AccountType correctAcType = AccountType.Student;
TextField usernameTxt = new TextField();
usernameTxt.setText("Username:");
PasswordField passwordField = new PasswordField();
passwordField.setText("Password:");
ComboBox <AccountType>comboBox = new ComboBox<>();
comboBox.getItems().addAll(AccountType.Administrator,AccountType.Student,AccountType.Staff,AccountType.Guest);
comboBox.setValue(AccountType.Student);
comboBox.setVisible(false);
Button submitButton = new Button("Login");

VBox layout = new VBox();
//layout.setPadding(new Insets(20,20,20,20));
layout.getChildren().addAll(usernameTxt,passwordField, comboBox, submitButton);
Scene scene = new Scene(layout);
primaryStage.setTitle("Authentication");
primaryStage.setScene(scene);
primaryStage.show();

submitButton.setOnAction(e->{ 
int fails = 0;
if(usernameTxt.getText().equals(correctUsername) && passwordField.getText().equals(correctPW) && fails < LIMIT) {
comboBox.setVisible(true);
} else if (fails<= LIMIT){
alert.setContentText("Your credentials are incorrect");
alert.showAndWait();
fails++;
} else if (fails >= LIMIT) {
alert.setContentText("TOO MANY ATTEMPTS. PLEASE CONTACT YOUR ADMINISTRATOR");
alert.showAndWait();
}
});

comboBox.setOnAction(e-> { 
if (comboBox.getValue().equals(correctAcType)) {
alert.setContentText("Hello there, " + correctUsername + "!");
alert.showAndWait();

}else if (!comboBox.getValue().equals(correctAcType)) {
alert.setContentText("Wrong Account Type!!n/Please try again!");
alert.showAndWait();
}

});



}
}