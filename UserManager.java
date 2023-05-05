package p;
import java.io.*;
import java.util.HashMap;

public class UserManager {
	private final String filePath = "users.txt";
    private HashMap<String, User> users;

    public UserManager() {
        users = new HashMap<>();
        loadUsers();
    }

    public boolean signUp(String username, String password,String email) {
        if (users.containsKey(username)) {
            return false;
        }
        User newUser = new User(username, password);
        users.put(username, newUser);
        saveUsers();
        return true;
    }

    public boolean logIn(String username, String password ) {
        User user = users.get(username);
        return user != null && user.getPassword().equals(password);
    }

    private void loadUsers() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userData = line.split(",");
                users.put(userData[0], new User(userData[0], userData[1]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveUsers() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (User user : users.values()) {
                writer.write(user.getUsername() + "," + user.getPassword());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
