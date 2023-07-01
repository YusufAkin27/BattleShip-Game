import java.util.Scanner;

public class Main {
 static    Oyun oyun = new Oyun();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1--> bilgisayara karşı ");
        System.out.println("2--> iki kişilik ");
        int secim = scanner.nextInt();
        switch (secim) {
            case 1:
                oyun.OyunaBaşlaBilgisayar();
                break;
            case 2:
                oyun.OyunaBaşlaKarşlıklı();
                break;
            default:
                System.out.println("hatalı tuşlama yaptınız tekrardan bir değer giriniz");
                secim = scanner.nextInt();
                break;
        }

    }
}