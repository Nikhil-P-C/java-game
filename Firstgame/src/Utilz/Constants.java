package Utilz;

public class Constants {
	  public static class Direction{
		  public static final int LEFT =3;
		  public static final int UP=0;
		  public static final int RIGHT=1;
		  public static final int DOWN=2;
	  }
      public static class PlayerConstant{
    	  public static final int IDLE=0;
    	  public static final int RUNNING=1;
    	  public static final int JUMP=2;
    	  public static final int FALLING=3;
    	  public static final int GROUND=4;
    	  public static final int HURT=5;
    	  public static final int ATTACK=6;
    	  public static final int JUMP_ATTACK1=7;
    	  public static final int JUMP_ATTACK2=8;
    	  
    	  public static int GetSpriteAmount(int player_action) {
    		  switch (player_action) {
    		  case IDLE:return 5;
    			  
    		  case RUNNING:return 6;
    			  
    		  case JUMP: return 3;
    			 
    		  case FALLING: return 1;
    			  
    		  case GROUND: return 2;
    			 
    		  case HURT: return 4;
    			 
    		  case ATTACK:
    		  case JUMP_ATTACK1:
    		  case JUMP_ATTACK2:
    			  return 3;
    			  
    		  default:return 1;
    		  }
    	  }
      }
}
