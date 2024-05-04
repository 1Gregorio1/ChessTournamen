import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("Введите колличество игроков:");
        int numberOfPlayers = Integer.parseInt(console.nextLine());
        System.out.print("Введите колличество раундов:");
        int numberOfRounds = Integer.parseInt(console.nextLine());
        String players[][] = new String[numberOfPlayers][4];

        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.print("Введите имя игрока " + (i + 1) + ": "  );
            players[i][0] = i + 1 + "";
            players[i][1] = console.nextLine();
            players[i][2] = "0";
        }
        firstFigth(players);
        enteringResults(players, console);
        renderTheTable(players);
        int round = 2;
        while (numberOfRounds - 1 > 0) {
            Figths(players, round++);
            enteringResults(players, console);
            renderTheTable(players);
            numberOfRounds--;
        }
        console.close();
    }

    static String lengthName(String str, int lengthString) {
        for (int i = str.length(); i < lengthString; i++) {
            str += " ";
        }
        return str;
    }

    public static void renderTheTable(String[][] arr) {
        String[][] tableArr = arr;
        String dash = "_____________________________________________________";
        String tableHeader = "| Id | Имя Игрока          | Очки | Коэф. Бухгольца |";
        System.out.println(dash);
        System.out.println(tableHeader);
        System.out.println(dash);
        //Arrays.sort(arr,(a,b)->a[2]-b[2]);
        for (int i = 0; i < tableArr.length; i++) {
            String str;
            if (i < 10) {
                str = "|  ";
            } else {
                str = "| ";
            }
            String namePlayer = lengthName(tableArr[i][1], 20);
            String pointPlayer = lengthName(tableArr[i][2], 5);
            System.out.println(str + tableArr[i][0] +  " | " + namePlayer + "| " + pointPlayer + "|");
            System.out.println(dash);
        }
    }

    static void firstFigth (String[][] players) {
        int countPlayers = players.length;
        mixingPlayers(players);
        System.out.println("");
        System.out.println();
        System.out.println("Пары первого раунда");
        if (countPlayers % 2 == 0) {
            for (int i = 0; i < countPlayers; i = i + 2) {
                System.out.println(players[i][1] + " - " + players[i+1][1]);
                players[i][3] = players[i+1][0] + ",";
                players[i+1][3] = players[i][0] + ",";
            }
        } else {
            for (int i = 0; i < countPlayers - 1; i = i + 2) {
                System.out.println(players[i][1] + " - " + players[i+1][1]);
                players[i][3] = players[i+1][0] + ",";
                players[i+1][3] = players[i][0] + ",";
            }
            System.out.println(players[countPlayers - 1][1] + " - BeY");
        }

    }

    static void Figths (String[][] players, int round) {
        int countPlayers = players.length;
        System.out.println("");
        System.out.println();
        String nameRound;
            switch (round) {
                case 2:
                    nameRound = "второго";
                    break;
                case 3:
                    nameRound = "третьего";
                    break;
                case 4:
                    nameRound = "четвертого";
                    break;
                case 5:
                    nameRound = "пятого";
                    break;
                case 6:
                    nameRound = "шестого";
                    break;
                case 7:
                    nameRound = "седьмого";
                    break;
                case 8:
                    nameRound = "восьмого";
                    break;
                case 9:
                    nameRound = "девятого";
                    break;
                case 10:
                    nameRound = "десятого";
                    break;
                default:
                    nameRound = "последующего";
                    break;
        }

        System.out.println("Пары " + nameRound + " раунда");
        if (countPlayers % 2 == 0) {
            for (int i = 0; i < countPlayers; i = i + 2) {
                System.out.println(players[i][1] + " - " + players[i+1][1]);
                players[i][3] = players[i+1][0] + ",";
                players[i+1][3] = players[i][0] + ",";
            }
        } else {
            for (int i = 0; i < countPlayers - 1; i = i + 2) {
                System.out.println(players[i][1] + " - " + players[i+1][1]);
                players[i][3] = players[i+1][0] + ",";
                players[i+1][3] = players[i][0] + ",";
            }
            System.out.println(players[countPlayers - 1][1] + " - BeY");
        }

    }
    static void mixingPlayers (String[][] players) {
        Random rnd = new Random();
        for (int i = players.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            String[] temp = players[index];
            players[index] = players[i];
            players[i] = temp;
        }

    }
    static void enteringResults (String[][] players, Scanner console) {
        System.out.println("Введите результаты матчей в формате '1 - 0'/'0.5'");
        for (int i = 0; i < players.length / 2; i++) {
            System.out.print("Введите результат матча " + (i + 1) + ": ");
            String result = console.nextLine();
            if (result.equals("0.5")) {
                players[i*2][2] = String.valueOf(Double.parseDouble(players[i*2][2]) + 0.5);
                players[i*2 + 1][2] = String.valueOf(Double.parseDouble(players[i*2+1][2]) + 0.5);
            } else {
                if (result.charAt(0) == '1'){
                    players[i*2][2] = String.valueOf(Double.parseDouble(players[i*2][2]) + 1);
                } else {
                    players[i*2 + 1][2] = String.valueOf(Double.parseDouble(players[i*2+1][2]) + 1);
                }
            }
        }
        shiftOfPositions(players);
    }
     static void shiftOfPositions (String[][] players) {
        String[] itemZero = players[0];
        for (int i = 0; i < players.length - 1; i++) {
            players[i] = players[i+1];
        }
        players[players.length - 1] = itemZero;
     }


}