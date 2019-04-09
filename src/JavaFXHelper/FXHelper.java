package JavaFXHelper;

import controller.AlertController;
import controller.ConfirmationController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;


import java.io.IOException;

public class FXHelper {
    public static void sceneChanger(Object obj, Node node, String fxml) throws IOException {
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(obj.getClass().getResource(fxml));
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    public static void sceneChanger(Object obj, Node node, String fxml, String tittle) throws IOException{
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setTitle(tittle);
        Parent root = FXMLLoader.load(obj.getClass().getResource(fxml));
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    public static void setStageTittle(Node node, String tittle){
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setTitle(tittle);
    }

    public static void alertPopup(Object obj, String tittle, String message) throws IOException{
        Stage stage = new Stage();

        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle(tittle); FXMLLoader loader = new FXMLLoader(); loader.setLocation(obj.getClass().getResource("/view/Alert.fxml"));

        //FXMLLoader loader = new FXMLLoader(obj.getClass().getResource("/view/Alert.fxml"));
        Parent root = loader.load();

        AlertController controller = loader.getController();
        controller.setMessage(message);

        Scene scene = new Scene(root);


        stage.setScene(scene);
        stage.showAndWait();
    }

    public static boolean confirmationDialog(String tittle, String message) throws IOException{
        return new Confirmation(tittle, message).display();
    }

    public static boolean closeProgram(Object obj, Stage window) throws IOException{

        if(confirmationDialog("Close?", "Are you sure you want to exit?")){
            System.out.print("PROGRAM CLOSED\n");
            alertPopup(obj, "Close", "Application will now close");
            window.close();
            return true;
        }

        return false;
    }

    private static class Confirmation{

        private String tittle;
        private String message;
        private boolean answer;


        private Confirmation(String tittle, String message) {
            this.tittle = tittle;
            this.message = message;
        }

        private boolean display() throws IOException{
            Stage stage = new Stage();

            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle(tittle);

            stage.setOnCloseRequest(e -> {
                answer = false;
            });

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Confirmation.fxml"));
            Parent root = loader.load();
            ConfirmationController controller = loader.getController();
            controller.setMessage(message);

            Scene scene = new Scene(root);


            stage.setScene(scene);
            stage.showAndWait();

            answer = controller.getAnswer();

            return answer;
        }
    }
}
