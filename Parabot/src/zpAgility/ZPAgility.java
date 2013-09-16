package zpAgility;

import java.awt.*;
import java.awt.Graphics;
import java.text.DecimalFormat;

import org.parabot.core.ui.components.LogArea;
import org.parabot.environment.api.interfaces.Paintable;
import org.parabot.environment.scripts.Category;
import org.parabot.environment.scripts.ScriptManifest;
import org.parabot.environment.scripts.Script;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.api.methods.Skill;
import java.util.ArrayList;

/**
 * Made by: Cynical
 */

@ScriptManifest(author = "Cynical", category = Category.AGILITY, description = "One Of A Kind!", name = "ZPAgility", servers = { "DeviousPK" }, version = 1)
public class ZPAgility extends Script implements Paintable {
	private final ArrayList<Strategy> strategies = new ArrayList<Strategy>();

	public int startExp = 0;
	public int currentExp = 0;
	public int startLevel = 0;
	static long startTime;
	public int currentLevel = 0;
	public String status;

	private final Color color1 = new Color(0, 0, 0, 74);
	private final Color color2 = new Color(0, 0, 0);
	private final Color color3 = new Color(255, 255, 255);

	private final BasicStroke stroke1 = new BasicStroke(1);

	private final Font font1 = new Font("Bitstream Charter", 0, 10);

	public String runTime(long i) {
		DecimalFormat nf = new DecimalFormat("00");
		long millis = System.currentTimeMillis() - i;
		long hours = millis / (1000 * 60 * 60);
		millis -= hours * (1000 * 60 * 60);
		long minutes = millis / (1000 * 60);
		millis -= minutes * (1000 * 60);
		long seconds = millis / 1000;
		return nf.format(hours) + ":" + nf.format(minutes) + ":"
				+ nf.format(seconds);
	}

	@Override
	public boolean onExecute() {
		startTime = System.currentTimeMillis();
		startExp = Skill.AGILITY.getExperience();
		currentLevel = Skill.AGILITY.getLevel();
		LogArea.log("Script Started");
		strategies.add(new Pipe());
		strategies.add(new Walk());
		provide(strategies);
		return true;
	}

	@Override
	public void onFinish() {
		LogArea.log("Thankyou for using cynAgility");
		LogArea.log("Script made by Cynical");

	}

	public void paint(Graphics g1) {
		currentExp = Skill.AGILITY.getExperience();
		currentExp -= startExp;
		Graphics2D g = (Graphics2D) g1;
		g.setColor(color1);
		g.fillRect(2, 324, 515, 15);
		g.setColor(color2);
		g.setStroke(stroke1);
		g.drawRect(2, 324, 515, 15);
		g.setFont(font1);
		g.setColor(color3);
		g.drawString("Time Running:" + runTime(startTime), 6, 335);
		g.drawString("||", 161, 334);
		g.drawString("Xp Gained:" + currentExp, 171, 335);
		g.drawString("||", 298, 334);
		g.drawString("Status:" + status, 310, 335);
		g.drawString("||", 409, 334);
		g.drawString("Level:" + currentLevel, 422, 335);
	}
}
