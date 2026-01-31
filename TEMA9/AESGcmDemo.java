import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;

public class AESGcmDemo {

    public static void main(String[] args) {
        System.out.println("=== DEMO AES/GCM (recomendado) ===");

        try {
            // 1) Clave AES
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(128);
            SecretKey key = keyGen.generateKey();

            // 2) IV aleatorio (12 bytes recomendado en GCM)
            byte[] iv = new byte[12];
            new SecureRandom().nextBytes(iv);

            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            GCMParameterSpec spec = new GCMParameterSpec(128, iv); // 128 bits de tag

            String mensajeOriginal = "Mensaje AES-GCM";
            byte[] plain = CryptoUtil.utf8(mensajeOriginal);

            // 3) Cifrar
            cipher.init(Cipher.ENCRYPT_MODE, key, spec);
            byte[] encrypted = cipher.doFinal(plain);

            // 4) Descifrar (necesitas la MISMA clave y el MISMO IV)
            cipher.init(Cipher.DECRYPT_MODE, key, spec);
            byte[] decrypted = cipher.doFinal(encrypted);

            System.out.println("Original : " + mensajeOriginal);
            System.out.println("IV       (Base64): " + CryptoUtil.b64(iv));
            System.out.println("Cifrado  (Base64): " + CryptoUtil.b64(encrypted));
            System.out.println("Descifrado: " + CryptoUtil.utf8(decrypted));

        } catch (GeneralSecurityException e) {
            System.out.println("Error AES-GCM: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }
}
