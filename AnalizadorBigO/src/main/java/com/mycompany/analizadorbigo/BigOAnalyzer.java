package com.mycompany.analizadorbigo;

import java.util.HashMap;
import java.util.Map;

public class BigOAnalyzer {

    private Map<String, Integer> complexitiesCount; // Almacena las complejidades detectadas

    public BigOAnalyzer() {
        this.complexitiesCount = new HashMap<>();
    }

    public String analyzeCode(String code) {
        if (!code.contains("{") || !code.contains("}")) {
            return "El código no parece ser Java. Por favor, ingrese código válido en Java.";
        }

        String[] lines = code.split("\n");
        StringBuilder lineAnalysis = new StringBuilder();
        int loopDepth = 0; // Para detectar la profundidad de bucles anidados

        // Reiniciar conteo de complejidades
        complexitiesCount.clear();

        // Análisis línea por línea
        for (int i = 0; i < lines.length; i++) {
            String line = lines[i].trim();

            if (line.startsWith("for") || line.startsWith("while")) {
                loopDepth++;
                String complexity = getComplexityByDepth(loopDepth);
                lineAnalysis.append("Línea ").append(i + 1).append(": ").append(complexity).append("\n");
                complexitiesCount.put(complexity, complexitiesCount.getOrDefault(complexity, 0) + 1);
            } else if (line.equals("}")) {
                loopDepth = Math.max(0, loopDepth - 1); // Reducir profundidad al cerrar un bloque
            }
        }

        // Resumen total de complejidades
        StringBuilder totalComplexities = new StringBuilder();
        complexitiesCount.forEach((key, value) -> totalComplexities.append(value).append("x ").append(key).append(" + "));
        if (totalComplexities.length() > 0) {
            totalComplexities.setLength(totalComplexities.length() - 3); // Quitar " + " al final
        }

        String simplifiedComplexity = simplifyBigO(complexitiesCount);
        String quality = evaluateCodeQuality(simplifiedComplexity);

        return lineAnalysis.toString()
                + "Complejidad Total: " + totalComplexities + "\n"
                + "Simplificado: " + simplifiedComplexity + "\n"
                + "Calidad del Código: " + quality
                + "\n\nNota: Los bucles anidados incrementan exponencialmente la complejidad.";
    }

    private String getComplexityByDepth(int depth) {
        switch (depth) {
            case 1: return "O(n)";
            case 2: return "O(n^2)";
            case 3: return "O(n^3)";
            case 4: return "O(n^4)";
            default: return "O(n^" + depth + ")";
        }
    }

    private String simplifyBigO(Map<String, Integer> complexities) {
        if (complexities.containsKey("O(n!)")) return "O(n!)";
        if (complexities.containsKey("O(2^n)")) return "O(2^n)";
        if (complexities.containsKey("O(n^4)")) return "O(n^4)";
        if (complexities.containsKey("O(n^3)")) return "O(n^3)";
        if (complexities.containsKey("O(n^2)")) return "O(n^2)";
        if (complexities.containsKey("O(n log n)")) return "O(n log n)";
        if (complexities.containsKey("O(n)")) return "O(n)";
        if (complexities.containsKey("O(log n)")) return "O(log n)";
        return "O(1)";
    }

    private String evaluateCodeQuality(String complexity) {
        switch (complexity) {
            case "O(1)": return "Excelente/Mejor";
            case "O(log n)": return "Bueno";
            case "O(n)": return "Aceptable";
            case "O(n log n)": return "Malo";
            case "O(n^2)": return "Pobre";
            case "O(n^3)": return "Muy pobre";
            case "O(n^4)": return "Extremadamente ineficiente";
            default: return "Horrible/Peor";
        }
    }

    // Método para obtener las complejidades detectadas
    public Map<String, Integer> getComplexities() {
        return complexitiesCount;
    }
}
