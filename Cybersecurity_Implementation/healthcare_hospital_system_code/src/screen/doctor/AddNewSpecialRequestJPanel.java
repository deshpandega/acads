/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screen.doctor;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.apache.log4j.Logger;
import source.department.Department;
import source.department.SecurityDepartment;
import source.hospital.Hospital;
import source.patient.Patient;
import source.role.LabAssistantRole;
import source.role.Role;
import source.userAccount.UserAccount;
import source.util.UtilFunctions;
import source.workQueue.LabWorkRequest;
import source.workQueue.SpecialMedicalWorkRequest;

/**
 *
 * @author GaurangDeshpande
 */
public class AddNewSpecialRequestJPanel extends javax.swing.JPanel {

    private JPanel cardContainer;
    private UserAccount account;
    private Hospital hospital;
    private Patient patient;
    private String requestType;
    private static Logger log;
    
    /**
     * Creates new form AddNewSpecialRequestJPanel
     */
    AddNewSpecialRequestJPanel(JPanel cardContainer, UserAccount account, Hospital hospital, Patient patient, String requestType) {
        initComponents();
        this.cardContainer = cardContainer;
        this.account = account;
        this.hospital = hospital;
        this.patient = patient;
        this.requestType = requestType;
        log = Logger.getLogger(AddNewSpecialRequestJPanel.class);
        
        lblErrRequestDetails.setVisible(false);
        
        if(requestType.equals("SpecialRequest")){
            lblDepartment.setVisible(false);
            cmbDepartment.setVisible(false);
        } 
        else if (requestType.equals("LabRequest")) {
            lblDepartment.setVisible(true);
            cmbDepartment.setVisible(true);
            cmbDepartment.removeAllItems();
            cmbDepartment.addItem("Select a Department");
            for (Department department : hospital.getDepartmentDirectory().getDepartmentList()) {
                for (Role role : department.getSupportedRole()) {
                    if (role instanceof LabAssistantRole) {
                        cmbDepartment.addItem(department);
                        break;
                    }
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
        btnBack = new javax.swing.JButton();
        lblHeading = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblErrRequestDetails = new javax.swing.JLabel();
        btnSubmitRequest = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtRequestMessage = new javax.swing.JTextArea();
        cmbDepartment = new javax.swing.JComboBox();
        lblDepartment = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        lblLoggedInUser.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblLoggedInUser.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);

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
        lblHeading.setText("Raise Request");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel13.setText("Request Message:");

        lblErrRequestDetails.setForeground(new java.awt.Color(255, 51, 0));
        lblErrRequestDetails.setText("lblErr");

        btnSubmitRequest.setBackground(new java.awt.Color(51, 51, 51));
        btnSubmitRequest.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnSubmitRequest.setForeground(new java.awt.Color(255, 255, 255));
        btnSubmitRequest.setText("Submit Request");
        btnSubmitRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitRequestActionPerformed(evt);
            }
        });

        txtRequestMessage.setColumns(20);
        txtRequestMessage.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtRequestMessage.setRows(5);
        jScrollPane1.setViewportView(txtRequestMessage);

        cmbDepartment.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        lblDepartment.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblDepartment.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblDepartment.setText("Department:");

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
                            .addComponent(lblHeading, javax.swing.GroupLayout.DEFAULT_SIZE, 1023, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblErrRequestDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(cmbDepartment, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnSubmitRequest, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErrRequestDetails)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSubmitRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(184, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        goBack();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnSubmitRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitRequestActionPerformed
        // TODO add your handling code here:
        boolean allDataEnteredCorrectly = validateData();
        if (allDataEnteredCorrectly) {
            String requestMessage = txtRequestMessage.getText().trim();
            
            if (requestType.equals("SpecialRequest")) {
                log.info(UtilFunctions.encrypt("SP_REQ : "+account.getEmployee()));
                SpecialMedicalWorkRequest request = new SpecialMedicalWorkRequest();
                request.setMessage(requestMessage);
                request.setRequestCreationDate(UtilFunctions.getTodayFormattedDate());
                request.setRequestCreator(account.getEmployee());
                request.setStatus("Initiated");
                request.setPatientInTalks(patient);

                Department department = null;
                for (Department dep : hospital.getDepartmentDirectory().getDepartmentList()) {
                    if (dep instanceof SecurityDepartment) {
                        department = dep;
                        break;
                    }
                }
                if (department != null) {
                    department.getWorkQueue().getWorkRequestList().add(request);
                    account.getWorkQueue().getWorkRequestList().add(request);
                }
            } 
            else if (requestType.equals("LabRequest")) {
                log.info(UtilFunctions.encrypt("LAB_REQ : "+account.getEmployee()));
                LabWorkRequest request = new LabWorkRequest();
                request.setMessage(requestMessage);
                request.setRequestCreationDate(UtilFunctions.getTodayFormattedDate());
                request.setRequestCreator(account.getEmployee());
                request.setStatus("Initiated");
                request.setPatientInTalks(patient);

                Department department = (Department) cmbDepartment.getSelectedItem();
                department.getWorkQueue().getWorkRequestList().add(request);
                account.getWorkQueue().getWorkRequestList().add(request);
                cmbDepartment.setSelectedIndex(0);
            }
            txtRequestMessage.setText("");
            JOptionPane.showMessageDialog(null, "Request raised!", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnSubmitRequestActionPerformed

    private boolean validateData(){
        int i=0;
        if (txtRequestMessage.getText().trim().equalsIgnoreCase("") || txtRequestMessage.getText().trim() == null) {
            txtRequestMessage.setBorder(javax.swing.BorderFactory.createLineBorder(Color.RED));
            lblErrRequestDetails.setVisible(true);
            lblErrRequestDetails.setText("Please enter Medicine Name");
            i++;
        } else if (!UtilFunctions.validateNumberAndText(txtRequestMessage.getText().trim())) {
            txtRequestMessage.setBorder(javax.swing.BorderFactory.createLineBorder(Color.RED));
            lblErrRequestDetails.setVisible(true);
            lblErrRequestDetails.setText("Please enter only numbers and text in Medicine Name");
            i++;
        } else {
            lblErrRequestDetails.setVisible(false);
            txtRequestMessage.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK));
        }
        
        if (requestType.equals("LabRequest")) {
            if (cmbDepartment.getSelectedItem().equals("Select a Department")) {
                cmbDepartment.setBorder(javax.swing.BorderFactory.createLineBorder(Color.RED));
                JOptionPane.showMessageDialog(null, "Please select department", "WARNING", JOptionPane.WARNING_MESSAGE);
                i++;
            } 
            else {
                cmbDepartment.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK));
            }
        }
        if(i==0){
            return true;
        }
        else{
            return false;
        }
    }
    
    private void goBack(){
        cardContainer.remove(this);
        Component[] componentArray = cardContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        if(requestType.equals("SpecialRequest")){
            RaiseSpecialMedicalRequestJPanel raiseSpecialMedicalRequestJPanel = (RaiseSpecialMedicalRequestJPanel) component;
            raiseSpecialMedicalRequestJPanel.populatePatientHistory();
        }
        else if(requestType.equals("LabRequest")){
            RaiseLabRequestJPanel raiseLabRequestJPanel = (RaiseLabRequestJPanel) component;
            raiseLabRequestJPanel.populatePatientHistory();
        }
        CardLayout layout = (CardLayout)cardContainer.getLayout();
        layout.previous(cardContainer);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSubmitRequest;
    private javax.swing.JComboBox cmbDepartment;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDepartment;
    private javax.swing.JLabel lblErrRequestDetails;
    private javax.swing.JLabel lblHeading;
    private javax.swing.JLabel lblLoggedInUser;
    private javax.swing.JTextArea txtRequestMessage;
    // End of variables declaration//GEN-END:variables
}
