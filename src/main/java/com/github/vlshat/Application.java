package com.github.vlshat;

public class Application
{
	public static void main( String[] args )
	{
		//System.out.println((int) Math.pow(2, 30));
		int value = 7;
        System.out.println(Integer.toBinaryString(value));
        System.out.println(Integer.toBinaryString(1 << 2));
        System.out.println(Integer.toBinaryString( (1 << 2) ^ value));
        System.out.println(value ^ (1 << 2));
    }

}