import java.util.Random;
import java.util.Scanner;

public class Oyun extends Game {
    private String[][] Alan = new String[10][10];
    private final String[][] GizliAlan = new String[10][10];
    private String[][] Alan2 = new String[10][10];
    private final String[][] GizliAlan2 = new String[10][10];
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    Player player = new Player();
    Player player2 = new Player();

    Game game = new Game();

    public void OyunaBaşlaKarşlıklı() {

        System.out.println("kullanıcı 1  adınızı giriniz");
        String name = scanner.next();
        player.setName(name);
        System.out.println("kullanıcı 2 adınızı giriniz ");
        String name2 = scanner.next();
        player2.setName(name2);
        game.RandomGemiDoldur(GizliAlan2);
        game.RandomGemiDoldur(GizliAlan);
        game.ekranaYazdir(Alan, player, player2, Alan2);
        try {
            Thread.sleep(1000); // 1000 milisaniye (1 saniye) boyunca bekleyin
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        kullaniciOynuyor(player);
    }

    public void OyunaBaşlaBilgisayar() {
        Player player = new Player();
        Player player2 = new Player();
        System.out.println("kullanıcı adınızı giriniz");
        String name = scanner.next();
        player.setName(name);
        player2.setName("bilgisayar");

        //bilgisayarın gemileri random yerleştirildi
        game.RandomGemiDoldur(GizliAlan2);
        // kullanıcının gemileri random yerleştirildi
        game.RandomGemiDoldur(GizliAlan);
        System.out.println(" savaş alanı gemileri dolduruldu");
        //bilgisayarın savas alanı ekrana yazıldı ilk oyunu kullanıcı başlıyor
        game.ekranaYazdir(Alan, player, player2, Alan2);
        try {
            Thread.sleep(1000); // 1000 milisaniye (1 saniye) boyunca bekleyin
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        kullaniciOynuyor(player2);


    }


    public void kullaniciOynuyor(Player oyuncu) {
        boolean devam;
        int x, y;
        int batirilangemi = game.batirilanGemi(Alan2);
        while (batirilangemi <= 14) {
            System.out.println("oyun sırası  "+oyuncu.getName()+"  kullanıcıda");
            System.out.println("x degerini giriniz");
            y = scanner.nextInt();
            System.out.println("y degerini giriniz");
            x = scanner.nextInt();
            //burada oyuna başlarken rakibin savas alanı giriliyor vs
            devam = game.oyunaBasla(x, y, GizliAlan2, Alan2, oyuncu);
            //ekrana savas alanı yazdırılıyor
            game.ekranaYazdir(Alan, oyuncu, player2, Alan2);
            try {
                Thread.sleep(1000); // 3 saniye boyunca bekle
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (game.oyunBittiMi(Alan2, oyuncu)) {
                //burada kontrol ediyo eger oyun bitiyse code burada biticek
                break;
            }
            if (devam == false) {
                System.out.println("oyun rakibe geçti");
                rakipOynuyor(player2);
            }
        }
    }

    public void rakipOynuyor(Player oyuncu2) {

        int x, y;
        boolean devam;

        int batirilangemi = game.batirilanGemi(Alan);
        while (batirilangemi <= 15) {

            if(oyuncu2.getName().equals("bilgisayar")){
                x = random.nextInt(10);
                y = random.nextInt(10);
                System.out.println("bilgisayar oynuyor");
                System.out.println("(" + y + "," + x + ") noktasını seçti");
            }
            else {
                System.out.println("oyun sırası  "+oyuncu2.getName()+"  kullanıcıda");
                System.out.println("x noktasını giriniz");
                y=scanner.nextInt();
                System.out.println("y noktasını giriniz");
                x=scanner.nextInt();
            }
            devam = game.oyunaBasla(x, y, GizliAlan, Alan, oyuncu2);
            if (game.oyunBittiMi(Alan, oyuncu2)) {
                break;
            }
            game.ekranaYazdir(Alan, player, oyuncu2, Alan2);
            try {
                Thread.sleep(1000); // 3 saniye bekle
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (devam == false) {
                kullaniciOynuyor(player);
            }
        }
    }

}

