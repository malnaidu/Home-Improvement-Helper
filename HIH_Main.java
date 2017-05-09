import java.awt.EventQueue;

/**
 * 
 */

/**
 * @author malnaidu
 *
 */
public class HIH_Main {
	  
    /**
     * A private constructor to inhibit instantiation.
     */
    private HIH_Main() {
        throw new IllegalStateException();
    }
    
    /**
     * The start point for the CompositeLayout program.
     * 
     * @param theArgs Command line arguments are ignored in this program
     */
    public static void main(final String[] theArgs) {
        
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new HIH_UI().start();
            }
        });
    }

}
