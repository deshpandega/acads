/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screen.patient;

import java.awt.CardLayout;
import java.util.Date;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import source.department.Department;
import source.hospital.Hospital;
import source.patient.Patient;
import source.patient.Prescription;
import source.userAccount.UserAccount;
import source.util.UtilFunctions;

/**
 *
 * @author infer
 */
public class PatientWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel cardContainer;
    private UserAccount account;
    private Department department;
    private Hospital hospital;
    /**
     * Creates new form PatientWorkAreaJPanel
     */
    public PatientWorkAreaJPanel(JPanel cardContainer, UserAccount account, Department department, Hospital hospital) {
        initComponents();
        this.cardContainer = cardContainer;
        this.account = account;
        this.department = department;
        this.hospital = hospital;
        
        lblLoggedInUser.setText(account.getPatient().getPerson().getLastName()+", "+account.getPatient().getPerson().getFirstName());
        
        populatePrescriptionTable();
    }

    private void populatePrescriptionTable(){
        Patient patient = account.getPatient();
        DefaultTableModel dtm = (DefaultTableModel) tblPrescription.getModel();
        dtm.setRowCount(0);
        if(patient.getPrescriptionHistory()!=null){
            for(Prescription prescription: patient.getPrescriptionHistory().getPrescriptionHistory()){
                if((UtilFunctions.validateDateSequence(new Date(), prescription.getPrescribedOn()))&&(UtilFunctions.validateDateSequence(prescription.getPrescribedTill(), new Date()))){
                    Object row[] = new Object[3];
                    row[0] = prescription.getMedicineName();
                    row[1] = prescription.getDailyDosage();
                    row[2] = prescription.getPrescribedTill();
                    dtm.addRow(row);
                }
            }
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

        lblLoggedInUser = new javax.swing.JLabel();
        lblHeading = new javax.swing.JLabel();
        btnViewDetails = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPrescription = new javax.swing.JTable();
        btnTakeTest = new javax.swing.JButton();
        btnTakeResponseTest = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        lblLoggedInUser.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblLoggedInUser.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);

        lblHeading.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblHeading.setText("Patient Activity");

        btnViewDetails.setBackground(new java.awt.Color(51, 51, 51));
        btnViewDetails.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnViewDetails.setForeground(new java.awt.Color(255, 255, 255));
        btnViewDetails.setText("View Prescription");
        btnViewDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewDetailsActionPerformed(evt);
            }
        });

        tblPrescription.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Prescription Medicine", "Dose for Today", "Dose Till"
            }
        ));
        jScrollPane1.setViewportView(tblPrescription);

        btnTakeTest.setBackground(new java.awt.Color(51, 51, 51));
        btnTakeTest.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnTakeTest.setForeground(new java.awt.Color(255, 255, 255));
        btnTakeTest.setText("Take Tap Test");
        btnTakeTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTakeTestActionPerformed(evt);
            }
        });

        btnTakeResponseTest.setBackground(new java.awt.Color(51, 51, 51));
        btnTakeResponseTest.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnTakeResponseTest.setForeground(new java.awt.Color(255, 255, 255));
        btnTakeResponseTest.setText("Take Response Test");
        btnTakeResponseTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTakeResponseTestActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblHeading, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblLoggedInUser, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnViewDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnTakeTest, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnTakeResponseTest, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 344, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoggedInUser, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblHeading, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnViewDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTakeTest, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTakeResponseTest, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(146, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnViewDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewDetailsActionPerformed
        // TODO add your handling code here:
        PatientDetailsJPanel patientDetailsJPanel = new PatientDetailsJPanel(cardContainer, account, department, hospital);
        cardContainer.add("patientDetailsJPanel", patientDetailsJPanel);
        CardLayout layout = (CardLayout) cardContainer.getLayout();
        layout.next(cardContainer);
    }//GEN-LAST:event_btnViewDetailsActionPerformed

    private void btnTakeTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTakeTestActionPerformed
        // TODO add your handling code here:
        TakeTestJPanel takeTestJPanel = new TakeTestJPanel(cardContainer, account);
        cardContainer.add("takeTestJPanel", takeTestJPanel);
        CardLayout layout = (CardLayout) cardContainer.getLayout();
        layout.next(cardContainer);
    }//GEN-LAST:event_btnTakeTestActionPerformed

    private void btnTakeResponseTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTakeResponseTestActionPerformed
        // TODO add your handling code here:
        TakeResponseTestJPanel takeResponseTestJPanel = new TakeResponseTestJPanel(cardContainer, account);
        cardContainer.add("takeResponseTestJPanel", takeResponseTestJPanel);
        CardLayout layout = (CardLayout) cardContainer.getLayout();
        layout.next(cardContainer);
    }//GEN-LAST:event_btnTakeResponseTestActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTakeResponseTest;
    private javax.swing.JButton btnTakeTest;
    private javax.swing.JButton btnViewDetails;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblHeading;
    private javax.swing.JLabel lblLoggedInUser;
    private javax.swing.JTable tblPrescription;
    // End of variables declaration//GEN-END:variables
}
