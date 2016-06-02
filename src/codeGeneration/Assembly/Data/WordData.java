package codeGeneration.Assembly.Data;

public class WordData extends GenericData {
    Integer[] words;

    public WordData(String label, Integer... words) {
        super(label, ".word");
        this.words = words;
    }

    @Override
    String[] getArgStrings() {
        String[] args = new String[words.length];
        for (int i = 0; i < words.length; i++) {
            args[i] = words[i].toString();
        }
        return args;
    }
}
