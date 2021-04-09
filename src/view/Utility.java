package view;

import java.util.*;
/**
 * 
 * @Description read input from keyboard; provide direct feedback
 *
 */
public class Utility {
    private static Scanner scanner = new Scanner(System.in);
    /**
     * 
     * @Description read 1- 4 from keyboard
     */
	public static char readMenuSelection() {
        char c;
        for (; ; ) {
            String str = readKeyBoard(1, false);
            c = str.charAt(0);
            if (c != '1' && c != '2' &&
                c != '3' && c != '4') {
                System.out.print("Please input a valid selection: ");
            } else break;
        }
        return c;
    }
	/**
	 * 
	 * @Description hint the user to continue
	 */
    public static void readReturn() {
        System.out.print("Press Enter to continue...");
        readKeyBoard(100, true);
    }
    /**
     * 
     * @Description read a two-digit integer from keyboard, and return it
     */
    public static int readInt() {
        int n;
        for (; ; ) {
            String str = readKeyBoard(2, false);
            try {
                n = Integer.parseInt(str);
                break;
            } catch (NumberFormatException e) {
                System.out.print("Please input a valid number:");
            }
        }
        return n;
    }
    /**
     * 
     * @Description Read Y or N
     */
    public static char readConfirmSelection() {
        char c;
        for (; ; ) {
            String str = readKeyBoard(1, false).toUpperCase();
            c = str.charAt(0);
            if (c == 'Y' || c == 'N') {
                break;
            } else {
                System.out.print("Please input \"Y\" or \"N\"");
            }
        }
        return c;
    }

    private static String readKeyBoard(int limit, boolean blankReturn) {
        String line = "";

        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            if (line.length() == 0) {
                if (blankReturn) return line;
                else continue;
            }

            if (line.length() < 1 || line.length() > limit) {
                System.out.print("The input limitation is " + limit + ", please try again:");
                continue;
            }
            break;
        }

        return line;
    }
}

