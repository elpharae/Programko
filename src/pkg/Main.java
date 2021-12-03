package pkg;

import java.util.Random;
import java.util.Scanner;

public class Main {

    private final int SIRKA_BUNKY = 4;
    private int[][] pole;
    private int rozsah;

    public Main() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        this.rozsah = sc.nextInt();

        Random rn = new Random();
        this.pole = new int[n][n];

        for (int i = 0; i < this.pole.length; i++) {
            for (int j = 0; j < this.pole[i].length; j++) {
                this.pole[i][j] = rn.nextInt(rozsah * 2) - rozsah + 1;
            }
        }

        vypis();
        int[] vysledky = maxNadVD();
        System.out.println("Max hodnota: " + vysledky[0]);
        System.out.println("X: " + vysledky[1]);
        System.out.println("Y: " + vysledky[2]);
    }

    //vypis
    private void vypis() {
        for (int i = 0; i < this.pole.length; i++) {
            System.out.print("|");
            for (int j = 0; j < this.pole[i].length; j++) {
                for (int k = 0; k < this.SIRKA_BUNKY - Integer.toString(this.pole[i][j]).length(); k++) {
                    System.out.print(" ");
                }
                System.out.print(this.pole[i][j]);
            }
            System.out.println("|");
        }
    }

    //vedlejsi diagonala
    private int[] maxNadVD() {
        int max = -rozsah;
        int x = 0;
        int y = 0;
        for (int i = 0; i < this.pole.length; i++) {             //i = 0 -> j = 0-2, i = 1 -> j = 0-1, i = 2 -> j = 0
            for (int j = 0; j < this.pole[i].length - i - 1; j++) {
                if (this.pole[i][j] > max) {
                    max = this.pole[i][j];
                    x = i;
                    y = j;
                }
            }
        }
        return new int[]{max, x, y};
    }

    public static void main(String[] args) {
        new Main();
    }
}
