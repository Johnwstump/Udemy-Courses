package dietService.impl;

import dietService.DietService;

public class VegetableDietService implements DietService{
	public String[] DIET_FOODS = {"Broccoli", "Spinach", "Greenbeans", "Lentel Soup", "Smoothie", "Cheese and Crackers"};
	private int counter;
	
	@Override
	public String getDailyDiet() {
		String todaysFood = DIET_FOODS[counter];
	
		counter = counter + 1 >= DIET_FOODS.length ? 0 : counter++;
		
		return todaysFood;
	}
}
