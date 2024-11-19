package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReportsPanel extends JPanel {

    private JComboBox<String> reportTypeComboBox;
    private JButton generateReportButton;
    private JTextArea reportTextArea;

    public ReportsPanel() {
        setLayout(new BorderLayout());

        // Create the top panel for report selection
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());

        // Create and add a combo box for selecting report type
        String[] reportTypes = {"Daily Report", "Weekly Report", "Monthly Report"};
        reportTypeComboBox = new JComboBox<>(reportTypes);
        topPanel.add(new JLabel("Select Report Type:"));
        topPanel.add(reportTypeComboBox);

        // Create and add a button to generate the report
        generateReportButton = new JButton("Generate Report");
        generateReportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateReport();
            }
        });
        topPanel.add(generateReportButton);

        // Create the text area for displaying the report
        reportTextArea = new JTextArea();
        reportTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(reportTextArea);

        // Add the top panel and text area to the main panel
        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void generateReport() {
        // Placeholder for report generation logic
        String selectedReportType = (String) reportTypeComboBox.getSelectedItem();
        String reportContent = "Generating " + selectedReportType + "...\n";
        
        // Here you would typically call methods to fetch data and generate the report content
        // For now, we'll just simulate report content
        reportContent += "Report content goes here.";
        
        // Display the generated report in the text area
        reportTextArea.setText(reportContent);
    }
}
