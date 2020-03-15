package com.Group12.Game;

/*
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	Board b = new Board();
    	//DisplayManager d = new DisplayManager(b.getXSize() * 25, b.getYSize() * 25);
    	
    	
    	
    	System.out.println(b.getCellType(1, 1));
    	b.setCellType(1, 1, cellType.Wall);
    	System.out.println(b.getCellType(1, 1));
        System.out.println( "Hello World!" );
        b.printAsciiBoard();
    }
}

