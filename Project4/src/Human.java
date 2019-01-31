
/********************************************
 * 			Amarilda Celhaka				*
 *			CMP SCI 2261					*
 *			Project #4						*
 * 			Due Date: 10/29/2018			*
 * 			Class: Human, extends Mammal    *
 ********************************************/



import java.util.*;

public class Human extends Mammal{
	
	private int money = 1 + (int)(Math.random() * 100);			//stores a random number for money(1-100) each human has
	private int dogfood = 1 + (int)(Math.random() * 100);		//stores a random number for dog food(1-100)
	private int weight = 70 + (int)Math.random() * 200;      	//stores the weight of human(70-200pounds)
	private boolean loyalty = false;							//stores a boolean, if a dog is loyal or not
	private int humanSex = (int)(Math.random() * 2);	
	ArrayList <Dog> dog;										//creating an array list of Dog objects
	
	
	/**Default constructor*/
	public Human() {
		
	}
	
	
	/**constructor that takes human name, sex, and array of dognames, dogSex and the size of the arrays*/
	public Human(String humanName, String [] dogName, int dogNum) {
		
		setHunger(getHunger());
		setName(humanName);
		setSex(humanSex);
		setWeight(weight);
		
		/**creating an array list of dogs with size dogNum*/
		dog = new ArrayList<Dog>(dogNum);
		
		
		/**Appending a new dog at the end of the list*/	
		for (int i = 0; i < dogNum; i++) {
		
		dog.add(new Dog(dogName[i]));
		
		}
	}
	
	
	/**Return money value*/
	public int getMoney() {
		return money;
	}
	
	
	/**Set a new value for the money*/
	public void setMoney(int money) {
		this.money = money;	
	}
	
	
	/**Return dog food amount*/
	public int getDogFood() {
		return dogfood;
	}
	
	
	/**Set a new value for dog food*/
	public void setDogFood(int dogfood) {
		this.dogfood = dogfood;
		
	}
	
	
	
	
	/**walkTheDog() method is used to walk the dog, resulting with *
	 * fun increased, cleanliness decreased and hunger increased   */
	public void walkTheDog() {
		
		for(int i = 0; i < dog.size(); i++) {
			
		//fun increased by 50%
		dog.get(i).setFun(50 + dog.get(i).getFun());
			
		//cleanliness decreased by 10%
		dog.get(i).setCleanliness((int)(0.9 * dog.get(i).getCleanliness()));
		
		//increasing hunger by 10%
		dog.get(i).setHunger((int)(1.1 * dog.get(i).getHunger()));
		
		}
	}
	
	
	
	
	
	
	/**batheTheDog method is used to bathe the dog, resulting with
	 * a decrease of dog fun and an increase of cleanliness 		 */
	public void batheTheDog() {
		
		for(int i = 0; i < dog.size(); i++) {
			
		//fun decreased by 10%
		dog.get(i).setFun((int)(0.9 * dog.get(i).getFun()));
		
		//cleanliness increased to 100
		dog.get(i).setCleanliness(100);
		
		}
	}
	
	
	
	
	
	/**FeedtheDog method is used to feed the dog, resulting with
	 * a dog less hungry, less clean, less money for the human and 
	 * a happier dog  												*/
	public void feedTheDog() {
		
		for(int i = 0; i < dog.size(); i++) {
			
			//Hunger decreased by 50
			dog.get(i).setHunger( dog.get(i).getHunger() - 50);
			
			//Cleanliness decreased by 10%
			dog.get(i).setCleanliness((int)(0.9 * dog.get(i).getCleanliness()));
			
			//fun increased by 10%
			dog.get(i).setFun((int)(1.1 * dog.get(i).getFun()));
		}
		
		//-1 dog food for each dog
		 dogfood -= dog.size();
		setDogFood(dogfood);
	}

	
	
	
	
	
	/**Buy food method will result with a human
	 * having less money and more food for the dogs*/
	public void buyFood() {
		//add 50 more food
		dogfood += 50;
		setDogFood(dogfood);
		
		//spend 10 money
		money = money - 10;
		setMoney(money);
	}
	
	
	
	
	
	
	/**passTheTime is a method that will decrease dog fun and
	 * increase money for  every iteration, while the dog are waiting*/
	public void passTheTime() {
		
		
		for(int i = 0; i < dog.size(); i++) {
			
			//all dogs for the human have -1 less fun
			dog.get(i).setFun(dog.get(i).getFun() - 1);
			
			//by pass the time dogs get also hungry, hungry increased by 10
			dog.get(i).setHunger(dog.get(i).getHunger() + 10);
			
		}
		
		//increase money by 10
		money += 10;
		setMoney(money);
	}
	
	
	
	
	
	
	/**Return loyalty true if dog is not hungry or is happy and false
	 * if dog is unhappy and hungry */
	public boolean isDogLoyal() {
		
		for(int i = 0; i < dog.size(); i++){
			
			if(dog.get(i).getLoyalty() <= 0) {
				
				loyalty = false;
			}
			else {
				
				loyalty = true;
			}	
		}
		return loyalty;
	}
	
	
	
	 
	
	
	/**To string method to display the attributes of humans object, with 
	 * a call to toString method of dogs */
	public String toString() {
		
		return "\nHuman Name: " + getName() + "\t\tHuman Sex: " + getSex() +
				"\n" + getName() + " has " + getMoney() + " money and " + getDogFood() +
				" food for the dogs "  + dog.toString() ;
	}

}
