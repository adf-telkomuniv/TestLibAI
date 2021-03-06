/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing;

import ga.GeneticAlgorithm;
import ga.OperatorOptions;
import ga.GaSettings;

/**
 *
 * @author dee
 */
public class TestGa {

    public static void main(String[] args) {

        try {
            GaSettings settings = new GaSettings(31, 1000, 300);
            OperatorOptions operations = new OperatorOptions(3, 6, 6, 0, 1);
            GeneticAlgorithm ga = new GeneticAlgorithm(settings, operations);
            settings.setThresholdFitness(1000);
            
            TspEvaluator ev = new TspEvaluator();
            ga.optimize(ev);
            
            System.out.println(ga.getBestFitness());
            System.out.println(ga.getBestIndv());
            System.out.println(ev.evaluate2(ga.getBestIndv()));
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
