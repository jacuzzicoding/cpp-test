import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class GarageGUI extends JFrame {
    // List to store vehicles (replacing the array from last assignment)
    private ArrayList<Vehicle> garage = new ArrayList<>(); // Creating an ArrayList of Vehicle objects called garage

    // GUI Components (kinda like a vertical stack of the UI elements the user will interact with)
    // Dropdown menu for the type of vehicle
    private JComboBox<String> typeCombo;
    // Text fields for the make, model, year, and mileage of the vehicle
    private JTextField makeField;
    private JTextField modelField;
    private JTextField yearField;
    private JTextField mileageField;
    // Text area to display the list of vehicles
    private JTextArea vehicleList;

    // Constructor
    public GarageGUI() {
        super("Tom's Garage");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setupGUI(); // Initialize and set up the GUI components
        pack();
        setLocationRelativeTo(null);  // Center on screen
    }

    // This function sets up the GUI for the program
    private void setupGUI() {
        // Main panel with some padding
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Input Panel (Top Section)
        JPanel inputPanel = createInputPanel();

        // Buttons Panel (Middle Section)
        JPanel buttonPanel = createButtonPanel();

        // List Panel (Bottom Section)
        JPanel listPanel = createListPanel();

        // Combine panels into the main panel
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        mainPanel.add(listPanel, BorderLayout.SOUTH);

        // Add main panel to frame
        add(mainPanel);
    }

    // Creates the input panel with labels and text fields
    private JPanel createInputPanel() {
        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 5, 5));

        // Vehicle Type Dropdown
        String[] types = {"Car", "Truck", "Motorcycle"};
        typeCombo = new JComboBox<>(types);
        inputPanel.add(new JLabel("Type:"));
        inputPanel.add(typeCombo);

        // Text Fields for vehicle details
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

        return inputPanel;
    }

    // Creates the buttons panel with Add and Clear buttons
    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel(new FlowLayout());

        JButton addButton = new JButton("Add Vehicle");
        JButton clearButton = new JButton("Clear Form");

        // Add Vehicle Button Action
        addButton.addActionListener(e -> addVehicle());

        // Clear Form Button Action
        clearButton.addActionListener(e -> clearForm());

        buttonPanel.add(addButton);
        buttonPanel.add(clearButton);

        return buttonPanel;
    }

    // Creates the list panel with the vehicle list and Remove button
    private JPanel createListPanel() {
        JPanel listPanel = new JPanel(new BorderLayout());

        // Vehicle List (Text Area inside a Scroll Pane)
        vehicleList = new JTextArea(10, 40);
        vehicleList.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(vehicleList);

        // Remove Button
        JButton removeButton = new JButton("Remove Selected Vehicle");
        removeButton.addActionListener(e -> removeVehicle());

        listPanel.add(scrollPane, BorderLayout.CENTER);
        listPanel.add(removeButton, BorderLayout.SOUTH);

        return listPanel;
    }

    // Adds a vehicle to the garage after validating inputs
    private void addVehicle() {
        try {
            // Validate input fields
            if (!validateFields()) {
                return;
            }

            // Get values from fields
            String type = (String) typeCombo.getSelectedItem();
            String make = makeField.getText().trim();
            String model = modelField.getText().trim();
            int year = Integer.parseInt(yearField.getText().trim());
            double mileage = Double.parseDouble(mileageField.getText().trim());

            // Create appropriate vehicle type
            Vehicle vehicle = null;
            switch (type) {
                case "Car":
                    vehicle = new Car(make, model, year, mileage);
                    break;
                case "Truck":
                    vehicle = new Truck(make, model, year, mileage);
                    break;
                case "Motorcycle":
                    vehicle = new Motorcycle(make, model, year, mileage);
                    break;
            }

            // Add to garage and update display
            if (vehicle != null) {
                garage.add(vehicle);
                updateVehicleList();
                clearForm();
                JOptionPane.showMessageDialog(this, "Vehicle added successfully!");
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                "Please enter valid numbers for year and mileage.",
                "Input Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }

    // Validates the input fields for correctness
    private boolean validateFields() {
        // Check for empty fields
        if (makeField.getText().trim().isEmpty() ||
            modelField.getText().trim().isEmpty() ||
            yearField.getText().trim().isEmpty() ||
            mileageField.getText().trim().isEmpty()) {

            JOptionPane.showMessageDialog(this,
                "All fields must be filled out.",
                "Input Error",
                JOptionPane.ERROR_MESSAGE);
            return false;
        }

        try {
            // Validate year
            int year = Integer.parseInt(yearField.getText().trim());
            if (year < 1900 || year > 2025) {
                JOptionPane.showMessageDialog(this,
                    "Please enter a valid year (1900-2025).",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE);
                return false;
            }

            // Validate mileage
            double mileage = Double.parseDouble(mileageField.getText().trim());
            if (mileage < 0) {
                JOptionPane.showMessageDialog(this,
                    "Mileage cannot be negative.",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE);
                return false;
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                "Please enter valid numbers for year and mileage.",
                "Input Error",
                JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    // Clears the input form fields
    private void clearForm() {
        makeField.setText("");
        modelField.setText("");
        yearField.setText("");
        mileageField.setText("");
        typeCombo.setSelectedIndex(0);
    }

    // Removes a selected vehicle from the garage
    private void removeVehicle() {
        String input = JOptionPane.showInputDialog(this,
            "Enter the number of the vehicle to remove (1-" + garage.size() + "):");

        try {
            int index = Integer.parseInt(input) - 1;
            if (index >= 0 && index < garage.size()) {
                garage.remove(index);
                updateVehicleList();
                JOptionPane.showMessageDialog(this, "Vehicle removed successfully!");
            } else {
                JOptionPane.showMessageDialog(this,
                    "Please enter a valid vehicle number.",
                    "Invalid Input",
                    JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException | NullPointerException e) { // Catch both NumberFormatException and NullPointerException errors
            JOptionPane.showMessageDialog(this,
                "Please enter a valid number.",
                "Invalid Input",
                JOptionPane.ERROR_MESSAGE);
        }
    }

    // Function to update the vehicle list display in the text area
    private void updateVehicleList() { 
        StringBuilder display = new StringBuilder(); // Use a StringBuilder to build the string 
        for (int i = 0; i < garage.size(); i++) { // Standard loop through the garage ArrayList
            display.append(i + 1).append(". ") // This makes it so that the first vehicle is 1, the second is 2, and so on. Much easier than indexing from 0 for the user
                  .append(garage.get(i).toString()) // This calls the toString method of the Vehicle object at index i
                  .append("\n"); //this will add a new line after each vehicle for the GUI to not feel cramped
        }
        vehicleList.setText(display.toString()); // Set the text of the text area to the string I wrote
    }

    // Main method to run the GUI application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> { //this will use swing utilities to run the GUI on the event dispatch thread (which I barely understand)
            new GarageGUI().setVisible(true); //create a new GarageGUI object and set it to visible to show the GUI to the user
        });
    }
}