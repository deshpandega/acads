/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screen.doctor;

import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import source.hospital.Hospital;
import source.patient.Patient;
import source.userAccount.UserAccount;
import source.util.UtilFunctions;
import source.workQueue.SpecialMedicalWorkRequest;
import source.workQueue.WorkRequest;

/**
 *
 * @author GaurangDeshpande
 */
public class RaiseSpecialMedicalRequestJPanel extends javax.swing.JPanel {

    private JPanel cardContainer;
    private UserAccount account;
    private Hospital hospital;
    private Patient patient;
    /**
     * Creates new form RaiseSpecialMedicalRequestJPanel
     */
    RaiseSpecialMedicalRequestJPanel(JPanel cardContainer, UserAccount account, Hospital hospital, Patient patient) {
        initComponents();
        this.cardContainer = cardContainer;
        this.account = account;
        this.hospital = hospital;
        this.patient = patient;
        
        lblLoggedInUser.setText(account.getEmployee().getPerson().getLastName()+", "+account.getEmployee().getPerson().getFirstName());
        
        populatePatientHistory();
    }
    
    void populatePatientHistory(){
        lblPatientID.setText(patient.getPatientID());
        lblPatientName.setText(patient.getPerson().getFirstName()+" "+patient.getPerson().getLastName());
        lblAge.setText(String.valueOf(patient.getPerson().getAge()));
        lblGender.setText(patient.getPerson().getGender());
        
        populateTable();
    }
    
    private void populateTable(){
        DefaultTableModel dtm = (DefaultTableModel)tblRequestList.getModel();
        dtm.setRowCount(0);
        for (WorkRequest request : account.getWorkQueue().getWorkRequestList()) {
            if (request instanceof SpecialMedicalWorkRequest) {
                Object row[] = new Object[6];
                row[0] = request;
                row[1] = request.getRequestAssignee();
                row[2] = UtilFunctions.formatDate(request.getRequestCreationDate());
                row[3] = request.getStatus();
                String outcome = ((SpecialMedicalWorkRequest) request).getRequestOutcome();
                row[4] = outcome == null ? "Waiting" : outcome;
                String result = ((SpecialMedicalWorkRequest) request).getComments();
                row[5] = result == null ? "NA" : result;
                dtm.addRow(row);
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

        btnBack = new javax.swing.JButton();
        lblHeading = new javax.swing.JLabel();
        lblLoggedInUser = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRequestList = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        lblPatientID = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblPatientName = new javax.swing.JLabel();
        lblAge = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblGender = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnRaiseRequest = new javax.swing.JButton();
        btnViewRequest = new javax.swing.JButton();

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
        lblHeading.setText("Raise Special Medical Request");

        lblLoggedInUser.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblLoggedInUser.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);

        tblRequestList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Request Message", "Assignee", "Raised On", "Status", "Result", "Comments"
            }
        ));
        jScrollPane1.setViewportView(tblRequestList);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel5.setText("Patient ID:");

        lblPatientID.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel6.setText("Patient Name:");

        lblPatientName.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        lblAge.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel8.setText("Age:");

        lblGender.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel7.setText("Gender:");

        btnRaiseRequest.setBackground(new java.awt.Color(51, 51, 51));
        btnRaiseRequest.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnRaiseRequest.setForeground(new java.awt.Color(255, 255, 255));
        btnRaiseRequest.setText("Raise Special Medical Request");
        btnRaiseRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRaiseRequestActionPerformed(evt);
            }
        });

        btnViewRequest.setBackground(new java.awt.Color(51, 51, 51));
        btnViewRequest.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnViewRequest.setForeground(new java.awt.Color(255, 255, 255));
        btnViewRequest.setText("View Request Details");
        btnViewRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewRequestActionPerformed(evt);
            }
        });

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
                            .addComponent(lblHeading, javax.swing.GroupLayout.DEFAULT_SIZE, 1020, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblPatientID, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblPatientName, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblGender, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblAge, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnRaiseRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnViewRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1004, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoggedInUser, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblHeading, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPatientID, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPatientName, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblAge, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblGender, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRaiseRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnViewRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(172, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        goBack();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnRaiseRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRaiseRequestActionPerformed
        // TODO add your handling code here:
        AddNewSpecialRequestJPanel addNewSpecialRequestJPanel = new AddNewSpecialRequestJPanel(cardContainer, account, hospital, patient, "SpecialRequest");
        cardContainer.add("addNewSpecialRequestJPanel", addNewSpecialRequestJPanel);
        CardLayout layout = (CardLayout) cardContainer.getLayout();
        layout.next(cardContainer);
    }//GEN-LAST:event_btnRaiseRequestActionPerformed

    private void btnViewRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewRequestActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblRequestList.getSelectedRow();
        if(selectedRow<0){
            JOptionPane.showMessageDialog(null, "Please select a patient", "WARNING", JOptionPane.WARNING_MESSAGE);
        }
        else{
            WorkRequest request = (WorkRequest) tblRequestList.getValueAt(selectedRow, 0);
            ViewSpecialRequestJPanel viewSpecialRequestJPanel = new ViewSpecialRequestJPanel(cardContainer, account, request, "SpecialRequest");
            cardContainer.add("viewSpecialRequestJPanel", viewSpecialRequestJPanel);
            CardLayout layout = (CardLayout) cardContainer.getLayout();
            layout.next(cardContainer);
        }
    }//GEN-LAST:event_btnViewRequestActionPerformed

    private void goBack(){
        cardContainer.remove(this);
        CardLayout layout = (CardLayout) cardContainer.getLayout();
        layout.previous(cardContainer);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnRaiseRequest;
    private javax.swing.JButton btnViewRequest;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAge;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblHeading;
    private javax.swing.JLabel lblLoggedInUser;
    private javax.swing.JLabel lblPatientID;
    private javax.swing.JLabel lblPatientName;
    private javax.swing.JTable tblRequestList;
    // End of variables declaration//GEN-END:variables
}
