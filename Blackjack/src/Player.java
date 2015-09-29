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
		public void addCard(Card in)
			{
				if(in.getValue() + handValue > 21 && in.getFace().equals("A"))
						in.setValue(1);
				hand.add(in);
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
