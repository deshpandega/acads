/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screen.securityTeam;

import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import source.patient.Patient;
import source.patient.Prescription;
import source.patient.Procedure;
import source.patient.Surgery;
import source.patient.Visit;
import source.patient.VitalSigns;
import source.userAccount.UserAccount;

/**
 *
 * @author GaurangDeshpande
 */
public class ViewPatientDetailsJPanel extends javax.swing.JPanel {

    private JPanel cardContainer;
    private UserAccount account;
    private Patient patient;
    /**
     * Creates new form ViewPatientDetailsJPanel
     */
    ViewPatientDetailsJPanel(JPanel cardContainer, UserAccount account, Patient patientInTalks) {
        initComponents();
        this.cardContainer = cardContainer;
        this.account = account;
        this.patient = patientInTalks;
        populatePatientHistory();
    }

    private void populatePatientHistory(){
        ArrayList<Visit> visitHistory = new ArrayList<Visit>();
        Visit visit = null;
        for(VitalSigns vitalSigns:patient.getVitalSignHistory().getVitalSignHistory()){
            visit = new Visit();
            visit.setPurpose(vitalSigns.getPurpose());
            visit.setVisitDate(vitalSigns.getVisitDate());
            visitHistory.add(visit);
        }
        for(Prescription prescription: patient.getPrescriptionHistory().getPrescriptionHistory()){
            visit = new Visit();
            visit.setPurpose(prescription.getPurpose());
            visit.setVisitDate(prescription.getVisitDate());
            visitHistory.add(visit);
        }
        for(Procedure procedure: patient.getProcedureDirectory().getProcedureList()){
            visit = new Visit();
            visit.setPurpose(procedure.getPurpose());
            visit.setVisitDate(procedure.getVisitDate());
            visitHistory.add(visit);
        }
        for(Surgery surgery: patient.getSurgicalHistory().getSurgeryDirectory()){
            visit = new Visit();
            visit.setPurpose(surgery.getPurpose());
            visit.setVisitDate(surgery.getVisitDate());
            visitHistory.add(visit);
        }
        
        Collections.sort(visitHistory, (Visit visit1, Visit visit2) -> visit1.getVisitDate().compareTo(visit2.getVisitDate()));
        Collections.reverse(visitHistory);
        
        DefaultTableModel dtm = (DefaultTableModel)tblPatientHistory.getModel();
        dtm.setRowCount(0);
        for(Visit v:visitHistory){
            Object row[] = new Object[2];
            row[0] = v.getVisitDate();
            row[1] = v.getPurpose();
            dtm.addRow(row);
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

        btnBack = new javax.swing.JButton();
        lblHeading = new javax.swing.JLabel();
        lblLoggedInUser = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPatientHistory = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        btnBack.setBackground(new java.awt.Color(51, 51, 51));
        btnBack.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblHeading.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblHeading.setText("Manage Hospitals");

        lblLoggedInUser.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblLoggedInUser.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);

        tblPatientHistory.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        tblPatientHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Last Visit Date", "Last Visit Comments"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPatientHistory.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblPatientHistory);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Patient History");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblLoggedInUser, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(lblHeading, javax.swing.GroupLayout.DEFAULT_SIZE, 1020, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoggedInUser, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblHeading, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(174, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        goBack();
    }//GEN-LAST:event_btnBackActionPerformed

    private void goBack(){
        cardContainer.remove(this);
        CardLayout layout = (CardLayout) cardContainer.getLayout();
        layout.previous(cardContainer);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblHeading;
    private javax.swing.JLabel lblLoggedInUser;
    private javax.swing.JTable tblPatientHistory;
    // End of variables declaration//GEN-END:variables
}