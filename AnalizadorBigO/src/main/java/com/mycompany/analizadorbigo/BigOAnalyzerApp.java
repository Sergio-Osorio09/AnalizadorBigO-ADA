package com.mycompany.analizadorbigo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class BigOAnalyzerApp extends JFrame {
    private JTextArea codeInput;
    private JTextArea resultOutput;
    private JButton analyzeButton;
    private JButton clearButton;
    private JTabbedPane tabbedPane; // Pestañas para resultados y gráfico
    private JPanel resultPanel;
    private JPanel chartPanel;

    public BigOAnalyzerApp() {
        setTitle("Big O Complexity Analyzer");
        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel para ingresar el código
        codeInput = new JTextArea(15, 50);
        codeInput.setLineWrap(true);
        codeInput.setWrapStyleWord(true);
        JScrollPane inputScrollPane = new JScrollPane(codeInput);
        inputScrollPane.setBorder(BorderFactory.createTitledBorder("Ingrese el Código Aquí"));

        // Botones
        analyzeButton = new JButton("Analizar");
        clearButton = new JButton("Limpiar");

        analyzeButton.addActionListener(new AnalyzeButtonListener());
        clearButton.addActionListener(new ClearButtonListener());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(analyzeButton);
        buttonPanel.add(clearButton);

        // Crear el área de resultados
        resultOutput = new JTextArea();
        resultOutput.setEditable(false);
        resultOutput.setLineWrap(true);
        resultOutput.setWrapStyleWord(true);
        JScrollPane resultScrollPane = new JScrollPane(resultOutput);
        resultScrollPane.setBorder(BorderFactory.createTitledBorder("Resultados del Análisis"));

        resultPanel = new JPanel(new BorderLayout());
        resultPanel.add(resultScrollPane, BorderLayout.CENTER);

        // Crear el panel vacío para el gráfico
        chartPanel = new JPanel();
        chartPanel.setLayout(new BorderLayout());
        chartPanel.setBorder(BorderFactory.createTitledBorder("Simulación de Complejidad Big O"));

        // Crear pestañas
        tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Resultados", resultPanel);
        tabbedPane.addTab("Gráfico", chartPanel);

        // Agregar componentes principales
        add(inputScrollPane, BorderLayout.NORTH);
        add(tabbedPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private class AnalyzeButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String code = codeInput.getText();
            BigOAnalyzer analyzer = new BigOAnalyzer();
            String result = analyzer.analyzeCode(code);

            // Mostrar resultados en el área de texto
            resultOutput.setText(result);

            // Obtener las complejidades detectadas
            Map<String, Integer> complexities = analyzer.getComplexities();

            // Generar gráfico dinámico basado en las complejidades
            BigOChart bigOChart = new BigOChart();
            JPanel newChartPanel = bigOChart.createChartPanel(complexities);

            // Actualizar el panel del gráfico
            chartPanel.removeAll();
            chartPanel.add(newChartPanel, BorderLayout.CENTER);
            chartPanel.revalidate();
            chartPanel.repaint();

            // Cambiar automáticamente a la pestaña de resultados
            tabbedPane.setSelectedIndex(0);
        }
    }

    private class ClearButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            codeInput.setText("");
            resultOutput.setText("");
            chartPanel.removeAll();
            chartPanel.revalidate();
            chartPanel.repaint();
            tabbedPane.setSelectedIndex(0); // Volver a la pestaña de resultados
        }
    }
}





