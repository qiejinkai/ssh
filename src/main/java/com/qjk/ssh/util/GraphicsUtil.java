package com.qjk.ssh.util;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.OutputStream;

import javax.imageio.ImageIO;

public final class GraphicsUtil {
	
	public final static int width = 138;
	public final static int height = 50;
	public final static int bgColor = 0xffe5e5e5;
	public final static int color = 0xff40dc82;
	
	public static void drawImage(String content,OutputStream out) throws Exception{
		
		drawImage(content, width, height, bgColor, color, out);
	}
	
	/**
	 * 图形编码
	**/
	public static void drawImage(String content,int width,int height,long bgColor,long color,OutputStream out) throws Exception{
		//TODO 
		
		int length = content == null ? 0 : content.length();
		
		if(width == 0 && height == 0){
			height = 64;
			width = height * (length + 1);
		}
		else if(width == 0) {
			width = height * (length + 1);
		}
		else if(height == 0) {
			height = width / (length + 1);
		}
		
		final BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		Graphics2D g = image.createGraphics();
	       
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        
        if(bgColor != 0) {
        	g.setColor(new Color((int)bgColor,true));
        	g.fillRect(0, 0, width, height);
        }else{
        	g.setColor(Color.WHITE);
        	g.fillRect(0, 0, width, height);
        }
        
        if(color != 0) {
        	g.setColor(new Color((int)color,true));
        }
        else {
        	g.setColor(Color.BLACK);
        }

        int dw = width / (length + 1);
        int dh = height * 9 / 10;
        int dy = dh;
        int dx = dw / 2;
        
        g.setFont(new Font("Fixedsys", Font.BOLD | Font.ITALIC, dh));
        
        for(int i=0;i<length;i++){
        	g.drawString(content.substring(i,i + 1), dx + dw * i , dy);
        }
        
        for(int i=0;i< width * height / 80; i++) {
        	
        	int d = (int) (Math.random() * width * height);
        	int y0 = d  / width;
        	int x0 = d % width;
        	
        	d = (int) (Math.random() * height) / 6;
        	double r = Math.random() * Math.PI * 2;
        	int x1 = (int)(  x0 + d * Math.cos(r));
        	int y1 = (int)(  y0 + d * Math.sin(r));
        	
        	g.setStroke(new BasicStroke((int) (Math.random() * 3 + 1) ));
        	
        	g.drawLine(x0, y0, x1, y1);
        	
        }
        
        g.dispose();
        ImageIO.write(image, "JPEG", out);
      
	}
}
