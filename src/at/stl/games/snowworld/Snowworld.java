package at.stl.games.snowworld;

import org.newdawn.slick.*;
import org.newdawn.slick.Graphics;

import java.util.ArrayList;
import java.util.List;

public class Snowworld extends BasicGame {
    private List<ActorSnow> actorSnows;
    public Snowworld(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.actorSnows = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            this.actorSnows.add(new Snowflake(Snowflake.SIZE.BIG));
            this.actorSnows.add(new Snowflake(Snowflake.SIZE.MEDIUM));
            this.actorSnows.add(new Snowflake(Snowflake.SIZE.SMALL));
        }
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        for (ActorSnow actorSnow :this.actorSnows) {
            actorSnow.update(delta);
        }
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        for (ActorSnow actorSnow:this.actorSnows) {
            actorSnow.render(graphics);
        }
    }

    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new Snowworld("Snowworld"));
            container.setDisplayMode(800,600,false); //Größe Bild
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
