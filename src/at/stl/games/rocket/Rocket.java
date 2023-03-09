package at.stl.games.rocket;

import org.newdawn.slick.*;

public class Rocket implements ActorRocket {
    private Image rocketImage;
    private  float x,y;
    private float speed;


    public Rocket() throws SlickException {
        Image tmp = new Image("testdata/rocket.png");
        this.rocketImage = tmp.getScaledCopy(100,100);
        this.x = 100;
        this.y = 100;
        this.speed = 1.8f;
    }

    @Override
    public void render(Graphics graphics) {
        rocketImage.draw(this.x,this.y);
    }

    @Override
    public void update(GameContainer gameContainer,int delta) {
        if(gameContainer.getInput().isKeyDown(Input.KEY_RIGHT)){

            if(this.x<705){
                this.x += (float)delta/this.speed;
            }
        }
        if(gameContainer.getInput().isKeyDown(Input.KEY_LEFT)){
            this.x--;
            if(this.x <0){
                this.x = 0;
            }
        }
        if(gameContainer.getInput().isKeyDown(Input.KEY_UP)){
            this.y--;
            if(this.y<0){
                this.y = 0;
            }
        }
        if(gameContainer.getInput().isKeyDown(Input.KEY_DOWN)){
            if(this.y<600-100){
                this.y += (float)delta/this.speed;
            }
        }

    }

    public float getX() {
        return x+47;
    }

    public float getY() {
        return y;
    }

}
