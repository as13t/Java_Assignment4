/*This is the driver class that contains the main function.
 * This will call the Knight class to set and get items
 * for the Knight battle.
 */

import java.util.Scanner;

public class KnightDriver 
{

	public static void main(String[] args) 
	{
		String knightName;
		String enemyName;
		String oppWeapon;
		String autoGen;
		String battleAns;
		String ans;
		
		int selWeapon = 0;
		int enemySelWeapon = 0;
		
		Scanner input = new Scanner(System.in);
		Scanner inputNum = new Scanner(System.in);
		Scanner inputAuto = new Scanner(System.in);
		Scanner inputBattle = new Scanner(System.in);
		Scanner inputCont = new Scanner(System.in);
		
		System.out.println("Welcome to Knightfight!\n");
		
		do
		{
			System.out.println("Enter the name of your Knight: ");
			knightName = input.nextLine();

			System.out.println("Now select your weapon! (Choose a number)");
			System.out.println("1) Long Sword\n2) Battle Axe\n3) Spear\n4) Warhammer");
			System.out.println("Your choice my liege? : ");
			selWeapon = inputNum.nextInt();
		
			System.out.println("Would you like to auto generate your opponent? (y|n)");
			autoGen = inputAuto.nextLine();
		
			if(autoGen.equals("y"))
			{
				Knight aKnight = new Knight(knightName, selWeapon, autoGen);
				aKnight.setKnight(knightName, selWeapon);
				enemyName = "Computer";
				oppWeapon = aKnight.autoGenWeapon();
				aKnight.setEnemy(enemyName, oppWeapon, autoGen);
				aKnight.displayCharacters();
			
				System.out.println("\nWould you like to begin the battle? (y|n)");
				battleAns = inputBattle.nextLine();
			
				if(battleAns.equals("y"))
				{
					aKnight.knightBattle();
				}
			}
			else
			{
				System.out.println("Enter the name of your enemy: ");
				enemyName = input.nextLine();
				System.out.println("Now select your weapon! (Choose a number)");
				System.out.println("1) Long Sword\n2) Battle Axe\n3) Spear\n4) Warhammer");
				System.out.println("Your choice? : ");
				enemySelWeapon = inputNum.nextInt();
				Knight knight = new Knight(knightName, selWeapon, autoGen, enemyName, enemySelWeapon);
				knight.setKnight(knightName, selWeapon);
				oppWeapon = knight.selectWeapon(enemySelWeapon);
				knight.setEnemy(enemyName, oppWeapon, autoGen);
				knight.displayCharacters();
			
				System.out.println("\nWould you like to begin the battle? (y|n)");
				battleAns = inputBattle.nextLine();
			
				if(battleAns.equals("y"))
				{
					knight.knightBattle();
				}

			}
			System.out.println("\nWould you like to play again? (y|n)");
			ans = inputCont.nextLine();
			
		}while(ans.equals("y"));
	}

}
