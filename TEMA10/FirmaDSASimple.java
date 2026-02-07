import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Signature;

public class FirmaDSASimple {
    public static void main(String[] args) throws Exception {
        // 1) Par de claves DSA
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("DSA");
        KeyPair kp = kpg.generateKeyPair();

        // 2) Firmar
        byte[] mensaje = "CriptaMagica".getBytes(); // como en los apuntes
        Signature sig = Signature.getInstance("DSA");
        sig.initSign(kp.getPrivate());
        sig.update(mensaje);
        byte[] firma = sig.sign();

        System.out.println("Firma DSA (hex) = " + HEXUtil.toHex(firma));

        // 3) Verificar
        Signature ver = Signature.getInstance("DSA");
        ver.initVerify(kp.getPublic());
        ver.update(mensaje);
        boolean ok = ver.verify(firma);

        System.out.println(ok ? "Verificación OK ✅" : "Verificación FALLÓ ❌");

        // Prueba extra: si cambias el mensaje, debería fallar
        Signature ver2 = Signature.getInstance("DSA");
        ver2.initVerify(kp.getPublic());
        ver2.update("OtroMensaje".getBytes());
        System.out.println(ver2.verify(firma) ? "OK" : "FALLA (esperado)");
    }
}
