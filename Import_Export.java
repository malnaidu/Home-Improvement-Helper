
//*******************************************************************
// serializable export of user profile for Iteration 2
//*******************************************************************

import java.lang.Math;
import java.io.Serializable;
import java.io.*;


public class Import_Export {
    // arguments are passed using the text field below this editor
    public static void main(String[] args) {
        UserProfile myProfile = new UserProfile("Fred","fredflintstone@bedrock.com");
        myProfile.export();
        
<<<<<<< HEAD
        UserProfile importedProfile = new UserProfile("", "");
        
        importedProfile = importedProfile.importData();
=======
        UserProfile importedProfile = myProfile.importData();
>>>>>>> origin/master
        
        System.out.println("Name: " + importedProfile.gettagName() + "\nEmail: " + importedProfile.getemail());
    }
}