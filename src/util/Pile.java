package util;

import java.lang.reflect.Array;
import java.util.EmptyStackException;
import java.util.Iterator;

public class Pile<T> implements Iterable<T> {
    private Maillon<T> donnees;
    private int taille;

    /**
     * Ajoute un élément sur le sommet de la pile.
     * @params donnee Données à empiler. Peut être null.
     */
    public void empiler(T donnee) {
        donnees = new Maillon<>(donnee, donnees);
        taille++;
    }

    /**
     * Enlève l'objet sur le sommet de la pile et le retourne
     * @throws EmptyStackException si la pile est vide
     */
    public T desempiler() {
        if (donnees == null)
            throw new EmptyStackException();

        T tmp = donnees.getDonnee();
        donnees = donnees.getSuivant();
        taille--;
        return tmp;
    }

    /**
     * Renvoie la représentation textuelle des données séparées par une virgule. Retourne [] si la pile est vide.
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder().append('[');
        for (T donnee : this) {
            builder.append(donnee).append(", ");
        }

        int taille = builder.length();
        // Supprime la dernière virgule s'il y a eu des données
        if (taille > 2)
            builder.delete(taille - 2, taille);

        return  builder.append(']').toString();
    }

    /**
     * Retourne une représentation sous forme de tableau de la pile
     */
    public T[] toArray(Class<T> classResultat) {
        T[] resultat = (T[]) Array.newInstance(classResultat, taille);
        int i = 0;
        for (T data: this) {
            resultat[i++] = data;
        }
        return resultat;
    }

    /**
     * @return un itérateur de type Iterator<T> sur la pile
     */
    @Override
    public Iterator<T> iterator() {
        return new MaillonIterateur<>(donnees);
    }

    /**
     * @return le nombre d'élément que cette pile contient
     */
    public int taille() {
        return taille;
    }

    /**
     * @return True si la pile est vide, false sinon.
     */
    public boolean vide() {
        return taille() == 0;
    }
}
