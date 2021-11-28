package util;

class Maillon<T> {
    private T donnee;
    private Maillon<T> suivant;

    /**
     * Créer un maillon avec qui contiendra les données et un prochain maillon
     */
    Maillon(T donnee, Maillon<T> suivant) {
        this.donnee = donnee;
        this.suivant = suivant;
    }

    /**
     * @return la donnée contenu dans ce maillon
     */
    T getDonnee() {
        return donnee;
    }

    /**
     * @return le prochain maillon dans la liste enchainée
     */
    Maillon<T> getSuivant() {
        return suivant;
    }
}
