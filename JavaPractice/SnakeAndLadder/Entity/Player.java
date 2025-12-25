package JavaPractice.SnakeAndLadder.Entity;

public class Player {
    int userId;
    String usrName;

    public Player(int userId, String userName){
        this.userId = userId;
        this.usrName = userName;
    }

    public int getUserId() {
        return userId;
    }

    public String getUsrName() {
        return usrName;
    }
}
