package View;
import javax.swing.*;
import java.awt.*;

public class MainMenu {
    
    private JFrame frame;
    public MainMenu() {
        showMainMenu();
    }
    
    public void showMainMenu() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        final int FRAME_WIDTH = 800; // Sedikit diperlebar untuk mengakomodasi tombol horizontal
        final int FRAME_HEIGHT = 200;
        int start_x = screenWidth / 2 - (FRAME_WIDTH / 2);
        int start_y = screenHeight / 2 - (FRAME_HEIGHT / 2);
        
        frame = new JFrame("Main Menu");
        frame.setBounds(start_x, start_y, FRAME_WIDTH, FRAME_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Panel utama
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        
        // Panel untuk judul
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        JLabel title = new JLabel("PEREKAMAN DATA");
        title.setFont(new Font("SansSerif", Font.BOLD, 24));
        titlePanel.add(title);
        
        JLabel title2 = new JLabel("E-KTP");
        title2.setFont(new Font("SansSerif", Font.BOLD, 24));
        titlePanel.add(title2);
        
        // Panel untuk tombol-tombol
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        
        // Tombol Perekaman
        JButton perekamanBtn = new JButton("PEREKAMAN");
        buttonPanel.add(perekamanBtn);
        perekamanBtn.addActionListener(e -> {
            frame.dispose();
            new FormInputData(1, null);
        });
        
        // Tombol Pencarian
        JButton pencarianBtn = new JButton("PENCARIAN");
        buttonPanel.add(pencarianBtn);
        pencarianBtn.addActionListener(e -> {
            frame.dispose();
            new FormPencarianData();
        });
        
        // Tombol Exit
        JButton exitBtn = new JButton("EXIT");
        buttonPanel.add(exitBtn);
        exitBtn.addActionListener(e -> {
            frame.dispose();
        });
        
        // Menambahkan panel ke frame
        mainPanel.add(titlePanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        
        frame.add(mainPanel);
        frame.setVisible(true);
    }
}