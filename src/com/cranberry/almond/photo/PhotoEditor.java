package com.cranberry.almond.photo;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class PhotoEditor {

	public static void main(String[] args) {


		try {
			BufferedImage srcImage = loadImage();
			
			BufferedImage destImage = new BufferedImage(srcImage.getWidth(), srcImage.getHeight(),
					srcImage.getType());
			File outputFile = createNewImage(destImage);

			increaseBrightness(srcImage, destImage);
			
			ImageIO.write(destImage, "jpg", outputFile);
			System.out.println("Image manipulation is complete ");
		} catch (IOException e) {
			System.out.println("Exception thrown");
		}

	}
	public static BufferedImage loadImage() throws IOException
	{
		String inputImageName ="InputImage";
		String imageUrl = "/Users/poudelsanjeev/Documents/ProjectResources/"+ inputImageName +".jpg";
		BufferedImage image = ImageIO.read(new File(imageUrl));
		
		return image;
	}
	
	public static File createNewImage(BufferedImage img)
	{
		String outputImageName = "OutputImage";
		String imageUrl = "/Users/poudelsanjeev/Documents/ProjectResources/"+ outputImageName +".jpg";
	    File outputfile = new File(imageUrl);
	    return outputfile;
	}
	public static void increaseBrightness(BufferedImage srcImage, BufferedImage destImage)
	{
		RescaleOp rescaleOp = new RescaleOp(1.5f, 75, null);
		rescaleOp.filter(srcImage, destImage);

		 Graphics2D g = destImage.createGraphics();  
	        g.drawImage(srcImage, 0, 0, srcImage.getWidth(), srcImage.getHeight(), srcImage.getWidth(), 0, 0, srcImage.getHeight(), null);  
	        g.dispose(); 
	}
}
