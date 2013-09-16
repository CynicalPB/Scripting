package zpAgility;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.api.methods.Camera;
import org.rev317.api.methods.Players;
import org.rev317.api.methods.SceneObjects;
import org.rev317.api.wrappers.scene.SceneObject;
import org.rev317.api.wrappers.scene.Tile;

public class Pipe implements Strategy {
	
	public Tile OBSTACLE_PIPE = new Tile(2484, 3430, 0); // Real Tile

	public final int OP_ID = 154;
	

	@Override
	public boolean activate() {
		return (Players.getLocal().getLocation() != OBSTACLE_PIPE) && 
				OBSTACLE_PIPE.distanceTo() < 2;
	}

	@Override
	public void execute() {
		final SceneObject[] OBSTACLE_PIPE = SceneObjects.getNearest(OP_ID);
		final SceneObject i = OBSTACLE_PIPE[0];
		if (Players.getLocal().getAnimation() == -1 && i.distanceTo() < 2) {
	    Camera.turnTo(i); 
	}
		if (i.isOnScreen()) {
            i.interact("Squeeze-through");
            i.interact("Squeeze-through");
            i.interact("Squeeze-through");
            i.interact("Squeeze-through");
            i.interact("Squeeze-through");
            i.interact("Squeeze-through");
            i.interact("Squeeze-through");
            i.interact("Squeeze-through");
            Time.sleep(100);
    }
}
}