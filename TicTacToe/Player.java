package TicTacToe;

import java.util.ArrayList;

public class Player {
    private static ArrayList<Player> players = new ArrayList<Player>();
    // id is the player's tag when playing e.g. X or Os
    private String id;

    public Player(String id) {
        players.add(this);
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public static int findPlayerIndexByID(String id) {
        for (Player player : players) {
            if (player.getId().equals(id)) {
                return players.indexOf(player);
            }
        }
        return -1;
    }

    public static ArrayList<Player> getPlayers() {
        return Player.players;
    }
}
