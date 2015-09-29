
public class Blackjack
	{
		public static void main(String[] args)
			{
				Deck shoe = new Deck();
				shoe.addDecks(2);
				Player joe = new Player(1000);
				shoe.shuffleDeck();
				joe.setBet(50);
				joe.drawHand(shoe);
				joe.printHand();
				System.out.println(joe.getHandValue());
				joe.addCard(shoe.drawCard());
				joe.printHand();
				System.out.println(joe.getHandValue());
				joe.winsHand();
				System.out.println(joe.getBank());
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
