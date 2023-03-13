package utils;

import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class CacheImagenes extends CacheRecursos implements ImageObserver{
	
	private static CacheImagenes cacheImagenes = null;
	
	
	public static CacheImagenes getCacheImagenes () {
		if (cacheImagenes == null) {
			cacheImagenes = new CacheImagenes();
		}
		return cacheImagenes;
	}
	
	
	protected Object loadResource(URL url) {
		try {
			return ImageIO.read(url);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("No se pudo cargar la imagen de "+url);
			System.out.println("El error fue : "+e.getClass().getName()+" "+e.getMessage());
			System.exit(0);
			return null;
		}
	}
	
	private BufferedImage crearCompatible(int width, int height, int transparency) {
		GraphicsConfiguration gc = 
		  GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
		BufferedImage compatible = gc.createCompatibleImage(width,height,transparency);
		return compatible;
	}
	
	public BufferedImage getImagen(String name) {
		BufferedImage loaded = (BufferedImage)getResource(name);
		BufferedImage compatible = crearCompatible(loaded.getWidth(),loaded.getHeight(),Transparency.BITMASK); 
		Graphics g = compatible.getGraphics();
		g.drawImage(loaded,0,0,this);
		return compatible;
	}
		
	
	public ImageIcon getIcono (String name) {
		return new ImageIcon (getImagen(name));
	}
	
	
	public boolean imageUpdate(Image img, int infoflags,int x, int y, int w, int h) {
	   return (infoflags & (ALLBITS|ABORT)) == 0;
	}
}
