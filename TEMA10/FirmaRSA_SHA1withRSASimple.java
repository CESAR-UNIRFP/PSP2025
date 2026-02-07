import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Signature;

public class FirmaRSA_SHA1withRSASimple {
    public static void main(String[] args) throws Exception {
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        kpg.initialize(2048);
        KeyPair kp = kpg.generateKeyPair();

        byte[] mensaje = "CriptaMagica".getBytes();

        Signature sig = Signature.getInstance("SHA1withRSA");
        sig.initSign(kp.getPrivate());
        sig.update(mensaje);
        byte[] firma = sig.sign();

        System.out.println("Firma SHA1withRSA (hex) = " + HEXUtil.toHex(firma));

        Signature ver = Signature.getInstance("SHA1withRSA");
        ver.initVerify(kp.getPublic());
        ver.update(mensaje);

        System.out.println(ver.verify(firma) ? "Verificación OK ✅" : "Verificación FALLÓ ❌");
    }
}
