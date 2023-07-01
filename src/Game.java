import java.util.Random;

public class Game implements SavasTahatasi {


    @Override
    public boolean oyunaBasla(int x, int y, String[][] GizliAlan, String[][] Alan, Player player) {
        if (x <= 0 || y <= 0 || x > 10 || y > 10) {
            System.out.println("hatalı bir nokta seçtiniz");
            return true;
        }
        if (Alan[x][y] == null) {
            Alan[x][y] = "";
        }
        if (Alan[x][y].equals("#")) {
            System.out.println("önceden işaretlenmiş nokta seçtiniz");
            return true;
        }
        if (GizliAlan[x][y].equals("X")) {
            System.out.println("gemiyi vurdunuz tebrikler");
            Alan[x][y] = "X";
            oyunBittiMi(Alan, player);
            return true; // değişiklik yapıldı
        }
        System.out.println("işaretlediğiniz noktada gemi bulunmamakta");
        Alan[x][y] = "#";
        return false;
    }


    @Override
    public int batirilanGemi(String[][] Alan) {
        int n = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (Alan[i][j] != null && Alan[i][j].equals("X")) {
                    n++;
                }
            }
        }
        return n;
    }

    @Override
    public boolean oyunBittiMi(String[][] Alan, Player player) {
        int n = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (Alan[i][j] != null && Alan[i][j].equals("X")) {
                    n = n + 1;
                }
            }
        }
        if (n == 15) {
            System.out.println("Tüm gemileri vurdunuz! Oyun bitti.");
            System.out.println("oyunu " + player.getName() + "kazandi");
            return true;
        }
        return false;
    }

    @Override
    public void ekranaYazdir(String[][] alan1, Player player1, Player player2, String[][] alan2) {
        System.out.println();
        System.out.println("\t\t\t"+"\033[0;32m" + player1.getName() + " SAVAŞ ALANI" +
                "\033[0m\t\t\t" +"\t\t\t\t\t\t\t\t\t"+ "\033[0;32m" + player2.getName() + " SAVAŞ ALANI" + "\033[0m");
        System.out.print("  ");
        for (int i = 0; i < 10; i++) {
            System.out.print(" \033[0;33m" + i + "   " + "\033[0m");
        }
        System.out.print("\t\t\t"+"  ");
        for (int i = 0; i < 10; i++) {
            System.out.print(" \033[0;33m" + i + "   " + "\033[0m");
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            System.out.print("\033[0;33m" + i + " " + "\033[0m");
            for (int j = 0; j < 10; j++) {
                if (alan1[i][j] == null) {
                    alan1[i][j] = "";
                }
                String value1 = alan1[i][j];
                if (value1.equals("X")) {
                    System.out.print("\033[0;31m" + "[" + value1 + " ]" + " " + "\033[0m");
                } else if (value1.equals("#")) {
                    System.out.print("\033[0;34m" + "[ " + value1 + "]" + " " + "\033[0m");
                } else {
                    System.out.print("\033[0;32m" + "[ " + value1 + " ]" + " " + "\033[0m");
                }
            }
            System.out.print("\t\t\t");
            System.out.print("\033[0;33m" + i + " " + "\033[0m");
            for (int j = 0; j < 10; j++) {
                if (alan2[i][j] == null) {
                    alan2[i][j] = "";
                }
                String value2 = alan2[i][j];
                if (value2.equals("X")) {
                    System.out.print("\033[0;31m" + "[" + value2 + " ]" + " " + "\033[0m");
                } else if (value2.equals("#")) {
                    System.out.print("\033[0;34m" + "[ " + value2 + "]" + " " + "\033[0m");
                } else {
                    System.out.print("\033[0;33m" + "[ " + value2 + " ]" + " " + "\033[0m");
                }

            }
            System.out.println();
        }
        System.out.print("  ");
        for (int i = 0; i < 10; i++) {
            System.out.print(" \033[0;33m" + i + "  " + "\033[0m");
        }
        System.out.println();
    }





    @Override
    public void RandomGemiDoldur(String[][] GizliAlan) {
        int gemiSayisi = 14;
        Random random = new Random();
        int x, y;

        // Tüm matris elemanları için rastgele x ve y değerleri ataması yapılıyor.
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                x = random.nextInt(10);
                y = random.nextInt(10);
                if (GizliAlan[i][j] == null) {
                    GizliAlan[i][j] = "";
                }
            }
        }

        // Belirtilen sayıda gemi rastgele yerleştiriliyor.
        while (gemiSayisi > 0) {
            x = random.nextInt(10);
            y = random.nextInt(10);
            if (GizliAlan[x][y] == null || !GizliAlan[x][y].equals("X")) {
                GizliAlan[x][y] = "X";
                gemiSayisi--;
            }
        }
        System.out.println("random 14 gemi yerleştirildi");
    }


}

