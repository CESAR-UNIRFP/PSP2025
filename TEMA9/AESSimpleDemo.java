import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class AESSimpleDemo {

    public static void main(String[] args) {
        System.out.println("=== DEMO AES (simple) ===");

        try {
            // 1) Clave AES (128 bits para compatibilidad)
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(128);
            SecretKey key = keyGen.generateKey();

            // 2) Cipher AES (por defecto suele ser AES/ECB/PKCS5Padding)
            Cipher cipher = Cipher.getInstance("AES");

            String mensajeOriginal = "La cripta mágica (AES)";
            byte[] plain = CryptoUtil.utf8(mensajeOriginal);

            // 3) Cifrar
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] encrypted = cipher.doFinal(plain);

            // 4) Descifrar
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] decrypted = cipher.doFinal(encrypted);

            System.out.println("Original : " + mensajeOriginal);
            System.out.println("Cifrado  (Base64): " + CryptoUtil.b64(encrypted));
            System.out.println("Descifrado: " + CryptoUtil.utf8(decrypted));

        } catch (GeneralSecurityException e) {
            System.out.println("Error AES: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }
}
