package проект;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageInd {

    public DataBase db;
    
    public ImageInd(){
        db = new DataBase();
        
        
    } 

    public void printdir(File dir) throws IOException {
        File fa[];
        fa = dir.listFiles();
        if (fa != null) {
            for (File fi : fa) {
                if (fi.getName().matches(".+\\.JPG")) {
                    processFile(fi);
                }
                if (fi.isDirectory()) {
                    printdir(fi);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        File f = new File("c://1//");
        ImageInd app = new ImageInd();
        app.printdir(f);
    }

    private void processFile(File fi) throws IOException {
        System.out.println(fi);

        BufferedImage img = ImageIO.read(fi);
        int colors[] = new int[img.getWidth() * img.getHeight()];

        long r = 0, g = 0, b = 0;

        for (int i = 0; i < img.getWidth(); i++) {
            for (int j = 0; j < img.getHeight(); j++) {
                int val = img.getRGB(i, j);
                //System.out.print(((val >> 24) & 0xFF) + " ");
                //System.out.print(val);System.out.println();
                int Red = ((val >> 16) & 0xFF);//System.out.print(Red);System.out.println();
                int Green = ((val >> 8) & 0xFF);//System.out.print(Green);System.out.println();
                int Blue = ((val >> 0) & 0xFF);//System.out.print(Blue);System.out.println();

                r = r + Red;
                g = g + Green;
                b = b + Blue;

                /*System.out.print(Red);
                 System.out.print(Green);
                 System.out.print(Blue);
                 System.out.print(((val >> 16) & 0xFF) + " ");
                 System.out.print(((val >> 8) & 0xFF) + " ");
                 System.out.print(((val >> 0) & 0xFF) + " ");
                 System.out.println();*/
            }
        }
        r = r / (img.getWidth() * img.getHeight());
        g = g / (img.getWidth() * img.getHeight());
        b = b / (img.getWidth() * img.getHeight());
        
        db.insertImageColor(fi.getPath(), r, g, b);
        
        System.out.print(r);
        System.out.print(" ");
        System.out.print(g);
        System.out.print(" ");
        System.out.print(b);
        System.out.println();
    }

}
