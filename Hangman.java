public class Hangman {
    private static final String[] WORDS = {"JAVA", "PYTHON", "COMPUTER", "PROGRAMMING", "ALGORITHM", "DATABASE"};
    private static final int MAX_TRIES = 6;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Hangman!");
        System.out.println("Try to guess the word.");

        String wordToGuess = WORDS[(int) (Math.random() * WORDS.length)].toUpperCase();
        StringBuilder guessedWord = new StringBuilder("_".repeat(wordToGuess.length()));

        int tries = 0;
        while (tries < MAX_TRIES && guessedWord.toString().contains("_")) {
            System.out.println("\n" + guessedWord);
            System.out.print("Enter a letter: ");
            char guess = scanner.nextLine().toUpperCase().charAt(0);

            boolean found = false;
            for (int i = 0; i < wordToGuess.length(); i++) {
                if (wordToGuess.charAt(i) == guess) {
                    guessedWord.setCharAt(i, guess);
                    found = true;
                }
            }

            if (!found) {
                tries++;
                System.out.println("Incorrect guess. You have " + (MAX_TRIES - tries) + " tries left.");
            }
        }

        if (guessedWord.toString().equals(wordToGuess)) {
            System.out.println("Congratulations! You guessed the word: " + wordToGuess);
        } else {
            System.out.println("Sorry, you ran out of tries. The word was: " + wordToGuess);
        }

        scanner.close();
    }
}