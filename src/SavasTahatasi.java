public interface SavasTahatasi {
    boolean oyunaBasla(int x, int y,String[][]GizliAlan,String[][]Alan,Player player);
    int batirilanGemi(String[][]Alan);
    boolean oyunBittiMi(String[][]Alan,Player player);
    void ekranaYazdir(String[][]Alan,Player player,Player player2,String[][]Alan2);
    void RandomGemiDoldur(String[][]GizliAlan);

}
