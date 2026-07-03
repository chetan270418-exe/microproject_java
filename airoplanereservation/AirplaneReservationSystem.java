package airoplanereservation;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class AirplaneReservationSystem extends JFrame implements ActionListener {
    private static final int ROWS = 4;
    private static final int COLS = 6;
    private JButton[][] seats = new JButton[ROWS][COLS];
    private ArrayList<String> bookedSeats = new ArrayList<>();
    private JButton selectedSeatButton = null;

    private JTextField nameField, ageField, phoneField;
    private JComboBox<String> genderCombo;
    private JLabel statusLabel;

    private JButton bookButton, resetButton, showStatusButton,Exitbutton;

    public AirplaneReservationSystem() {
        super("Airplane Reservation System");
        setSize(900, 680);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JLabel title = new JLabel("Air India Domestic - Seat Reservation", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 24));
        title.setForeground(new Color(0, 80, 150));
        add(title, BorderLayout.NORTH);

        JPanel mainPanel = new JPanel(new BorderLayout(20, 20));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        mainPanel.add(createSeatMapPanel(), BorderLayout.WEST);
        mainPanel.add(createPassengerDetailsPanel(), BorderLayout.CENTER);

        add(mainPanel, BorderLayout.CENTER);

        statusLabel = new JLabel("Welcome! Click any green seat to select.", SwingConstants.CENTER);
        statusLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        statusLabel.setForeground(new Color(50, 100, 50));
        add(statusLabel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private JPanel createSeatMapPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Aircraft Seat Map (A320 - 24 seats)"));

        JPanel grid = new JPanel(new GridLayout(ROWS, COLS, 8, 8));
        grid.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        String[] labels = {"A", "B", "C", "D", "E", "F"};

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                JButton btn = new JButton((r + 1) + labels[c]);
                btn.setPreferredSize(new Dimension(70, 60));
                btn.setFont(new Font("Arial", Font.BOLD, 14));
                btn.setBackground(new Color(220, 255, 220)); // Available
                btn.setOpaque(true);
                btn.setBorder(BorderFactory.createRaisedBevelBorder());
                btn.addActionListener(this);
                seats[r][c] = btn;
                grid.add(btn);
            }
        }

        // Legend
        JPanel legend = new JPanel(new FlowLayout());
        JLabel avail = createLegendLabel("Available", new Color(220, 255, 220));
        JLabel booked = createLegendLabel("Booked", new Color(255, 180, 180));
        JLabel selected = createLegendLabel("Selected", new Color(173, 216, 230));

        legend.add(avail);
        legend.add(booked);
        legend.add(selected);

        panel.add(grid, BorderLayout.CENTER);
        panel.add(legend, BorderLayout.SOUTH);
        return panel;
    }

    private JLabel createLegendLabel(String text, Color color) {
        JLabel lbl = new JLabel(text);
        lbl.setOpaque(true);
        lbl.setBackground(color);
        lbl.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        lbl.setPreferredSize(new Dimension(90, 25));
        lbl.setHorizontalAlignment(SwingConstants.CENTER);
        return lbl;
    }

    private JPanel createPassengerDetailsPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createTitledBorder("Passenger Details"));

        panel.add(createSpacer(20));

        // Name
        JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p1.add(new JLabel("Full Name: "));
        nameField = new JTextField(20);
        p1.add(nameField);
        panel.add(p1);

        panel.add(createSpacer(10));

        // Age
        JPanel p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p2.add(new JLabel("Age:          "));
        ageField = new JTextField(5);
        p2.add(ageField);
        panel.add(p2);

        panel.add(createSpacer(10));

        // Gender
        JPanel p3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p3.add(new JLabel("Gender:     "));
        genderCombo = new JComboBox<>(new String[]{"Male", "Female", "Other"});
        p3.add(genderCombo);
        panel.add(p3);

        panel.add(createSpacer(10));

        // Phone
        JPanel p4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p4.add(new JLabel("Phone:      "));
        phoneField = new JTextField(15);
        p4.add(phoneField);
        panel.add(p4);

        panel.add(createSpacer(30));

        // Buttons
        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 25, 10));
        
        bookButton = new JButton("BOOK SEAT");
        bookButton.setBackground(new Color(0, 120, 215));
        bookButton.setForeground(Color.WHITE);
        bookButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        bookButton.addActionListener(this);
 
    
        resetButton = new JButton("Reset Form");
        showStatusButton = new JButton("Show Booked Seats");


        resetButton.addActionListener(this);
        showStatusButton.addActionListener(this);

        Exitbutton = new JButton("Exit");
        Exitbutton.setBackground(new Color(220, 50, 50));   // nicer red
        Exitbutton.setForeground(Color.WHITE);
        Exitbutton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        Exitbutton.addActionListener(e -> System.exit(0));
        Exitbutton.setSize(20,30);

        btnPanel.add(bookButton);
        btnPanel.add(resetButton);
        btnPanel.add(showStatusButton);
        btnPanel.add(Exitbutton);

        panel.add(btnPanel);
        panel.add(createSpacer(20));

        return panel;
    }

    private JPanel createSpacer(int height) {
        JPanel spacer = new JPanel();
        spacer.setPreferredSize(new Dimension(0, height));
        return spacer;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        // Seat clicked
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (source == seats[r][c]) {
                    String seat = seats[r][c].getText();

                    if (bookedSeats.contains(seat)) {
                        statusLabel.setText(" Seat " + seat + " is already booked!");
                        statusLabel.setForeground(Color.RED);
                    } else {
                        // Deselect previous seat
                        if (selectedSeatButton != null) {
                            selectedSeatButton.setBackground(new Color(220, 255, 220));
                        }
                        // Select new seat
                        seats[r][c].setBackground(new Color(173, 216, 230)); // Light Blue
                        selectedSeatButton = seats[r][c];

                        statusLabel.setText(" Selected seat: " + seat + " — Fill details & click BOOK");
                        statusLabel.setForeground(new Color(0, 100, 0));
                    }
                    return;
                }
            }
        }

        
        if (source == bookButton) {
            if (selectedSeatButton == null) {
                statusLabel.setText(" Please select a seat first!");
                statusLabel.setForeground(Color.RED);
                return;
            }

            String name = nameField.getText().trim();
            String ageStr = ageField.getText().trim();
            String phone = phoneField.getText().trim();
            String gender = (String) genderCombo.getSelectedItem();

            if (name.isEmpty() || ageStr.isEmpty() || phone.isEmpty()) {
                statusLabel.setText("❌ Please fill all passenger details!");
                statusLabel.setForeground(Color.RED);
                return;
            }

            int age;
            try {
                age = Integer.parseInt(ageStr);
            } catch (NumberFormatException ex) {
                statusLabel.setText(" Age must be a number!");
                statusLabel.setForeground(Color.RED);
                return;
            }

            String seatNo = selectedSeatButton.getText();

            // Book it
            bookedSeats.add(seatNo);
            selectedSeatButton.setBackground(new Color(255, 180, 180));
            selectedSeatButton.setEnabled(false);
            selectedSeatButton = null;

            String msg = "🎉 Booking Confirmed!\n\n" +
                         "Passenger : " + name + "\n" +
                         "Age       : " + age + "\n" +
                         "Gender    : " + gender + "\n" +
                         "Phone     : " + phone + "\n" +
                         "Seat      : " + seatNo;

            JOptionPane.showMessageDialog(this, msg, "Success", JOptionPane.INFORMATION_MESSAGE);

            statusLabel.setText(" Seat " + seatNo + " booked successfully for " + name);
             SwingUtilities.invokeLater(() -> {
            this.dispose();           // Close THIS window
            new BookingConfirmationDialog(msg, 10000);  // Open new dashboard
        });
            
            resetForm();
       
         }
 
        
        // Reset Form
            else if (source == resetButton) {
            resetForm();
            statusLabel.setText("Form cleared. Ready for next booking.");
        }

        // Show Booked Seats
        else if (source == showStatusButton) {
            if (bookedSeats.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No seats booked yet!", "Status", JOptionPane.INFORMATION_MESSAGE);
            } else {
                StringBuilder sb = new StringBuilder("📋 Booked Seats:\n\n");
                for (String s : bookedSeats) sb.append("• ").append(s).append("\n");
                JOptionPane.showMessageDialog(this, sb.toString(), "Booked Seats", JOptionPane.PLAIN_MESSAGE);
            }
        }
    }
    
    private void resetForm() {
        nameField.setText("");
        ageField.setText("");
        phoneField.setText("");
        genderCombo.setSelectedIndex(0);
    }
    
}