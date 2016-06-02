package codeGeneration.Assembly.Data;

/**
 * Represents static data
 */
public abstract class GenericData implements Data {
    private final String directive;
    private final String label;

    GenericData(String label, String directive) {
        this.label = label;
        this.directive = directive;
    }

    abstract String[] getArgStrings();

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public String getRepresentation() {
        StringBuilder sb = new StringBuilder();
        sb.append(label).append(":\t");
        sb.append(directive).append(" ");
        boolean commas = false;
        for (String s : getArgStrings()) {
            if (commas) sb.append(", ");
            else commas = true;
            sb.append(s);
        }
        return sb.toString();
    }
}
