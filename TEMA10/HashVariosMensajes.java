import java.security.MessageDigest;

public class HashVariosMensajes {
    public static void main(String[] args) throws Exception {
        byte[] m1 = "Bohemian Rhapsody".getBytes();
        byte[] m2 = "Imagine".getBytes();
        byte[] m3 = "Yesterday".getBytes();

        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(m1);
        md.update(m2);
        md.update(m3);

        byte[] hash = md.digest();
        System.out.println("HASH FINAL = " + HEXUtil.toHex(hash));
    }
}
