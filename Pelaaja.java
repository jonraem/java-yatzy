import java.io.Serializable;
//rajapinta
public class Pelaaja implements Serializable{
  public int pelaajaNumero;   
  public int laskin =0;    
  public String nimi;
  public PoytaKirja kirja;  //T�m�n sis�ll� hl�kohtaiset pisteet
  public Heitto heitto;   //'Current' heitto
  
  //Uuden pelaajan luominen. Tiedot: nimi ja j�rjestysnumero.
  public Pelaaja(String nimi) {
    laskin++;
    kirja=new PoytaKirja();
    this.pelaajaNumero =laskin;
    this.nimi=nimi;
  }
  
  public PoytaKirja pKirja(){
    return kirja;
  }
  
  public int pNumero(){
    return pelaajaNumero;
  }
  public Heitto pHeitto(){
    return heitto;
  }
  public String pNimi(){
    return nimi;
  }
  public void uusiHeitto(){
    Heitto uusi=new Heitto();
    this.heitto=uusi;
  }
  public void jatkoHeitto(boolean eka,boolean toka,boolean kolmas,boolean nelj�s,boolean viides){
    heitto.valintaHeitto(eka,toka,kolmas,nelj�s,viides);
  }
  
  //heiton lis��minen haluttuun kohtaan
  public void lisaaTulos(int kohta){
    kirja.asetaArvo(kohta,heitto);   
  }  
}