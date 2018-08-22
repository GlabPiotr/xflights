package com.braykoglab.xflights.configuration;

import android.content.Context;

import com.github.fernandodev.androidproperties.lib.AssetsProperties;
import com.github.fernandodev.androidproperties.lib.Property;

public final class Configuration extends AssetsProperties {

    @Property
    public static String LUFTHANSA_BASE_URL;

    @Property
    public static String LUFTHANSA_CLIEND_ID;

    @Property
    public static String LUFTHANSA_CLIENT_SECRET;

    @Property
    public static String LUFTHANSA_GRANT_TYPE;

    public Configuration(Context context) {
        super(context);
    }
}
