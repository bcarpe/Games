package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class ViewDialogBox {
	private String text;
	private Rectangle bounds;
	private Color bgColor;
	private Color fgColor;
	private Font font;
	private boolean textCentered = false;
	
	public ViewDialogBox(String inText, Rectangle inBounds, Color inBgColor, Color inFgColor, Font inFont) {
		text = inText;
		bounds = inBounds;
		bgColor = inBgColor;
		fgColor = inFgColor;
		font = inFont;
	}
	
	public ViewDialogBox(String inText, int inX, int inY, int inWidth, int inHeight, Color inBgColor, Color inFgColor, Font inFont) {
		text = inText;
		bounds = new Rectangle(inX, inY, inWidth, inHeight);
		bgColor = inBgColor;
		fgColor = inFgColor;
		font = inFont;
	}
	
	public void setTextCentered(boolean textCentered) {
		this.textCentered = textCentered;
	}
	
	public void draw(Graphics2D g2d) {
		if(bgColor == null) 
			g2d.setColor(Color.WHITE);
		else
			g2d.setColor(bgColor);
		g2d.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
		
		if(fgColor == null) 
			g2d.setColor(Color.BLACK);
		else
			g2d.setColor(fgColor);
		if(font != null)
			g2d.setFont(font);
		if(textCentered) {
			FontMetrics metrics = g2d.getFontMetrics(font);
			int textHeight = metrics.getHeight();
			int textAscent = metrics.getAscent();
			int textWidth = metrics.stringWidth(text);
			g2d.drawString(text, 
							bounds.x + (bounds.width - textWidth)/2, 
							bounds.y + (bounds.height - textHeight)/2 + textAscent);
		}
		else
			g2d.drawString(text, bounds.x + 10, bounds.y + font.getSize() + 10);
		
		//Annie T'rese Bombshell Carpenter
	}
}
