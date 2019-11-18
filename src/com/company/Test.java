package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Test{
    private static Writer w = new Writer();
    private static Integer threadNum;

    public static class StartThread implements Runnable{
        private Writer w = new Writer();
        private String name;

        public StartThread(String name) {
            this.name = name;
        }


        @Override
        public void run() {
            try {
                Reader r = new Reader(name);
                String text = r.getAllText();
                w.addString(text);
            }catch(Exception e) {

            }
        }

    }

    public static void main(String[] args) {
        try {
            Writer wr = new Writer();
            threadNum = args.length;
            ArrayList<Thread> threads = new ArrayList<Thread>();
            ArrayList<StartThread> startThreads = new ArrayList<StartThread>();
            for(int i = 0; i < threadNum; i++) {
                startThreads.add(new StartThread(args[i]));
                threads.add(i, new Thread(startThreads.get(i)));
            }

            for(int i = 0; i < threadNum; i++) {
                threads.get(i).start();
            }

            for(int i = 0; i < threadNum; i++) {
                threads.get(i).join();
            }
            System.out.println(w.getHashMap());
        }catch(Exception e) {

        }
    }


}


