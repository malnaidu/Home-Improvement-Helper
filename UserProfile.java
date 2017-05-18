import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


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
    
    public String gettagName()
    {
        return tagName;
    }
    
    public String getemail()
    {
        return email;
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