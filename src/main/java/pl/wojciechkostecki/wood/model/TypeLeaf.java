package pl.wojciechkostecki.wood.model;

public enum TypeLeaf {
    NEEDLE_SHAPED("needle"),
    BLADE("blade");

    private String value;

    TypeLeaf(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
