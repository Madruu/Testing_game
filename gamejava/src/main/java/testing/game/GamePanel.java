package testing.game;

import java.awt.Dimension;
import java.awt.Graphics;
//import java.awt.Image;
import java.awt.image.BufferedImage;
//import java.awt.image.BufferedImage;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
//import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
//import javax.imageio.ImageIO;
import javax.swing.JPanel;

import inputs.KeyboardInputs;
import inputs.MouseInputs;
import static utilz.Constants.playerConstants.*;
import static utilz.Constants.Directions.*;




public class GamePanel extends JPanel
{
    //Change deltas to float. as well as x and y direcitons
    private MouseInputs mouseInputs;
    private Game game;
    
    public GamePanel(Game game)
    {
        mouseInputs = new MouseInputs(this);
        this.game = game;

        setPanelSize();
        addKeyListener(new KeyboardInputs(this));
        //mosue inputs
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);

    }


    private void setPanelSize() 
    {
        Dimension size = new Dimension(1280, 800);
        setPreferredSize(size);
    }



    public void updateGame()
    {

    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        game.render(g);
        
        //g.drawImage(animations[playerAction][aniIndex], (int)xDelta, (int)yDelta, 256, 160, null);
    }

    public Game getGame()
    {
        return game;
    }




    
    
}
