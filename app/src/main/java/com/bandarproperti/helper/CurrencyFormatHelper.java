package com.bandarproperti.helper;

import java.text.DecimalFormat;

/**
 * Created by arief on 08-Jul-17.
 */

public class CurrencyFormatHelper {

    DecimalFormat localFormat;

    public String localFormatView(int value){
        localFormat = new DecimalFormat("##,###.##");
        return localFormat.format(value);
    }
}
