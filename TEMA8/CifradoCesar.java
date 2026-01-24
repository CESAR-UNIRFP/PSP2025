public class CifradoCesar {

    private static final String ABC = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
    private static final int DESPLAZAMIENTO = 3;

    public static String cifrar(String texto) {
        return transformar(texto, +DESPLAZAMIENTO);
    }

    public static String descifrar(String texto) {
        return transformar(texto, -DESPLAZAMIENTO);
    }

    private static String transformar(String texto, int desplazamiento) {
        if (texto == null) return null;

        StringBuilder sb = new StringBuilder();
        String t = texto.toUpperCase();

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            int pos = ABC.indexOf(c);

            if (pos == -1) {
                // Si no está en el alfabeto (espacios, dos puntos, números...), lo dejamos igual
                sb.append(c);
            } else {
                int nuevaPos = (pos + desplazamiento) % ABC.length();
                if (nuevaPos < 0) nuevaPos += ABC.length();
                sb.append(ABC.charAt(nuevaPos));
            }
        }
        return sb.toString();
    }
}
