import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;

public class HashArchivo {
    public static void main(String[] args) throws Exception {
        Path ruta = Path.of(System.getProperty("user.dir"), "src/datos.txt"); //Path.of("datos.txt");     
        MessageDigest md = MessageDigest.getInstance("SHA-256");

        try (InputStream in = Files.newInputStream(ruta)) {
            byte[] buffer = new byte[4096];
            int n;
            while ((n = in.read(buffer)) != -1) {
                md.update(buffer, 0, n);
            }
        }

        byte[] hash = md.digest();
        System.out.println("SHA-256(datos.txt) = " + HEXUtil.toHex(hash));
    }
}
