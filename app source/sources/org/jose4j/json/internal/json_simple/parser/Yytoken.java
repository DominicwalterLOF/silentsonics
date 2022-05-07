package org.jose4j.json.internal.json_simple.parser;

public class Yytoken {
    public static final int TYPE_COLON = 6;
    public static final int TYPE_COMMA = 5;
    public static final int TYPE_EOF = -1;
    public static final int TYPE_LEFT_BRACE = 1;
    public static final int TYPE_LEFT_SQUARE = 3;
    public static final int TYPE_RIGHT_BRACE = 2;
    public static final int TYPE_RIGHT_SQUARE = 4;
    public static final int TYPE_VALUE = 0;
    public int type = 0;
    public Object value = null;

    public Yytoken(int type2, Object value2) {
        this.type = type2;
        this.value = value2;
    }

    public String toString() {
        StringBuilder sb;
        new StringBuilder();
        StringBuilder sb2 = sb;
        switch (this.type) {
            case -1:
                StringBuilder append = sb2.append("END OF FILE");
                break;
            case 0:
                StringBuilder append2 = sb2.append("VALUE(").append(this.value).append(")");
                break;
            case 1:
                StringBuilder append3 = sb2.append("LEFT BRACE({)");
                break;
            case 2:
                StringBuilder append4 = sb2.append("RIGHT BRACE(})");
                break;
            case 3:
                StringBuilder append5 = sb2.append("LEFT SQUARE([)");
                break;
            case 4:
                StringBuilder append6 = sb2.append("RIGHT SQUARE(])");
                break;
            case 5:
                StringBuilder append7 = sb2.append("COMMA(,)");
                break;
            case 6:
                StringBuilder append8 = sb2.append("COLON(:)");
                break;
        }
        return sb2.toString();
    }
}
