import java.util.Vector;

public class Hand {

 //  Private Variables
 private Vector<Card> cards;
 private int handTotal;

  //  Constructor
  public Hand(){
    handTotal = 0;
    cards = new Vector<>();
  }

  public Card returnLatest(){
    return cards.get(cards.size()-1);
  }
  // Setters
  public void setHandTotal(int handTotal) {
    this.handTotal = handTotal;
  }

  public int returnNumCards(){
    return cards.size();
  }

  // Getters
  public int getHandTotal() {
    
    return handTotal;
  }

  //  Other Methods
  
  // append a card to the hand given by the dealer
  public void addCardToHand(Card card) {
    //  add card to Hand vector

     if (card.getcardValue() == 1 && handTotal<11){

      handTotal += 11;

    }
    else if (card.getcardValue() > 10){
      handTotal += 10;
    }
    else{
      handTotal += card.getcardValue();
    }
  
    cards.add(card);

    
     
       
  }

/*  public void reinitCardValue(){

    int numAces = 0;
    handTotal = 0;

    for (int i=0;i<cards.size();i++){
      if (cards.get(i).isAce == true){
        numAces++;
      }
      else if (cards.get(i).getcardValue() > 10){
        handTotal+=10;
      }
      else{
        handTotal+=cards.get(i).getcardValue();
      }
    }

    if (numAces==1 && handTotal<=10){
      handTotal+=11;
    }
    else{
      
      for (int i =0;i<numAces;i++){
        handTotal+=1;
      }
    }

  }
*/
  public Card accessCardatIndex(int i){
    return cards.get(i);
  }

  public void setEqualTo(Hand h){
    cards.clear();

    for (int i=0;i<h.returnNumCards();i++){
     

      addCardToHand(h.accessCardatIndex(i));
      
    }

   }


}