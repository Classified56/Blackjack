import java.util.ArrayList;
import java.util.Collections;

public class Blackjack
	{
		public static void main(String[] args)
			{
				Deck shoe = new Deck();
				for(int i = 0; i < 52; i++)
					{
						System.out.println(shoe.getCard(i).getSuit());
						System.out.println(shoe.getCard(i).getFace());
						System.out.println(shoe.getCard(i).getValue());
					}
			}

	}
