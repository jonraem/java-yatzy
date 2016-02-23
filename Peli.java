import java.util.*;

import java.io.*;

public class Peli implements Serializable {
  public  ArrayList<Pelaaja> pelaajat;
  public int m‰‰r‰;       //pelaajam‰‰r‰
  public int apu;         //laskuapu
  public int kierros;     //kierroksen numero
  
  public Peli() {
    this.m‰‰r‰=0;
    this.apu=1;
    this.kierros=1;
  }
  //pelaajalista
  public ArrayList<Pelaaja> pPelaajat(){
    return pelaajat;
  }
  
  public void aPeli(){
    this.pelaajat=new ArrayList<Pelaaja>();
    //pelaajien lis‰ys
    
    while (apu<5){
      System.out.println("Uuden pelaajan nimi tai aloita peli (jatka).");
      java.util.Scanner abc = new java.util.Scanner(System.in);
      String nimi = abc.next();
      if (nimi.equals("jatka")){
        break;
      }
      else{
        Pelaaja uusi= new Pelaaja (nimi);
        this.pelaajat.add(uusi);
        
        System.out.println("Pelaaja "+pelaajat.get(m‰‰r‰).pNimi()+" liittyi peliin.");
        m‰‰r‰++;}
    }
    System.out.println("Peliss‰ mukana:");
    for (int i=0;i<m‰‰r‰;i++){
      System.out.println(pelaajat.get(i).pNimi());
    }}
  
  
  //heittojen aloitus
  
  public void pelaa(){
    int heittoM‰‰r‰;
    while (kierros<15){
      kierros++;
      
      java.util.Scanner sc = new java.util.Scanner(System.in);
      
      for (int k=0;k<m‰‰r‰;k++){
        System.out.println();
        System.out.println();
        //ensimm‰inen heitto
        heittoM‰‰r‰=0;
        pelaajat.get(k).pKirja().tulosta();
        System.out.println();
        System.out.println("Vuorossa: "+pelaajat.get(k).pNimi());
        pelaajat.get(k).uusiHeitto();
        System.out.print("Heitit: ");
        pelaajat.get(k).pHeitto().tulosta();
        System.out.println();
        
        while (apu<5){        //heiton j‰lkeen
          System.out.println("Sijoita pˆyt‰kirjaan (sijoita) tai valitse uudelleenheitett‰v‰t nopat (vaihda). Viimeisen sallitun uusintaheiton j‰lkeen automaattinen sijoitus. Voit halutessasi myˆs lopettaa pelin (lopeta).");
          heittoM‰‰r‰++;
          String heitot = sc.next();
          
          if (heitot.equals("vaihda")&&heittoM‰‰r‰<3){
            vaihdettavat(k);
            System.out.print("Heitit: ");
            pelaajat.get(k).pHeitto().tulosta();
            System.out.println();
          }
          else if (heitot.equals("lopeta")){
            System.exit(k);
          }
          
          else {
            apu=10;
          }}
        
        //sijoitustila
        System.out.println();
        pelaajat.get(k).pKirja().tulosta();
        System.out.println();
        System.out.print("Tulos: ");
        pelaajat.get(k).pHeitto().tulosta();
        System.out.println();
        System.out.println("Valitse pˆyt‰kirjasta oikea k‰si ja sijoita yl‰osaan (1-6) tai alaosaan (8-16).");
        int indeksi = sc.nextInt();
        pelaajat.get(k).pKirja().asetaArvo(indeksi-1,pelaajat.get(k).pHeitto());
        pelaajat.get(k).pKirja().yl‰Bonus();
        pelaajat.get(k).pKirja().laskeTulos();
        pelaajat.get(k).pKirja().laskeValisumma();
        System.out.println();
        pelaajat.get(k).pKirja().tulosta();
        apu=1;
      }}

  }
  
  //vaihtotila
  public void vaihdettavat(int k){
    System.out.println("Kirjoita uudelleenheitett‰vien noppien indeksit (1-5). Toista arvoja, jos haluat vaihtaa v‰hemm‰n noppia.");
    java.util.Scanner vaihto = new java.util.Scanner(System.in);
    
    boolean yksi=false;
    boolean kaksi=false;
    boolean kolme=false;
    boolean nelj‰=false;
    boolean viisi=false;
    
    for (int a=0;a<5;a++){
      int vaihda = vaihto.nextInt();
      if (vaihda==1){yksi=true;}
      if (vaihda==2){kaksi=true;}
      if (vaihda==3){kolme=true;}
      if (vaihda==4){nelj‰=true;}
      if (vaihda==5){viisi=true;}
    }
    
    pelaajat.get(k).pHeitto().valintaHeitto(yksi,kaksi,kolme,nelj‰,viisi);}
  
  
}