package com.example.payroll;

import com.example.payroll.gui.PayrollSystemGUI;

public class Main {
    public static void main(String[] args) {
        // Initialize and display the GUI
        javax.swing.SwingUtilities.invokeLater(() -> {
            PayrollSystemGUI gui = new PayrollSystemGUI();
            gui.display();
        });
    }
}
