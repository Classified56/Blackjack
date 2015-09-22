import java.util.ArrayList;
import java.util.Collections;

public class Deck
	{
		private ArrayList<Card> deck = new ArrayList<Card>();
		public Deck(ArrayList nDeck)
			{
				for(int i = 65; i < 69; i++)
					{
						char suit = 0;
						char value = 0;
						for(int j = 1; j <= 13; j++)
							{
								switch(j)
								{
									case 1:
										value = 'A';
										break;
									case 11: 
										value = 'J';
										break;
									case 12: 
										value = 'Q';
										break;
									case 13: 
										value = 'K';
										break;
									default:
										value = (char)(j + 48);
										break;
								}
							}
						deck.add(new Card(suit, value));
					}
				nDeck = deck;
			}
		public ArrayList<Card> getDeck()
			{
				return deck;
			}
		public void setDeck(ArrayList<Card> deck)
			{
				this.deck = deck;
			}
		public ArrayList shuffleDeck(ArrayList d)
			{
				Collections.shuffle(d);
				return d;
			}

	}
