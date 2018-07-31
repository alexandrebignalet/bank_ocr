import java.util.Arrays;

public enum SymbolAsNumber {
    ZERO(" _ "+
         "| |"+
         "|_|", "0"),
    ONE("   "+
        "  |"+
        "  |", "1");

    private final String symbol;
    private final String value;

    SymbolAsNumber(String symbol, String value) {
        this.symbol = symbol;
        this.value = value;
    }

    public static SymbolAsNumber of(String symbol) {
        return Arrays.stream(SymbolAsNumber.values())
                .filter(symbolAsNumber -> symbolAsNumber.symbol.equals(symbol))
                .findFirst()
                .orElse(SymbolAsNumber.ZERO);
    }

    public String getValue() {
        return value;
    }
}
