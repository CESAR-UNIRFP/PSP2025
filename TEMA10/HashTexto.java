import java.security.MessageDigest;

public class HashTexto {
    public static void main(String[] args) throws Exception {
        String texto = "Hola PSP";
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(texto.getBytes());

        byte[] hash = md.digest();
        System.out.println("SHA-256 = " + HEXUtil.toHex(hash));
    }
}


// "SHA-1", "SHA-512"