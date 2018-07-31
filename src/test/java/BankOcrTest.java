import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankOcrTest {

    @Test
    public void shouldMapNumberFromFileToInteger() {
        String symbol_0 =
                " _ " +
                "| |" +
                "|_|";

        assertThat(BankOcr.parseSymbol(symbol_0)).isEqualTo("0");

        String symbol_1 =
                "   "+
                "  |"+
                "  |";

        assertThat(BankOcr.parseSymbol(symbol_1)).isEqualTo("1");
    }

    @Test
    public void shouldParseLineOf27CharsLong() {
        String wrongRawAccountNumberPattern = " ";
        assertThrows(IllegalArgumentException.class, () -> BankOcr.parseLine(wrongRawAccountNumberPattern));
    }

    @Test
    public void shouldParseALineOfSymbols() {
        String symbols =  "                           "+
                          "  |  |  |  |  |  |  |  |  |"+
                          "  |  |  |  |  |  |  |  |  |";

        assertThat(BankOcr.parseLine(symbols)).isEqualTo("111111111");
    }
}
