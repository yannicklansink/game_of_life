package come.yannick;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.transform.Affine;

public class MainView extends VBox {

    private Button stepButton;
    private Canvas canvas;
    private Affine affine;

    private Simulation simulation;

    public MainView() {
        stepButton = new Button("step");
        stepButton.setOnAction(actionEvent -> {
            simulation.step();
            draw();
        });
        canvas = new Canvas(400, 400);

        affine = new Affine();
        affine.appendScale(400/10f, 400/10f);


        simulation = new Simulation(10, 10);
        simulation.setAlive(2,2);
        simulation.setAlive(3,2);
        simulation.setAlive(4,2);
        this.getChildren().addAll(stepButton, canvas);
    }

    public void draw() {
        GraphicsContext g = canvas.getGraphicsContext2D();
        g.setFill(Color.LIGHTGRAY);
        g.fillRect(0,0,400,400);
        g.setTransform(affine);

        g.setFill(Color.BLACK);
        for (int x = 0; x < simulation.getWidth(); x++) {
            for (int y = 0; y < simulation.getHeight(); y++) {
                if (simulation.getState(x, y) == 1) {
                    g.fillRect(x, y, 1, 1);
                }

            }
        }

        g.setStroke(Color.GRAY);
        g.setLineWidth(0.05f);
        for (int x = 0; x <= simulation.getWidth(); x++) {
            g.strokeLine(x, 0, x, 10);
            
        }

        for (int y = 0; y <= simulation.getHeight(); y++) {
            g.strokeLine(0, y, 10, y);
            
        }

    }
}
