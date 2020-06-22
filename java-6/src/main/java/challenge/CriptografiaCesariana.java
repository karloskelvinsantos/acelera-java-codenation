package challenge;

public class CriptografiaCesariana implements Criptografia {
    public static final int KEY = 3;

    @Override
    public String criptografar(String texto) {
       return shiftCharacters(texto, true);
    }

    @Override
    public String descriptografar(String texto) {
        return shiftCharacters(texto, false);
    }

    public String shiftCharacters(String text, boolean isEncrypt) {
        if (text.isEmpty()) throw new IllegalArgumentException();

        StringBuilder shiftedCharacters = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char letter = text.toLowerCase().charAt(i);
            if (Character.isLetter(letter)) {
                letter = isEncrypt ? encrypt(letter) : decrypt(letter);
            }
            shiftedCharacters.append(letter);
        }

        return shiftedCharacters.toString();
    }

    public char encrypt(int i) {
        i += KEY;
        return (char) (i > 122 ? ((i % 122) + 97 - 1) : i);
    }

    public char decrypt(int i) {
        i -= KEY;
        return (char) (i < 97 ? (122 - (3 - (((i + 3) % 97) + 3))) : i);
    }

}
