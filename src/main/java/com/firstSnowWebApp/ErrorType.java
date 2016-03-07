package com.firstSnowWebApp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2/27/2016.
 */
public interface ErrorType {

    public String getMessage();

    default String formatMessage(Object... vals) {

        // here we convert the Array values in string for better display
        vals = Arrays.asList(vals).stream().map(v ->
                (v.getClass().isArray())?Arrays.toString((Object[])v):v
        ).toArray();

        return String.format(getMessage(), vals);
    }
}