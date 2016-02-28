package com.tinkeracademy.projects;

import java.util.ArrayList;

public class FlipTextLookupTable {

	public static ArrayList<String> alphabets = new ArrayList<String>();
	public static ArrayList<String> reverseAlphabets = new ArrayList<String>();
	
	// http://www.upsidedowntext.com/unicode
	static {
		
	alphabets.add("a");
	reverseAlphabets.add("\u0250");
	
	alphabets.add("b");
	reverseAlphabets.add("q");
	
	alphabets.add("c");	
	reverseAlphabets.add("\u0254");
	
	alphabets.add("d");	
	reverseAlphabets.add("p");
	
	alphabets.add("e");	
	reverseAlphabets.add("\u01DD");
	
	alphabets.add("f");	
	reverseAlphabets.add("\u025F");
	
	alphabets.add("g");	
	reverseAlphabets.add("\u0183");
	
	alphabets.add("h");	
	reverseAlphabets.add("\u0265");
	
	alphabets.add("i");	
	reverseAlphabets.add("\u1D09");
	
	alphabets.add("j");	
	reverseAlphabets.add("\u027E");
	
	alphabets.add("k");	
	reverseAlphabets.add("\u029E");
	
	alphabets.add("l");	
	reverseAlphabets.add("l");
	
	alphabets.add("m");	
	reverseAlphabets.add("\u026F");
	
	alphabets.add("n");	
	reverseAlphabets.add("u");
	
	alphabets.add("o");	
	reverseAlphabets.add("o");

	alphabets.add("p");	
	reverseAlphabets.add("d");
	
	alphabets.add("q");	
	reverseAlphabets.add("b");
	
	alphabets.add("r");	
	reverseAlphabets.add("\u0279");
	
	alphabets.add("s");	
	reverseAlphabets.add("s");
	
	alphabets.add("t");	
	reverseAlphabets.add("\u0287");
	
	alphabets.add("u");	
	reverseAlphabets.add("n");
	
	alphabets.add("v");	
	reverseAlphabets.add("\u028C");
	
	alphabets.add("w");	
	reverseAlphabets.add("\u028D");
	
	alphabets.add("x");	
	reverseAlphabets.add("x");
	
	alphabets.add("y");	
	reverseAlphabets.add("\u028E");
	
	alphabets.add("z");	
	reverseAlphabets.add("z");
	
	alphabets.add("A");	
	reverseAlphabets.add("\u2200");
	
	alphabets.add("B");	
	reverseAlphabets.add("B");
	
	alphabets.add("C");	
	reverseAlphabets.add("\u0186");
	
	alphabets.add("D");	
	reverseAlphabets.add("D");
	
	alphabets.add("E");	
	reverseAlphabets.add("\u018E");
	
	alphabets.add("F");	
	reverseAlphabets.add("\u2132");
	
	alphabets.add("G");	
	reverseAlphabets.add("\u05E4");
	
	alphabets.add("H");	
	reverseAlphabets.add("H");
	
	alphabets.add("I");	
	reverseAlphabets.add("I");
	
	alphabets.add("J");	
	reverseAlphabets.add("\u017F");
	
	alphabets.add("K");	
	reverseAlphabets.add("K");
	
	alphabets.add("L");	
	reverseAlphabets.add("\u02E5");
	
	alphabets.add("M");	
	reverseAlphabets.add("W");
	
	alphabets.add("N");	
	reverseAlphabets.add("N");
	
	alphabets.add("O");	
	reverseAlphabets.add("O");
	
	alphabets.add("P");	
	reverseAlphabets.add("\u0500");
	
	alphabets.add("Q");	
	reverseAlphabets.add("Q");
	
	alphabets.add("R");	
	reverseAlphabets.add("R");
	
	alphabets.add("S");	
	reverseAlphabets.add("S");
	
	alphabets.add("T");	
	reverseAlphabets.add("\u2534");
	
	alphabets.add("U");	
	reverseAlphabets.add("\u2229");
	
	alphabets.add("V");	
	reverseAlphabets.add("\u039B");
	
	alphabets.add("W");	
	reverseAlphabets.add("M");
	
	alphabets.add("X");	
	reverseAlphabets.add("X");
	
	alphabets.add("Y");	
	reverseAlphabets.add("\u2144");
	
	alphabets.add("Z");	
	reverseAlphabets.add("Z");
	
	alphabets.add("0");	
	reverseAlphabets.add("0");
	
	alphabets.add("1");	
	reverseAlphabets.add("\u0196");
	
	alphabets.add("2");	
	reverseAlphabets.add("\u1105");
	
	alphabets.add("3");	
	reverseAlphabets.add("\u0190");
	
	alphabets.add("4");	
	reverseAlphabets.add("\u3123");
	
	alphabets.add("5");	
	reverseAlphabets.add("\u03DB");
	
	alphabets.add("6");	
	reverseAlphabets.add("9");
	
	alphabets.add("7");	
	reverseAlphabets.add("\u3125");
	
	alphabets.add("8");	
	reverseAlphabets.add("8");
	
	alphabets.add("9");	
	reverseAlphabets.add("6");
	
	alphabets.add(",");	
	reverseAlphabets.add("'");
	
	alphabets.add(".");	
	reverseAlphabets.add("\u02D9");
	
	alphabets.add("?");	
	reverseAlphabets.add("\u00BF");
	
	alphabets.add("!");	
	reverseAlphabets.add("\u00A1");
	
	alphabets.add("\"");	
	reverseAlphabets.add(",,");
	
	alphabets.add("'");	
	reverseAlphabets.add(",");
	
	alphabets.add("`");	
	reverseAlphabets.add(",");
	
	alphabets.add("(");	
	reverseAlphabets.add(")");
	
	alphabets.add(")");	
	reverseAlphabets.add("(");
	
	alphabets.add("[");	
	reverseAlphabets.add("]");
	
	alphabets.add("]");	
	reverseAlphabets.add("[");
	
	alphabets.add("{");	
	reverseAlphabets.add("}");
	
	alphabets.add("}");	
	reverseAlphabets.add("{");
	
	alphabets.add("<");	
	reverseAlphabets.add(">");
	
	alphabets.add(">");	
	reverseAlphabets.add("<");
	
	alphabets.add("&");	
	reverseAlphabets.add("\u214B");
	
	alphabets.add("_");	
	reverseAlphabets.add("\u203E");
	
	@SuppressWarnings("unchecked")
	ArrayList<String> copy = ((ArrayList<String>) alphabets.clone());
	
	alphabets.addAll(reverseAlphabets);
	reverseAlphabets.addAll(copy);
	
	}
	
	public static String getFlippedSymbol(String c) {
		int idx = alphabets.indexOf(c);
		if (idx != -1) {
			c = (String) reverseAlphabets.get(idx);
		}
		return c;
	}
}
