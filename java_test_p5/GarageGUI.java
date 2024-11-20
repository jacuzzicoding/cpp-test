import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class GarageGUI extends JFrame {
    // List to store vehicles (replacing the array from last assignment)
    private ArrayList<Vehicle> garage = new ArrayList<>(); //basically this line is creating an arraylist of vehicle objects called garage
    
    // GUI Components (kinda like a vertical stack of the ui elements the user will interact with)
    //dropdown menu for the type of vehicle
    private JComboBox<String> typeCombo; 
    //text fields for the make, model, year, and mileage of the vehicle
    private JTextField makeField;
    private JTextField modelField;
    private JTextField yearField;
    private JTextField mileageField;
    //text area to display the list of vehicles
    private JTextArea vehicleList;
    
    // Constructor
    public GarageGUI() {
        super("Tom's Garage");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setupGUI();
        pack();
        setLocationRelativeTo(null);  // Center on screen
    }
    
    //this function sets up the GUI for the program
    private void setupGUI() {
        // Main panel with some padding
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Input Panel (Top Section)
        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 5, 5));
        
        // Vehicle Type Dropdown
        String[] types = {"Car", "Truck", "Motorcycle"};
        typeCombo = new JComboBox<>(types);
        inputPanel.add(new JLabel("Type:"));
        inputPanel.add(typeCombo);
        
        // Text Fields
        makeField = new JTextField(20);
        modelField = new JTextField(20);
        yearField = new JTextField(20);
        mileageField = new JTextField(20);
        
        inputPanel.add(new JLabel("Make:"));
        inputPanel.add(makeField);
        inputPanel.add(new JLabel("Model:"));
        inputPanel.add(modelField);
        inputPanel.add(new JLabel("Year:"));
        inputPanel.add(yearField);
        inputPanel.add(new JLabel("Mileage:"));
        inputPanel.add(mileageField);
        
        // Buttons Panel (Middle Section)
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton addButton = new JButton("Add Vehicle");
        JButton clearButton = new JButton("Clear Form");
        buttonPanel.add(addButton);
        buttonPanel.add(clearButton);
        
        // Vehicle List (Bottom Section)
        vehicleList = new JTextArea(10, 40);
        vehicleList.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(vehicleList);
        
        // Remove Button
        JButton removeButton = new JButton("Remove Selected Vehicle");
        
        // Add everything to main panel
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(removeButton, BorderLayout.SOUTH);
        
        // Add main panel to frame
        add(mainPanel);
        
        // We'll add the button functionality next!
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new GarageGUI().setVisible(true);
        });
    }
}