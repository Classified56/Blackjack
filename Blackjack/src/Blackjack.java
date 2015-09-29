
public class Blackjack
	{
		public static void main(String[] args)
			{
				Deck shoe = new Deck();
				shoe.addDecks(2);
				Player joe = new Player(1000);
				shoe.shuffleDeck();
				do
					{
						joe.addCard(shoe.drawCard());
						joe.printHand();
					}
				while(joe.getHandValue() < 22);
			}
		public static void printDeck(Deck in)
			{
				for(int i = 0; i < in.size(); i++)
					{
						Card temp = in.drawCard();
						System.out.print(temp.getSuit());
						System.out.println(temp.getFace());
					}
			}

	}
