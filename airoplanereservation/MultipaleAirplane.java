package airoplanereservation;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;



public class MultipaleAirplane extends JFrame  {

    public MultipaleAirplane(){
        
        super("Airplane Information Dashboard");
        try {
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(1100, 600);
            setLocationRelativeTo(null);
            setResizable(false);
            setVisible(true);
            
        
            JPanel contentPane = new JPanel();
            contentPane.setLayout(null);   
            contentPane.setBackground(Color.white);
            setContentPane(contentPane);  
            
          
            JPanel infoPanel = new JPanel();
            JPanel infoPane2 = new JPanel();
            JPanel infoPane3 = new JPanel();
            JPanel infoPane4 = new JPanel();
            JPanel infoPane5 = new JPanel();
            JPanel infoPane6 = new JPanel();
            JPanel infoPane7 = new JPanel();
            JPanel infoPane8 = new JPanel();
            
            infoPanel.setBackground(new Color(255, 200, 150));
            infoPane2.setBackground(new Color(255, 200, 150));
            infoPane3.setBackground(new Color(255, 200, 150));
            infoPane4.setBackground(new Color(255, 200, 150));
            infoPane5.setBackground(new Color(255, 200, 150));
            infoPane6.setBackground(new Color(255, 200, 150));
            infoPane7.setBackground(new Color(255, 200, 150));
            infoPane8.setBackground(new Color(255, 200, 150));
            
            // add some example components
            // Panel 1: Starts at 10, Width 250 (Ends at 260)
            infoPanel.setBounds(10, 20, 250, 250);
            infoPane2.setBounds(280, 20, 250, 250);
            infoPane3.setBounds(550, 20, 250, 250);
            infoPane4.setBounds(820, 20, 250, 250);
            infoPane6.setBounds(10,280 , 250, 250);
            infoPane5.setBounds(280,280 , 250, 250);
            infoPane7.setBounds(550,280 , 250, 250);
            infoPane8.setBounds(820, 280, 250, 250);
            
            //button
            
            JButton jb1 = new JButton("SELECT");           
            jb1.setFont(new Font("Segoe UI", Font.BOLD, 14));
            jb1.setForeground(Color.WHITE);
            jb1.setBackground(new Color(0, 120, 215));
            jb1.setFocusPainted(false);
            infoPanel.setLayout(new BorderLayout());      
            infoPanel.add(jb1, BorderLayout.SOUTH);  
            
            JButton jb2 = new JButton("SELECT");         
            jb2.setFont(new Font("Segoe UI", Font.BOLD, 14));
            jb2.setForeground(Color.WHITE);
            jb2.setBackground(new Color(0, 120, 215));
            jb2.setFocusPainted(false);
            infoPane2.setLayout(new BorderLayout());      
            infoPane2.add(jb2, BorderLayout.SOUTH);  
            
            JButton jb3 = new JButton("SELECT");         
            jb3.setFont(new Font("Segoe UI", Font.BOLD, 14));
            jb3.setForeground(Color.WHITE);
            jb3.setBackground(new Color(0, 120, 215));
            jb3.setFocusPainted(false);
            infoPane3.setLayout(new BorderLayout());      
            infoPane3.add(jb3, BorderLayout.SOUTH);  
            
        JButton jb4 = new JButton("SELECT");         
        jb4.setFont(new Font("Segoe UI", Font.BOLD, 14));
        
        jb4.setForeground(Color.WHITE);
        jb4.setBackground(new Color(0, 120, 215));
        jb4.setFocusPainted(false);
        infoPane4.setLayout(new BorderLayout());      
        infoPane4.add(jb4, BorderLayout.SOUTH);  
        
        JButton jb5 = new JButton("SELECT");         
        jb5.setFont(new Font("Segoe UI", Font.BOLD, 14));
        jb5.setForeground(Color.WHITE);
        jb5.setBackground(new Color(0, 120, 215));
        jb5.setFocusPainted(false);
        infoPane5.setLayout(new BorderLayout());      
        infoPane5.add(jb5, BorderLayout.SOUTH);
        
        JButton jb6 = new JButton("SELECT"); // fix typo too
        jb6.setFont(new Font("Segoe UI", Font.BOLD, 14));
        jb6.setForeground(Color.WHITE);
        jb6.setBackground(new Color(0, 120, 215));
        jb6.setFocusPainted(false);
        infoPane6.setLayout(new BorderLayout());      
        infoPane6.add(jb6, BorderLayout.SOUTH);  
        
        JButton jb7 = new JButton("SELECT");         
        jb7.setFont(new Font("Segoe UI", Font.BOLD, 14));
        jb7.setForeground(Color.WHITE);
        jb7.setBackground(new Color(0, 120, 215));
        jb7.setFocusPainted(false);
        infoPane7.setLayout(new BorderLayout());      
        infoPane7.add(jb7, BorderLayout.SOUTH);  
        
        JButton jb8 = new JButton("SELECT");         
        jb8.setFont(new Font("Segoe UI", Font.BOLD, 14));
        jb8.setForeground(Color.WHITE);
        jb8.setBackground(new Color(0, 120, 215));
        jb8.setFocusPainted(false);
        infoPane8.setLayout(new BorderLayout());      
        infoPane8.add(jb8, BorderLayout.SOUTH);  
        
        
        // Panel 1 – infoPanel
        // ───────────────────────────────────────────────
        JLabel flight1 = new JLabel("fligh:- AI-235");
        flight1.setFont(new Font("Segoe UI", Font.BOLD, 18));
        flight1.setForeground(new Color(30, 60, 100));
        flight1.setBounds(10, 15, 230, 35);
        infoPanel.add(flight1);
        
        JLabel route1 = new JLabel("route:- BOM → DEL");
        route1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        route1.setForeground(Color.DARK_GRAY);
        route1.setBounds(20, 65, 210, 28);
        infoPanel.add(route1);
        
        JLabel time1 = new JLabel("time:- 06:45 – 08:55");
        time1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        time1.setForeground(Color.DARK_GRAY);
        time1.setBounds(20, 150, 210, 28);
        infoPanel.add(time1);
        
        JLabel status1 = new JLabel("status:- Delayed 20 min");
        status1.setFont(new Font("Segoe UI", Font.BOLD, 14));
        status1.setForeground(new Color(220, 53, 69));     
        status1.setBounds(20, 125, 210, 28);
        infoPanel.add(status1);
        
        JLabel load1 = new JLabel("load:- 189/285");
        load1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        load1.setForeground(new Color(80, 80, 80));
        load1.setBounds(120, 25, 105, 28);
        infoPanel.add(load1);
        
        
        // Panel 2 –
        
        JLabel flight2 = new JLabel("fligh:- AI-428");
        flight2.setFont(new Font("Segoe UI", Font.BOLD, 18));
        flight2.setForeground(new Color(30, 60, 100));
        flight2.setBounds(10, 15, 230, 35);
        infoPane2.add(flight2);
        
        JLabel route2 = new JLabel("route:- DEL → BLR");
        route2.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        route2.setForeground(Color.DARK_GRAY);
        route2.setBounds(20, 65, 210, 28);
        infoPane2.add(route2);
        
        JLabel time2 = new JLabel("time:- 09:20 – 11:50");
        time2.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        time2.setForeground(Color.DARK_GRAY);
        time2.setBounds(20, 150, 210, 28);
        infoPane2.add(time2);
        
        JLabel status2 = new JLabel("status:- Gate Closed");
        status2.setFont(new Font("Segoe UI", Font.BOLD, 14));
        status2.setForeground(Color.BLACK);    
        status2.setBounds(20, 125, 210, 28);
        infoPane2.add(status2);
        
        JLabel load2 = new JLabel("load:- 135/285");
        load2.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        load2.setForeground(Color.BLACK);
        load2.setBounds(120, 105, 210, 28);
        infoPane2.add(load2);
        
        //panel3
        
        JLabel flight3 = new JLabel("fligh:- AI-428");
        flight3.setFont(new Font("Segoe UI", Font.BOLD, 18));
        flight3.setForeground(new Color(30, 60, 100));
        flight3.setBounds(10, 15, 230, 35);
        infoPane3.add(flight3);
        
        JLabel route3 = new JLabel("route:- DEL → BLR");
        route3.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        route3.setForeground(Color.DARK_GRAY);
        route3.setBounds(20, 65, 210, 28);
        infoPane3.add(route3);
        
        JLabel time3 = new JLabel("time:- 09:20 – 11:50");
        time3.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        time3.setForeground(Color.DARK_GRAY);
        time3.setBounds(20, 150, 210, 28);
        infoPane3.add(time3);
        
        JLabel status3 = new JLabel("status:- Scheduled");
        status3.setFont(new Font("Segoe UI", Font.BOLD, 14));
        status3.setForeground(Color.blue);     // green example
        status3.setBounds(20, 125, 210, 28);
        infoPane3.add(status3);
        
        JLabel load3 = new JLabel("load:- 135/285");
        load3.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        load3.setForeground(Color.BLACK);
        load3.setBounds(120, 105, 210, 28);
        infoPane3.add(load3);
        
        //paneal4
        
        
        JLabel flight4 = new JLabel("fligh:- AI-428");
        flight4.setFont(new Font("Segoe UI", Font.BOLD, 18));
        flight4.setForeground(new Color(30, 60, 100));
        flight4.setBounds(10, 15, 230, 35);
        infoPane4.add(flight4);
        
        JLabel route4 = new JLabel("route:- DEL → BLR");
        route4.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        route4.setForeground(Color.DARK_GRAY);
        route4.setBounds(20, 65, 210, 28);
        infoPane4.add(route4);
        
        JLabel time4 = new JLabel("time:- 09:20 – 11:50");
        time4.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        time4.setForeground(Color.DARK_GRAY);
        time4.setBounds(20, 150, 210, 28);
        infoPane4.add(time4);
        
        JLabel status4 = new JLabel("status:- On Time");
        status4.setFont(new Font("Segoe UI", Font.BOLD, 14));
        status4.setForeground(Color.green);     // green example
        status4.setBounds(20, 125, 210, 28);
        infoPane4.add(status4);
        
        JLabel load4 = new JLabel("load:- 135/285");
        load4.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        load4.setForeground(Color.BLACK);
        load4.setBounds(120, 105, 210, 28);
        infoPane4.add(load4);
        
        //panel5
        
        
        JLabel flight5 = new JLabel("fligh:- AI-428");
        flight5.setFont(new Font("Segoe UI", Font.BOLD, 18));
        flight5.setForeground(new Color(30, 60, 100));
        flight5.setBounds(10, 15, 230, 35);
        infoPane5.add(flight5);

        JLabel route5 = new JLabel("route:- DEL → BLR");
        route5.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        route5.setForeground(Color.DARK_GRAY);
        route5.setBounds(20, 65, 210, 28);
        infoPane5.add(route5);
        
        JLabel time5 = new JLabel("time:- 09:20 – 11:50");
        time5.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        time5.setForeground(Color.DARK_GRAY);
        time5.setBounds(20, 150, 210, 28);
        infoPane5.add(time5);
        
        JLabel status5 = new JLabel("status:- Scheduled");
status5.setFont(new Font("Segoe UI", Font.BOLD, 14));
status5.setForeground(Color.blue);     
status5.setBounds(20, 125, 210, 28);
infoPane5.add(status5);

JLabel load5 = new JLabel("load:- 135/285");
load5.setFont(new Font("Segoe UI", Font.PLAIN, 13));
load5.setForeground(Color.BLACK);
load5.setBounds(120, 105, 210, 28);
infoPane5.add(load5);

//panel6

JLabel flight6 = new JLabel("fligh:- AI-428");
flight6.setFont(new Font("Segoe UI", Font.BOLD, 18));
flight6.setForeground(new Color(30, 60, 100));
flight6.setBounds(10, 15, 230, 35);
infoPane6.add(flight6);

JLabel route6 = new JLabel("route:- DEL → BLR");
route6.setFont(new Font("Segoe UI", Font.PLAIN, 14));
route6.setForeground(Color.DARK_GRAY);
route6.setBounds(20, 65, 210, 28);
infoPane6.add(route6);

JLabel time6 = new JLabel("time:- 09:20 – 11:50");
time6.setFont(new Font("Segoe UI", Font.PLAIN, 14));
time6.setForeground(Color.DARK_GRAY);
time6.setBounds(20, 150, 210, 28);
infoPane6.add(time6);

JLabel status6 = new JLabel("status:- On Time");
status6.setFont(new Font("Segoe UI", Font.BOLD, 14));
status6.setForeground(Color.green);     // green example
status6.setBounds(20, 125, 210, 28);
infoPane6.add(status6);

JLabel load6 = new JLabel("load:- 135/285");
load6.setFont(new Font("Segoe UI", Font.PLAIN, 13));
load6.setForeground(Color.BLACK);
load6.setBounds(120, 105, 210, 28);
infoPane6.add(load6);


//paneal7

JLabel flight7 = new JLabel("fligh:- AI-428");
flight7.setFont(new Font("Segoe UI", Font.BOLD, 18));
flight7.setForeground(new Color(30, 60, 100));
flight7.setBounds(10, 15, 230, 35);
infoPane7.add(flight7);

JLabel route7 = new JLabel("route:- DEL → BLR");
route7.setFont(new Font("Segoe UI", Font.PLAIN, 14));
route7.setForeground(Color.DARK_GRAY);
route7.setBounds(20, 65, 210, 28);
infoPane7.add(route7);

JLabel time7 = new JLabel("time:- 09:20 – 11:50");
time7.setFont(new Font("Segoe UI", Font.PLAIN, 14));
time7.setForeground(Color.DARK_GRAY);
time7.setBounds(20, 150, 210, 28);
infoPane7.add(time7);

JLabel status7 = new JLabel("status:- On Time");
status7.setFont(new Font("Segoe UI", Font.BOLD, 14));
status7.setForeground(Color.green);     
status7.setBounds(20, 125, 210, 28);
infoPane7.add(status7);

JLabel load7 = new JLabel("load:- 135/285");
load7.setFont(new Font("Segoe UI", Font.PLAIN, 13));
load7.setForeground(Color.BLACK);
load7.setBounds(120, 105, 210, 28);
infoPane7.add(load7);


//panel8
JLabel flight8 = new JLabel("fligh:- AI-428");
flight8.setFont(new Font("Segoe UI", Font.BOLD, 18));
flight8.setForeground(new Color(30, 60, 100));
flight8.setBounds(10, 15, 230, 35);
infoPane8.add(flight8);

JLabel route8 = new JLabel("route:- DEL → BLR");
route8.setFont(new Font("Segoe UI", Font.PLAIN, 14));
route8.setForeground(Color.DARK_GRAY);
route8.setBounds(20, 65, 210, 28);
infoPane8.add(route8);

JLabel time8 = new JLabel("time:- 09:20 – 11:50");
time8.setFont(new Font("Segoe UI", Font.PLAIN, 14));
time8.setForeground(Color.DARK_GRAY);
time8.setBounds(20, 150, 210, 28);
infoPane8.add(time8);

JLabel status8 = new JLabel("status:- Scheduled");
status8.setFont(new Font("Segoe UI", Font.BOLD, 14));
status8.setForeground(Color.blue);     // green example
status8.setBounds(20, 125, 210, 28);
infoPane8.add(status8);

JLabel load8 = new JLabel("load:- 135/285");
load8.setFont(new Font("Segoe UI", Font.PLAIN, 13));
load8.setForeground(Color.BLACK);
load8.setBounds(20, 105, 210, 28);
infoPane8.add(load8);
contentPane.add(infoPanel);
contentPane.add(infoPane2);
contentPane.add(infoPane3);
contentPane.add(infoPane4);
contentPane.add(infoPane5);
contentPane.add(infoPane6);
contentPane.add(infoPane7);
contentPane.add(infoPane8);
setVisible(true);


ActionListener selectListener = e -> {
    SwingUtilities.invokeLater(() -> {
        dispose();                          
        new AirplaneReservationSystem();     
    });
};



// Assign the SAME listener to all 8 buttons
jb1.addActionListener(selectListener);
jb2.addActionListener(selectListener);
jb3.addActionListener(selectListener);
jb4.addActionListener(selectListener);
jb5.addActionListener(selectListener);
jb6.addActionListener(selectListener);
jb7.addActionListener(selectListener);
jb8.addActionListener(selectListener);
}catch (Exception e) {
    System.out.println(" somthis is not good in this code multipale " + e);
    
}
}
}




