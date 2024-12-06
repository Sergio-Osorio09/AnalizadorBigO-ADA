CLASE BigOAnalyzerApp

    INICIALIZAR codeInput COMO área de texto para ingresar código
    INICIALIZAR resultOutput COMO área de texto para mostrar resultados
    INICIALIZAR analyzeButton COMO botón "Analizar"
    INICIALIZAR clearButton COMO botón "Limpiar"
    INICIALIZAR tabbedPane COMO pestañas para "Resultados" y "Gráfico"
    INICIALIZAR resultPanel COMO panel para mostrar resultados
    INICIALIZAR chartPanel COMO panel para mostrar gráficos

    FUNCIÓN BigOAnalyzerApp() // Constructor de la ventana
        ESTABLECER título de la ventana a "Big O Complexity Analyzer"
        CONFIGURAR tamaño de la ventana a 1000x800
        CONFIGURAR operación de cierre a EXIT_ON_CLOSE
        CENTRAR ventana en la pantalla
        CONFIGURAR layout COMO BorderLayout

        // Configurar área de entrada de código
        CREAR JScrollPane PARA codeInput con título "Ingrese el Código Aquí"

        // Configurar botones
        AGREGAR acción a analyzeButton QUE LLAMA A AnalyzeButtonListener
        AGREGAR acción a clearButton QUE LLAMA A ClearButtonListener

        CREAR panel para botones Y AGREGAR analyzeButton Y clearButton

        // Configurar área de resultados
        CONFIGURAR resultOutput como no editable
        CREAR JScrollPane PARA resultOutput con título "Resultados del Análisis"
        AGREGAR JScrollPane a resultPanel

        // Configurar panel de gráficos
        CONFIGURAR chartPanel CON layout BorderLayout y título "Simulación de Complejidad Big O"

        // Configurar pestañas
        AGREGAR pestaña "Resultados" QUE CONTIENE resultPanel a tabbedPane
        AGREGAR pestaña "Gráfico" QUE CONTIENE chartPanel a tabbedPane

        // Agregar componentes principales a la ventana
        AGREGAR inputScrollPane AL NORTE
        AGREGAR tabbedPane AL CENTRO
        AGREGAR buttonPanel AL SUR
    FIN FUNCIÓN
FIN CLASE

    CLASE INTERNA AnalyzeButtonListener IMPLEMENTA ActionListener
        MÉTODO actionPerformed(evento)
            OBTENER texto de codeInput
            CREAR instancia de BigOAnalyzer
            ANALIZAR código usando analyzer

            // Mostrar resultados en resultOutput
            MOSTRAR resultados en resultOutput

            // Generar gráfico basado en complejidades
            OBTENER complejidades del analyzer
            CREAR gráfico dinámico usando BigOChart

            // Actualizar panel de gráficos
            LIMPIAR chartPanel
            AGREGAR nuevo gráfico a chartPanel
            REFRESCAR chartPanel

            // Cambiar a la pestaña de resultados
            SELECCIONAR pestaña "Resultados" en tabbedPane
        FIN MÉTODO
    FIN CLASE

    CLASE INTERNA ClearButtonListener IMPLEMENTA ActionListener
        MÉTODO actionPerformed(evento)
            LIMPIAR contenido de codeInput y resultOutput
            LIMPIAR chartPanel
            REFRESCAR chartPanel
            SELECCIONAR pestaña "Resultados" en tabbedPane
        FIN MÉTODO
    FIN CLASE


