import java.io.*;

public class Sarake implements Serializable{
  public int arvo;         //sarakkeen arvo
  public String nimi;      //sarakkeen nimi
  public boolean asetettu; //onko jo asetettu
  public int kohta;        //sarakkeen järjestysnro
  
  
  public Sarake(String nimi,int kohta) {
    
    this.kohta=kohta;
    this.nimi=nimi;
  }
  public int pArvo(){
    return arvo;
  }
  public String pNimi(){
    return nimi;
  }
  public boolean pAsetettu(){
    return asetettu;
  }
  public int pKohta(){
    return kohta;
  }
  //asettaa arvot sarakkeen pistelaskun mukaan
  public void asetaArvot(Heitto heitto){
    
    asetettu=true;
    //ykköset
    if (this.kohta==1){
      for (int i=0;i<5;i++){
        if (heitto.pTulos().get(i)==1){
          arvo++;  }}}
    //kakkoset
    if (this.kohta==2){
      for (int i=0;i<5;i++){
        if (heitto.pTulos().get(i)==2){
          arvo+=2;  }}}
    //kolmoset
    if (this.kohta==3){
      for (int i=0;i<5;i++){
        if (heitto.pTulos().get(i)==3){
          arvo+=3;  }}}
    //neloset
    if (this.kohta==4){
      for (int i=0;i<5;i++){
        if (heitto.pTulos().get(i)==4){
          arvo+=4;  }}}
    //viitoset
    if (this.kohta==5){
      for (int i=0;i<5;i++){
        if (heitto.pTulos().get(i)==5){
          arvo+=5;  }}}
    //kuutoset
    if (this.kohta==6){
      for (int i=0;i<5;i++){
        if (heitto.pTulos().get(i)==6){
          arvo+=6;  }}}
    
    //pari
    if (this.kohta==8){
      for (int i=0;i<4;i++){
        if (heitto.pTulos().get(i)==heitto.pTulos().get(i+1)){
          arvo=heitto.pTulos().get(i)+heitto.pTulos().get(i+1);
        }}}
    
    //kaksi paria. etsii ensin ensimmäisen ja lopuista toisen.
    if (this.kohta==9){
      for (int i=0;i<4;i++){
        if (heitto.pTulos().get(i)==heitto.pTulos().get(i+1)){
          for (int k=i+2;k<4;k++){
            if (heitto.pTulos().get(k)==heitto.pTulos().get(k+1)){
              arvo=heitto.pTulos().get(i)+heitto.pTulos().get(i+1)+heitto.pTulos().get(k)+heitto.pTulos().get(k+1);
            }}}}}
    
    //kolmoset
    if (this.kohta==10){
      for (int i=0;i<3;i++){
        if (heitto.pTulos().get(i)==heitto.pTulos().get(i+1)&&heitto.pTulos().get(i+2)==heitto.pTulos().get(i)){
          arvo=heitto.pTulos().get(i)*3;
        }}}
    //neloset
    if (this.kohta==11){
      for (int i=0;i<2;i++){
        if(heitto.pTulos().get(i)==heitto.pTulos().get(i+1)&&heitto.pTulos().get(i+2)==heitto.pTulos().get(i)&&heitto.pTulos().get(i+3)==heitto.pTulos().get(i)){
          arvo=heitto.pTulos().get(i)*4;
        }}}
    //pieni suora
    if (this.kohta==12){
      if (heitto.pTulos().get(0)==1&&
          heitto.pTulos().get(1)==2&&
          heitto.pTulos().get(2)==3&&
          heitto.pTulos().get(3)==4&&
          heitto.pTulos().get(4)==5){
        arvo=15;
      }}
    //iso suora
    if (this.kohta==13){
      if (heitto.pTulos().get(0)==2&&
          heitto.pTulos().get(1)==3&&
          heitto.pTulos().get(2)==4&&
          heitto.pTulos().get(3)==5&&
          heitto.pTulos().get(4)==6){
        arvo=20;
      }}
    
    //täyskäsi, katsotaan ensin onko kolme samaa tai pari. tämän jälkeen etsitään toinen
    if (this.kohta==14){
      if (heitto.pTulos().get(0)==heitto.pTulos().get(1)&&
          heitto.pTulos().get(2)==heitto.pTulos().get(3)&&heitto.pTulos().get(4)==heitto.pTulos().get(2)){
        arvo=heitto.pTulos().get(0)*2+heitto.pTulos().get(2)*3;}
      if (heitto.pTulos().get(3)==heitto.pTulos().get(4)&&
          heitto.pTulos().get(0)==heitto.pTulos().get(1)&&heitto.pTulos().get(0)==heitto.pTulos().get(2)){
        arvo=heitto.pTulos().get(3)*2+heitto.pTulos().get(0)*3;}}
    
    //sattuma ottaa mitkä tahansa luvut
    if (this.kohta==15){
      arvo=heitto.pTulos().get(3)+heitto.pTulos().get(0)+heitto.pTulos().get(1)+heitto.pTulos().get(2)+heitto.pTulos().get(4);
    }
    //jatsi eli viisi samaa
    if (this.kohta==16){
      if (heitto.pTulos().get(0)==heitto.pTulos().get(1)&&heitto.pTulos().get(2)==heitto.pTulos().get(0)&&heitto.pTulos().get(3)==heitto.pTulos().get(0)&&heitto.pTulos().get(4)==heitto.pTulos().get(0)){
        arvo=50;
      }
    }}
  //yläosabonuksen lasku pisteisiin
  public void laskeBonus(){
    arvo=50;
  }//tuloksen asettaminen
  public void asetaTulos(int arvo){
    this.arvo=arvo;
  }  
}