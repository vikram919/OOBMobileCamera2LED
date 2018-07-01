package de.unirostock.de.oobmobilecamera2led;

public interface BitStreamDetectorKeyReadCallback {
    public void onKeyRead(String key);
    public void onSymbolRead(Boolean symbol);
    public void onStateChanged(int state);
    public void onReset();
}
