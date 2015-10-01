import java.util.Scanner;
import java.util.ArrayList;

public class Blackjack
	{
		static Scanner numUserInput = new Scanner(System.in);
		static Scanner strUserInput = new Scanner(System.in);
		public static void main(String[] args)
			{
				//starts game with x amount of players
				Deck shoe = new Deck();
				shoe.addDecks(3);
				shoe.shuffleDeck();
				shoe.drawCard();
				ArrayList<Player> table = new ArrayList<Player>();
				System.out.print("How many players would you like to play as? ");
				int numPlayers = numUserInput.nextInt();
				for(int i = 0; i < numPlayers; i++)
					table.add(new Player(1000));
				Dealer house = new Dealer();
				
				//game start
				boolean hot = true;
				while(hot)
					{
						//set bets
						for(int i = 0; i < table.size(); i++)
							{
								System.out.print("Bet for Player " + (i + 1) + "? ");
								int bet = numUserInput.nextInt();
								table.get(i).setBet(bet);
							}
						
						//deals out all hands
						for(int j = 0; j < 2; j++)
							{
								for(int i = 0; i < table.size(); i++)
									{
										table.get(i).addCard(shoe.drawCard());
									}
								house.addCard(shoe.drawCard());
							}
						for(int i = 0; i < table.size(); i++)
							{
								System.out.println("Player " + (i + 1));
								table.get(i).printHand();
								System.out.println("");
							}
						house.printHalf();
						
						//each player plays
						ArrayList<Integer> newPlayers = new ArrayList<Integer>();
						for(int i = 0; i < table.size(); i++)
							{
								boolean going = true;
								boolean split = false;
								boolean dd = false;
								int turnCounter = 0;
								if(table.get(i).getHandValue() == 21)
									{
										System.out.println("Blackjack! Winner winner chicken dinner!");
										table.get(i).setBank(table.get(i).getBank() + table.get(i).getBet());
										table.get(i).winsHand();
									}
								while(going)
									{
										table.get(i).printHand();
										System.out.println("\nPlayer " + (i + 1) + " has: " + table.get(i).getHandValue());
										if(table.get(i).getCardFace(0).equals(table.get(i).getCardFace(1)) && turnCounter == 0)
											{
												split = true;
												System.out.print("Split, ");
											}
										if((table.get(i).getHandValue() == 10 || table.get(i).getHandValue() == 11) && turnCounter == 0)
											{
												dd = true;
												System.out.print("Double down, ");
											}
										System.out.print("Hit, or Stay? ");
										String choice = strUserInput.nextLine();
										if(choice.equalsIgnoreCase("Split") && split && table.get(i).getBet() * 2 < table.get(i).getBank() && turnCounter == 0)
											{
												Card newHand = table.get(i).getCard(1);
												table.get(i).removeCard(1);
												newPlayers.add(i + 1);
												table.get(i).setBank(table.get(i).getBank() - table.get(i).getBet());
												table.add(i + 1, new Player(table.get(i).getBet()));
												table.get(i + 1).setBet(table.get(i).getBet());
												table.get(i + 1).addCard(newHand);
												table.get(i).addCard(shoe.drawCard());
												table.get(i + 1).addCard(shoe.drawCard());
											}
										else if(choice.equalsIgnoreCase("Double down") && dd && table.get(i).getBet() * 2 < table.get(i).getBank() && turnCounter == 0)
											{
												table.get(i).doubleDown(shoe.drawCard());
												going = false;
												table.get(i).printHand();
												System.out.println("Player " + (i + 1) + " had " + table.get(i).getHandValue());
											}
										else if(choice.equalsIgnoreCase("Hit"))
											{
												table.get(i).addCard(shoe.drawCard());
												if(table.get(i).getHandValue() > 21)
													{
														System.out.println("You busted with " + table.get(i).getHandValue());
														table.get(i).losesHand();
														going = false;
													}
											}
										else if(choice.equalsIgnoreCase("Stay"))
											{
												going = false;
											}
										else
											{
												System.out.println("Please choose a valid action. ");
											}
										turnCounter++;
									}
							}
						//dealer plays
						house.printFull();
						while(house.getHandValue() < 17)
							{
								System.out.println();
								house.addCard(shoe.drawCard());
								house.printFull();
								if(house.getHandValue() > 21)
									{
										System.out.println("Dealer busted. ");
										house.resetHand();
										break;
									}
							}
						
						//check for wins
						System.out.println();
						for(int z = 0; z < table.size(); z++)
							{
								if(table.get(z).getHandValue() == 0)
									{
										System.out.println("Player " + (z + 1) + " was already paid out. Bank: " + table.get(z).getBank());
									}
								else if(table.get(z).getHandValue() < house.getHandValue())
									{
										table.get(z).losesHand();
										System.out.println("Player " + (z + 1) + " lost. Bank: " + table.get(z).getBank());
									}
								else if(table.get(z).getHandValue() > house.getHandValue())
									{
										table.get(z).winsHand();
										System.out.println("Player " + (z + 1) + " won. Bank: " + table.get(z).getBank());
									}
								else if(table.get(z).getHandValue() == house.getHandValue())
									{
										table.get(z).pushesHand();
										System.out.println("Player " + (z + 1) + " pushed. Bank: " + table.get(z).getBank());
									}
							}
						
						//add split bets to original player
						if(newPlayers.size() > 0)
							{
								for(int x = 0; x < newPlayers.size(); x++)
									{
										table.get(newPlayers.get(x) - 1).setBank(table.get(newPlayers.get(x) - 1).getBank() + table.get(newPlayers.get(x)).getBank());
									}
								//has to be backwards to not interfere with the placement of the temporary players.
								for(int x = newPlayers.size() - 1; x >= 0; x--)
									{
										table.remove(newPlayers.get(x));
									}
							}
						
						//choice to end game
						System.out.print("\nAnother hand? (yes or no) ");
						String choice = strUserInput.nextLine();
						if(choice.equals("no"))
							{
								hot = false; 
							}
						System.out.println("\n\n");
					}
				numUserInput.close();
				strUserInput.close();
			}
		
		public static void printDeck(Deck in)
			{
				for(int i = 0; i < in.size(); i++)
					{
						Card temp = in.drawCard();
						System.out.print(temp.getSuit() + " ");
						System.out.println(temp.getFace());
					}
			}

	}
