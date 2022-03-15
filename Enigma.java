import java.util.Arrays;
import java.util.Collections;

public class Enigma {
    /**
     * Convertir chaque lettre dans une String en un entier
     * compris entre 0 et 25 qui correspond � la position de la lettre
     * selon l'ordre alphab�tique A=0, B=1,....,Z=25
     */
    public static int[] strToPos(final String pMsg) {
        String vS = pMsg.toUpperCase();
        int[] vPos = new int[vS.length()];

        for (int vI = 0; vI < vPos.length; vI++) {

            vPos[vI] = vS.charAt(vI) - 'A';
        }
        return vPos;
    } // strToPos()

    /**
     * Convertir un tableau d'entiers (positions de lettres)
     * en une String avec les lettres correspondantes A=0, B=1,....,Z=25
     */
    public static String posToStr(final int[] pPos) {
        String vS = "";

        for (int vI = 0; vI < pPos.length; vI++) {

            vS += (char) ('A' + pPos[vI]);
        }
        return vS;
    } // posToStr()

    public static void main(final String pArgs[]) {
        Integer[][] vR1 = new Integer[][] {
                { 17, 4, 19, 21, 7, 11, 3, -5, 7, 9, -10, 9, 17, 6, -6, -2, -4, -7, -12, -5, 3, 4, -21, -16, -2, -21 },
                { 10, 21, 5, -17, 21, -4, 12, 16, 6, -3, 7, -7, 4, 2, 5, -7, -11, -17, -9, -6, -9, -19, 2, -3, -21,
                        -4 } };
        Integer[][] vR2 = new Integer[][] {
                { 25, 7, 17, -3, 13, 19, 12, 3, -1, 11, 5, -5, -7, 10, -2, 1, -2, 4, -17, -8, -16, -18, -9, -1, -22,
                        -16 },
                { 3, 17, 22, 18, 16, 7, 5, 1, -7, 16, -3, 8, 2, 9, 2, -5, -1, -13, -12, -17, -11, -4, +1, -10, -19,
                        -25 } };
        Integer[][] vR3 = new Integer[][] {
                { 12, -1, 23, 10, 2, 14, 5, -5, 9, -2, -13, 10, -2, -8, 10, -6, 6, -16, 2, -1, -17, -5, -14, -9, -20,
                        -10 },
                { 1, 16, 5, 17, 20, 8, -2, 2, 14, 6, 2, -5, -12, -10, 9, 10, 5, -9, 1, -14, -2, -10, -6, 13, -10,
                        -23 } };
        Integer[] vRF = new Integer[] { 25, 23, 21, 19, 17, 15, 13, 11, 9, 7, 5, 3, 1, -1, -3, -5, -7, -9, -11, -13,
                -15, -17, -19, -21, -23, -25 };
        /* ============================================================= */

        // TODO Question-10

        // Fin TODO Question-10
        /* ============================================================= */

        // TODO Question-11

        // Fin TODO Question-11
        /* ============================================================= */
    } // main()
} // Enigma

class Rotor // classe non accessible en dehors de ce fichier
{
    // Les trois rotors + reflecteur
    Integer[][] aRotor1; // aRotor1[0][j] : ligne du retour du rotor 1
                         // aRotor1[1][j] : ligne d'aller du rotor 1
    Integer[][] aRotor2;
    Integer[][] aRotor3;
    Integer[] aReflecteur; // Reflecteur
    int aRotorActif; // le rotor qui doit tourner d'une position après chaque chiffrement d'une
                     // lettre
    int[] aPosition; // position[i] : position du rotor actif i (Nbr de décalages effectués).
                     // Quand un rotor fait un tour complet, il revient à sa position initiale 0

    /**
     * Constructeur pour intitialiser les valeurs des rotors et du réflecteur
     */

    public Rotor(final Integer[][] pR1, final Integer[][] pR2, final Integer[][] pR3, final Integer[] pReflect) {
        this.aRotor1 = pR1;
        this.aRotor2 = pR2;
        this.aRotor3 = pR3;
        this.aReflecteur = pReflect;
        this.aRotorActif = 0;
        this.aPosition = new int[] { 0, 0, 0 };
    } // Rotor()

    /**
     * Décaler d'une position à gauche (pDirection=-1)
     * ou à droite (pDirection=1) le rotor actif
     */
    public void decalRotor(final int pDirection, final int pRotorActif) {
        switch (pRotorActif) {
            case 1:
                Collections.rotate(Arrays.asList(this.aRotor1[0]), pDirection);
                Collections.rotate(Arrays.asList(this.aRotor1[1]), pDirection);
                this.aPosition[0] = (this.aPosition[0] + 1) % 26;
                break;
            case 2:
                Collections.rotate(Arrays.asList(this.aRotor2[0]), pDirection);
                Collections.rotate(Arrays.asList(this.aRotor2[1]), pDirection);
                this.aPosition[1] = (this.aPosition[1] + 1) % 26;
                break;
            case 3:
                Collections.rotate(Arrays.asList(this.aRotor3[0]), pDirection);
                Collections.rotate(Arrays.asList(this.aRotor3[1]), pDirection);
                this.aPosition[2] = (this.aPosition[2] + 1) % 26;
                break;
            default:
                System.out.println("erreur: rotor non identifié");
                System.exit(0);
        } // switch
    } // decalRotor()
} // Rotor
