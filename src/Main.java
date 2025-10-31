import javax.swing.*;
import java.awt.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main extends JPanel implements Runnable {

    // Map Config:
    private static final int TILE_SIZE = 64;
    private static final int TILE_WIDTH = 40;
    private static final int TILE_HEIGHT = 40;

    // Map Tile 2d array
    private Tile[][] map;
    // Instance of KH
    private KeyHandler keyHandler;

    // Loop Config
    private boolean running = false;
    private Thread loop;

    public Main(){
        setPreferredSize(new Dimension(960, 720));
        setBackground(Color.LIGHT_GRAY);
        setFocusable(true);

        keyHandler = new KeyHandler();
        initializeMap();
    }

    // Initialize Map
    private void initializeMap(){
        map = new Tile[TILE_WIDTH][TILE_HEIGHT];
        for(int i = 0; i < TILE_WIDTH; i++){
            for(int j = 0; j < TILE_HEIGHT; j++){
                double r = Math.random();
                TerrainType type = r < 0.1 ? TerrainType.WATER :
                        r < 0.4 ? TerrainType.DIRT : TerrainType.GRASS;
                map[i][j] = new Tile(i, j, type);
            }
        }
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("Temp");
        Main m = new Main();
        frame.add(m);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        }

        public void start() {
        running = true;
        loop = new Thread(this);
        loop.start();
        }

        @Override
        public void run() {
//            final int FPS = 60;
//            final long frame = 1000 / FPS;


        }

        @Override
        public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

//        int W = TILE_SIZE;
//        int H = TILE_SIZE;



        for (int i = 0; i < TILE_WIDTH; i++){
            for (int j = 0; j < TILE_HEIGHT; j++){
                map[i][j].draw(g2d);
            }
        }

        }


}
