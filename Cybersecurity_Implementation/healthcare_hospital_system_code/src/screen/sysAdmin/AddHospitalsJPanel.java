/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screen.sysAdmin;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.apache.log4j.Logger;
import source.EcoSystem;
import source.hospital.Hospital;
import source.userAccount.UserAccount;
import source.util.UtilFunctions;

/**
 *
 * @author GaurangDeshpande
 */
public class AddHospitalsJPanel extends javax.swing.JPanel {
    private JPanel cardContainer;
    private UserAccount account; 
    private EcoSystem ecoSystem;
    private static int count = 0;
    private Hospital hospital;
    private static Logger log;
    
    /**
     * Creates new form ManageHospitalsJPanel
     */
    AddHospitalsJPanel(JPanel cardContainer, UserAccount account, EcoSystem ecoSystem) {
        initComponents();
        this.cardContainer = cardContainer;
        this.account = account;
        this.ecoSystem = ecoSystem;
        log = Logger.getLogger(AddHospitalsJPanel.class);
        
        lblLoggedInUser.setText(account.getEmployee().getPerson().getLastName()+", "+account.getEmployee().getPerson().getFirstName());
        
        lblErrHospitalName.setVisible(false);
        lblErrHospitalBranch.setVisible(false);
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
        txtHeading = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtHospitalName = new javax.swing.JTextField();
        txtHospitalBranch = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        lblErrHospitalName = new javax.swing.JLabel();
        lblErrHospitalBranch = new javax.swing.JLabel();
        btnSaveHospital = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        lblLoggedInUser.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblLoggedInUser.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);

        txtHeading.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        txtHeading.setText("Add Hospitals");

        btnBack.setBackground(new java.awt.Color(51, 51, 51));
        btnBack.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel3.setText("Hospital Name:");

        txtHospitalName.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        txtHospitalBranch.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel4.setText("Hospital Branch:");

        lblErrHospitalName.setForeground(new java.awt.Color(255, 51, 0));
        lblErrHospitalName.setText("lblErr");

        lblErrHospitalBranch.setForeground(new java.awt.Color(255, 51, 0));
        lblErrHospitalBranch.setText("lblErr");

        btnSaveHospital.setBackground(new java.awt.Color(51, 51, 51));
        btnSaveHospital.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnSaveHospital.setForeground(new java.awt.Color(255, 255, 255));
        btnSaveHospital.setText("Save Hospital");
        btnSaveHospital.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveHospitalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtHospitalName, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblErrHospitalName, javax.swing.GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtHospitalBranch, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblErrHospitalBranch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnSaveHospital, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addComponent(txtHeading, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblLoggedInUser, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblLoggedInUser, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnBack, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addComponent(txtHeading, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHospitalName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblErrHospitalName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHospitalBranch, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblErrHospitalBranch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSaveHospital, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
   
    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        goBack();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnSaveHospitalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveHospitalActionPerformed
        // TODO add your handling code here:
        boolean allDataEnteredCorrectly = validateData();
        if(allDataEnteredCorrectly){
            log.info(UtilFunctions.encrypt("CR_HOSP : "+account.getEmployee()));
            hospital = ecoSystem.getHospitalDirectory().createAndAddHospital(txtHospitalName.getText().trim(), txtHospitalBranch.getText().trim());
            System.out.println(hospital.getName()+" - "+hospital.getHospitalBranchName());
            txtHospitalName.setText("");
            txtHospitalBranch.setText("");
            JOptionPane.showMessageDialog(null,"Hospital Saved!", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            return;
        }
    }//GEN-LAST:event_btnSaveHospitalActionPerformed

    private boolean validateData(){
        int i=0;
        //Validate Hospital Name
        if (txtHospitalName.getText().trim().equalsIgnoreCase("") || txtHospitalName.getText().trim() == null) {
            txtHospitalName.setBorder(javax.swing.BorderFactory.createLineBorder(Color.RED));
            lblErrHospitalName.setText("Please enter hospital name");
            lblErrHospitalName.setVisible(true);
            i++;
        } else if (!UtilFunctions.validateTextOnly(txtHospitalName.getText().trim())) {
            txtHospitalName.setBorder(javax.swing.BorderFactory.createLineBorder(Color.RED));
            lblErrHospitalName.setText("Please enter only characters");
            lblErrHospitalName.setVisible(true);          
            i++;
        } else {
            lblErrHospitalName.setText("");
            lblErrHospitalName.setVisible(false);
            txtHospitalName.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK));
        }
        
        //Validate Hospital Branch
        if(txtHospitalBranch.getText().trim().equalsIgnoreCase("")||txtHospitalBranch.getText().trim()==null){
            txtHospitalBranch.setBorder(javax.swing.BorderFactory.createLineBorder(Color.RED));
            lblErrHospitalBranch.setText("Please enter Ceiling Price");
            lblErrHospitalBranch.setVisible(true);
            i++;
        }
        else if(!UtilFunctions.validateTextOnly(txtHospitalBranch.getText().trim())){
            txtHospitalBranch.setBorder(javax.swing.BorderFactory.createLineBorder(Color.RED));
            lblErrHospitalBranch.setText("Please enter only numbericals");
            lblErrHospitalBranch.setVisible(true);
            i++;
        }
        else{
            lblErrHospitalBranch.setText("");
            lblErrHospitalBranch.setVisible(false);
            txtHospitalBranch.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK));
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
        CardLayout layout = (CardLayout) cardContainer.getLayout();
        layout.previous(cardContainer);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSaveHospital;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblErrHospitalBranch;
    private javax.swing.JLabel lblErrHospitalName;
    private javax.swing.JLabel lblLoggedInUser;
    private javax.swing.JLabel txtHeading;
    private javax.swing.JTextField txtHospitalBranch;
    private javax.swing.JTextField txtHospitalName;
    // End of variables declaration//GEN-END:variables
}
