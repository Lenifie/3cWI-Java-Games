package at.stl.games.tetris;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.Color;

public class LineBlock implements Actor{
    private Color color;
    float x,y;
    float speed;

    public LineBlock(){
        this.color = Color.cyan;
        this.x = 200;
        this.y = 200;
        this.speed = speed;
    }


    @Override
    public void render(Graphics graphics) {
        graphics.fillRect(this.x,this.y,100,40);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        if(gameContainer.getInput().isKeyDown(Input.KEY_RIGHT)){

            this.x++;
        }
        if(gameContainer.getInput().isKeyDown(Input.KEY_LEFT)){
            this.x--;

        }
        if(gameContainer.getInput().isKeyDown(Input.KEY_SPACE)){
            this.y++;
        }
        if(gameContainer.getInput().isKeyDown(Input.KEY_UP)){
            this.x = -y;
            this.y = x;
        }
    }

    @Override
    public Color getColor() {
        return color;
    }
}
