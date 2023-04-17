package at.stl.games.Tetris_Tutorial;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Collections;

public class Blocks extends JPanel {
    private final Point[][][] myPoint = {
            {
                    //I
                    {new Point(0,1),new Point(1,1),new Point(2,1),new Point(3,1)},
                    {new Point(1,0),new Point(1,1),new Point(1,2),new Point(1,3)},
                    {new Point(0,1),new Point(1,1),new Point(2,1),new Point(3,1)},
                    {new Point(1,0),new Point(1,1),new Point(1,2),new Point(1,3)},
            },
            {
                    //J
                    {new Point(0,1),new Point(1,1),new Point(2,1),new Point(2,0)},
                    {new Point(1,0),new Point(1,1),new Point(1,2),new Point(2,2)},
                    {new Point(0,1),new Point(1,1),new Point(2,1),new Point(0,2)},
                    {new Point(1,0),new Point(1,1),new Point(1,2),new Point(0,0)},
            },
            {
                    //L
                    {new Point(0,1),new Point(1,1),new Point(2,1),new Point(2,0)},
                    {new Point(1,0),new Point(1,1),new Point(1,2),new Point(2,2)},
                    {new Point(0,1),new Point(1,1),new Point(2,1),new Point(0,0)},
                    {new Point(1,0),new Point(1,1),new Point(1,2),new Point(2,0)},
            },
            {
                    //O
                    {new Point(0,0),new Point(0,1),new Point(1,0),new Point(1,1)},
                    {new Point(0,0),new Point(0,1),new Point(1,0),new Point(1,1)},
                    {new Point(0,0),new Point(0,1),new Point(1,0),new Point(1,1)},
                    {new Point(0,0),new Point(0,1),new Point(1,0),new Point(1,1)},
            },
    };

    private final Color[] myColor={Color.CYAN,Color.MAGENTA,Color.ORANGE,Color.YELLOW,Color.BLACK,Color.PINK,Color.RED};
    private  Point pt;
    private int currentPiece;
    private int rotation;
    private ArrayList<Integer>nextPiece = new ArrayList<Integer>();
    private long score;
    private Color[][]well;

    private void init(){
        well=new Color[12][24];
        for(int i=0;i<12;i++){
            for(int j = 0; j<23;j++){
                //if(i==0||11==i||i=22){
                 //   well[i][j]=Color.pink;
                //}else{
                    well[i][j]=Color.black;
                //}
            }
        }
        newPiece();
    }

    public void newPiece(){
        pt=new Point(5,2);
        rotation =0;

        if(nextPiece.isEmpty()){
            Collections.addAll(nextPiece, 0,1,2,3);
            Collections.shuffle(nextPiece);
        }
    }

    private boolean collidesAt(int x, int y, int rotation){
        for (Point p: myPoint[currentPiece][rotation]){
            if (well[p.x+x][p.y+y]!=Color.black){
                return true;
            }
        }
        return false;
    }

    private void rotate(int i){
        int newRotation = (rotation+i)%4;
        if (newRotation<0){
            newRotation=3;
        }
        if(!collidesAt(pt.x,pt.y,newRotation)){
            rotation=newRotation;
        }
        repaint();
    }

    public void move(int i){
        if (!collidesAt(pt.x,pt.y,rotation)){
            pt.x += i;
        }
        repaint();
    }

    public void drop(){
        if(!collidesAt(pt.y,pt.y,rotation)){
            pt.y += 1;
        }else{
            fixToWell();
        }
        repaint();
    }

    public void fixToWell(){
        for (Point p: myPoint[currentPiece][rotation]){
            well[pt.x+p.x][pt.y+p.y]=myColor[currentPiece];
        }
        clearRows();
        newPiece();
    }

    public void deleteRows(int row){
        for (int j=row-1;j>0;j--){
            for (int i = 1; i < 11; i++) {
                well[i][j]=well[i][j];
            }
        }
    }

    private void clearRows(){
        boolean gap;
        int numClear=0;
        for (int j = 21; j >0 ; j--) {
            gap=false;
            for (int i=1;i<11;i++){
                if(well[i][j]==Color.black){
                    gap=true;
                    break;
                }
            }
            if(!gap){
                deleteRows(numClear);
                j+=1;
                numClear+=1;
            }
        }
        switch (numClear){
            case 1:
                score+=100;
                break;
            case 2:
                score+=300;
                break;
            case 3:
                score+=500;
                break;
            case 4:
                score+=800;
                break;
        }
    }
    private void drawPiece(Graphics graphics){
        graphics.setColor(myColor[currentPiece]);
        for (Point p:myPoint[currentPiece][rotation]) {
            graphics.fillRect((p.x+pt.x)*26,(pt.y+p.y)*26,25,25);
        }
    }
    public void paintComponent(Graphics graphics){
        graphics.fillRect(0,0,26*12,26*23);
        for (int i = 0; i < 23; i++) {
            for (int j = 0; j < 23; j++) {
                graphics.setColor(well[i][j]);
                graphics.fillRect(26*i,26*j,25,25);
            }
        }
        graphics.setColor(Color.WHITE);
        graphics.drawString("Score is: "+score, 19*12, 25);
        drawPiece(graphics);
    }

    public static void main(String[] args) {

        JFrame f = new JFrame("Blocks");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(12*26+10,26*23+25);
        f.setVisible(true);

        final Blocks game=new Blocks();
        game.init();
        f.add(game);

        f.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                switch (e.getKeyCode()){
                    case KeyEvent.VK_UP:
                        game.rotate(-1);
                        break;
                    case KeyEvent.VK_DOWN:
                        game.rotate(+1);
                        break;
                    case KeyEvent.VK_LEFT:
                        game.move(-1);
                        break;
                    case KeyEvent.VK_SPACE:
                        game.drop();
                        game.score+=1;
                        break;

                }
            }
        });
        new Thread(() -> {
            while (true){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                game.drop();
            }
        }).start();
    }
}

