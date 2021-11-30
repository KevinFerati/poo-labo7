package hanoi;

import util.Pile;

public class Hanoi {
    private int turn;

    private Pile<Integer> colonneDebut = new Pile<>();
    private Pile<Integer> colonneIntermediaire = new Pile<>();
    private Pile<Integer> colonneFin = new Pile<>();

    private HanoiDisplayer displayer;

    /**
     * Créer une instance Hanoi permettant de résoudre la tour de hanoi avec un affichage sur la console par défaut
     * @param disks Nombre de disque sur la première colonne
     */
    public Hanoi(int disks) {
        this(disks, new HanoiDisplayer());
    }

    /**
     * Créer une instance Hanoi permettant de résoudre la tour de hanoi
     * @param disks Nombre de disque sur la première colonne
     * @param displayer Classe gérant l'affichage à chaque tour de la résolution de Hanoi
     */
    public Hanoi(int disks, HanoiDisplayer displayer) {
        if (disks < 1) throw new IllegalArgumentException("Il ne peut pas y avoir 0 ou moins de disque");
        if (displayer == null) throw new NullPointerException("le display ne peut être null");

        this.displayer = displayer;

        for (int i = disks; i > 0; i--) {
            colonneDebut.empiler(i);
        }
    }

    /**
     * Résout le problème de Hanoi et appelle le displayer à chaque tour.
     */
    public void solve() {
        displayer.display(this);
        lancerResolutionRecursif(colonneDebut.taille(), colonneDebut, colonneFin, colonneIntermediaire);
    }


    /**
     * Déplace les disques selon l'algorithme de résolution récursif de hanoi
     */
    private void lancerResolutionRecursif(int disqueCompteur, Pile<Integer> debut, Pile<Integer> fin, Pile<Integer> milieu) {
        if (disqueCompteur == 0)
            return;

        lancerResolutionRecursif(disqueCompteur - 1, debut, milieu, fin);
        fin.empiler(debut.desempiler());
        ++turn;
        displayer.display(this);
        lancerResolutionRecursif(disqueCompteur - 1, milieu, fin, debut);

    }

    /**
     * @return l'état actuel des trois colonnes sous forme de matrice de taille de 3 x N.
     *          La première ligne correspond à la colonne de départ, la dernière à celle de fin.
     */
    public int[][] status() {
        int[][] res = new int[3][];
        Pile<Integer>[] piles = new Pile[]{colonneDebut, colonneIntermediaire, colonneFin};

        for (int i = 0; i < piles.length; ++i) {
            res[i] = pileToTabInt(piles[i]);
        }

        return res;
    }

    /**
     * Retourne une copie de la colonne en paramètre sous forme de
     * @param colonne
     * @return
     */
    private int[] pileToTabInt(Pile<Integer> colonne){
        int[] resultat = new int[colonne.taille()];
        int i = 0;
        for (Integer d : colonne) {
            resultat[i++] = d;
        }
        return resultat;
    }

    /**
     * @return si la solution a été atteinte.
     */
    public boolean finished() {
        return colonneDebut.vide() && colonneIntermediaire.vide() ;
    }

    /**
     * @return le nombre de disque déplacés.
     */
    public int turn() {
        return turn;
    }

    /**
     * @return une représentation des 3 colonnes
     */
    @Override
    public String toString() {
        return new StringBuilder()
                .append("-- Turn : ").append(turn()).append('\n')
                .append("One   : ").append(colonneDebut).append('\n')
                .append("Two   : ").append(colonneIntermediaire).append('\n')
                .append("Three : ").append(colonneFin).append('\n')
                .toString();
    }
}
