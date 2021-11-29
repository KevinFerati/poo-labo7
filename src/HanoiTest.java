//import hanoi.gui.JHanoi;
import hanoi.Hanoi;
import util.Pile;

import java.util.Stack;

public class HanoiTest {

    public static void main(String[] args) {
        if (args.length > 1)
            throw new RuntimeException("max 1 argument !");
        // Nombre de disque donne en argument -> affichage console
        else if (args.length == 1){
            int disques = Integer.parseInt(args[0]);
            if (disques < 1)
                throw new RuntimeException("Le nombre de disque doit etre > 0 !");

            Hanoi h = new Hanoi(disques);
            h.solve();
        }
        // Pas d'argument -> affichage graphique
        else{
            new JHanoi();
        }
    }
}
