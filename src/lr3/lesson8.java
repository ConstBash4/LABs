package lr3;

public class lesson8 {
    public static void main(String[] args) {
        char[] vowels = new char[] {'A', 'E', 'I', 'O', 'U', 'Y'};
        char[] alphabet = new char[10];
        char letter = 'A'; boolean isVowel;

        for(int i = 0; i < alphabet.length; i++) {
            do {
                isVowel = false;
                for (int j = 0; j < vowels.length; j++) {
                    if(letter == vowels[j]) {
                        isVowel = true;
                        break;
                    }
                }
                if(isVowel) letter++;
            } while (isVowel);
            alphabet[i] = letter;
            letter++;
        }

        MasOutput(alphabet);
    }

    private static void MasOutput(char[] mas) {
        for (int i = 0; i < mas.length; i++) {
            System.out.print(mas[i] + " ");
        }
        System.out.print("\n");
    }
}
