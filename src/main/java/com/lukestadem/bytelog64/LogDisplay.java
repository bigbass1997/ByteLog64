package com.lukestadem.bytelog64;

import com.lukestadem.bytelog64.gui.ByteBlock;
import com.lukestadem.bytelog64.gui.HexRow;
import com.lukestadem.rendgine.Engine;
import com.lukestadem.rendgine.EngineTask;
import com.lukestadem.rendgine.graphics.Color;
import com.lukestadem.rendgine.graphics.ModernImmediateRenderer2D;
import com.lukestadem.rendgine.graphics.TextureRenderer;
import com.lukestadem.rendgine.graphics.font.BitmapFont;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;

import static org.lwjgl.opengl.GL46.*;

public class LogDisplay implements EngineTask {
	
	private static final Logger log = LoggerFactory.getLogger(LogDisplay.class);
	
	private final ModernImmediateRenderer2D mir;
	private final TextureRenderer tr;
	
	private List<HexRow> rows;
	
	public LogDisplay(Engine engine, BitmapFont font, ModernImmediateRenderer2D mir, TextureRenderer tr){
		this.mir = mir;
		this.tr = tr;
		
		rows = new LinkedList<>();
		
		HexRow row = new HexRow(-200, 100, font);
		row.byteBlocks.add(new ByteBlock(Color.toColor(0x243B0CFF), iByte(0xF0,0x00,0x00,0x00)));
		row.byteBlocks.add(new ByteBlock(Color.toColor(0x5522A3FF), iByte(0x00,0x00,0x00,0x00)));
		row.byteBlocks.add(new ByteBlock(Color.toColor(0xA31B18FF), iByte(0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00)));
		rows.add(row);
		
		row = new HexRow(-200, 82, font);
		row.byteBlocks.add(new ByteBlock(Color.toColor(0x99215FFF), iByte(0x00,0x00,0x00,0x00,0x00,0x01,0xEB,0x55)));
		row.byteBlocks.add(new ByteBlock(Color.toColor(0x647F10FF), iByte(0x00,0x01)));
		row.byteBlocks.add(new ByteBlock(Color.toColor(0x13789CFF), iByte(0x01)));
		row.byteBlocks.add(new ByteBlock(Color.toColor(0x343EA0FF), iByte(0x00)));
		row.byteBlocks.add(new ByteBlock(Color.toColor(0x964710FF), iByte(0xDC,0x57)));
		row.byteBlocks.add(new ByteBlock(Color.toColor(0x1C8432FF), iByte(0x23,0x9B)));
		rows.add(row);
	}
	
	@Override
	public void loop(Engine engine){
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		mir.clear();
		
		for(HexRow row : rows){
			row.background(engine, mir);
		}
		mir.render(engine.camera);
		
		tr.begin(engine.camera.combined);
		for(HexRow row : rows){
			row.foreground(engine, tr);
		}
		tr.end();
	}
	
	protected byte iByte(int i){
		return (byte) i;
	}
	
	protected byte[] iByte(int... ints){
		final byte[] bytes = new byte[ints.length];
		for(int i = 0; i < ints.length; i++){
			bytes[i] = (byte) ints[i];
		}
		return bytes;
	}
}
