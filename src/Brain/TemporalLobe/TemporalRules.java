package Brain.TemporalLobe;

import java.awt.event.ActionEvent;

import Brain.Rules;
import Coma.Coma;

public class TemporalRules extends Rules{
	
	private InTheDogPark i;
	private Coma c;
	
	public TemporalRules(InTheDogPark i, Coma c) {
		super();
		this.i = i;
		this.c = c;
	}

	@Override
	public String getText() {
		String rules;
		rules = "<html>This lobe of the brain coordinates auditory information. <br>"
				+ "The screen will show a neighborhood full of various objects. "
				+ "The player will receive information about which objects make which "
				+ "sounds while playing. Several of these sounds will be similar to test "
				+ "the player’s ability to distinguish between different sounds. They will "
				+ "hear a sound, and they have to click on the object it came from. In 30 seconds, "
				+ "they have to distinguish at least 10 objects to win";
		
		
		return rules;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if (src == begin)
			i.changePanel("2");
		else if (src == back)
			c.changePanel("3");
	}

}
