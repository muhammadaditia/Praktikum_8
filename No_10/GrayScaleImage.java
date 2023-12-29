package No_10;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

class Surface extends JPanel{
    private Image mshi;
    private BufferedImage bufimg;
    private Dimension d;
    
    public Surface(){
        loadImage();
        determineAndSetSize();
        createGrayImage();
    }

    private void determineAndSetSize() {
        d = new Dimension();
        d.width = mshi.getWidth(null);
        d.height = mshi.getHeight(null);
        setPreferredSize(d);
    }

    private void createGrayImage() {
        bufimg = new BufferedImage(d.width, d.height, BufferedImage.TYPE_BYTE_GRAY);
        Graphics2D g2d = bufimg.createGraphics();
        g2d.drawImage(mshi, 0, 0, null);
        g2d.dispose();
    }
    
    private void loadImage() {
        mshi = new ImageIcon("person.jpg").getImage();
    }
    
    private void doDrawing(Graphics g){
        Graphics g2d = (Graphics2D) g;
        g2d.drawImage(bufimg, null, 0, 0);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }
  
}

public class GrayScaleImage extends JFrame{

    public GrayScaleImage() {
        initUI();
    }

    private void initUI() {
        Surface dpn1 = new Surface();
        add(dpn1);
        
        pack();
        
        setTitle("GrayScale Image");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable(){
            @Override
            public void run() {
                GrayScaleImage ex = new GrayScaleImage();
                ex.setVisible(true);
            }
            
        });
    }
   
}