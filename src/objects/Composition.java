package objects;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import Revolution.MoveType;

public class Composition implements MoveType {
    private final ImageView i = new ImageView();
    private final int id;

    //create an ImageView to hold the image and create a Box of the same size to check for intersections before we move the image
    public Composition(int id, double startX, double startY) {
        this.id = id;
        i.setImage(new Image("influence.png"));
        i.setLayoutX(startX);
        i.setLayoutY(startY);
    }

    public ImageView
    getShape() {
        return i;
    }

    public int getId(){
        return id;
    }

    public void setX(int x){
        i.setLayoutX(x);
    }

    public void setY(int y){
        i.setLayoutY(y);
    }
}