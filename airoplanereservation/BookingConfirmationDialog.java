package airoplanereservation;
import javax.swing.*;
import java.awt.*;

public class BookingConfirmationDialog {
    public BookingConfirmationDialog(String seatNumber, int amount) {

        JDialog dialog = new JDialog((Frame) null, "Booking Confirmation", true);
        dialog.setSize(420, 780);
        dialog.setLocationRelativeTo(null);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setLayout(new BorderLayout(10, 10));

     
        JLabel header = new JLabel("Please Pay to Confirm", SwingConstants.CENTER);
        header.setFont(new Font("Segoe UI", Font.BOLD, 22));
        header.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));
        dialog.add(header, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new BorderLayout(0, 20));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(10, 30, 20, 30));


        JPanel qrBox = new JPanel(new BorderLayout());
        qrBox.setBorder(BorderFactory.createLineBorder(new Color(80, 80, 80), 2));
        qrBox.setBackground(new Color(245, 245, 245));

        ImageIcon ic = new ImageIcon("WhatsApp Image 2026-03-19 at 3.16.25 PM.jpeg");

        JLabel qrLabel = new JLabel(ic, SwingConstants.CENTER);
        qrLabel.setFont(new Font("Monospaced", Font.BOLD, 52));
        qrLabel.setForeground(new Color(60, 60, 60));
        qrLabel.setBorder(BorderFactory.createEmptyBorder(60, 0, 60, 0));
        qrBox.add(qrLabel, BorderLayout.CENTER);
        qrBox.setPreferredSize(new Dimension(260, 260));

        centerPanel.add(qrBox, BorderLayout.CENTER);

        JPanel infoPanel = new JPanel(new GridLayout(3, 2, 8, 12));
        infoPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));

        Font labelFont = new Font("Segoe UI", Font.PLAIN, 15);
        Font valueFont = new Font("Segoe UI", Font.BOLD, 15);

        infoPanel.add(createLabel("Seat:", labelFont));
        infoPanel.add(createLabel(seatNumber, valueFont));
        infoPanel.add(createLabel("Amount:", labelFont));
        infoPanel.add(createLabel("₹ " + amount, valueFont));
        infoPanel.add(createLabel("Status:", labelFont));
        infoPanel.add(createLabel("Payment Pending", valueFont, new Color(200, 90, 30)));

        centerPanel.add(infoPanel, BorderLayout.SOUTH);
        dialog.add(centerPanel, BorderLayout.CENTER);

 
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 20));
       
        JButton paidBtn = new JButton("I've Paid (Mock)");
        paidBtn.setFont(new Font("Segoe UI", Font.BOLD, 16));
        paidBtn.setBackground(new Color(50, 168, 82));
        paidBtn.setForeground(Color.WHITE);
        paidBtn.setFocusPainted(false);
        paidBtn.setPreferredSize(new Dimension(160, 45));

        JButton cancelBtn = new JButton("Cancel");
        cancelBtn.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        cancelBtn.setPreferredSize(new Dimension(120, 45));
       
        paidBtn.addActionListener(e -> {
            JOptionPane.showMessageDialog(dialog,
                    "Booking confirmed!\nSeat: " + seatNumber,
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE);
                dialog.dispose();
                new AirplaneReservationSystem();
        });

        cancelBtn.addActionListener(e -> dialog.dispose());
        buttonPanel.add(paidBtn);
        buttonPanel.add(cancelBtn);
        dialog.add(buttonPanel, BorderLayout.SOUTH);
        dialog.setVisible(true);
    }

    private static JLabel createLabel(String text, Font font) {
        return createLabel(text, font, Color.BLACK);
    }

    private static JLabel createLabel(String text, Font font, Color color) {
        JLabel lbl = new JLabel(text);
        lbl.setFont(font);
        lbl.setForeground(color);
        return lbl;
    }


}