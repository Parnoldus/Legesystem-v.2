public class Pasient {

  private String navn;
  private String foedselsnr;
  private int unikID;
  private static int idTeller;
  Stabel<Resept> reseptliste = new Stabel<Resept>();

  public Pasient(String n, String fnr) {
    navn = n;
    foedselsnr = fnr;
    unikID = idTeller;
    idTeller++;
  }

  public String hentNavn() {
    return navn;
  }

  public int hentID() {
    return unikID;
  }

  public String hentNavnOgFdn(){
    return navn + "," + foedselsnr;
  }

  public void leggTilResept(Resept r){
    reseptliste.leggPaa(r);
  }

  /*
    Itererer gjennom listen over pasientens resepter og summerer det totale
    antallet resepter paa narkotiske legemidler.
    @return antallet resepter paa narkotiske legemidler
  **/
  public int antNarkResepter() {
    int antNarkResepter = 0;
    for (Resept r : reseptliste) {
      if (r.hentLegemiddel() instanceof Narkotisk) {
        antNarkResepter++;
      }
    }
    return antNarkResepter;
  }

  public Stabel<Resept> hentReseptListe() {
    return reseptliste;
  }

  public boolean harNarkResepter() {
    boolean harNarkRes =false;
    for (Resept r : reseptliste) {
      if (r.hentLegemiddel() instanceof Narkotisk) {
        harNarkRes=true;
      }
    }
    return harNarkRes;
  }

  public void skrivResepter(){
    for (Resept r : reseptliste){
      System.out.println(r);
    }
  }

  // paal kommentar: oppgaven ber om aa bruke samme format som i innfilen
  @Override
  public String toString() {
    return navn + "," + foedselsnr;
  }
}
