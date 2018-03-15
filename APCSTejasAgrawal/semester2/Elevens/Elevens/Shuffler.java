/**
 * This class provides a convenient way to test shuffling methods.
 */

import java.util.Random;

public class Shuffler {

    /**
     * The number of consecutive shuffle steps to be performed in each call
     * to each sorting procedure.
     */
    private static final int SHUFFLE_COUNT = 4;

    /**
     * The number of values to shuffle.
     */
    private static final int VALUE_COUNT = 52;

    /**
     * Tests shuffling methods.
     * @param args is not used.
     */
    public static void main(String[] args) {
        System.out.println("Results of " + SHUFFLE_COUNT +
            " consecutive perfect shuffles:");
        int[] values1 = new int[VALUE_COUNT];
        for (int i = 0; i < values1.length; i++) {
            values1[i] = i;
        }
        for (int j = 1; j <= SHUFFLE_COUNT; j++) {
            values1 = perfectShuffle(values1);
            System.out.print("  " + j + ":");
            for (int k = 0; k < values1.length; k++) {
                System.out.print(" " + values1[k]);
            }
            System.out.println();
        }
        System.out.println();

        System.out.println("Results of " + SHUFFLE_COUNT +
            " consecutive efficient selection shuffles:");
        int[] values2 = new int[VALUE_COUNT];
        for (int i = 0; i < values2.length; i++) {
            values2[i] = i;
        }
        for (int j = 1; j <= SHUFFLE_COUNT; j++) {
            selectionShuffle(values2);
            System.out.print("  " + j + ":");
            for (int k = 0; k < values2.length; k++) {
                System.out.print(" " + values2[k]);
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Apply a "perfect shuffle" to the argument.
     * The perfect shuffle algorithm splits the deck in half, then interleaves
     * the cards in one half with the cards in the other.
     * @param values is an array of integers simulating cards to be shuffled.
     */
    public static int[] perfectShuffle(int[] values) {
        /* *** TO BE IMPLEMENTED IN ACTIVITY 3 *** */

        //int cards[] = new int[52];
        //cards = values;

        int shuffled[] = new int[52];
        int k = 0;

        for (int j = 0; j < 26; j++) {
            shuffled[k] = values[j];
            k += 2;
        }

        k = 1;
        for (int j = 26; j < 52; j++) {
            shuffled[k] = values[j];
            k += 2;
        }

        values = shuffled;
        
        return values;
    }

    /**
     * Apply an "efficient selection shuffle" to the argument.
     * The selection shuffle algorithm conceptually maintains two sequences
     * of cards: the selected cards (initially empty) and the not-yet-selected
     * cards (initially the entire deck). It repeatedly does the following until
     * all cards have been selected: randomly remove a card from those not yet
     * selected and add it to the selected cards.
     * An efficient version of this algorithm makes use of arrays to avoid
     * searching for an as-yet-unselected card.
     * @param values is an array of integers simulating cards to be shuffled.
     */
    public static void selectionShuffle(int[] values) {
        /* *** TO BE IMPLEMENTED IN ACTIVITY 3 *** */

        //int cards[] = new int[52];
        //cards = values;

        //int shuffled[] = new int[52];
        Random generator = new Random();
        int temp;

        for (int k = 51; k > 0; k--) {
            int r = generator.nextInt(52);
            temp = values[k];                    //temp has stored original card
            values[k] = values[r];                //original card is replaced by new card
            values[r] = temp;                    //original card is stored in new card spot
        }

        
    }
}
