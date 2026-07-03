        package login;
        import airoplanereservation.*;
        import java.awt.*;
        import java.sql.*;
        import javax.swing.*;

            public class LoginApp {

            private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/airindia_db";
            private static final String DB_USER = "root";
            private static final String DB_PASS = "Chetan@27";   

            public static void main(String[] args) {
                SwingUtilities.invokeLater(LoginFrame::new);  
            }
        
            static public class LoginFrame extends JFrame {
                private final JTextField usernameField;
                private final JPasswordField passwordField;
                private final JLabel statusLabel;
                
                public LoginFrame() {
                    super("Air India - Login");
                    setSize(480, 420);
                    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    setLocationRelativeTo(null);
                    setResizable(true);
                    setLayout(new BorderLayout());

                

                // Top panel (header)
                JPanel topPanel = new JPanel(new BorderLayout(10, 0));   
                topPanel.setBackground(new Color(0, 80, 150));
                topPanel.setPreferredSize(new Dimension(480, 90));

                JLabel logoLabel = new JLabel();
        
                ImageIcon ic = new ImageIcon("airicon.png");
                Image scaledImage = ic.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
                logoLabel.setIcon(new ImageIcon(scaledImage));
                logoLabel.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 10));  

                JPanel textPanel = new JPanel();
                textPanel.setBackground(new Color(0, 80, 150));
                textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS)); 

                topPanel.add(logoLabel, BorderLayout.WEST);       
                topPanel.add(textPanel, BorderLayout.CENTER);     
                topPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
            
            
                JLabel title = new JLabel("AIR INDIA");
                title.setFont(new Font("Segoe UI", Font.BOLD, 30));
                title.setForeground(Color.WHITE);
                title.setAlignmentX(Component.CENTER_ALIGNMENT);   

                JLabel subtitle = new JLabel("Domestic Reservation System");
                subtitle.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                subtitle.setForeground(new Color(200, 230, 255));
                subtitle.setAlignmentX(Component.CENTER_ALIGNMENT); 

                    textPanel.add(title);
                    textPanel.add(subtitle);
                    textPanel.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));
                    add(topPanel, BorderLayout.NORTH);
                
                    
                    // second panel
                    JPanel centerPanel = new JPanel(new GridBagLayout());
                    centerPanel.setBackground(Color.WHITE);
                    GridBagConstraints gbc = new GridBagConstraints();
                    gbc.insets = new Insets(12, 12, 12, 12);

                    
                    gbc.gridx = 0; gbc.gridy = 0;
                    centerPanel.add(new JLabel("Username:"), gbc);
                    
                    gbc.gridx = 1;
                    usernameField = new JTextField(18);
                    centerPanel.add(usernameField, gbc);
                    
                    gbc.gridx = 0; gbc.gridy = 1;
                    centerPanel.add(new JLabel("Password:"), gbc);
                    
                    gbc.gridx = 1;
                    passwordField = new JPasswordField(18);
                    centerPanel.add(passwordField, gbc);
                    
                    gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2;
                    statusLabel = new JLabel(" ", SwingConstants.CENTER);
                    statusLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
                    statusLabel.setForeground(Color.RED);
                    centerPanel.add(statusLabel, gbc);
                    
                    // Buttons panel
                    gbc.gridy = 3; gbc.gridwidth = 1;
                    gbc.fill = GridBagConstraints.HORIZONTAL;
                    
                    JButton loginButton = new JButton("LOGIN");
                    loginButton.setBackground(new Color(0, 120, 215));
                    loginButton.setForeground(Color.WHITE);
                    loginButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
                    loginButton.addActionListener(ev -> handleLogin());
                    centerPanel.add(loginButton, gbc);
                    
                    gbc.gridy = 3;  gbc.gridx= 1;
                    gbc.fill = GridBagConstraints.HORIZONTAL;
                    JButton registerButton = new JButton("Create Account");
                    registerButton.setBackground(new Color(0, 120, 215));
                    registerButton.setForeground(Color.WHITE);
                    registerButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
                    registerButton.addActionListener(e -> new RegisterFrame());
                    centerPanel.add(registerButton, gbc);
                    add(centerPanel, BorderLayout.CENTER);
                    setVisible(true);
                }
                private void handleLogin() {
                    String username = usernameField.getText().trim();
                    String password = new String(passwordField.getPassword()).trim();

                    if (username.isEmpty() || password.isEmpty()) {
                        statusLabel.setText("Please enter username and password");
                        statusLabel.setForeground(Color.RED);
                        return;
                    }

                    if (validateLogin(username, password)) {
                        statusLabel.setText("Login Successful!");
                        statusLabel.setForeground(new Color(0, 150, 0));

                        SwingUtilities.invokeLater(() -> {
                            dispose();
                            new MultipaleAirplane();
                        });
                    } else {
                        statusLabel.setText("Invalid username or password");
                        statusLabel.setForeground(Color.RED);
                    }
                }
                
                private boolean validateLogin(String username, String password) {
                    String query = "SELECT * FROM users WHERE username = ? AND password = ?";
                    try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
                    PreparedStatement ps = conn.prepareStatement(query)) {
                        
                        ps.setString(1, username);
                        ps.setString(2, password);  // In real app → use hashing!
                        
                        ResultSet rs = ps.executeQuery();
                        return rs.next(); 
                        // true if record found 
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(this,
                                "Database error: " + ex.getMessage(),
                                "Error", JOptionPane.ERROR_MESSAGE);
                                return false;
                            }
                        }
                    }   
                    // ────────────────────────────────────────────────
                    //               REGISTRATION WINDOW
                    // ────────────────────────────────────────────────
                    static class RegisterFrame extends JDialog {
                        
                        private final JTextField regUsername;
                        private final JPasswordField regPassword, regConfirm;
                        private final JLabel regStatus;
                        
                        public RegisterFrame() {
                            super((Frame) null, "Create New Account", true);
                            setSize(420, 380);
                            setLocationRelativeTo(null);
                            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                            setLayout(new BorderLayout());
                            JPanel content = new JPanel(new GridBagLayout());
                            content.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
                            GridBagConstraints gbc = new GridBagConstraints();
                            gbc.insets = new Insets(10, 10, 10, 10);
                            gbc.fill = GridBagConstraints.HORIZONTAL;
                            
                            gbc.gridx = 0; gbc.gridy = 0;
                            content.add(new JLabel("Username:"), gbc);
                            
                            gbc.gridx = 1;
                            regUsername = new JTextField(18);
                            content.add(regUsername, gbc);
                            
                            gbc.gridx = 0; gbc.gridy = 1;
                            content.add(new JLabel("Password:"), gbc);
                            
                            gbc.gridx = 1;
                            regPassword = new JPasswordField(18);
                            content.add(regPassword, gbc);
                            
                            gbc.gridx = 0; gbc.gridy = 2;
                            content.add(new JLabel("Confirm:"), gbc);
                            
                            gbc.gridx = 1;
                            regConfirm = new JPasswordField(18);
                            content.add(regConfirm, gbc);
                            
                            gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2;
                            regStatus = new JLabel(" ", SwingConstants.CENTER);
                            regStatus.setForeground(Color.RED);
                            content.add(regStatus, gbc);
                            
                            JButton createBtn = new JButton("Create Account");
                            createBtn.setBackground(new Color(0, 120, 215));
                            createBtn.setForeground(Color.WHITE);
                            createBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
                            createBtn.addActionListener(ev -> handleCreate());
                            
                            gbc.gridy = 4;
                            content.add(createBtn, gbc);
                            
                            add(content, BorderLayout.CENTER);
                            setVisible(true);
                        }
                        private void handleCreate() {
                            String user = regUsername.getText().trim();
                            String pass = new String(regPassword.getPassword()).trim();
                            String confirm = new String(regConfirm.getPassword()).trim();

                            if (user.isEmpty() || pass.isEmpty() || confirm.isEmpty()) {
                                regStatus.setText("All fields are required");
                                return;
                            }

                            if (!pass.equals(confirm)) {
                                regStatus.setText("Passwords do not match");
                                return;
                            }

                            if (registerUser(user, pass)) {
                                JOptionPane.showMessageDialog(this,
                                    "Account created successfully!\nYou can now login.",
                                    "Success", JOptionPane.INFORMATION_MESSAGE);
                                    dispose();
                                } else {
                                    regStatus.setText("Username already exists or error occurred");
                                }
                        }
                            private boolean registerUser(String username, String password) {
                                String insert = "INSERT INTO users (username, password) VALUES (?, ?)";
                                try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
                                PreparedStatement ps = conn.prepareStatement(insert)) {

                                    ps.setString(1, username);
                                    ps.setString(2, password);   // ← In real app: hash the password!
                                    ps.executeUpdate();
                                    return true;
                                } catch (SQLIntegrityConstraintViolationException ex) { 
                                    // Username already exists
                                    return false;
                                } catch (SQLException ex) {
                                    JOptionPane.showMessageDialog(this,
                                        "Database error: " + ex.getMessage(),
                                        "Error", JOptionPane.ERROR_MESSAGE);
                                        return false;
                                    }
                                }
                            }
                        }