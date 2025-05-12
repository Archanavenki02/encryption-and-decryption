import java.util.Scanner;

public class EncryptionDecryption {

    // Method to encrypt text using Caesar Cipher
    public static String encrypt(String text, int shift) {
        StringBuilder encryptedText = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                ch = (char) ((ch - base + shift) % 26 + base);
            }

            encryptedText.append(ch);
        }

        return encryptedText.toString();
    }

    // Method to decrypt text using Caesar Cipher
    public static String decrypt(String text, int shift) {
        return encrypt(text, 26 - (shift % 26));
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Simple Encryption and Decryption Tool");
        System.out.print("Enter the text: ");
        String text = scanner.nextLine();

        System.out.print("Enter the shift value (1-25): ");
        int shift = scanner.nextInt();

        String encryptedText = encrypt(text, shift);
        String decryptedText = decrypt(encryptedText, shift);

        System.out.println("\nEncrypted Text: " + encryptedText);
        System.out.println("Decrypted Text: " + decryptedText);

        scanner.close();
    }
}