package io.extra;

/**
 * Created by alexr on 15.01.1997.
 *
 * print integer
 * in HEX View
 *
 * 1 -> 0x01
 * 255 -> 0xFF
 *
 * if origin > 255 - only lower byte is used
 */
public class HexFromByte {
    private final int origin;

    public HexFromByte(byte origin) {
        this(0xFF & origin);
    }

    public HexFromByte(int origin) {
        this.origin = 0xFF & origin;
    }

    @Override
    public String toString() {
        return String.format("0x%02X", origin);
    }
}
