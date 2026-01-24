public class CifradoAfin {

    private static final int A = 5;   // primo relativo con 26
    private static final int B = 8;
    private static final int M = 26;

    // Cifrado: E(x) = (a·x + b) mod m
    public static String cifrar(String texto) {
        StringBuilder sb = new StringBuilder();
        texto = texto.toUpperCase();

        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);

            if (c >= 'A' && c <= 'Z') {
                int x = c - 'A';
                int cifrado = (A * x + B) % M;
                sb.append((char) (cifrado + 'A'));
            } else {
                sb.append(c); // espacios, números, etc.
            }
        }
        return sb.toString();
    }

    // Descifrado: D(x) = a^-1 (x − b) mod m
    public static String descifrar(String texto) {
        StringBuilder sb = new StringBuilder();
        texto = texto.toUpperCase();

        int aInv = inversoMultiplicativo(A);

        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);

            if (c >= 'A' && c <= 'Z') {
                int y = c - 'A';
                int descifrado = aInv * (y - B);
                descifrado = ((descifrado % M) + M) % M;
                sb.append((char) (descifrado + 'A'));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private static int inversoMultiplicativo(int a) {
        for (int i = 1; i < M; i++) {
            if ((a * i) % M == 1) {
                return i;
            }
        }
        throw new RuntimeException("No existe inverso multiplicativo");
    }
}
