package helloworld;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class chessFX extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        Button[] btnArr=new Button[5];
        btn.setText("Say 'Hello World'");
        for(int x=0;x<5;x++){
         btnArr[x].setText("Button "+x);
         HBox hbBtn = new HBox(10);
         grid.add(btnArr[x], 1, 4);
        }
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });

        StackPane root = new StackPane();
        root.getChildren().add(btn);

 Scene scene = new Scene(root, 500, 400);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
 public static void main(String[] args) {
        launch(args);
    }
}
