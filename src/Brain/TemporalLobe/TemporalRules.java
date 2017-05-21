package Brain.TemporalLobe;

import java.awt.event.ActionEvent;

import Brain.Rules;
import Coma.Coma;

/**
 * Represents the rules for "Locked"
 * @author 
 * @version 5/18/17
 */
public class TemporalRules extends Rules{
	private Coma c;
	
	/**
	 * Initializes this rules panel.
	 * @param l the Locked panel these rules belong to
	 * @param c the overall Coma game the rules of this mini game belongs to
	 */
	public TemporalRules(Coma c) {
		super();
		this.c = c;
	}

	@Override

	/**
	 * returns the instructions of this game
	 */
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
		if (src == begin) {
			((Temporal)c.getPanel(4)).reset();
			c.changePanel("15");
		}
		else if (src == menu)
			c.changePanel("3");
	}

}