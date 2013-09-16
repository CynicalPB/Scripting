package zpAgility;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.api.methods.Camera;
import org.rev317.api.methods.Players;
import org.rev317.api.methods.SceneObjects;
import org.rev317.api.wrappers.scene.SceneObject;
import org.rev317.api.wrappers.scene.Tile;

    public class Walk implements Strategy {
    	
    	public Tile OBSTACLE_PIPE = new Tile(2484, 3430, 0); // Real Tile
    	public Tile BOTTOM_PIPE = new Tile(2484, 3437, 0);
    	public Tile FAILSAFE = new Tile(2483, 3431, 0);

    	public final int BUSH_ID = 1276 ;
    	public final int OP_ID = 154;
    	

   	 public boolean activate(){
   	        return Players.getLocal().getLocation() != BOTTOM_PIPE && Players.getLocal().getAnimation() == -1;
   	        
   	        }
   	        
   	        public void execute(){ 
   	    		final SceneObject[] BUSH = SceneObjects.getNearest(BUSH_ID);
   	    		final SceneObject b = BUSH[0];
   	                if(Players.getLocal().getLocation() != BOTTOM_PIPE){
   	                Camera.turnTo(b);
   	                OBSTACLE_PIPE.clickMM();
   	                Time.sleep(2000);
   	}
   }
}
  
