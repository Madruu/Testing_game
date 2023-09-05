package testing.game;

import java.awt.Graphics;

import entities.Player;

public class Game implements Runnable
{
    private GameWindow gameWindow;
    private GamePanel gamePanel;
    private Thread gameThread;
    private final int FPS_SET = 120;
    private final int UPS_SET = 200;

    private Player player;
    
    public Game()
    {
        initClasses();

        gamePanel = new GamePanel(this);
        gameWindow = new GameWindow(gamePanel);
        gamePanel.requestFocus();

        startGameLoop();
    }

    private void initClasses() 
    {
        player = new Player(200,200);
    }

    private void startGameLoop()
    {
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void update()
    {
        player.update();
    }

    public void render(Graphics g)
    {
        player.render(g);
    }

    @Override
    public void run() 
    {
        //Game loop goes here
        //It needs to run in a loop, so we use a while loop
        //Needed variable that informs the duration of each frame
        //it needs to be in nanoSeconds
        double timePerFrame = 1000000000.0 / FPS_SET;
        double timePerUpdate = 1000000000.0 / UPS_SET;

        long previousTime = System.nanoTime();

        int frames = 0;
        int updates = 0;
        long lastCheck = System.currentTimeMillis();

        //Creating variable called deltaU. Same thing as deltaTime, but for updates.

        double deltaU = 0;
        double deltaF = 0;

        while(true)
        {

            long currentTime = System.nanoTime();

            //If its time to update the game
            deltaU += (currentTime - previousTime) / timePerUpdate;
            deltaF += (currentTime - previousTime) / timePerFrame;
            previousTime = currentTime;

            if(deltaU >= 1)
            {
                update ();
                updates++;
                deltaU--;
            }

            if(deltaF >= 1)
            {
                gamePanel.repaint();
                frames++;
                deltaF--;
            }
            
            //CHecking for the current time (currentTime Millis) and the last time is checked (lastChecked)
            if(System.currentTimeMillis() - lastCheck >= 1000)
            {
                //print the fps
                lastCheck = System.currentTimeMillis();
                System.out.println("FPS: " + frames + "|UPS:" + updates);
    
                //Reseting frames
                frames = 0;
                updates = 0;
            }
        }


        
        //throw new UnsupportedOperationException("Unimplemented method 'run'");
    }

    public void windowFocusLost()
    {
        player.resetDirBooleans();
    }

    public Player getPlayer()
    {
        return player;
    }
}
