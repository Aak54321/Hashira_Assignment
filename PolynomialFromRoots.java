import com.google.gson.*;
import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class PolynomialFromRoots {
    public static void main(String[] args) throws Exception {
        // Read JSON file
        FileReader reader = new FileReader("input.json");
        JsonObject obj = JsonParser.parseReader(reader).getAsJsonObject();
        reader.close();

        // Extract n and k
        JsonObject keys = obj.getAsJsonObject("keys");
        int n = keys.get("n").getAsInt();
        int k = keys.get("k").getAsInt();
        int degree = k - 1;

        // Collect roots in decimal
        List<BigInteger> roots = new ArrayList<>();
        for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
            if (entry.getKey().equals("keys")) continue;

            JsonObject rootObj = entry.getValue().getAsJsonObject();
            int base = Integer.parseInt(rootObj.get("base").getAsString());
            String valStr = rootObj.get("value").getAsString();

            BigInteger root = new BigInteger(valStr, base);
            roots.add(root);
        }

        // Use only first 'degree' roots
        List<BigInteger> selectedRoots = roots.subList(0, degree);

        // Polynomial coefficients (monic polynomial starts with [1])
        List<BigInteger> coeffs = new ArrayList<>();
        coeffs.add(BigInteger.ONE);

        for (BigInteger root : selectedRoots) {
            List<BigInteger> newCoeffs = new ArrayList<>(Collections.nCopies(coeffs.size() + 1, BigInteger.ZERO));
            for (int i = 0; i < coeffs.size(); i++) {
                // Multiply existing term by x (shift)
                newCoeffs.set(i, newCoeffs.get(i).add(coeffs.get(i)));
                // Multiply existing term by (-root)
                newCoeffs.set(i + 1, newCoeffs.get(i + 1).add(coeffs.get(i).negate().multiply(root)));
            }
            coeffs = newCoeffs;
        }

        // Print coefficients
        System.out.println("Polynomial coefficients:");
        for (BigInteger c : coeffs) {
            System.out.print(c + " ");
        }
        System.out.println();
    }
}
