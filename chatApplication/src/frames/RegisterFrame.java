package frames;

import database_connection.DatabaseManager;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author Adminn
 */
public class RegisterFrame extends javax.swing.JInternalFrame {
    
    private DatabaseManager database;
    Connection con = null;
    
    /**
     * Creates new form RegisterFrame
     */
    
    public RegisterFrame(DatabaseManager database) {
        this.database = database;
        initComponents();
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        username = new javax.swing.JTextField();
        usernameLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        passwordAgainLabel = new javax.swing.JLabel();
        passwordAgain = new javax.swing.JPasswordField();
        emailLabel = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        register = new javax.swing.JButton();
        error = new javax.swing.JLabel();
        error_password = new javax.swing.JLabel();
        errorUsername = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Registration");

        usernameLabel.setText("username: ");

        passwordLabel.setText("password: ");

        passwordAgainLabel.setText("password again:");

        emailLabel.setText("e-mail address: ");

        register.setText("Register");
        register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(passwordAgainLabel)
                            .addComponent(emailLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(register)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(passwordAgain)
                                .addComponent(email, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(usernameLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(passwordLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(error, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(error_password, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(errorUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameLabel)
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(errorUsername))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(passwordLabel)
                            .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(passwordAgainLabel)
                            .addComponent(passwordAgain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(error_password, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(error, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emailLabel))))
                .addGap(18, 18, 18)
                .addComponent(register)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /*
    * When button is clicked this will do
    * insert into users database new user
    */
    
    private void registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerActionPerformed
        try {
            if(isUserValid()){
                JOptionPane.showMessageDialog(this,"Registration sucessful!");
                Object[] values = {this.username.getText(),this.password.getPassword(),this.email.getText()};
                try {
                    PreparedStatement register = database.Insert("users ", values);
                    register.execute();
                } catch (SQLException ex) {
                    Logger.getLogger(RegisterFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegisterFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_registerActionPerformed
    
    /*
    * check if user entered valid username,password, etc.
    */
    public boolean isUserValid() throws SQLException{
        if(!validEmail()){
            this.error.setForeground(Color.RED);
            this.error.setText("Wrong e-mail address.");
            return false;
        }else{
            this.error.setText("");
        } 
        
        if(!isPasswordCorrect()){
            this.error.setForeground(Color.RED);
            this.error_password.setText("Password length must be 7-15.");
            return false;
        }else{
            this.error_password.setText("");
        }
        if(!this.password.getText().equals(this.passwordAgain.getText())){
            this.error.setForeground(Color.RED);
            this.error_password.setText("Passwords do not \n\bmatch.");
            return false;
        }else{
            this.error_password.setText("");
        }
        if(!validDatabaseEmail()){
            this.error.setForeground(Color.red);
            this.error.setText("email is already used.");
            return false;
        }
        if(!isUsernameCorrect(this.username.getText())){
            return false;
        }
        return true;
    } 
     
    public boolean isUsernameCorrect(String username) throws SQLException{
        if(username.length()>15){
            setErrorUsername("Username length >15");
            return false;
        }
        Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(username);
        if(m.find()){
            setErrorUsername("Invalid characters.");
            return false;
        }
        Object[] columns = {"username"};
        PreparedStatement db_user =  database.Select(columns, "users");
        ResultSet users = db_user.executeQuery();
        while(users.next()){
            if(username.equalsIgnoreCase(users.getString("username"))){
                setErrorUsername("Username is taken.");
                return false;
            }
        }
        return true;
    }
    public void setErrorUsername(String text){
        this.errorUsername.setText(text);
    }
    /*
    * check if password is correct
    */
    public boolean isPasswordCorrect(){
        String password = this.password.getText();
        if(password.length()>=7 && password.length()<=15){
            return true;
        }
        return false;
    }
    /*
    * check if email is already in database
    */
    public boolean validDatabaseEmail(){
        try {
            PreparedStatement query = database.Select(null,"Users");
            System.out.println(query);
            ResultSet result = query.executeQuery();
            
            while(result.next()){
                if(result.getString("mail").equals(this.email.getText())){
                    return false;
                }
                System.out.println(result.getString("mail"));
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegisterFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    /*
    * check if email is valid
    */
    public boolean validEmail(){
        String email = this.email.getText();
        
        try{
            String emailPattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\"
                    + ".[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
            Pattern pattern = Pattern.compile(emailPattern);
            Matcher matcher = pattern.matcher(email);
            if(matcher.matches()){
                return true;
            }
            return false;
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField email;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JLabel error;
    private javax.swing.JLabel errorUsername;
    private javax.swing.JLabel error_password;
    private javax.swing.JPasswordField password;
    private javax.swing.JPasswordField passwordAgain;
    private javax.swing.JLabel passwordAgainLabel;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JButton register;
    private javax.swing.JTextField username;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}