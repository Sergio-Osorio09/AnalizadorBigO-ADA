package com.mycompany.analizadorbigo;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.util.Map;

public class BigOChart {

    public JPanel createChartPanel(Map<String, Integer> complexities) {
        // Crear dataset basado en las complejidades detectadas
        XYSeriesCollection dataset = createDataset(complexities);

        // Crear gráfico
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Simulación de Complejidad Big O",
                "Tamaño de Entrada (n)",
                "Operaciones",
                dataset
        );

        // Configurar el panel del gráfico
        return new ChartPanel(chart);
    }

    private XYSeriesCollection createDataset(Map<String, Integer> complexities) {
        XYSeriesCollection dataset = new XYSeriesCollection();

        // Datos para O(1)
        if (complexities.containsKey("O(1)")) {
            XYSeries constant = new XYSeries("O(1)");
            for (int n = 1; n <= 10; n++) {
                constant.add(n, 1);
            }
            dataset.addSeries(constant);
        }

        // Datos para O(n)
        if (complexities.containsKey("O(n)")) {
            XYSeries linear = new XYSeries("O(n)");
            for (int n = 1; n <= 10; n++) {
                linear.add(n, n);
            }
            dataset.addSeries(linear);
        }

        // Datos para O(n^2)
        if (complexities.containsKey("O(n^2)")) {
            XYSeries quadratic = new XYSeries("O(n^2)");
            for (int n = 1; n <= 10; n++) {
                quadratic.add(n, n * n);
            }
            dataset.addSeries(quadratic);
        }

        // Datos para O(n^3)
        if (complexities.containsKey("O(n^3)")) {
            XYSeries cubic = new XYSeries("O(n^3)");
            for (int n = 1; n <= 10; n++) {
                cubic.add(n, n * n * n);
            }
            dataset.addSeries(cubic);
        }

        // Datos para O(n^4)
        if (complexities.containsKey("O(n^4)")) {
            XYSeries quartic = new XYSeries("O(n^4)");
            for (int n = 1; n <= 10; n++) {
                quartic.add(n, Math.pow(n, 4));
            }
            dataset.addSeries(quartic);
        }

        // Datos para O(log n)
        if (complexities.containsKey("O(log n)")) {
            XYSeries logarithmic = new XYSeries("O(log n)");
            for (int n = 1; n <= 10; n++) {
                logarithmic.add(n, Math.log(n));
            }
            dataset.addSeries(logarithmic);
        }

        // Datos para O(2^n)
        if (complexities.containsKey("O(2^n)")) {
            XYSeries exponential = new XYSeries("O(2^n)");
            for (int n = 1; n <= 10; n++) {
                exponential.add(n, Math.pow(2, n));
            }
            dataset.addSeries(exponential);
        }

        return dataset;
    }
}
