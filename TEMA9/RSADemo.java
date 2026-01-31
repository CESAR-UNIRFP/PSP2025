import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import javax.crypto.Cipher;

public class RSADemo {

    public static void main(String[] args) {
        System.out.println("=== DEMO RSA (asimétrico) ===");

        try {
            // 1) Generar par de claves
            KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
            kpg.initialize(2048);
            KeyPair kp = kpg.generateKeyPair();

            // 2) Cipher RSA
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");

            String mensajeOriginal = "Hola RSA";
            byte[] plain = CryptoUtil.utf8(mensajeOriginal);

            // 3) Cifrar con clave pública
            cipher.init(Cipher.ENCRYPT_MODE, kp.getPublic());
            byte[] encrypted = cipher.doFinal(plain);

            // 4) Descifrar con clave privada
            cipher.init(Cipher.DECRYPT_MODE, kp.getPrivate());
            byte[] decrypted = cipher.doFinal(encrypted);

            System.out.println("Original : " + mensajeOriginal);
            System.out.println("Cifrado  (Base64): " + CryptoUtil.b64(encrypted));
            System.out.println("Descifrado: " + CryptoUtil.utf8(decrypted));

            System.out.println("\nNota docente: RSA no es para textos largos; se usa para cifrar claves o datos pequeños.");

        } catch (GeneralSecurityException e) {
            System.out.println("Error RSA: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }
}
