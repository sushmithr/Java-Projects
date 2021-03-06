import java.util.Random;

public class Card 
{
  private char suit;
 	private String rank;
 	private char result;

 	public Card(char type, String card) 
  {
 	  suit = type;
 	  rank = card;
  }

  public char getSuit() 
  {     
    return suit;
  }

  public String getRank() 
  {
    String result;	

    if (rank.equals("0"))
    {
      result = "0";
    }
    if (rank.equals("2"))
    {
      result = "2";
    }
    if (rank.equals("3"))
    {
      result = "3";
    }
    if(rank.equals("4"))
    {
		  result = "4";
    }
    if(rank.equals("5"))
    {
		  result = "5";
    }
    if(rank.equals("6"))
		{
      result = "6";
    }
    if(rank.equals("7"))
		{
      result = "7";
    }
    if(rank.equals("8"))
		{
      result = "8";
    }
    if(rank.equals("9"))
		{
      result = "9";
    }
    if(rank.equals("10"))
	  {
      result = "10";
    }
    if(rank.equals("11"))
    {
      result = "J";
    }
    if(rank.equals("12"))
		{
      result = "Q";
    }
    if(rank.equals("13"))
    {
      result = "K";
    }
    if(rank.equals("14"))
    {
      result = "A";
    }

    return result;
  }

  public String toString() 
  {
    String printRank;
    String printSuit;

    if(rank.equals("11")) 
    {
      printRank = "Jack"; 
    }
    else
    { 
      if(rank.equals("12")) 
      {
        printRank = "Queen"; 
      }
      else
      {
        if(rank.equals("13")) 
        {
          printRank = "King";
        }
       	else 
        {
          if(rank.equals("14"))
          {
            printRank = "Ace"; 
          }
          else 
          {
            printRank = rank;
          }
        }
      }
    }

    if (suit == 'D')
    { 
      printSuit = "Diamonds"; 
    }
    else 
    {
      if (suit == 'H')
      {
        printSuit = "Hearts";
      }
      else 
      {
        if (suit == 'C')
        {
        	printSuit = "Clubs";
        }
        else
        { 
          if (suit == 'S')
          {
            printSuit = "Spades";
          }
        }
      }
    }          
    String print = (printRank + " of " + printSuit); 
  }
}

public class Player
{
	private Card[] cards = new Card[10];
    
	public void addCard(Card newCard, int i)
	{
    	cards[i] = newCard; 
	}

	public int getValue(int numOfCards, int firstCardIndex) 
	{
    	int cardsToAdd = numOfCards;
    	int sum = 0;
   		for (int j = 0; j < cardsToAdd; j++)
   		{
       		if(cards[firstCardIndex].charAt == '2')
       		{
       			sum += 2;
       		} 
       		if(cards[firstCardIndex].charAt == '3')
       		{
       			sum += 3;
       		}
       		if(cards[firstCardIndex].charAt == '4')
       		{
      			sum += 4;
       		}
       		if(cards[firstCardIndex].charAt == '5')
       		{
       			sum += 5;
       		}
       		if(cards[firstCardIndex].charAt == '6')
       		{
       			sum += 6;
       		}
       		if(cards[firstCardIndex].charAt == '7')
       		{
       			sum += 7;
       		}
       		if(cards[firstCardIndex].charAt == '8')
       		{
       			sum += 8;
       		}
       		if(cards[firstCardIndex].charAt == '9')
       		{
       			sum += 9;
       		}
       		if(cards[firstCardIndex].charAt == '1')
       		{
       			sum += 10;
       		}
       		if(cards[firstCardIndex].charAt == 'J')
       		{
       			sum += 10;
       		}
       		if(cards[firstCardIndex].charAt == 'Q')
       		{
       			sum += 10;
       		}
       		if(cards[firstCardIndex].charAt == 'K')
       		{
       			sum += 10;
       		}
       		if(cards[firstCardIndex].charAt == 'A')
       		{
       			sum += 11;
      		}
      		firstCardIndex += 1; 
   		}
   		return sum;
	}

	public String toString() 
  	{
  		return sum;
  	}
}

public class BlackJack 
{
	public static void main(String[] args)
	{                                                        
		int count = 0;

		Card[]deck = new Card[52];
		
		for (int cardNum = 2; cardNum < 10; cardNum++)
		{
			deck[count++] = new Card('H',Integer.toString(cardNum)); 
			deck[count++] = new Card('D',Integer.toString(cardNum)); 
			deck[count++] = new Card('S',Integer.toString(cardNum)); 
			deck[count++] = new Card('C',Integer.toString(cardNum));
		}
        for (int i = 0; i < 3; i++)
        {
            deck[count++] = new Card('H',Integer.toString(i+10));
			deck[count++] = new Card('D',Integer.toString(i+10)); 
			deck[count++] = new Card('S',Integer.toString(i+10));
			deck[count++] = new Card('C',Integer.toString(i+10));
        }

		Card[] deckShuffled = new Card[52];   

		for (int counter = 0; counter <= 51; counter++)
		{
			Random shuffleNum = new Random();
			int randomCounter = 52 - counter;
			int randomNum = shuffleNum.nextInt(randomCounter);
			Card card = deck[randomNum];
			deckShuffled[counter] = card;
			deck[randomNum] = deck[randomCounter - 1];
		}

		Player dealer = new Player();
        for(int i = 0; i < 2; i++)
        {
        	dealer.addCard(deckShuffled[i], i); 
        }

        Player player1 = new Player();
        for(int j = 0; j < 2; j++)
        {
            player1.addCard(deckShuffled[j + 2], j); 
        }

        Player player2 = new Player();
        for(int n = 0; n < 2; n++)
        {
            player2.addCard(deckShuffled[n + 4], n); 
        }

        Player player3 = new Player();
        for(int l = 0; l < 10; l++)
        {
            player3.addCard(deckShuffled[l + 6], l);   
        }
	}
}
