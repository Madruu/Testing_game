package testing.game;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import javax.swing.JFrame;
public class GameWindow 
{
    private JFrame JFrame;
    public GameWindow(GamePanel gamePanel)
    {
        //Criando objeto jframe (tela do jogo)
        JFrame = new JFrame();

        //JFrame.setSize(400, 400);
        JFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JFrame.add(gamePanel);
        JFrame.setLocationRelativeTo(null);
        JFrame.setResizable(false);
        //Pack(): telling JFrame to fit the size of the window to the preferred size of its components
        JFrame.pack();
        JFrame.setVisible(true);
        JFrame.addWindowFocusListener(new WindowFocusListener() {
            @Override
            public void windowLostFocus(WindowEvent e) {
                gamePanel.getGame().windowFocusLost();
                //throw new UnsupportedOperationException("Unimplemented method 'windowLostFocus'");
            }

            @Override
            public void windowGainedFocus(WindowEvent e) {
                // TODO Auto-generated method stub
                //throw new UnsupportedOperationException("Unimplemented method 'windowGainedFocus'");
            }

            
        });
    }
}
