import java.util.Scanner;

class Main {
    public static String isPalindrome(String str) {

        String rev = "";

        for (int i = str.length() - 1; i >= 0; i--) {
            rev = rev + str.charAt(i);

        }
        System.out.println("Kelimenin ters hali: " + rev);

        if (str.equals(rev)) {

            return "Kelime Polindrom";
        }
        return "kelime polindrom degil";
    }

    public static void main(String[] args) {

        Scanner girdi = new Scanner(System.in);
        System.out.print("Lutfen Kelime Giriniz: ");
        String sonuc = girdi.nextLine();
        sonuc = sonuc.toLowerCase();
        String A = isPalindrome(sonuc);
        System.out.println(A);
    }
}