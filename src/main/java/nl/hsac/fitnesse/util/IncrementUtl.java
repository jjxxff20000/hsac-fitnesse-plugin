package nl.hsac.fitnesse.util;

/**
 * Helpers for IncrementInt.
 */
public class IncrementUtl {
	private int current;
	
	public void setCurrent(int current){
		incrementUtl.current = current;
	}
	
    private static IncrementUtl incrementUtl=null;
    
    private IncrementUtl(){
    	current = 0;
    }
    
    public static IncrementUtl getInstance(){
    	if(incrementUtl == null){
    		incrementUtl = new IncrementUtl();
    	}
    	return incrementUtl;
    }
    
    private int intPlus(){
    	return ++current;
    }
    
    public int incrementInt(){
    	return incrementUtl.intPlus();
    }
}
