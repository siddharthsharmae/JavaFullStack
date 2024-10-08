package com.Siddharth.Upload.JavaFullStack;

public class SpeedCheck {
    //Question is Which is faster String or stringbuffer or stringbuilder
        public static void main(String[] args) {
            long start1, end1, start2, end2, start3, end3,s = 0, sbf = 0, sbl=0;
            int z = 0;
            int a=0, b=0, c = 0;
            while (z < 50) {

                start1 = System.nanoTime();
                String str1 = "Siddharth";
                for (int i = 0; i < 100; i++) {
                    str1 = str1 + " ";
                }
                end1 = System.nanoTime();

                s = end1 - start1;

                start2 = System.nanoTime();
                StringBuffer str2 = new StringBuffer("Siddharth");
                for (int i = 0; i < 100; i++) {
                    str2.append(" ");
                }
                end2 = System.nanoTime();

                sbf = end2 - start2;

                start3 = System.nanoTime();
                StringBuilder str3 = new StringBuilder("Siddharth");
                for (int i = 0; i < 100; i++) {
                    str3.append(" ");
                }
                end3 = System.nanoTime();

                sbl = end3 - start3;

                if (s <= sbf && s <= sbl) {
                    a++;
                } else if (sbf <= sbl && sbf <= s) {
                    b++;
                } else {
                    c++;
                }
                z++;
            }
            System.out.println("\nNumber of times string is smallest is "+a+"\n");
            System.out.println("Number of times StringBuffer is smallest is "+b+"\n");
            System.out.println("Number of times stringBuilder is smallest is "+c+"\n");
        }
    }

