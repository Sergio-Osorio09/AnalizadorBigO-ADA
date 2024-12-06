CLASE BigOChart

    MÉTODO createChartPanel(complexities: Map<String, Integer>) -> JPanel
        CREAR dataset USANDO createDataset(complexities)
        CREAR gráfico USANDO ChartFactory.createXYLineChart CON:
            - Título: "Simulación de Complejidad Big O"
            - Eje X: "Tamaño de Entrada (n)"
            - Eje Y: "Operaciones"
            - Dataset creado previamente
        RETORNAR nuevo ChartPanel USANDO el gráfico
    FIN MÉTODO

    MÉTODO PRIVADO createDataset(complexities: Map<String, Integer>) -> XYSeriesCollection
        CREAR dataset COMO nuevo XYSeriesCollection

        SI complexities CONTIENE "O(1)"
            CREAR serie constant COMO nuevo XYSeries CON nombre "O(1)"
            PARA n DESDE 1 HASTA 10
                AGREGAR punto (n, 1) A constant
            FIN PARA
            AGREGAR constant AL dataset
        FIN SI

        SI complexities CONTIENE "O(n)"
            CREAR serie linear COMO nuevo XYSeries CON nombre "O(n)"
            PARA n DESDE 1 HASTA 10
                AGREGAR punto (n, n) A linear
            FIN PARA
            AGREGAR linear AL dataset
        FIN SI

        SI complexities CONTIENE "O(n^2)"
            CREAR serie quadratic COMO nuevo XYSeries CON nombre "O(n^2)"
            PARA n DESDE 1 HASTA 10
                AGREGAR punto (n, n^2) A quadratic
            FIN PARA
            AGREGAR quadratic AL dataset
        FIN SI

        SI complexities CONTIENE "O(n^3)"
            CREAR serie cubic COMO nuevo XYSeries CON nombre "O(n^3)"
            PARA n DESDE 1 HASTA 10
                AGREGAR punto (n, n^3) A cubic
            FIN PARA
            AGREGAR cubic AL dataset
        FIN SI

        SI complexities CONTIENE "O(n^4)"
            CREAR serie quartic COMO nuevo XYSeries CON nombre "O(n^4)"
            PARA n DESDE 1 HASTA 10
                AGREGAR punto (n, n^4) A quartic
            FIN PARA
            AGREGAR quartic AL dataset
        FIN SI

        SI complexities CONTIENE "O(log n)"
            CREAR serie logarithmic COMO nuevo XYSeries CON nombre "O(log n)"
            PARA n DESDE 1 HASTA 10
                AGREGAR punto (n, log(n)) A logarithmic
            FIN PARA
            AGREGAR logarithmic AL dataset
        FIN SI

        SI complexities CONTIENE "O(2^n)"
            CREAR serie exponential COMO nuevo XYSeries CON nombre "O(2^n)"
            PARA n DESDE 1 HASTA 10
                AGREGAR punto (n, 2^n) A exponential
            FIN PARA
            AGREGAR exponential AL dataset
        FIN SI

        RETORNAR dataset
    FIN MÉTODO

FIN CLASE
