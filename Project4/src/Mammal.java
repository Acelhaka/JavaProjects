/********************************************
 * 			Amarilda Celhaka				*
 *			CMP SCI 2261					*
 *			Project #4						*
 * 			Due Date: 10/29/2018			*
 * 			Class Mammal					*
 ********************************************/



public class Mammal {
	
	private String name;
	private int weight;
	private int hunger;
	private int sex;
	//private java.util.Date dateCreated;
	
	
	/**Default constructor*/
	public Mammal() {
		
	}
	
	
	/**Constructing a Mammal with specified 
	 * name, weight, hunger and sex*/
	public Mammal(String name, int weight, int hunger, int sex) {
		this.name = name;
		this.weight = weight;
		this.hunger = hunger;
		this.sex = sex;
	}
	
	
	/**Return name*/
	public String getName() {
		return name;
	}
	
	
	
	/**Set a new name*/
	public void setName(String name) {
		this.name = name;	
	}
	
	
	
	/**Return weight*/
	public int getWeight() {
		return weight;
	}
	
	
	
	/**Set a new weight*/
	public void setWeight(int weight) {
		this.weight = weight;	
	}
	
	
	
	/**Return hunger*/
	public int getHunger() {
		if(hunger > 100){
			
			hunger = 100;
		}
		else if(hunger < 0){
			
			hunger = 0;
		}
		return hunger;
	}
	
	
	
	/**Set a new hunger*/
	public void setHunger(int hunger) {
		this.hunger = hunger;	
	}
	
	
	
	/**Return sex*/
	public char getSex() {
		
		if(sex == 0) {
			sex = 'F';
		}
		else {
			sex = 'M';
		}
		return (char)sex;
	}
	
	
	
	/**Set a new sex*/
	public void setSex(int sex) {
		this.sex = sex;	
	}
	

}

