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
	}
}

// you can add other public classes to this editor in any order
public class UserProfile implements Serializable
{
	private String tagName;
	private String email;
	public UserProfile(String tagName, String email)
	{
		this.tagName = tagName;
		this.email = email;
	}
	public String toString()
	{
		return tagName + " " + email;
	}

	public void export () {
		ObjectOutputStream oos = null;
		FileOutputStream fout = null;
		try{
			fout = new FileOutputStream("c:\\profile.ser", true);
			oos = new ObjectOutputStream(fout);
			oos.writeObject(this);
		} catch (Exception ex) {} 
		finally {
			if(oos != null){
				try {oos.close();} catch (e) {}
			} 
		}

	}
}