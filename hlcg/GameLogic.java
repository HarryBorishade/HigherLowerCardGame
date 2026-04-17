package hlcg.HigherLower;

import java.util.*;

public class GameLogic {

    private Deck deck;
    private List<Player> players;
    private Scanner scanner;

    public GameLogic() {
        this.deck = new Deck();
        this.players = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }
    private void setupPlayers() {
        System.out.print("Enter number of players: ");
        int numPlayers = scanner.nextInt();
        scanner.nextLine(); // clear buffer

        for (int i = 0; i < numPlayers; i++) {
            System.out.print("Enter name for Player " + (i + 1) + ": ");
            String name = scanner.nextLine();
            players.add(new Player(name));
        }
    }
    public void startGame() {
        setupPlayers();

        while (!deck.isEmpty()) {
            for (Player player : players) {
                if (deck.numberOfCards() < 2) break;

                playTurn(player);
            }
        }

        endGame();
    }
    private void playTurn(Player player) {
        Card current = deck.drawCard();

        System.out.println("\n" + player.getName() + "'s turn");
        System.out.println("Current card: " + current);
        System.out.print("Higher or Lower? (h/l): ");

        String guess = scanner.nextLine().toLowerCase();

        Card next = deck.drawCard();
        System.out.println("Next card: " + next);

        int currentValue = current.getRank().getValue();
        int nextValue = next.getRank().getValue();

        boolean correct =
                (guess.equals("h") && nextValue > currentValue) ||
                (guess.equals("l") && nextValue < currentValue);

        if (correct) {
            System.out.println("Correct!");
            player.increaseScore();
        } else {
            System.out.println("Wrong!");
        }
    }
    private void endGame() {
        System.out.println("\n--- Final Scores ---");

        for (Player player : players) {
            System.out.println(player.getName() + ": " + player.getScore());
        }
    }
}