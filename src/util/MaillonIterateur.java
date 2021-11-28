package util;

import java.util.Iterator;

class MaillonIterateur<T> implements Iterator<T> {
    private Maillon<T> chaine;

    MaillonIterateur(Maillon<T> debut) {
        chaine = debut;
    }

    /**
     * @return True si il reste des éléments sur lesquels itérer, false si l'itérateur est à la dernière position
     */
    @Override
    public boolean hasNext() {
        return chaine != null;
    }

    /**
     * @return L'élément dans la position actuelle dans l'itérateur
     */
    @Override
    public T next() {
        T donnee = chaine.getDonnee();
        chaine = chaine.getSuivant();
        return donnee;
    }
}
