/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * code taken from https://jonathanmelgoza.com/blog/como-hacer-graficos-con-java/
 */
public class Chart {
     public Chart(int[] list){
        // Fuente de Datos
        DefaultPieDataset data = new DefaultPieDataset();
        
        long sum = 0;
         for (int i = 0; i < 9; i++) {
             sum += list[i];
         }
        
        data.setValue((list[0]*100)/sum + "% " + " San José : " + list[0], list[0]);
        data.setValue((list[1]*100)/sum + "% " + " Alajuela : "+ list[1], list[1]);
        data.setValue((list[2]*100)/sum + "% " + " Cartago : "+ list[2], list[2]);
        data.setValue((list[3]*100)/sum + "% " + " Heredia : "+ list[3], list[3]);
        data.setValue((list[4]*100)/sum + "% " + " Guanacaste : "+ list[4], list[4]);
        data.setValue((list[5]*100)/sum + "% " + " Puntarenas : "+ list[5], list[5]);
        data.setValue((list[6]*100)/sum + "% " + " Limón : "+ list[6], list[6]);
        data.setValue((list[7]*100)/sum + "% " + " Nationalized : "+ list[7], list[7]);
        data.setValue((list[8]*100)/sum + "% " + " Special case : "+ list[8], list[8]);
        // Creando el Grafico
        JFreeChart chart = ChartFactory.createPieChart(
         "Amount of people per province", 
         data, 
         true, 
         true, 
         false);

        // Mostrar Grafico
        ChartFrame frame = new ChartFrame("JFreeChart", chart);
        frame.pack();
        frame.setVisible(true);
    }
}
