package com.lukestadem.bytelog64.gui;

import com.lukestadem.rendgine.graphics.Color;

public class ByteBlock {
	
	public byte[] bytes;
	public Color color;
	
	public ByteBlock(){
		bytes = new byte[0];
		color = Color.toColor(0x00000000);
	}
	
	public ByteBlock(float r, float g, float b, float a, byte... bytes){
		this.bytes = bytes;
		color = new Color(r, g, b, a);
	}
	
	public ByteBlock(Color color, byte... bytes){
		this.bytes = bytes;
		this.color = color;
	}
	
	@Override
	public String toString(){
		String s = "";
		
		for(byte b : bytes){
			char[] hexDigits = new char[2];
			hexDigits[0] = Character.forDigit((b >> 4) & 0xF, 16);
			hexDigits[1] = Character.forDigit((b & 0xF), 16);
			s += (new String(hexDigits)).toUpperCase() + " ";
		}
	    
	    return s.trim();
	}
}
