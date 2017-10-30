package src.main;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by rkore on 10/9/2017.
 */


public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void printMenu(){
        System.out.println("Sveiki atvyke prie kavos aparato, pasirinkite funkcija:" +
                "\n 0 - meniu" +
                "\n 1 - padaryti kavos" +
                "\n 2 - kiek ko yra?" +
                "\n 3 - papildyti produktus/puodukus"+
                "\n 4 - isvalyti aparata" +
                "\n 5 - iseiti");
    }

    public static void printConsumablesManu(){
        System.out.println("Pasirinkite, ka noretumete papildyti:" +
                        "\n 1 - papildyti kavos" +
                        "\n 2 - papildyti cukraus" +
                        "\n 3 - papildyti vandens" +
                        "\n 4 - papildyti pieno milteliu"+
                        "\n 5 - papildyti sokolado" +
                        "\n 6 - papildyti puodeliu"+
                        "\n 7 - papildyti viska" +
                        "\n 8 - iseiti");
    }

    public static void lounchInnerSwitch (CoffeMachine coffeMachine) {
        int innerChoice = 0;
        boolean innerquit = false;
        printConsumablesManu();
        while (!innerquit) {
            boolean procceed2 = true;
            do {
                try {
                    innerChoice = scanner.nextInt();
                    procceed2 = false;
                } catch (InputMismatchException e) {
                    scanner.next();
                    System.out.println("Siam Ivedimui prasau naudoti skaitmenis");
                }

            } while (procceed2);

            switch (innerChoice) {
                case 1:
                    System.out.println("Kiek kavos pildysite?");
                    int coffe = scanner.nextInt();
                    coffeMachine.fillCoffe(coffe);
                    break;
                case 2:
                    System.out.println("Kiek cukraus pildysite?");
                    int sugar = scanner.nextInt();
                    coffeMachine.fillSugar(sugar);
                    break;
                case 3:
                    System.out.println("Kiek vandens pildysite?");
                    double water = scanner.nextDouble();
                    coffeMachine.fillWater(water);
                    break;
                case 4:
                    System.out.println("Kiek pieno pildysite?");
                    int milk = scanner.nextInt();
                    coffeMachine.fillMilk(milk);
                    break;
                case 5:
                    System.out.println("Kiek sokolado pildysite?");
                    int chocolate = scanner.nextInt();
                    coffeMachine.fillChocolate(chocolate);
                    break;
                case 6:
                    coffeMachine.fillAllCups();
                    System.out.println("Visu puodeliu papildyta iki maksimumo");
                    break;
                case 7:
                    coffeMachine.fillAllToMax();
                    System.out.println("Visko papildyta, siuo metu yra:");
                    coffeMachine.querryProd();
                    break;
                case 8:
                    innerquit = true;
                    printMenu();
                    break;
            }
        }
    }

    public static void main(String[] args) {
        CoffeMachine manoKavosAparatas = new CoffeMachine("Prolific",100,200,3,100,100,10,20,10
        );

        int choise = 0;
        boolean quit = false;

        printMenu();

        while (!quit){
            boolean proceed = true;
            do{
                 try {
                    choise = scanner.nextInt();
                    proceed = false;
                 }catch (InputMismatchException e){
                     scanner.next();
                     System.out.println("Ivedimui prasau naudoti skaitmenis");
                 }

            }while (proceed);

            switch (choise){
                case 0:
                    printMenu();
                    break;
                case 1:
                    System.out.println("Pasirinkite: " +
                            "\n 1 - Espresso" +
                            "\n 2 - Juoda Amerikietiska" +
                            "\n 3 - Vanduo su Cukrumi" +
                            "\n 4 - Capucino");
                    int recepyIndex=0;
                    boolean proceed3 = true;
                    do{
                        try {
                            recepyIndex = scanner.nextInt();
                            proceed3 = false;
                        }catch (InputMismatchException e){
                            scanner.next();
                            System.out.println("Ivedimui prasau naudoti skaitmenis");
                        }

                    }while (proceed3);

                    manoKavosAparatas.makeCoffe(recepyIndex);
                    break;
                case 2:
                    manoKavosAparatas.querryProd();
                    break;
                case 3:
                    lounchInnerSwitch(manoKavosAparatas);
                    break;
                case 4:
                    manoKavosAparatas.clearAparatus();
                    break;
                case 5:
                    quit = true;
                    break;

            }

        }

    }
}
