import java.util.*;

import java.io.*;

public class PoytaKirja implements Serializable {
  ArrayList<Sarake> kirja;
  
//pöytäkirja tehtävineen
  public PoytaKirja() {
    kirja=new ArrayList<Sarake>();
    kirja.add(new Sarake("Ykköset         ",1));
    kirja.add(new Sarake("Kakkoset        ",2));
    kirja.add(new Sarake("Kolmoset        ",3));
    kirja.add(new Sarake("Neloset         ",4));
    kirja.add(new Sarake("Viitoset        ",5));
    kirja.add(new Sarake("Kuutoset        ",6));
    kirja.add(new Sarake("YLÄOSAN SUMMA   ",7));
    kirja.add(new Sarake("Yksi pari       ",8));
    kirja.add(new Sarake("Kaksi paria     ",9));
    kirja.add(new Sarake("Kolme samaa    ",10));
    kirja.add(new Sarake("Neljä samaa    ",11));
    kirja.add(new Sarake("Pieni suora    ",12));
    kirja.add(new Sarake("Iso suora      ",13));
    kirja.add(new Sarake("Täyskäsi       ",14));
    kirja.add(new Sarake("Sattuma        ",15));
    kirja.add(new Sarake("Jatsi          ",16));
    kirja.add(new Sarake("KOKONAISTULOS  ",17));
    
  }
  
//pöytäkirjan tulostaminen heiton jälkeen
  public void tulosta(){
    for (int i=0;i<kirja.size();i++){
      System.out.print(kirja.get(i).pKohta()+" ");
      System.out.print(kirja.get(i).pNimi()+" ");
      System.out.print(kirja.get(i).pArvo()+" ");
      System.out.println(kirja.get(i).pAsetettu()+" ");
    }
  }
  
//arvojen asettaminen pöytäkirjaan
  public void asetaArvo(int kohta,Heitto heitto){
    if (kirja.get(kohta).pAsetettu()==true){ //kohde jo käytetty
      System.out.println("Kohde käytetty. Valitse uusi indeksi");
      java.util.Scanner sc = new java.util.Scanner(System.in);
      int indeksi = sc.nextInt();
      kohta=indeksi-1;
      asetaArvo(kohta,heitto);}
    
    else if (kirja.get(kohta).pKohta()==7){ //välisummavirhe
      System.out.println("Et voi lisätä käden pistemäärää suoraan yläosan välisummaan. Valitse uusi indeksi.");
      java.util.Scanner sc = new java.util.Scanner(System.in);
      int indeksi = sc.nextInt();
      kohta=indeksi-1;
      asetaArvo(kohta,heitto);}

    else if (kirja.get(kohta).pKohta()==17){ //kokonaistulosvirhe
      System.out.println("Et voi lisätä käden pistemäärää suoraan kokonaistulokseen. Valitse uusi indeksi.");
      java.util.Scanner sc = new java.util.Scanner(System.in);
      int indeksi = sc.nextInt();
      kohta=indeksi-1;
      asetaArvo(kohta,heitto);}
    
    else {
      kirja.get(kohta).asetaArvot(heitto);
    }}
  
//yläosan bonuksen lisääminen kokonaissummaan
  public void yläBonus(){
    if (kirja.get(0).pArvo()+kirja.get(1).pArvo()+kirja.get(2).pArvo()+kirja.get(3).pArvo()+kirja.get(4).pArvo()+kirja.get(6).pArvo()>62){
      kirja.get(7).laskeBonus();
      
      
    }}
  //kokonaistuloksen laskeminen
  public void laskeTulos(){
    int tulos=0;
    for (int r=0;r<16;r++){
      tulos+= kirja.get(r).pArvo();
    }
    kirja.get(16).asetaTulos(tulos);
  }
  //välisumman laskeminen
  public void laskeValisumma(){
    int tulos=0;
    for (int r=0;r<6;r++){
      tulos+= kirja.get(r).pArvo();
    }
    kirja.get(6).asetaTulos(tulos);
  }}