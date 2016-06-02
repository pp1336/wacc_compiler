package codeGeneration.Assembly.Data;

public class BytesData extends GenericData {
    Integer[] bytes;

    public BytesData(String label, Integer... bytes) {
        super(label, ".byte");
        for (Integer i : bytes) {
            if (i < 0 || i > 255) {
                String msg = "arguments must be between 0 and 255";
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
