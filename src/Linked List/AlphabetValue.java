package LinkedList;

public class AlphabetValue {
    public static void main(String[] args) {
        char letter = 'b'; // Example letter
        int value = getAlphabetValue(letter);
        System.out.println("The place value of '" + letter + "' is: " + value);
    }

    public static int getAlphabetValue(char letter) {
        // Convert letter to lowercase to handle both uppercase and lowercase input
        letter = Character.toLowerCase(letter);
        
        // Ensure the letter is within 'a' to 'z'
        if (letter < 'a' || letter > 'z') {
            throw new IllegalArgumentException("Input must be a letter between 'a' and 'z'.");
        }
        
        // Calculate the place value
        return letter - 'a' + 1;
    }
}
