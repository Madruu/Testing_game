package inputs;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import testing.game.GamePanel;

public class MouseInputs implements MouseListener, MouseMotionListener{

    private GamePanel gamePanel;
    //constructor 
    public MouseInputs(GamePanel gamePanel)
    {
        this.gamePanel = gamePanel;
    }


    @Override
    public void mouseDragged(MouseEvent e) 
    {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'mouseDragged'");
    }

    @Override
    public void mouseMoved(MouseEvent e) 
    {
        //gamePanel.setRectPos(e.getX(), e.getY());;
    }

    @Override
    public void mouseClicked(MouseEvent e) 
    {
        // TODO Auto-generated method stub
        //System.out.println("Mouse clicked!");
        if(e.getButton() == MouseEvent.BUTTON1)
        {
            gamePanel.getGame().getPlayer().setAttacking(true);
        }    
    }

    @Override
    public void mousePressed(MouseEvent e) 
    {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'mousePressed'");
    }

    @Override
    public void mouseReleased(MouseEvent e) 
    {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'mouseReleased'");
    }

    @Override
    public void mouseEntered(MouseEvent e) 
    {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'mouseEntered'");
    }

    @Override
    public void mouseExited(MouseEvent e) 
    {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'mouseExited'");
    }
    
}
