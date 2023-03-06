package at.stl.games.rocket;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Rocket implements ActorRocket {
    private Image rocketImage;
    private  float x,y;


    public Rocket() throws SlickException {
        Image tmp = new Image("testdata/rocket.png");
        this.rocketImage = tmp.getScaledCopy(50,50);
        this.x = 100;
        this.y = 100;
    }

    @Override
    public void render(Graphics graphics) {
        rocketImage.draw(this.x,this.y);
    }

    @Override
    public void update(int delta) {
        this.x++;
    }
}
