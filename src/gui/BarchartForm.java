/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import connexion.Connexion;
import java.awt.BorderLayout;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author adhmin
 */
public class BarchartForm extends javax.swing.JInternalFrame {

    private DefaultCategoryDataset dataset;
    private Connexion connexion;
    private ChartPanel chartPanel;
    private javax.swing.JLabel jLabel1;

    /**
     * Creates new form Barchart
     */
    public BarchartForm() {
        initComponents();
        connexion = Connexion.getInstance();
        this.setTitle("Nombre d'étudiants inscrits par examen");
        dataset = new DefaultCategoryDataset();
        load();

        JFreeChart barChart = ChartFactory.createBarChart(
                "Nombre d'étudiants inscrits par examen",
                "Examen",
                "Nombre d'étudiants",
                dataset
        );

        chartPanel = new ChartPanel(barChart);

        jLabel1 = new javax.swing.JLabel("Nombre d'étudiants inscrits par examen");

        jPanel1.setLayout(new BorderLayout());
        jPanel1.add(jLabel1, BorderLayout.NORTH);
        jPanel1.add(chartPanel, BorderLayout.CENTER);

        this.pack();
    }

    private void load() {
        String req = "SELECT e.matiere, COUNT(i.etudiant_id) AS student_count "
                + "FROM Examen e "
                + "LEFT JOIN InscriptionExamen i ON e.id = i.examen_id "
                + "GROUP BY e.matiere";

        try (PreparedStatement ps = connexion.getCn().prepareStatement(req);
                ResultSet rs = ps.executeQuery()) {

            dataset.clear();

            while (rs.next()) {
                String matiere = rs.getString("matiere");
                int studentCount = rs.getInt("student_count");

                System.out.println("Matière: " + matiere + ", Nombre d'étudiants: " + studentCount); // Ajout de cette ligne

                dataset.addValue(studentCount, "Étudiants", matiere);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Nombre d'étudiants inscrits par examen"));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Nombre d'étudiants inscrits par examen"));
        jPanel1.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1085, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 316, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(155, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
