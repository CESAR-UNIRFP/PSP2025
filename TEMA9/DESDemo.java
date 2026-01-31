import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class DESDemo {

    public static void main(String[] args) {
        System.out.println("=== DEMO DES (simétrico) ===");

        try {
            // 1) Generar clave DES
            KeyGenerator keyGen = KeyGenerator.getInstance("DES");
            SecretKey key = keyGen.generateKey();

            // 2) Preparar Cipher (explícito para claridad)
            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");

            String mensajeOriginal = "La cripta mágica (DES)";
            byte[] plain = CryptoUtil.utf8(mensajeOriginal);

            // 3) Cifrar
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] encrypted = cipher.doFinal(plain);
            String encryptedB64 = CryptoUtil.b64(encrypted);

            // 4) Descifrar
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] decrypted = cipher.doFinal(encrypted);

            System.out.println("Original : " + mensajeOriginal);
            System.out.println("Cifrado  (Base64): " + encryptedB64);
            System.out.println("Descifrado: " + CryptoUtil.utf8(decrypted));

        } catch (GeneralSecurityException e) {
            System.out.println("Error DES: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }
}
