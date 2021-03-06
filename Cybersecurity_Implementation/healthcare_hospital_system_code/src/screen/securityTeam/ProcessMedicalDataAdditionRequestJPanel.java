/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screen.securityTeam;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.apache.log4j.Logger;
import source.patient.Patient;
import source.patient.Prescription;
import source.patient.Surgery;
import source.patient.VitalSigns;
import source.userAccount.UserAccount;
import source.util.UtilFunctions;
import source.workQueue.MedicalDataAdditionWorkRequest;

/**
 *
 * @author GaurangDeshpande
 */
public class ProcessMedicalDataAdditionRequestJPanel extends javax.swing.JPanel {

    private JPanel cardContainer;
    private UserAccount account;
    private MedicalDataAdditionWorkRequest request;
    private static Logger log;
    
    /**
     * Creates new form ProcessMedicalDataAdditionRequestJPanel
     */
    ProcessMedicalDataAdditionRequestJPanel(JPanel cardContainer, UserAccount account, MedicalDataAdditionWorkRequest request) {
        initComponents();
        this.cardContainer = cardContainer;
        this.account = account;
        this.request = request;
        log = Logger.getLogger(ProcessMedicalDataAdditionRequestJPanel.class);
        lblLoggedInUser.setText(account.getEmployee().getPerson().getLastName()+", "+account.getEmployee().getPerson().getFirstName());
        
        populateRequestsDetails();
        if (request.getStatus().equalsIgnoreCase("Pending") || request.getStatus().equalsIgnoreCase("Processing")) {
            cmbOutcome.removeAllItems();
            cmbOutcome.addItem("Select response");
            cmbOutcome.addItem("Approve");
            cmbOutcome.addItem("Reject");
            txtComments.setText("");
        }
        else{
            cmbOutcome.removeAllItems();
            cmbOutcome.setEnabled(false);
            cmbOutcome.addItem(request.getRequestOutcome());
            txtComments.setEnabled(false);
            txtComments.setText(request.getComments());
        }
    }

    private void populateRequestsDetails(){
        lblPatientID.setText(request.getPatientInTalks().getPatientID());
        lblPatientName.setText(request.getPatientInTalks().getPerson().getFirstName()+" "+request.getPatientInTalks().getPerson().getLastName());
        lblGender.setText(request.getPatientInTalks().getPerson().getGender());
        lblAge.setText(String.valueOf(request.getPatientInTalks().getPerson().getAge()));
        lblRequestMessage.setText(request.getMessage());
        if(request.getResuestResolutionDate()!=null){
            lblCompletedOn.setText(String.valueOf(UtilFunctions.formatDate(request.getResuestResolutionDate())));
        }
        lblRaisedOn.setText(String.valueOf(UtilFunctions.formatDate(request.getRequestCreationDate())));
        lblStatus.setText(request.getStatus());
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
        jLabel5 = new javax.swing.JLabel();
        lblPatientID = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblPatientName = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        btnViewPatientDetails = new javax.swing.JButton();
        txtComments = new javax.swing.JTextField();
        cmbOutcome = new javax.swing.JComboBox();
        btnCompleteRequest = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        lblCompletedOn = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblGender = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblAge = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblRequestMessage = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblRaisedOn = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();

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
        lblHeading.setText("Process Request");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel5.setText("Patient ID:");

        lblPatientID.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel6.setText("Patient Name:");

        lblPatientName.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel13.setText("Outcome:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel14.setText("Comments:");

        btnViewPatientDetails.setBackground(new java.awt.Color(51, 51, 51));
        btnViewPatientDetails.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnViewPatientDetails.setForeground(new java.awt.Color(255, 255, 255));
        btnViewPatientDetails.setText("View Patient Details");
        btnViewPatientDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewPatientDetailsActionPerformed(evt);
            }
        });

        txtComments.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        cmbOutcome.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        btnCompleteRequest.setBackground(new java.awt.Color(51, 51, 51));
        btnCompleteRequest.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnCompleteRequest.setForeground(new java.awt.Color(255, 255, 255));
        btnCompleteRequest.setText("Complete Request");
        btnCompleteRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompleteRequestActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel15.setText("Completed On:");

        lblCompletedOn.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel7.setText("Gender:");

        lblGender.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel8.setText("Age:");

        lblAge.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel9.setText("Request Message:");

        lblRequestMessage.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel11.setText("Raised On:");

        lblRaisedOn.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel12.setText("Status:");

        lblStatus.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 951, Short.MAX_VALUE)
                        .addComponent(lblLoggedInUser, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblHeading, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblGender, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblPatientID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblPatientName, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                                    .addComponent(lblAge, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(212, 212, 212)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblRequestMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lblRaisedOn, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(9, 9, 9)
                                        .addComponent(cmbOutcome, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtComments)
                                    .addComponent(lblCompletedOn, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(212, 212, 212)
                        .addComponent(btnCompleteRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnViewPatientDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblCompletedOn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblLoggedInUser, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnBack, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                            .addComponent(lblHeading, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblPatientID, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblPatientName, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblGender, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblAge, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lblRequestMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblRaisedOn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbOutcome, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtComments, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnViewPatientDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCompleteRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(131, 131, 131))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        goBack();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnViewPatientDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewPatientDetailsActionPerformed
        // TODO add your handling code here:
        ViewPatientDetailsJPanel viewPatientDetailsJPanel = new ViewPatientDetailsJPanel(cardContainer, account, request.getPatientInTalks());
        cardContainer.add("viewPatientDetailsSecurityTeamJPanel", viewPatientDetailsJPanel);
        CardLayout layout = (CardLayout) cardContainer.getLayout();
        layout.next(cardContainer);
    }//GEN-LAST:event_btnViewPatientDetailsActionPerformed

    private void btnCompleteRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompleteRequestActionPerformed
        // TODO add your handling code here:
        boolean allDataEnteredCorrectly = validateData();
        if(allDataEnteredCorrectly){
            
            log.info(UtilFunctions.encrypt("PRO_EMREQ : "+account.getEmployee()));
            request.setComments(txtComments.getText().trim());
            request.setStatus("Complete");
            request.setRequestOutcome((String)cmbOutcome.getSelectedItem());
            request.setResuestResolutionDate(UtilFunctions.getTodayFormattedDate());
            
            //If Approved, modify the patient object
            if (((String) cmbOutcome.getSelectedItem()).equals("Approve")) {
                Patient patient = request.getPatientInTalks();
                if (request.getMessage().equals("Add Vital Sign")) {
                    VitalSigns vs = patient.getVitalSignHistory().addVitalSign();
                    vs.setPurpose(request.getVitalSigns().getPurpose());
                    vs.setVisitDate(request.getVitalSigns().getVisitDate());
                    vs.setBloodPressure(request.getVitalSigns().getBloodPressure());
                    vs.setBloodGlucoseLevel(request.getVitalSigns().getBloodGlucoseLevel());
                    vs.setHeight(request.getVitalSigns().getHeight());
                    vs.setPulseRate(request.getVitalSigns().getPulseRate());
                    vs.setRespirationRate(request.getVitalSigns().getRespirationRate());
                    vs.setTemperature(request.getVitalSigns().getTemperature());
                    vs.setWeight(request.getVitalSigns().getWeight());
                } else if (request.getMessage().equals("Add Prescription")) {
                    Prescription p = patient.getPrescriptionHistory().prescribeMedicine();
                    p.setDailyDosage(request.getPrescription().getDailyDosage());
                    p.setMedicineID(request.getPrescription().getMedicineID());
                    p.setMedicineName(request.getPrescription().getMedicineName());
                    p.setPrescribedOn(request.getPrescription().getPrescribedOn());
                    p.setPrescribedTill(request.getPrescription().getPrescribedTill());
                    p.setPrescriptionDescription(request.getPrescription().getPrescriptionDescription());
                    p.setPurpose(request.getPrescription().getPurpose());
                    p.setVisitDate(request.getPrescription().getVisitDate());
                } else if (request.getMessage().equals("Add Surgery")) {
                    Surgery s = patient.getSurgicalHistory().performNewSurgery();
                    s.setPerformedBy(request.getSurgery().getPerformedBy());
                    s.setPurpose(request.getSurgery().getPurpose());
                    s.setSurgeryAssisstedBy(request.getSurgery().getSurgeryAssisstedBy());
                    s.setSurgeryComplications(request.getSurgery().getSurgeryComplications());
                    s.setSurgeryDescription(request.getSurgery().getSurgeryDescription());
                    s.setSurgeryOutcome(request.getSurgery().getSurgeryOutcome());
                    s.setSurgeryTime(request.getSurgery().getSurgeryTime());
                    s.setSurgeryType(request.getSurgery().getSurgeryType());
                    s.setVisitDate(request.getSurgery().getVisitDate());
                }
            }
            
            btnCompleteRequest.setEnabled(false);
            txtComments.setEnabled(false);
            cmbOutcome.setEnabled(false);
        }
    }//GEN-LAST:event_btnCompleteRequestActionPerformed

    private boolean validateData(){
        int i=0;
        
        //Validate Comments
        if(txtComments.getText().trim().equalsIgnoreCase("")||txtComments.getText().trim()==null){
            txtComments.setBorder(javax.swing.BorderFactory.createLineBorder(Color.RED));
            JOptionPane.showMessageDialog(null, "Please enter comments", "WARNING", JOptionPane.WARNING_MESSAGE);
            i++;
        }
        else if(!UtilFunctions.validateTextOnly(txtComments.getText().trim())){
            txtComments.setBorder(javax.swing.BorderFactory.createLineBorder(Color.RED));
            JOptionPane.showMessageDialog(null, "Please enter only alphabets in Comments", "WARNING", JOptionPane.WARNING_MESSAGE);
            i++;
        }
        else{
            txtComments.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK));
        }
        
        //Validate Outcome
        if(cmbOutcome.getSelectedItem().equals("Select response")){
            cmbOutcome.setBorder(javax.swing.BorderFactory.createLineBorder(Color.RED));
            JOptionPane.showMessageDialog(null, "Please select response", "WARNING", JOptionPane.WARNING_MESSAGE);
            i++;
        }
        else{
            cmbOutcome.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK));
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
        Component component= componentArray[componentArray.length - 1];
        ManageDataAdditionRequestJPanel manageDataAdditionRequestJPanel = (ManageDataAdditionRequestJPanel) component;
        manageDataAdditionRequestJPanel.populateRequestsTable();
        CardLayout layout = (CardLayout) cardContainer.getLayout();
        layout.previous(cardContainer);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCompleteRequest;
    private javax.swing.JButton btnViewPatientDetails;
    private javax.swing.JComboBox cmbOutcome;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblAge;
    private javax.swing.JLabel lblCompletedOn;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblHeading;
    private javax.swing.JLabel lblLoggedInUser;
    private javax.swing.JLabel lblPatientID;
    private javax.swing.JLabel lblPatientName;
    private javax.swing.JLabel lblRaisedOn;
    private javax.swing.JLabel lblRequestMessage;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JTextField txtComments;
    // End of variables declaration//GEN-END:variables
}
