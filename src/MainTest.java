import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

enum ColorCode1 implements ColorCode {
    RED(1, "10"), GREEN(3, "30") ,BLUE(2, "20");;

    private final String colorCode;
    private final int sequence;

    ColorCode1(int sequence, String colorCode) {
        this.colorCode = colorCode;
        this.sequence = sequence;
    }

    public String getColorCode() {
        return colorCode;
    }

    public int getSequence() {
        return sequence;
    }

    public static String getLimitedColorCodeSequence(int linkedAccounts) {
        return ColorCodeUtils.getLimitedColorCodeSequence(linkedAccounts, ColorCode1.class);
    }
}

enum ColorCode2 implements ColorCode {
    YELLOW(2, "10"), ORANGE(1, "30") ,PINK(3, "20");;
    private final String colorCode;
    private final int sequence;

    ColorCode2(int sequence, String colorCode) {
        this.sequence = sequence;
        this.colorCode = colorCode;
    }

    public String getColorCode() {
        return colorCode;
    }

    public int getSequence() {
        return sequence;
    }

    public static String getLimitedColorCodeSequence(int linkedAccounts) {
        return ColorCodeUtils.getLimitedColorCodeSequence(linkedAccounts, ColorCode2.class);
    }
}

interface ColorCode {
    String getColorCode();

    int getSequence();
}

class ColorCodeUtils {
    public static String getLimitedColorCodeSequence(int linkedAccounts, Class<? extends ColorCode> enumClass) {
        ColorCode[] colorCodes = enumClass.getEnumConstants();
        List<String> codes = Arrays.stream(colorCodes)
                .sorted(Comparator.comparingInt(ColorCode::getSequence))
                .map(ColorCode::getColorCode)
                .limit(linkedAccounts)
                .collect(Collectors.toList());

        return String.join(", ", codes);
    }
}

public class MainTest {
    public static void main(String[] args) {
        int linkedAccounts = 3;

        // Calling ColorCode1
        String colorCodeSequence1 = ColorCode1.getLimitedColorCodeSequence(linkedAccounts);
        System.out.println("ColorCode1 Sequence: " + colorCodeSequence1);

        // Calling ColorCode2
        String colorCodeSequence2 = ColorCode2.getLimitedColorCodeSequence(linkedAccounts);
        System.out.println("ColorCode2 Sequence: " + colorCodeSequence2);
    }
}
