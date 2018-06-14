package motivationService.impl;

import motivationService.MotivationService;

public class RandomMotivationService implements MotivationService {

	// As sampled from the truly wonderful 'Inspiro bot' at inspirobot.me
	private final String[] MOTIVATIONAL_MESSAGES = {"Pets plan for fluffy clouds most of the time", 
			"Don't apologize. Why not just sacrifice everything you have?", 
			"Between a midwife and technology lies the future.", 
			"When we die, the world will be gone. So wake up every day."};
	
	@Override
	public String getMotivationalMessage() {
		return MOTIVATIONAL_MESSAGES[(int)(Math.random() * MOTIVATIONAL_MESSAGES.length)];
	}

}
