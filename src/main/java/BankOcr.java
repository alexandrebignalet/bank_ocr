import java.util.Arrays;

public class BankOcr {

    public static void main(String[] args) {
        System.out.println("hello");
    }

    public static String parseSymbol(String symbol) {
        return SymbolAsNumber.of(symbol).getValue();
    }

    public static String parseLine(String rawAccountNumber) {
        if (rawAccountNumber.length() % 27 != 0) throw new IllegalArgumentException("invalid account number length");

        StringBuilder result = new StringBuilder();

        int i = 0;
        while(i < 9) {
            int indexScaling = i*3;
            result.append(
                    parseSymbol(
                            rawAccountNumber.substring(indexScaling, indexScaling+3) +
                        rawAccountNumber.substring(indexScaling+27, indexScaling+27+3) +
                        rawAccountNumber.substring(indexScaling+27*2, indexScaling+27*2+3)
                    )
            );
            i++;
        }


        return result.toString();
    }

    public String buildBlockFromRawAccount(String lastBlock, int startingIndex) {
        int endingIndex = lastBlock.length() + 3;
        buildBlockFromRawAccount()
    }
}
