/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing;

import gsp.GSP;
import java.io.IOException;

/**
 *
 * @author ANDITYAARIFIANTO
 */
public class TestGSP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            GSP g = new GSP();
<<<<<<< HEAD
            g.start("data\\current_A.txt", "data\\goal_A.txt",0);
=======
            g.start("data\\GSPcurrent2.txt", "data\\GSPgoal2a.txt");
>>>>>>> 238582deebbe27e2f38666a24b2bae999527cad0
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
