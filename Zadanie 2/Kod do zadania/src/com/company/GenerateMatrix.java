package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Random;

public class GenerateMatrix {

    public static void generate(int cols, int rows, String fileName, int min, int max) {
        try {
            FileWriter myWriterFraction = new FileWriter("data/fractionMatrix" + fileName + ".txt");
            FileWriter myWriterDouble = new FileWriter("data/doubleMatrix" + fileName + ".txt");
            FileWriter myWriterFloat = new FileWriter("data/floatMatrix" + fileName + ".txt");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    Random ran = new Random();
                    BigInteger num;
                    BigInteger denum;
                    if (max == 0 && min == 0) {
                        num = BigInteger.valueOf(ran.nextInt());
                        while (true) {
                            denum = BigInteger.valueOf(ran.nextInt());
                            if (denum.equals(BigInteger.ZERO)) {
                            } else break;
                        }
                    } else {
                        num = BigInteger.valueOf(ran.nextInt((max - min) + 1) + min);
                        while (true) {
                            denum = BigInteger.valueOf(ran.nextInt((max - min) + 1) + min);
                            if (denum.equals(BigInteger.ZERO)) {
                            } else break;
                        }
                    }
                    myWriterFloat.write((num.floatValue() / denum.floatValue()) / 65536 + ",");
                    myWriterDouble.write((num.doubleValue() / denum.doubleValue()) / 65536 + ",");
                    myWriterFraction.write(num + ";" + (denum.multiply(BigInteger.valueOf(65536))) + ",");
                }
            }
            myWriterFloat.close();
            myWriterDouble.close();
            myWriterFraction.close();
        } catch (IOException err) {
            err.printStackTrace();
        }
    }

    public static void generateABCX(int size, int min, int max) {
        generate(size, size, "A" + size, min, max);
        generate(size, size, "B" + size, min, max);
        generate(size, size, "C" + size, min, max);
        generate(1, size, "X" + size, min, max);
    }


    public static void main(String[] args) {
//        generateABCX(10, -65536, 65535);
//        generateABCX(15, -65536, 65535);
//        generateABCX(20, -65536, 65535);
//        generateABCX(25, -65536, 65535);
//        generateABCX(30, -65536, 65535);
//        generateABCX(35, -65536, 65535);
//        generateABCX(40, -65536, 65535);
//        generateABCX(45, -65536, 65535);
//        generateABCX(50, -65536, 65535);
//        generateABCX(100, -65536, 65535);
//        generateABCX(150, -65536, 65535);
//        generateABCX(200, -65536, 65535);
//        generateABCX(250, -65536, 65535);
//        generateABCX(300, -65536, 65535);
//        generateABCX(350, -65536, 65535);
//        generateABCX(400, -65536, 65535);
//        generateABCX(450, -65536, 65535);
        generateABCX(500, -65536, 65535);
    }
}
