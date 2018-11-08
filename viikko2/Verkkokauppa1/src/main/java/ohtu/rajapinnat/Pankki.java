package ohtu.rajapinnat;

/**
 *
 * @author ebberg
 */
public interface Pankki {
    boolean tilisiirto(String nimi, int viitenumero, String tililta, String tilille, int summa);
}
