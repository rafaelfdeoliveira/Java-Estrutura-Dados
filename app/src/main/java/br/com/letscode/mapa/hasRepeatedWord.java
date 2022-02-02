package br.com.letscode.mapa;

public class hasRepeatedWord {
    public hasRepeatedWord() {
        String text = "   joao maria    pedro joa     ";
        System.out.println(isRepeatingWord(text));
    }

    public static boolean isRepeatingWord(String text) {
        String[] words = text.strip().split("\\s+");
        for (int i = 0; i < words.length; i++) {
            int currentWordLength = words[i].length();
            for (int j = i + 1; j < words.length; j++) {
                int comparingWordLength = words[j].length();
                if (comparingWordLength != currentWordLength) continue;
                int count = 0;
                for (int z = 0; z < comparingWordLength; z++) {
                    if (words[i].charAt(z) != words[j].charAt(z)) break;
                    count++;
                }
                if (count == comparingWordLength) return true;
            }
        }
        return false;
    }
}
