package com.company;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        // image Source
        File originalImage = new File("C:\\Users\\LENOVO\\IdeaProjects\\ImageProcessing\\src\\com\\company\\download.jpg");

        BufferedImage img = null;

        try{
            img = ImageIO.read(originalImage);

            BufferedImage imgProcessed = new BufferedImage(img.getWidth(),img.getHeight(),BufferedImage.TYPE_INT_ARGB);

            for(int i=0; i<img.getWidth(); i++){
                for(int j=0; j<img.getHeight(); j++){
                    Color c = new Color(img.getRGB(i,j));
                    int r = c.getRed();
                    int g = c.getGreen();
                    int b = c.getBlue();
                    int alp = c.getAlpha();

                    //////// processing code
                    if (b > 100){
                        r = 0;
                        g = 0;
                        b = 0;
                    } else if (r < 200 ){
                        r = 0;
                        g = 0;
                        b = 0;
                    }

                    ///////////

                    Color processedColor = new Color(r,g,b,alp);
                    imgProcessed.setRGB(i,j,processedColor.getRGB());

                }
            }

            ImageIO.write(imgProcessed,"png", new File("C:\\Users\\LENOVO\\IdeaProjects\\ImageProcessing\\src\\com\\company\\Finish.jpg"));

        }catch (IOException e){

            e.printStackTrace();
        }


    }
}
