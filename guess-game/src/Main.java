import java.util.Scanner;


public class Main {

    public static void selectionSortDesc(int[] intArr, String[] strArr) {

        int size = intArr.length;
        for (int i = 0 ;i < size - 1; i++){
            int min = i;
            for (int j = i + 1; j< size; j++){
                if (intArr[j] > intArr[min]){
                    min = j;
                }
            }
            int temp = intArr[min];
            String tempStr = strArr[min];

            intArr[min] = intArr[i];
            strArr[min] = strArr[i];

            strArr[i] = tempStr;
            intArr[i] = temp;
        }

    }

    public static boolean guessNumber(int randomNumber, Scanner scanner) {

        int numberOfGuessRightsPerPlay = 4;

        for (int j = 0; j < numberOfGuessRightsPerPlay; j++) {
            int guess = scanner.nextInt();
            while (guess < 1 || guess > 100) {
                System.out.println("Lütfen 1 ile 100 arasında bir sayı giriniz!");
                guess = scanner.nextInt();
            }
            if (randomNumber == guess) {
                System.out.println("Doğru Tahmin");
                return true;
            } else if (guess > randomNumber) {
                System.out.println("Lütfen daha küçük bir sayı giriniz.");
            } else {
                System.out.println("Lütfen daha büyük bir sayı giriniz.");
            }
        }
        System.out.println("Sayıyı tahmin edemediniz :/");
        return false;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Oyun başlıyor...");

        int numberOfPlayers = 2;
        int numberOfPlays = 2;
        int[] playersRightGuessNumbers = new int[numberOfPlayers];
        int[] playersWrongGuessNumbers = new int[numberOfPlayers];
        String[] playerNames = new String[numberOfPlayers];

        System.out.println("Oyuncu isimlerini giriniz: ");
        for (int i = 0; i < numberOfPlayers; i++) {
            playerNames[i] = scanner.nextLine();
        }

        for (int i = 0; i < numberOfPlays; i++) {

            System.out.println(i + 1 + ". oyun...");

            for (int j = 0; j < numberOfPlayers; j++) {

                System.out.println("Sıradaki " + (j + 1) + ". oyuncu: ");
                int randomNumber = (int) (Math.random() * 100 + 1);
                System.out.println("Lütfen bir tahmin yap: ");
                if (guessNumber(randomNumber, scanner)) {
                    ++playersRightGuessNumbers[j];
                } else {
                    ++playersWrongGuessNumbers[j];
                }
                System.out.println("--------------------------------");
            }

            System.out.println("--------------------------------");

        }

        System.out.println("Oyun bitti.");
        System.out.println("Skor tablosu: ");

        System.out.println("           D | Y");
        System.out.println("---------|---|---|------");
        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.format("%-8s | " + playersRightGuessNumbers[i]
                    + " | " + playersWrongGuessNumbers[i] + " | %n", (playerNames[i]));
            System.out.println("---------|---|---|------");
        }


        System.out.println();
        selectionSortDesc(playersRightGuessNumbers, playerNames);
        System.out.println("Skora göre sıralama: ");
        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.println(i + 1 + ". oyuncu: " + playerNames[i]);
        }


        scanner.close();
    }
}