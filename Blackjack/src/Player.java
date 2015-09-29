import java.util.ArrayList;

public class Player
	{
		private int bank;
		private int bet;
		private int handValue;
		private ArrayList<Card> hand = new ArrayList<Card>();
		
		public Player(int b)
			{
				bank = b;
				bet = 0;
				handValue = 0;
			}
		public void drawHand(Deck in)
			{
				for(int i = 0; i < 2; i++)
					{
						Card temp = in.drawCard();
						hand.add(temp);
						handValue += temp.getValue();
					}
			}
		public void doubleDown(Card in)
			{
				
			}
		public void addCard(Card in)
			{
				hand.add(in);
				if(in.getValue() + handValue > 21)
					{
						int aceSpot;
						String suit;
						for(int i = 0; i < 4; i++)
							{
								switch(i)
								{
									case 0:
										suit = "Hearts";
										break;
									case 1:
										suit = "Spades";
										break;
									case 2:
										suit = "Diamonds";
										break;
									case 3:
										suit = "Clubs";
										break;
								}
								Card compareCard = new Card(suit, 11, "A");
								aceSpot = hand.indexOf(compareCard);
								if(aceSpot >= 0)
									{
										hand.get(aceSpot).setValue(1);
										break;
									}
							}
					}
				handValue += in.getValue();
			}
		public int getBank()
			{
				return bank;
			}
		public void winsHand()
			{
				bank += bet;
				bet = 0;
				handValue = 0;
				hand.removeAll(hand);
			}
		public void losesHand()
			{
				bank -= bet;
				bet = 0;
				handValue = 0;
				hand.removeAll(hand);
			}
		public int getBet()
			{
				return bet;
			}
		public void setBet(int bet)
			{
				this.bet = bet;
			}
		public int getHandValue()
			{
				return handValue;
			}
		public void printHand()
			{
				for (int i = 0; i < hand.size(); i++)
					{
						System.out.print(hand.get(i).getSuit() + " ");
						System.out.println(hand.get(i).getFace());
					}
			}
	}
