


/********************************************
 * 			Amarilda Celhaka				*
 *			CMP SCI 2261					*
 *			Project #4						*
 * 			Due Date: 10/29/2018			*
 * 			Class: Dog, extends Mammal		*
 ********************************************/

public class Dog extends Mammal {
	
	private int fun = 1 + (int)(Math.random() * 100);
	private int cleanliness = 1 + (int)(Math.random() * 100);
	private int dogWeight = 6 + (int)(Math.random() * 150);
	private int dogHunger = 1 + (int)(Math.random() * 100);
	private int dogSex = (int)(Math.random() * 2);
	private int loyalty;
	
	
	/**Default constructor*/
	public Dog() {
	}
	
	
	
	public Dog(String name) {
		
		setName(name);
	    setSex(dogSex);
		setHunger(dogHunger);
		setWeight(dogWeight);
	}
	
	 
	
	
	/**Return loyalty*/
	/**it will return the max value of fun and (100 - dogHunger)*/
	public int getLoyalty() {
		
		if(fun >= (100 - dogHunger)){
			loyalty = fun;
		}
		else {
			loyalty = (100 - dogHunger);

		}
		
		return loyalty;
	}
	
	
	
	
	
	
	/**Return fun*/
	public int getFun() {
		
		if(fun > 100){
			fun = 100;
		}
		else if(fun < 0){
			fun = 0;
		}
		return fun;
	}
	
	
	
	
	/**Set Fun*/
	public void setFun(int fun) {
		this.fun = fun;
	}
	 
	
	
	
	
	/**return cleanliness*/
	public int getCleanliness() {
		if(cleanliness > 100){
			cleanliness = 100;
		}
		else if(cleanliness < 0){
			cleanliness = 0;
		}
		return cleanliness;
	}
	
	
	
	
	
	/**set cleanliness*/
	public void setCleanliness(int cleanliness) {
		this.cleanliness = cleanliness;
	}
	
	
	
	
	/**toString() method will display the attributes of dog objects*/
	public String toString() {
		return  "\n\nDog Name: " + getName() + "\t\tDog Sex: " + getSex() + "\t\tDogweight: " + getWeight() + 
				"\nDog Hunger: " + getHunger() +  "\t\tDog Fun: " + getFun() + "\t\tDog Cleanliness: " + getCleanliness()
				+ "\nDog Loyalty " + getLoyalty();
	}
}
