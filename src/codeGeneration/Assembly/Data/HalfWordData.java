package codeGeneration.Assembly.Data;

public class HalfWordData extends GenericData {
    Integer[] bytes;

    public HalfWordData(String label, Integer... bytes) {
        super(label, ".halfword");
        for (Integer i : bytes) {
            if (i < 0 || i > 65535) {
                String msg = "arguments must be between 0 and 65535";
                throw new IllegalArgumentException(msg);
            }
        }
        this.bytes = bytes;
    }

    @Override
    String[] getArgStrings() {
        String[] args = new String[bytes.length];
        for (int i = 0; i < bytes.length; i++) {
            args[i] = bytes[i].toString();
        }
        return args;
    }
}
