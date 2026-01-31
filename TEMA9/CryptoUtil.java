import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class CryptoUtil {

    public static byte[] utf8(String s) {
        return s.getBytes(StandardCharsets.UTF_8);
    }

    public static String utf8(byte[] bytes) {
        return new String(bytes, StandardCharsets.UTF_8);
    }

    public static String b64(byte[] data) {
        return Base64.getEncoder().encodeToString(data);
    }

    public static byte[] fromB64(String b64) {
        return Base64.getDecoder().decode(b64);
    }

    public static void main(String[] args) {
        String original = "Hola Eclipse 👋 ñáéíóú";

        // String -> UTF8 bytes -> Base64
        byte[] bytes = utf8(original);
        String encoded = b64(bytes);

        // Base64 -> bytes -> String
        byte[] decodedBytes = fromB64(encoded);
        String decoded = utf8(decodedBytes);

        System.out.println("Original : " + original);
        System.out.println("Base64   : " + encoded);
        System.out.println("Decoded  : " + decoded);
        System.out.println("Igual?   : " + original.equals(decoded));
    }
}
