package coach.impl;

import coach.Coach;
import dietService.DietService;
import motivationService.MotivationService;

public class TrackCoach implements Coach{

	private MotivationService motivationService;
	private DietService dietService;
	
	public TrackCoach(MotivationService motivationService) {
		this.motivationService = motivationService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}

	@Override
	public String getDailyMotivation() {
		return this.motivationService.getMotivationalMessage();
	}

	@Override
	public String getDailyDiet() {
		if (dietService == null) {
			return "No diet information available.";
		}
		
		return dietService.getDailyDiet();
	}
	
	public void setDietService(DietService dietService) {
		this.dietService = dietService;
	}

	
}
