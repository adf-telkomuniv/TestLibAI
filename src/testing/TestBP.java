/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing;

import ann.BackProp;
import misc.FileIO;

/**
 *
 * @author dee
 */
public class TestBP {

    public static void main(String[] args) {

        try {
            int[] hiddenNeuron = {7,7,7};
            BackProp model = new BackProp(hiddenNeuron, 500);
            model.setlR(0.01);

            double[][] input = FileIO.readFileDouble("data\\train.txt");
            double[][] target = FileIO.readFileDouble("data\\test2.txt");

//        double[][] input = {
//            {1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1},
//            {1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1},
//            {1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1},
//            {1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1},
//            {1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1},
//            {1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1},
//            {1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1},
//            {1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1}
//        };
//            double[][] target = {{1}, {0}, {1}, {0}, {1}, {0}, {1}, {0}};
            
            
            model.train(input, target, input, target);

            double[] test;
            double [][] output = target.clone();
            for (int i = 0; i < input.length; i++) {
                test = model.test(input[i]);
                output[i] = test;
                for (int j = 0; j < test.length; j++) {
                    System.out.print(test[j] + " ");
                }
                System.out.println("");
            }
            
            System.out.println(model.accuracy(output, target)/output.length*100+"%");
            System.out.println("==================================");
            for (int i = 0; i < input.length; i++) {
                test = model.testFlexible(input[i]);
                output[i] = test;
                for (int j = 0; j < test.length; j++) {
                    System.out.print(test[j] + " ");
                }
                System.out.println("");
            }
            
            System.out.println(model.accuracy(output, target)/output.length*100+"%");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
