package com.lukestadem.bytelog64.gui;

import com.lukestadem.rendgine.Engine;
import com.lukestadem.rendgine.graphics.ModernImmediateRenderer2D;
import com.lukestadem.rendgine.graphics.TextureRenderer;
import com.lukestadem.rendgine.graphics.font.BitmapFont;
import org.joml.Vector2f;

import java.util.LinkedList;
import java.util.List;

public class HexRow {
	
	public Vector2f pos;
	public BitmapFont font;
	
	public List<ByteBlock> byteBlocks;
	
	public Vector2f tmp;
	
	public float sidePad;
	public float topbotPad;
	
	public HexRow(float x, float y, BitmapFont font){
		this.pos = new Vector2f(x, y);
		this.font = font;
		
		byteBlocks = new LinkedList<>();
		
		tmp = new Vector2f();
		
		sidePad = 2.5f;
		topbotPad = -2.5f;
	}
	
	public void background(Engine engine, ModernImmediateRenderer2D mir){
		tmp.set(pos);
		
		final float spaceWidth = font.getTextWidth(" ");
		for(ByteBlock block : byteBlocks){
			final String blockStr = block.toString();
			final float width = font.getTextWidth(blockStr);
			final float height = font.getMaxHeight(blockStr);
			
			mir.rect(tmp.x - sidePad - 1, tmp.y - topbotPad + 6, width + (sidePad * 2), height + (topbotPad * 2), block.color);
			
			tmp.x += width + spaceWidth;
		}
	}
	
	public void foreground(Engine engine, TextureRenderer tr){
		tmp.set(pos);
		
		final float spaceWidth = font.getTextWidth(" ");
		for(ByteBlock block : byteBlocks){
			final String blockStr = block.toString();
			final float width = font.getTextWidth(blockStr);
			
			font.render(tr, block.toString(), tmp.x, tmp.y, 1,1,1,1);
			
			tmp.x += width + spaceWidth;
		}
	}
}
