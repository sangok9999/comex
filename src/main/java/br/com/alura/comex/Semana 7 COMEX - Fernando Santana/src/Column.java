public @interface Column {
    String name();

    boolean nullable();

    int length();
}
