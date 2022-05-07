package com.google.appinventor.components.runtime;

import android.util.Log;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.common.ComponentCategory;

@SimpleObject
@DesignerComponent(category = ComponentCategory.INTERNAL, description = "write in ode", iconName = "images/chameleon.png", nonVisible = true, version = 1)
public class KodularChameleonAd extends AndroidNonvisibleComponent implements Component {
    private static final String LOG_TAG = "Kodular Chameleon Ad";

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KodularChameleonAd(ComponentContainer componentContainer) {
        super(componentContainer.$form());
        int d = Log.d(LOG_TAG, "Kodular Chameleon Ad Created");
    }

    @SimpleFunction(description = "Load a new interstitial chameleon ad.")
    public void LoadAd() {
    }

    @SimpleFunction(description = "Show a chameleon interstitial ad after it was loaded.")
    public void ShowAd() {
        int i = Log.i(LOG_TAG, "ShowAd was called.");
    }

    @SimpleEvent(description = "Event triggered when ads are loaded.")
    public void AdLoaded() {
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "AdLoaded", new Object[0]);
    }

    @SimpleEvent(description = "Event triggered when ads are closed.")
    public void AdClosed() {
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "AdClosed", new Object[0]);
    }

    @SimpleEvent(description = "Event triggered when ads failed to load. Here is the list with all possible error codes (int) and error messages (string): '1' = The before loaded ad was not finished. It is not allowed to load a new one. The first must be in finished loading process. '2' = Ad failed to load. No internet connection available. '3' = Please enter a valid chameleon 'App ID'. '4' = Please enter a valid chameleon 'User ID'. '5' = UNKNOWN_WEB_VIEW_ERROR. '6' = There was an error validating the SSL Certificate.")
    public void AdFailedToLoad(String str, int i) {
        Object[] objArr = new Object[2];
        objArr[0] = str;
        Object[] objArr2 = objArr;
        objArr2[1] = Integer.valueOf(i);
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "AdFailedToLoad", objArr2);
    }

    @SimpleEvent(description = "Event triggered when ads failed to show. Here is the list with all possible error codes (int) and error messages (string): '1' = UNKNOWN_ERROR_ON_SHOW_AD. '2' = The ad must first be loaded. After loading finished the ad can be shown.")
    public void AdFailedToShow(String str, int i) {
        Object[] objArr = new Object[2];
        objArr[0] = str;
        Object[] objArr2 = objArr;
        objArr2[1] = Integer.valueOf(i);
        boolean dispatchEvent = EventDispatcher.dispatchEvent(this, "AdFailedToShow", objArr2);
    }

    @DesignerProperty(defaultValue = "", editorType = "string")
    @SimpleProperty(description = "Input here your own Chameleon Ad 'App ID' (request one at my.kodular.io).")
    public void AppId(String str) {
    }

    @DesignerProperty(defaultValue = "", editorType = "string")
    @SimpleProperty(description = "Input here your own Chameleon Ad 'User ID' (get yours at my.kodular.io).")
    public void UserId(String str) {
    }

    @DesignerProperty(defaultValue = "False", editorType = "boolean")
    @SimpleProperty(description = "If set to true, the device will receive test ads. This option must be set before you load a new ad.")
    public void TestMode(boolean z) {
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR)
    public boolean TestMode() {
        return true;
    }
}
