package at.stl.games.rocket;

import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;

public class Main extends BasicGame {

    private List<ActorRocket> actors;


    public Main(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.actors = new ArrayList<>();


        Rocket rocket = new Rocket();
        this.actors.add(rocket);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        for (ActorRocket actor:this.actors) {
            actor.update(delta);
        }

    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        for (ActorRocket actor:this.actors) {
            actor.render(graphics);
        }
    }

    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new Main("Rocket"));
            container.setDisplayMode(800,600,false); //Größe Bild
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
