/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing;

import fuzzy.Fuzzy;
import fuzzy.Input;
import fuzzy.MamdaniOutput;
import fuzzy.Membership;
import fuzzy.Rule;
import fuzzy.Rules;

/**
 *
 * @author dee
 */
public class TestFuzzy2 {

    public static void main(String[] args) {

        Input in1 = new Input();
        in1.addMembership("low", 0, 0, 0.3, 0.5);
        in1.addMembership("middle", 0.3, 0.5, 0.7);
        in1.addMembership("high", 0.5, 0.7, 1, 1);

        Input in2 = new Input();
        in2.addMembership("low", 0, 0, 0.3, 0.5);
        in2.addMembership("middle", 0.3, 0.5, 0.7);
        in2.addMembership("high", 0.5, 0.7, 1, 1);

        Input in3 = new Input();
        in3.addMembership("low", 0, 0, 0.3, 0.5);
        in3.addMembership("middle", 0.3, 0.5, 0.7);
        in3.addMembership("high", 0.5, 0.7, 1, 1);

        MamdaniOutput classVeryLow = new MamdaniOutput(20);
        classVeryLow.addMembership("low", 0, 0, 0, 0.68);
        classVeryLow.addMembership("mid", 0, 0.68, 0.68, 0.85);
        classVeryLow.addMembership("high", 0.68, 0.85, 1, 1);

        Rules ruleVeryLow = new Rules();
        String[][] s = new String[3][];
        s[0] = new String[]{"low", "middle", "high"};
        s[1] = new String[]{"low", "middle", "high"};
        s[2] = new String[]{"low", "middle", "high"};
        String[] out = new String[]{"high", "mid", "low"};
        ruleVeryLow.generate(s, out);
        System.out.println(ruleVeryLow);

        MamdaniOutput classHigh = new MamdaniOutput(20);
        classHigh.setMembership(0, new Membership("low", new double[]{0, 0, 0.68}));
        classHigh.setMembership(1, new Membership("mid", new double[]{0, 0.68, 0.85}));
        classHigh.setMembership(2, new Membership("high", new double[]{0.68, 0.85, 1, 1}));

        Rules ruleHigh = new Rules();
        s = new String[3][];
        s[0] = new String[]{"low", "middle", "high"};
        s[1] = new String[]{"low", "middle", "high"};
        s[2] = new String[]{"low", "middle", "high"};
        out = new String[]{"low", "mid", "high"};
        ruleHigh.generate(s, out);
//        System.out.println(ruleHigh);

        Fuzzy f = new Fuzzy();
        f.addInput(in1);
        f.addInput(in2);
        f.addInput(in3);
        double[] input = {0.01, 0.034, 0.09};
        double output;

        f.setOutput(classVeryLow);
        f.setRules(ruleVeryLow);

        output = f.processFuzzy(input);
        System.out.println("crisp class low = " + output);

        f.setOutput(classHigh);
        f.setRules(ruleHigh);
        output = f.processFuzzy(input);
        System.out.println("crisp class high = " + output);
    }
}
