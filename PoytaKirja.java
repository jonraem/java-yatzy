import java.util.*;

import java.io.*;

public class PoytaKirja implements Serializable {
  ArrayList<Sarake> kirja;
  
//p�yt�kirja teht�vineen
  public PoytaKirja() {
    kirja=new ArrayList<Sarake>();
    kirja.add(new Sarake("Ykk�set         ",1));
    kirja.add(new Sarake("Kakkoset        ",2));
    kirja.add(new Sarake("Kolmoset        ",3));
    kirja.add(new Sarake("Neloset         ",4));
    kirja.add(new Sarake("Viitoset        ",5));
    kirja.add(new Sarake("Kuutoset        ",6));
    kirja.add(new Sarake("YL�OSAN SUMMA   ",7));
    kirja.add(new Sarake("Yksi pari       ",8));
    kirja.add(new Sarake("Kaksi paria     ",9));
    kirja.add(new Sarake("Kolme samaa    ",10));
    kirja.add(new Sarake("Nelj� samaa    ",11));
    kirja.add(new Sarake("Pieni suora    ",12));
    kirja.add(new Sarake("Iso suora      ",13));
    kirja.add(new Sarake("T�ysk�si       ",14));
    kirja.add(new Sarake("Sattuma        ",15));
    kirja.add(new Sarake("Jatsi          ",16));
    kirja.add(new Sarake("KOKONAISTULOS  ",17));
    
  }
  
//p�yt�kirjan tulostaminen heiton j�lkeen
  public void tulosta(){
    for (int i=0;i<kirja.size();i++){
      System.out.print(kirja.get(i).pKohta()+" ");
      System.out.print(kirja.get(i).pNimi()+" ");
      System.out.print(kirja.get(i).pArvo()+" ");
      System.out.println(kirja.get(i).pAsetettu()+" ");
    }
  }
  
//arvojen asettaminen p�yt�kirjaan
  public void asetaArvo(int kohta,Heitto heitto){
    if (kirja.get(kohta).pAsetettu()==true){ //kohde jo k�ytetty
      System.out.println("Kohde k�ytetty. Valitse uusi indeksi");
      java.util.Scanner sc = new java.util.Scanner(System.in);
      int indeksi = sc.nextInt();
      kohta=indeksi-1;
      asetaArvo(kohta,heitto);}
    
    else if (kirja.get(kohta).pKohta()==7){ //v�lisummavirhe
      System.out.println("Et voi lis�t� k�den pistem��r�� suoraan yl�osan v�lisummaan. Valitse uusi indeksi.");
      java.util.Scanner sc = new java.util.Scanner(System.in);
      int indeksi = sc.nextInt();
      kohta=indeksi-1;
      asetaArvo(kohta,heitto);}

    else if (kirja.get(kohta).pKohta()==17){ //kokonaistulosvirhe
      System.out.println("Et voi lis�t� k�den pistem��r�� suoraan kokonaistulokseen. Valitse uusi indeksi.");
      java.util.Scanner sc = new java.util.Scanner(System.in);
      int indeksi = sc.nextInt();
      kohta=indeksi-1;
      asetaArvo(kohta,heitto);}
    
    else {
      kirja.get(kohta).asetaArvot(heitto);
    }}
  
//yl�osan bonuksen lis��minen kokonaissummaan
  public void yl�Bonus(){
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
  //v�lisumman laskeminen
  public void laskeValisumma(){
    int tulos=0;
    for (int r=0;r<6;r++){
      tulos+= kirja.get(r).pArvo();
    }
    kirja.get(6).asetaTulos(tulos);
  }}