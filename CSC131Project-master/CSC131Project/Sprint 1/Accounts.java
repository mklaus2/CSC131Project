import java.util.*;
import java.io.*;

public class Accounts {
    private Map<String, User> user_list = null;
    private Map<String, String> user_password = null;

    public Accounts(){

    }

    public String create_user(String username, boolean admin, String password){
        if(user_list.containsKey(username)) return "Username has been taken.";
        user_list.put(username, new User(username, admin));
        user_password.put(username, password);
        return "Account successfully created.";
    }

    public User login(String username, String password){
        if(!user_password.containsKey(username)) return null;
        if(!password.equals(user_password.get(username))) return null;
        return user_list.get(username);
    }

    private void populate_maps() throws IOException {
        String row;
        BufferedReader csv_reader = new BufferedReader(new FileReader("user_list.csv"));
        while ((row = csv_reader.readLine()) != null) {
            String[] data = row.split(",");

        }
        csv_reader.close();
    }


}
