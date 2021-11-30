import hanoi.gui.JHanoi;
import hanoi.Hanoi;

public class HanoiTest {

    public static void main(String[] args) {
        if (args.length > 1)
            throw new RuntimeException("Un argument maximum");
        
        if (args.length == 0) {
            new JHanoi();
            return;
        }

        Hanoi h = new Hanoi(Integer.parseInt(args[0]));
        h.solve();

    }
}
