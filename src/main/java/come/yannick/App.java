package come.yannick;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        MainView mainView = new MainView();
        Scene scene = new Scene(mainView, 640, 480);
        stage.setScene(scene);
        stage.setTitle("Game of life | :)");

        stage.show();
        mainView.draw();
    }

    public static void main(String[] args) {
        launch(args);
        Simulation simulation = new Simulation(8, 5);
        simulation.setAlive(2,2);
        simulation.setAlive(3,2);
        simulation.setAlive(4,2);
        simulation.printBoard();
        simulation.step();
        simulation.printBoard();
        simulation.step();
        simulation.printBoard();

    }

}