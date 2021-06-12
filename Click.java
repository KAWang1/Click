import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.event.*;
import javafx.scene.shape.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.*;
import java.util.Scanner;
import javafx.scene.*;
import javafx.scene.input.MouseEvent;
import java.util.Random;
import javafx.scene.text.Text;
import java.util.Timer;
import java.util.TimerTask;

public class Click extends Application
{
    private Group groupBase;
    private Button Reset, Easy, Medium, Hard, Random;
    private double X, Y, Z;
    private int Click = 0;
    private Scene game;
    Text ClickL;
    Circle ball;
    
    public void start(Stage primaryStage)
    {  
      ClickL = new Text("   Click: " + String.valueOf(Click) + "     ");
      Reset = new Button("Reset"); Reset.setOnAction(this::ResetPress);
      Easy = new Button("Easy"); Easy.setOnAction(this::EasyPress);
      Medium = new Button("Medium"); Medium.setOnAction(this::MediumPress);
      Hard = new Button("Hard"); Hard.setOnAction(this::HardPress);
      Random = new Button("Random"); Random.setOnAction(this::RandomPress);
      Random rand = new Random();
      X = rand.nextInt((750-100)+1)+100;
      Y = rand.nextInt((450-100)+1)+100;
  //    Z = rand.nextInt((15-3)+1)+3;
      
      ball = new Circle(X, Y, 10);
      ball.setFill(Color.GOLD);
      //E-15 M-10 H-3
      
      ball.setOnMouseClicked(new EventHandler<MouseEvent>() {
        public void handle(MouseEvent me) {
          double NewX = rand.nextInt((750-100)+1)+100;
          double NewY = rand.nextInt((450-100)+1)+100;
 //         double NewZ = rand.nextInt((15-3)+1)+3;
          //calculate new position of the circle
          if (NewX == X && NewY == Y){
            NewX = rand.nextInt((750-100)+1)+100;
            NewY = rand.nextInt((450-100)+1)+100;
          }
          if ((NewX >= ball.getRadius()+100) &&  (NewX <= 750 - ball.getRadius())){
            ball.setCenterX(NewX);
          }
          if ((NewY >= ball.getRadius()+100) &&  (NewY <= 450 - ball.getRadius())){
            ball.setCenterY(NewY);
          }
//          ball.setRadius(NewZ);
          Click++;
          ClickL.setText("   Click: " + String.valueOf(Click)+ "     ");
          
          System.out.println(Click);
          System.out.println(ClickL);
        }
      });
     
      
      
      
      
      HBox hbox = new HBox();
      hbox.getChildren().addAll(Reset, ClickL, Easy, Medium, Hard, Random);
      
      groupBase = new Group(ball);
      Group CompGUI = new Group();

      CompGUI.getChildren().add(groupBase);
      CompGUI.getChildren().add(hbox);
   
    //Standard JavaFX initialization
    game = new Scene(CompGUI, 800, 500);
    primaryStage.setTitle("Shooter");
    primaryStage.setScene(game);
    primaryStage.show();
    primaryStage.setResizable(false);
    }
    public void ResetPress(ActionEvent event)
    {
        Click = 0;
        ClickL.setText("   Click: " + String.valueOf(Click)+ "     ");
    }
    public void EasyPress(ActionEvent event)
    {
        ball.setRadius(16);
    }
    public void MediumPress(ActionEvent event)
    {
        ball.setRadius(10);
    }
    public void HardPress(ActionEvent event)
    {
        ball.setRadius(3);
    }
    public void RandomPress(ActionEvent event)
    {
        Random rand = new Random();
        Z = rand.nextInt((15-3)+1)+3;
        ball.setRadius(Z);
    }
}
