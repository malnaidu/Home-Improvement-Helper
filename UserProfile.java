package view;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


// you can add other public classes to this editor in any order
public class UserProfile implements Serializable
{
    private String username;
    private String password;
    
    public UserProfile(String username, String password)
    {
        this.username = username;
        this.password = password;
    }
    
    public String toString()
    {
        return username + " " + password;
    }
    
    public String getUsername()
    {
        return username;
    }
    
    public String getPassword()
    {
        return password;
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
                try {oos.close();} catch (Exception e) {}
            }
        } 
    }
    
    public UserProfile importData()
    {
        ObjectInputStream ois = null;
        FileInputStream fin = null;
        
        UserProfile temp = null;
        
        try{
            fin = new FileInputStream("c:\\profile.ser");
            ois = new ObjectInputStream(fin);
            temp = (UserProfile) ois.readObject();
            
//            this.tagName = temp.gettagName();
//            this.email = temp.getemail();
        } catch (Exception ex) {} 
        finally {
            if(ois != null){
                try {ois.close();} catch (Exception e) {}
            } 
        }
        
        return temp;
    }
}