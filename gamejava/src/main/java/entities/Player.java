package entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import inputs.KeyboardInputs;
import inputs.MouseInputs;
import static utilz.Constants.playerConstants.*;
import static utilz.Constants.Directions.*;

public class Player extends Entity
{
    private BufferedImage[][] animations;
    private int aniTick, aniIndex, aniSpeed = 20;
    private int playerAction = IDLE;
    //private int playerDir = -1;
    private boolean moving = false, attacking = false;
    private boolean left, up, right, down;
    private float playerSpeed = 2.0f;

    public Player(float x, float y)
    {
        super(x, y);
        loadAnimations();
    }

    public void update()
    {
        updatePos();
        updateAnimationTick();
        setAnimation();
    }

    public void render(Graphics g)
    {
        g.drawImage(animations[playerAction][aniIndex], (int)x, (int)y, 256, 160, null);

    }



    private void updateAnimationTick() 
    {
        aniTick++;

        if(aniTick >= aniSpeed)
        {
            aniTick = 0;
            aniIndex++;
            if(aniIndex >= GetSpriteAmount(playerAction))//Depending on the player action, we get a relative amount of indexes
            {
                aniIndex = 0;
                attacking = false;
            }
        }
    }


    private void setAnimation() 
    {
        int startAni = playerAction;

        if(moving)
        {
            playerAction = RUNNING;
        } else
            {
                playerAction = IDLE;
            }

        if(attacking)
        {
            playerAction = ATTACK_1;
        }

        if(startAni != playerAction)
        {
            resetAniTick();
        }
    }

    private void resetAniTick() 
    {
        aniTick = 0;
        aniIndex = 0;
    }

    private void updatePos() 
    {

        //no way of reseting, so
        moving = false; //Setting false by default, so when we walk, it turns true
        //if pressing two buttons at the same time (left and right) make him static
        if(left && !right)
        {
            x -= playerSpeed;
            moving = true;
        } else if(right && !left)
            {
                x += playerSpeed;
                moving = true;
            }

        if(up && !down)
        {
            y -= playerSpeed;
            moving = true;
        } else if(down && !up)
            {
                y += playerSpeed;
                moving = true;
            }
    }

    private void loadAnimations() 
    {
        InputStream is = getClass().getResourceAsStream("/player_sprites.png");

        //Stronger "if"

        try 
        {
            BufferedImage img = ImageIO.read(is);
            //Put the number os sprites of an animation
            animations = new BufferedImage[9][6];
            for(int j = 0; j < animations.length; j++)
             for(int i = 0; i < animations[j].length; i++)
             {
                animations[j][i] = img.getSubimage(i*64, j*40, 64, 40);
             }
        } catch (IOException e) 
        {
            e.printStackTrace();
        } finally 

        {
            try
            {
                is.close();
            } catch(IOException e)
            {
                e.printStackTrace();
            }
        }

        
    }

    public void resetDirBooleans()
    {
        left = false;
        right = false;
        up = false;
        down = false;
    }

    public void setAttacking(boolean attacking)
    {
        this.attacking = attacking;
    }

    //Creating getters and setters
    public boolean  isLeft()
    {
        return left;
    }

    public void setLeft(boolean left)
    {
        this.left = left;
    }

    public boolean isUp()
    {
        return up;
    }

    public void setUp(boolean up)
    {
        this.up = up;
    }
    
    public boolean isRight()
    {
        return right;
    }

    public void setRight(boolean right)
    {
        this.right = right;
    }

    public boolean isDown()
    {
        return down;
    }

    public void setDown(boolean down)
    {
        this.down = down;
    }
}
