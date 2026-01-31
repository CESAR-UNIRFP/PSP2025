import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Arrays;

public class HybridAesRsaDemo {

    public static void main(String[] args) {
        System.out.println("=== DEMO HÍBRIDA (AES para datos + RSA para clave) ===");

        try {
            // RSA: par de claves
            KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
            kpg.initialize(2048);
            KeyPair kp = kpg.generateKeyPair();

            // AES: clave + IV
            KeyGenerator aesGen = KeyGenerator.getInstance("AES");
            aesGen.init(128);
            SecretKey aesKey = aesGen.generateKey();

            byte[] iv = new byte[12];
            new SecureRandom().nextBytes(iv);

            // 1) Cifrar mensaje con AES-GCM
            Cipher aes = Cipher.getInstance("AES/GCM/NoPadding");
            GCMParameterSpec gcm = new GCMParameterSpec(128, iv);

            String mensaje = "Mensaje largo que conviene cifrar con AES, no con RSA...";
            aes.init(Cipher.ENCRYPT_MODE, aesKey, gcm);
            byte[] cipherMsg = aes.doFinal(CryptoUtil.utf8(mensaje));

            // 2) Cifrar la clave AES con RSA (pública)
            Cipher rsa = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            rsa.init(Cipher.ENCRYPT_MODE, kp.getPublic());
            byte[] cipherKey = rsa.doFinal(aesKey.getEncoded());

            // ---- Lo que “envías” por red: cipherKey, iv, cipherMsg (en Base64)
            System.out.println("Clave AES cifrada (Base64): " + CryptoUtil.b64(cipherKey));
            System.out.println("IV (Base64): " + CryptoUtil.b64(iv));
            System.out.println("Mensaje cifrado (Base64): " + CryptoUtil.b64(cipherMsg));

            // 3) Receptor: descifra clave AES con RSA (privada)
            rsa.init(Cipher.DECRYPT_MODE, kp.getPrivate());
            byte[] aesKeyBytes = rsa.doFinal(cipherKey);
            SecretKey aesKeyRecovered = new SecretKeySpec(aesKeyBytes, "AES");

            // 4) Receptor: descifra mensaje con AES-GCM
            aes.init(Cipher.DECRYPT_MODE, aesKeyRecovered, gcm);
            byte[] plainMsg = aes.doFinal(cipherMsg);

            System.out.println("\nDescifrado final: " + CryptoUtil.utf8(plainMsg));

        } catch (GeneralSecurityException e) {
            System.out.println("Error híbrido: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }
}
