package com.putrenkov.liberery.mainstart;


import com.putrenkov.liberery.bookslibrary.Menu;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        start();
    }
    private static void start() {
        Scanner scan = new Scanner(System.in);
        String line = "";
        while (!line.equals("5")) {
            try {
                System.out.println("\n  Input Menu settings: " +
                        "\n  1 - Add author and book" +
                        "\n  2 - Edit author and book" +
                        "\n  3 - Remove author and book" +
                        "\n  4 - Show all author and book" +
                        "\n  5 - Exit");
                line = scan.nextLine();

                if (line.equals("5")) return;

                new Menu().action(line);
            } catch (StringIndexOutOfBoundsException e) {
                e.printStackTrace();
            }
        }
        scan.close();
    }
}
