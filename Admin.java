package studenteventmanagement;

import studenteventmanagement.database.PostDatabase;

public class Admin extends User {
     
    
    public Admin(int id, String email, String password, String name) {
        super(id, email, password, name);
      
    }
    
    
       @Override
    public void login(String email, String password) {
       
    }

    @Override
    public void logout() {
       
    }

    public void createPost(Post post) {
    PostDatabase.getInstance().savePost(post);
}

    
   }
    
     
    

