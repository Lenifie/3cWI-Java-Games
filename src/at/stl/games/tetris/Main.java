package at.stl.games.tetris;

import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;

public class Main extends BasicGame {
    private List<Actor> actors;

    public Main(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.actors = new ArrayList<>();

        RectangleBlock rectangleBlock = new RectangleBlock();
        this.actors.add(rectangleBlock);
        LineBlock lineBlock = new LineBlock();
        this.actors.add(lineBlock);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        for (Actor actor:this.actors) {
            actor.update(gameContainer,delta);
        }
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        for (Actor actor:this.actors) {
            actor.render(graphics);
        }
    }

    @Override
    public void keyPressed(int key, char c) {


    }

    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new Main("Tetris"));
            container.setDisplayMode(600,800,false); //Größe Bild
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
