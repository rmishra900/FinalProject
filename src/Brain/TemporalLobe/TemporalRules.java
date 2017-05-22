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
		rules = "<html>This lobe of the brain coordinates auditory information. <br><br>"
				+ "You are locked inside of a jail cell but provided with a keypad. To get "
				+ "out, listen to the music representing the passcode by pressing the play "
				+ "button. The numbers on the keypad will correspond with these sounds. "
				+ "Find the correct 4-digit passcode combination to unlock the cell and escape. "
				+ "<br><br>Use the clear button whenever you need to clear the passcode you have "
				+ "displayed.";
		
		
		return rules;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if (src == getBegin()) {
			((Temporal)c.getPanel(4)).reset();
			c.changePanel("15");
		}
		else if (src == getMenu())
			c.changePanel("3");
	}

}