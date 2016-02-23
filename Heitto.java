import java.util.*;

import java.io.Serializable;

//rajapinta
public class Heitto implements Serializable{
  public ArrayList<Integer> tulos;
  Random generator = new Random();
  
  //Nopat heitet‰‰n
  public Heitto() {
    tulos=new ArrayList<Integer>();
    tulos.add(generator.nextInt(6)+1);
    tulos.add(generator.nextInt(6)+1);
    tulos.add(generator.nextInt(6)+1);
    tulos.add(generator.nextInt(6)+1);
    tulos.add(generator.nextInt(6)+1);
    Collections.sort(tulos);
  }
  
  //heit‰ valitut uudestaan
  public void valintaHeitto(boolean eka,boolean toka,boolean kolmas,boolean nelj‰s,boolean viides){
    if (eka==true){
      tulos.set(0,generator.nextInt(6)+1);
    }
    if (toka==true){
      tulos.set(1,generator.nextInt(6)+1);
    }
    if (kolmas==true){
      tulos.set(2,generator.nextInt(6)+1);
    }
    if  (nelj‰s==true){
      tulos.set(3,generator.nextInt(6)+1);
    }
    if (viides==true){
      tulos.set(4,generator.nextInt(6)+1);
    }
    Collections.sort(tulos);
  }
  
  //Palauttaa tuloksen arrayListin‰
  public ArrayList<Integer> pTulos(){
    return tulos;
  }//noppien tulostus
  public void tulosta(){
    System.out.print(tulos.get(0)+" ");
    System.out.print(tulos.get(1)+" ");
    System.out.print(tulos.get(2)+" ");
    System.out.print(tulos.get(3)+" ");
    System.out.println(tulos.get(4)+" ");
  }
  
  
}