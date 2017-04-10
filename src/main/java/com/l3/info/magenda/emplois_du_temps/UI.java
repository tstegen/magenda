package com.l3.info.magenda.emplois_du_temps;

import java.awt.FontMetrics;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.font.FontRenderContext;
import java.awt.font.LineBreakMeasurer;
import java.awt.font.TextAttribute;
import java.awt.font.TextLayout;
import java.text.AttributedString;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class UI {

	public static final int TEXT_TO_LEFT = 1;
	public static final int TEXT_TO_CENTER = 2;
	public static final int TEXT_TO_RIGHT = 3;
	        
	public static void drawCenteredString( Graphics g, String s,int policy , int dx, int dy, int w, int h) {
		 int x,y;
		 FontMetrics fm = g.getFontMetrics();
		
		switch(policy) {
		
		case UI.TEXT_TO_LEFT:
		    x = 5;
		    y = (fm.getAscent() + (h - (fm.getAscent() + fm.getDescent())) / 2);
		    break;
		    
		case UI.TEXT_TO_CENTER:
		    x = (w - fm.stringWidth(s)) / 2;
		    y = (fm.getAscent() + (h - (fm.getAscent() + fm.getDescent())) / 2);
			break;
			
		case UI.TEXT_TO_RIGHT:
		    x = (w - fm.stringWidth(s));
		    y = (fm.getAscent() + (h - (fm.getAscent() + fm.getDescent())) / 2);
		    break;
		    
		default:
			x=0;
			y = (fm.getAscent() + (h - (fm.getAscent() + fm.getDescent())) / 2);
			
		}
		
	    g.drawString(s, dx+x, dy+y);
		
	}
	
    public static void DrawString(Graphics g,String text, int dx, int dy, int w, int h) {
        Point coordonee = new Point(dx, dy);
        Graphics2D g2d = (Graphics2D) g;
        FontRenderContext frc = g2d.getFontRenderContext();

        AttributedString attrStr = new AttributedString(text);
        attrStr.addAttribute(TextAttribute.FONT, g.getFont(), 0, text.length());   
        LineBreakMeasurer measurer = new LineBreakMeasurer(attrStr.getIterator(), frc);
       
        float breakWidth;
        breakWidth = w - 10;

        while (measurer.getPosition() < text.length()) {
          TextLayout layout = measurer.nextLayout(breakWidth);
          coordonee.y += (layout.getAscent());
          layout.draw(g2d, coordonee.x + (w - layout.getAdvance())/2, coordonee.y);
          coordonee.y += layout.getDescent();
        }
        
    }
    
}
