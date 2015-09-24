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
				for(int i = 0; i < 4; i++)
					{
						for(int j = 1; j <= 13; j++)
							{
								switch(j)
									{
										case 1:
											value = 11;
											face = "A";
											break;
										case 2:
											face = "2";
											value = j;
											break;
										case 3:
											face = "3";
											value = j;
											break;
										case 4:
											face = "4";
											value = j;
											break;
										case 5:
											face = "5";
											value = j;
											break;
										case 6:
											face = "6";
											value = j;
											break;
										case 7:
											face = "7";
											value = j;
											break;
										case 8:
											face = "8";
											value = j;
											break;
										case 9:
											face = "9";
											value = j;
											break;
										case 10:
											face = "10";
											value = j;
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
									}
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
								deck.add(new Card(suit, value, face));
							}
					}
			}
		public Card drawCard(int spot)
			{
				return deck.get(spot);
			}
		public void removeCard(int spot)
			{
				deck.remove(spot);
			}
		public void setCard(int spot, String suit, int value, String face)
			{
				deck.get(spot).setSuit(suit);
				deck.get(spot).setValue(value);
				deck.get(spot).setFace(face);
			}
		public ArrayList<Card> shuffleDeck()
			{
				Collections.shuffle(deck);
				return deck;
			}
		public void addCard(Card one)
			{
				deck.add(one);
			}
		public int size()
			{
				return deck.size();
			}

	}
