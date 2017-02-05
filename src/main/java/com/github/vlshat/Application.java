package com.github.vlshat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Application
{
	public static void main( String[] args )
	{
		//System.out.println((int) Math.pow(2, 30));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String lastValue = null;
        String s = null;
        String key = null;
        List<String> sets = new ArrayList<>();
        try {
            while ((s = reader.readLine()) != null){
                StringTokenizer stringTokenizer = new StringTokenizer(s, "\t");
                if (lastValue == null){
                    lastValue = stringTokenizer.nextToken();
                    key = lastValue;
                    sets.add(stringTokenizer.nextToken());
                } else {
                    lastValue = key;
                    key = stringTokenizer.nextToken();
                }

                if (!key.equals(lastValue) && sets.size() == 1){
                    System.out.println(lastValue);
                    sets.clear();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!key.equals(lastValue)){
            System.out.println(key);
        }

    }

}