import java.awt.*;

// Tile types
enum TerrainType {
    GRASS, DIRT, WATER
}

 // Location and type
public class Tile {
    int x, y;
    TerrainType type;

    // Constrct
    public Tile(int x, int y, TerrainType type){
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public void draw(Graphics g){

        switch (type){
            case GRASS -> g.setColor(new Color(60, 180, 60));
            case DIRT -> g.setColor(new Color(139, 69, 19));
            case WATER -> g.setColor(new Color(30, 144, 255));
        }


    }
}
