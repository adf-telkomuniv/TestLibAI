/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing;

import fuzzy.Fuzzy;
import fuzzy.FuzzyValue;
import fuzzy.Input;
import fuzzy.MamdaniOutput;
import fuzzy.Rule;
import fuzzy.Rules;
import fuzzy.SugenoOutput;

/**
 *
 * @author dee
 */
public class TestFuzzy {

    public static void main(String[] args) {

        Fuzzy f = new Fuzzy();
        Input suhu = new Input();
        suhu.addMembership("Cold", -100, -10, 0, 3);
        suhu.addMembership("Cool", 0, 3, 12, 15);
        suhu.addMembership("Normal", 12, 15, 24, 27);
        suhu.addMembership("Warm", 24, 27, 36, 39);
        suhu.addMembership("Hot", 36, 39, 50, 100);
        f.addInput(suhu);

        Input kelembaban = new Input();
        kelembaban.addMembership("Dry", -100, 0, 10, 20);
        kelembaban.addMembership("Moist", 10, 20, 40, 50);
        kelembaban.addMembership("Wet", 40, 50, 70, 100);
        f.addInput(kelembaban);

        Rules rules = new Rules();
        String[][] s = new String[2][];
        s[0] = new String[]{"Cold", "Cool", "Normal", "Warm", "Hot"};
        s[1] = new String[]{"Dry", "Moist", "Wet"};
        String[] out = new String[]{"Short", "Medium", "Long"};
        rules.generate(s, out);
        Rule r = rules.getRule(9);
        r.setOutputLing("Long");
        rules.setRule(9, r);

        System.out.println("-------print rules-------");
        System.out.println(rules);
        System.out.println("===============");
        f.setRules(rules);

        MamdaniOutput out1 = new MamdaniOutput(10);
        out1.addMembership("Short", 0, 0, 20, 28);
        out1.addMembership("Medium", 20, 28, 40, 48);
        out1.addMembership("Long", 40, 48, 90, 90);
        f.setOutput(out1);

        System.out.println("-------fuzzyfication-------");
        double[] inp = {37, 12};
        FuzzyValue[][] fuzzyInput = f.fuzzyfy(inp);
        for (int i = 0; i < fuzzyInput.length; i++) {
            for (int j = 0; j < fuzzyInput[i].length; j++) {
                FuzzyValue ff = fuzzyInput[i][j];
                System.out.print(ff.getLinguistic() + " " + ff.getFuzzyValue() + " , ");
            }
            System.out.println("");
        }

        FuzzyValue[] fuzzyOutput = f.inference(fuzzyInput, rules);
        System.out.println("-------inference-------");
        for (int i = 0; i < fuzzyOutput.length; i++) {
            System.out.println(fuzzyOutput[i].getLinguistic() + " " + fuzzyOutput[i].getFuzzyValue());
        }
        System.out.println("-----deffuzyfication-----");
        double x = f.defuzzify(fuzzyOutput, out1);
        System.out.println("x mamdani = " + x);
        System.out.println("==============");

        System.out.println("Automatic Process ");
        double x2 = f.processFuzzy(inp);
        System.out.println("x mamdani = " + x2);

        SugenoOutput out2 = new SugenoOutput(new double[]{20, 40, 60},
                new String[]{"Short", "Medium", "Long"});
        f.setOutput(out2);
        x2 = f.processFuzzy(inp);
        System.out.println("x sugeno = " + x2);

    }

}
