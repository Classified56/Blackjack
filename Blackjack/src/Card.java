
public class Card
	{
		private char suit;
		private int value;
		private 
		public Card(char s, char v)
			{
				suit = s;
				value = v;
			}
		public char getSuit()
			{
				return suit;
			}
		public void setSuit(char suit)
			{
				this.suit = suit;
			}
		public char getValue()
			{
				return value;
			}
		public void setValue(char value)
			{
				this.value = value;
			}

	}
