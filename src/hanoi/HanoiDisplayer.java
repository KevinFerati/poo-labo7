package hanoi;

public class HanoiDisplayer {

    /**
     * Affichage l'état actuel de la tour de hanoi dans la console.
     */
    public void display(Hanoi hanoi) {
        if (hanoi == null)
            throw new NullPointerException();

        System.out.println(hanoi);
    }
}
