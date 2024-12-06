CLASE BigOAnalyzer

    // Inicializar mapa para contar complejidades
    INICIALIZAR complexitiesCount COMO un mapa vacío

    // Método para analizar código ingresado
    MÉTODO analyzeCode(código)
        SI el código no contiene "{" O "}"
            RETORNAR "El código no parece ser Java. Ingrese código válido."
        FIN SI

        DIVIDIR código en líneas
        INICIALIZAR loopDepth COMO 0
        LIMPIAR el mapa complexitiesCount

        // Análisis línea por línea
        PARA CADA línea EN el código
            REMOVER espacios en blanco de línea

            SI línea empieza con "for" O "while"
                INCREMENTAR loopDepth
                complexity ← getComplexityByDepth(loopDepth)
                AUMENTAR el conteo de complexity EN complexitiesCount
                AGREGAR resultado al análisis
            SINO SI línea ES "}"
                REDUCIR loopDepth A UN MÁXIMO DE 0
            FIN SI
        FIN PARA

        // Generar resumen de complejidades
        CREAR totalComplexities COMO una cadena vacía
        PARA CADA complejidad EN complexitiesCount
            AGREGAR formato "conteo x complejidad + " a totalComplexities
        FIN PARA
        REMOVER el último " + " de totalComplexities

        // Simplificar complejidad
        simplifiedComplexity ← simplifyBigO(complexitiesCount)

        // Evaluar calidad
        quality ← evaluateCodeQuality(simplifiedComplexity)

        RETORNAR análisis de línea + totalComplexities + simplifiedComplexity + quality
    FIN MÉTODO

    // Complejidad según profundidad
    MÉTODO getComplexityByDepth(profundidad)
        SEGÚN profundidad
            CASO 1: RETORNAR "O(n)"
            CASO 2: RETORNAR "O(n^2)"
            CASO 3: RETORNAR "O(n^3)"
            CASO 4: RETORNAR "O(n^4)"
            DEFAULT: RETORNAR "O(n^" + profundidad + ")"
        FIN SEGÚN
    FIN MÉTODO

    // Simplificar Big O
    MÉTODO simplifyBigO(complejidades)
        SI contiene "O(n!)": RETORNAR "O(n!)"
        SI contiene "O(2^n)": RETORNAR "O(2^n)"
        SI contiene "O(n^4)": RETORNAR "O(n^4)"
        SI contiene "O(n^3)": RETORNAR "O(n^3)"
        SI contiene "O(n^2)": RETORNAR "O(n^2)"
        SI contiene "O(n log n)": RETORNAR "O(n log n)"
        SI contiene "O(n)": RETORNAR "O(n)"
        SI contiene "O(log n)": RETORNAR "O(log n)"
        RETORNAR "O(1)"
    FIN MÉTODO

    // Calidad de complejidad
    MÉTODO evaluateCodeQuality(complejidad)
        SEGÚN complejidad
            CASO "O(1)": RETORNAR "Excelente/Mejor"
            CASO "O(log n)": RETORNAR "Bueno"
            CASO "O(n)": RETORNAR "Aceptable"
            CASO "O(n log n)": RETORNAR "Malo"
            CASO "O(n^2)": RETORNAR "Pobre"
            CASO "O(n^3)": RETORNAR "Muy pobre"
            CASO "O(n^4)": RETORNAR "Extremadamente ineficiente"
            DEFAULT: RETORNAR "Horrible/Peor"
        FIN SEGÚN
    FIN MÉTODO

    // Obtener las complejidades detectadas
    MÉTODO getComplexities()
        RETORNAR complexitiesCount
    FIN MÉTODO

FIN CLASE
