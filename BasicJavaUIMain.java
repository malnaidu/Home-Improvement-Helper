import java.awt.EventQueue;

public final class BasicJavaUIMain {
    
    /**
     * A private constructor to inhibit instantiation.
     */
    private BasicJavaUIMain() {
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
                new BasicJavaUI().start();
            }
        });
    }

}