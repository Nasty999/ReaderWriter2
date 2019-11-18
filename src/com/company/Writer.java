package com.company;

import java.util.HashMap;

public class Writer {
    private static HashMap<String, Integer> hm;

    public Writer () {
        hm = new HashMap<>();
    }

    public synchronized void addNew(String key){
        if(hm.containsKey(key)){
            hm.put(key, hm.get(key) + 1);
        }
        else{
            hm.put(key, 1);
        }
    }

    public synchronized void addString(String text){
        String[] subStr;
        String delimeter = " ";
        subStr = text.split(delimeter);
        //System.out.println(subStr);
        for(int i = 0; i < subStr.length; i++){
            this.addNew(subStr[i]);
            //System.out.println(subStr[i]);
        }
    }

    public synchronized HashMap<String, Integer> getHashMap(){
        return hm;
    }


}
