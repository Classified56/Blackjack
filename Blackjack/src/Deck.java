import java.util.ArrayList;
import java.util.Collections;

public class Deck
	{
		private ArrayList<Card> deck = new ArrayList<Card>();
		public Deck()
			{
				int value = 0;
				String face = "";
				String suit = "";
				for(int i = 65; i < 69; i++)
					{
						int suitSet = 68 - i;
						for(int j = 1; j <= 13; j++)
							{
								switch(j)
								{
									case 1:
										value = 11;
										face = "A";
										break;
									
									case 11: 
										face = "J";
										value = 10;
										break;
									case 12: 
										face = "Q";
										value = 10;
										break;
									case 13: 
										face = "K";
										value = 10;
										break;
									default:
										face = j;
										value = j;
										break;
								}
								switch(suitSet)
									{
										case 1:
											suit = "Hearts";
											break;
										case 2:
											suit = "Spades";
											break;
										case 3:
											suit = "Diamonds";
											break;
										case 4:
											suit = "Clubs";
											break;
									}
								deck.add(new Card(suit, value, face));
							}
					}
			}
		public Card getCard(int spot)
			{
				return deck.get(spot);
			}
		public void setCard(int spot, String suit, int value, String face)
			{
				deck.get(spot).setSuit(suit);
				deck.get(spot).setValue(value);
				deck.get(spot).setFace(face);
			}
		public ArrayList shuffleDeck(ArrayList d)
			{
				Collections.shuffle(d);
				return d;
			}
		public int size()
			{
				return deck.size();
			}

	}
