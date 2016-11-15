package Revolution;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.RectangleBuilder;

import static bases.PixelMeasures.WORLD_WIDTH;

public class ScorePane extends Pane {
    public ScorePane() {
    }

    public void setScores(double cScore, double bScore, double pScore) {

        Rectangle c = RectangleBuilder.create()
                .height(20).width(WORLD_WIDTH / 3.0 - 10)
                .stroke(Color.BLACK)
                .build();
        c.setLayoutX(5);
        c.setLayoutY(5);

        Rectangle cBar = RectangleBuilder.create()
                .height(18).width((WORLD_WIDTH / 3.0 - 10) * (cScore / 300.0))
                .fill(Color.RED)
                .build();
        cBar.setLayoutX(6);
        cBar.setLayoutY(6);

        Rectangle b = RectangleBuilder.create()
                .height(20).width(WORLD_WIDTH / 3.0 - 10)
                .stroke(Color.BLACK)
                .build();
        b.setLayoutX(5);
        b.setLayoutY(30);

        Rectangle bBar = RectangleBuilder.create()
                .height(18).width((WORLD_WIDTH / 3.0 - 10) * (bScore / 300.0))
                .stroke(Color.BLACK)
                .fill(Color.GREEN)
                .build();
        bBar.setLayoutX(6);
        bBar.setLayoutY(31);


        Rectangle p = RectangleBuilder.create()
                .height(20).width(WORLD_WIDTH / 3.0 - 10)
                .stroke(Color.BLACK)
                .build();
        p.setLayoutX(5);
        p.setLayoutY(55);

        Rectangle pBar = RectangleBuilder.create()
                .height(18).width((WORLD_WIDTH / 3.0 - 10) * (pScore / 300.0))
                .fill(Color.YELLOW)
                .build();
        pBar.setLayoutX(6);
        pBar.setLayoutY(56);

        this.getChildren().clear();
        this.getChildren().addAll(c, b, p, cBar, bBar, pBar);
    }

}