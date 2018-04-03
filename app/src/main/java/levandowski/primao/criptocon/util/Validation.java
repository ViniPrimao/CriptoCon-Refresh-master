package levandowski.primao.criptocon.util;

import java.text.DecimalFormat;

public class Validation {

    public static String validationPrice(double price){
        DecimalFormat format = new DecimalFormat("0.##");
        return format.format(price);
    }
}
