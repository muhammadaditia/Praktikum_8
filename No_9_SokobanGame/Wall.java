package No_9_SokobanGame;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Wall extends Actor {

    private Image image;

    public Wall(int x, int y) {
        super(x, y);
        
        initWall();
    }
    
    private void initWall() {
        
        ImageIcon iicon = new ImageIcon("src/resource_sokoban/wall.png");
        image = iicon.getImage();
        setImage(image);
    }
}
