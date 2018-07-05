package io.extra;

public class ByteArrayToString {
    private final byte[] origin;

    public ByteArrayToString(byte[] origin) {
        this.origin = origin;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < origin.length; i++) {
            sb.append(new HexFromByte(origin[i]));
            if (i<origin.length-1) {
                sb.append(", ");
            } else {
                sb.append("]");
            }
        }
        return sb.toString();
    }
}
