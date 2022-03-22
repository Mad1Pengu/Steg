import java.awt.Color;
public class Steganography {

	
	/**
	* Clear the lower (rightmost) two bits in a pixel.
	*/
	public static void clearLow( Pixel p )
	{
		p.setRed((p.getRed()/4)* 4);
		p.setGreen((p.getGreen()/4)* 4);
		p.setBlue((p.getBlue()/4)* 4);
	/* To be implemented */
	}
	public static Picture testClearLow(Picture p) {
	    
	    //for each row in the pixels 2d array
	    for (Pixel[] rowArray : p.getPixels2D())
	    {
	    	
	    	//for each Pixel object in the 1darray rowArray
	      for (Pixel pixelObj : rowArray)
	      {
	        clearLow(pixelObj);
	      }
	    }
	    return p;

	}
	
	/**
	* Set the lower 2 bits in a pixel to the highest 2 bits in c
	*/
	public static void setLow (Pixel p, Color c)
	{
	/* To be implemented */
		clearLow(p);
		//color when last 6 bits set to 0
		int newRed = (c.getRed()/ 64) * 64;
		int newGreen = (c.getGreen()/ 64) * 64;
		int newBlue = (c.getBlue()/ 64) * 64;
		
		//checking and setting depending on the first 2 bits for Red
		if(newRed == 192) {
			p.setRed(p.getRed() + 3);
		}
		if(newRed == 128) {
			p.setRed(p.getRed() + 2);
		}
		if(newRed == 64) {
			p.setRed(p.getRed() + 1);
		}else {
			p.setRed(p.getRed());
		}
		
		//checking and setting depending on the first 2 bits for Green
		if(newGreen == 192) {
			p.setGreen(p.getGreen() + 3);
		}
		if(newGreen == 128) {
			p.setGreen(p.getGreen() + 2);
		}
		if(newGreen == 64) {
			p.setGreen(p.getGreen() + 1);
		}else {
		p.setGreen(p.getGreen());
		}
		
		//checking and setting depending on the first 2 bits for Blue
		if(newBlue == 192) {
			p.setBlue(p.getBlue() + 3);
		}
		if(newBlue == 128) {
			p.setBlue(p.getBlue() + 2);
		}
		if(newBlue == 64) {
			p.setBlue(p.getBlue() + 1);
		}else {
			p.setBlue(p.getBlue());
		}
		
	}
	
	public static Picture testSetLow(Picture p, Color c) {
	    
	    //for each row in the pixels 2d array
	    for (Pixel[] rowArray : p.getPixels2D())
	    {
	    	
	    	//for each Pixel object in the 1darray rowArray
	      for (Pixel pixelObj : rowArray)
	      {
	        setLow(pixelObj, c);
	      }
	    }
	    return p;

	}

/**
* Sets the highest two bits of each pixel’s colors
* to the lowest two bits of each pixel’s colors
*/
	public static Picture revealPicture(Picture hidden) {
			Picture copy = new Picture(hidden);
			Pixel[][] pixels = copy.getPixels2D();
			Pixel[][] source = hidden.getPixels2D();
			for (int r = 0; r < pixels.length; r++) {
				for (int c = 0; c < pixels[0].length; c++) {
					Color col = source[r][c].getColor();
					/* To be Implemented */
					
					int lastRed = col.getRed() % 4;
					int lastGreen = col.getGreen() % 4;
					int lastBlue = col.getBlue() % 4;
					
					//remove first two bits of red
					if(pixels[r][c].getRed() >= 192) {
						pixels[r][c].setRed(pixels[r][c].getRed() - 192);
					}
					else if(pixels[r][c].getRed() >= 128 && pixels[r][c].getRed() < 192) {
						pixels[r][c].setRed(pixels[r][c].getRed() - 128);
					}
					else if(pixels[r][c].getRed() >= 64 && pixels[r][c].getRed() < 128) {
						pixels[r][c].setRed(pixels[r][c].getRed() - 64);
					}else {
						pixels[r][c].setRed(pixels[r][c].getRed());
					}
					
					//remove first two bits of green
					if(pixels[r][c].getGreen() >= 192) {
						pixels[r][c].setGreen(pixels[r][c].getGreen() - 192);
					}
					else if(pixels[r][c].getGreen() >= 128 && pixels[r][c].getGreen() < 192) {
						pixels[r][c].setGreen(pixels[r][c].getGreen() - 128);
					}
					else if(pixels[r][c].getGreen() >= 64 && pixels[r][c].getGreen() < 128) {
						pixels[r][c].setGreen(pixels[r][c].getGreen() - 64);
					}else {
						pixels[r][c].setGreen(pixels[r][c].getGreen());
					}
					
					//remove first two bits of blue
					if(pixels[r][c].getBlue() >= 192) {
						pixels[r][c].setBlue(pixels[r][c].getBlue() - 192);
					}
					else if(pixels[r][c].getBlue() >= 128 && pixels[r][c].getBlue() < 192) {
						pixels[r][c].setBlue(pixels[r][c].getBlue() - 128);
					}
					else if(pixels[r][c].getBlue() >= 64 && pixels[r][c].getBlue() < 128) {
						pixels[r][c].setBlue(pixels[r][c].getBlue() - 64);
					}else {
						pixels[r][c].setBlue(pixels[r][c].getBlue());
					}
					
					//setting
					if(lastRed == 3) {
						pixels[r][c].setRed(pixels[r][c].getRed() + 192);
					}
					if(lastRed == 2) {
						pixels[r][c].setRed(pixels[r][c].getRed() + 128);
					}
					if(lastRed == 1) {
						pixels[r][c].setRed(pixels[r][c].getRed() + 64);
					}else {
						pixels[r][c].setRed(pixels[r][c].getRed());
					}
					
					if(lastGreen == 3) {
						pixels[r][c].setGreen(pixels[r][c].getGreen() + 192);
					}
					if(lastGreen == 2) {
						pixels[r][c].setGreen(pixels[r][c].getGreen() + 128);
					}
					if(lastGreen == 1) {
						pixels[r][c].setGreen(pixels[r][c].getGreen() + 64);
					}else {
						pixels[r][c].setGreen(pixels[r][c].getGreen());
					}
					
					if(lastBlue == 3) {
						pixels[r][c].setBlue(pixels[r][c].getBlue() + 192);
					}
					if(lastBlue == 2) {
						pixels[r][c].setBlue(pixels[r][c].getBlue() + 128);
					}
					if(lastBlue == 1) {
						pixels[r][c].setBlue(pixels[r][c].getBlue() + 64);
					}else {
						pixels[r][c].setBlue(pixels[r][c].getBlue());
					}
				}
				
					
				}
				return copy;
		}
	
	public static void main(String[] args) {
		//Picture beach = new Picture ("beach.jpg");
		//beach.explore();
		//Picture copy = testClearLow(beach);
		//copy.explore();
		
		Picture beach2 = new Picture ("beach.jpg");
		beach2.explore();
		Picture copy2 = testSetLow(beach2, Color.PINK);
		copy2.explore();
		
		Picture copy3 = revealPicture(copy2);
		copy3.explore();

	}

}
