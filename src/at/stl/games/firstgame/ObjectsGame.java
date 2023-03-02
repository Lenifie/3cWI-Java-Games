package at.stl.games.firstgame;

import org.newdawn.slick.*;
import org.newdawn.slick.Graphics;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ObjectsGame extends BasicGame {

    private List<Rectangle> rectangles;



    public ObjectsGame(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.rectangles = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            Rectangle rectangle = new Rectangle(random.nextInt(600), random.nextInt(600), random.nextInt(50));
            rectangles.add(rectangle);
        }
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        for (Rectangle rectangle:this.rectangles) {
            rectangle.update(delta);
        }

    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        for (Rectangle rectangle:this.rectangles) {
            rectangle.render(graphics);
        }
    }

    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new ObjectsGame("Rectangles"));
            container.setDisplayMode(800,600,false); //Größe Bild
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
