package at.stl.games.tetris;

import at.stl.games.snowworld.Snowflake;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import java.util.Random;

public class Blocks implements Actor{
    public enum TETROMINOS{O,T,L,J,I,Z,S}
    private float x,y;
    private  float speed;
    private float width;
    private Random random;
    private Color color;

    public Blocks(TETROMINOS tetrominos){
        this.random = new Random();
        this.speed = 35;
        if (tetrominos == TETROMINOS.O){
            this.color = Color.yellow;
            this.width = 40;
        }
        if (tetrominos == TETROMINOS.T){
            this.color = Color.magenta;
            this.width = 40;
        }
        if (tetrominos == TETROMINOS.L){
            this.color = Color.orange;
            this.width = 40;
        }
        if (tetrominos == TETROMINOS.J){
            this.color = Color.blue;
            this.width = 40;
        }
        if (tetrominos == TETROMINOS.I){
            this.color = Color.cyan;
            this.width = 40;
        }
        if (tetrominos == TETROMINOS.Z){
            this.color = Color.red;
            this.width = 40;
        }
        if (tetrominos == TETROMINOS.S){
            this.color = Color.green;
            this.width = 40;
        }

        setRandomPosition();
    }

    public void setRandomPosition(){
        this.x = random.nextInt(600);
        this.y = random.nextInt(800)-800;
    }

    @Override
    public void render(Graphics graphics) {
        graphics.fillRect(this.x,this.y,this.width,40);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        if(this.y<800-50){
            this.y += (float)delta/speed;
        }
        if(gameContainer.getInput().isKeyDown(Input.KEY_RIGHT)){
            if(this.x<560){
                this.x += (float)delta;
            }
        }
        if(gameContainer.getInput().isKeyDown(Input.KEY_LEFT)){
            this.x--;
            if(this.x <0){
                this.x = 0;
            }
        }
        if(gameContainer.getInput().isKeyDown(Input.KEY_SPACE)){
            if(this.y<800-50){
                this.y += (float)delta;
            }
        }
        if(gameContainer.getInput().isKeyDown(Input.KEY_UP)){

        }

    }

    @Override
    public Color getColor() {
        return color;
    }
}
