import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class StudentList extends JFrame implements ActionListener {

    // Declare variables
    private JLabel lblName, lblRollNo, lblSemister, lblBatch;
    private JTextField txtName, txtRollNo, txtSemister, txtBatch;
    private JButton btnAdd, btnSearch, btnShowAll;
    private JTextArea txtResults;
    private List<Student> students;

    // Constructor
    public StudentList() {
        // Set the title
        super("Student List");

        // Set the layout
        setLayout(new FlowLayout());

        // Initialize variables
        lblName = new JLabel("Name: ");
        lblRollNo = new JLabel("Roll No: ");
        lblSemister = new JLabel("Semister: ");
        lblBatch = new JLabel("Batch: ");
        txtName = new JTextField(20);
        txtRollNo = new JTextField(10);
        txtSemister = new JTextField(5);
        txtBatch = new JTextField(5);
        btnAdd = new JButton("Add");
        btnSearch = new JButton("Search");
        btnShowAll = new JButton("Show All");
        txtResults = new JTextArea(10, 40);
        students = new ArrayList<>();

        // Add action listeners to the buttons
        btnAdd.addActionListener(this);
        btnSearch.addActionListener(this);
        btnShowAll.addActionListener(this);

        // Add the components to the frame
        add(lblName);
        add(txtName);
        add(lblRollNo);
        add(txtRollNo);
        add(lblSemister);
        add(txtSemister);
        add(lblBatch);
        add(txtBatch);
        add(btnAdd);
        add(btnSearch);
        add(btnShowAll);
        add(txtResults);

        // Set the size and location of the frame
        setSize(1000, 700);
        setLocationRelativeTo(null);

        // Set the default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Make the frame visible
        setVisible(true);
    }

    // Main method
    public static void main(String[] args) {
        new StudentList();
    }

    // Action performed method
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAdd) {
            // Get the values from the text fields
            String name = txtName.getText();
            int rollNo = Integer.parseInt(txtRollNo.getText());
            int semi = Integer.parseInt(txtSemister.getText());
            String Batch = txtBatch.getText();

            // Create a new student object with the values
            Student student = new Student(name, rollNo, semi, Batch);

        // Add the student to the list
        students.add(student);

        // Clear the text fields
        txtName.setText("");
        txtRollNo.setText("");
        txtSemister.setText("");
        txtBatch.setText("");

        // Show a message indicating that the student was added
        JOptionPane.showMessageDialog(this, "Student added successfully");
    } else if (e.getSource() == btnSearch) {
        // Get the roll number to search for
        int rollNo = Integer.parseInt(txtRollNo.getText());

        // Clear the text area
        txtResults.setText("");

        // Search for the student with the given roll number
        boolean found = false;
        for (Student student : students) {
            if (student.getRollNo() == rollNo) {
                // If the student is found, display their details in the text area
                txtResults.append("Name: " + student.getName() + "\n");
                txtResults.append("Roll No: " + student.getRollNo() + "\n");
                txtResults.append("Semister: " + student.getSemi() + "\n");
                txtResults.append("Batch: " + student.getBatch() + "\n");
                found = true;
                break;
            }
        }

        // If the student is not found, show a message indicating that
        if (!found) {
            JOptionPane.showMessageDialog(this, "Student not found");
        }
    } else if (e.getSource() == btnShowAll) {
        // Clear the text area
        txtResults.setText("");

        // Display the details of all the students in the list
        for (Student student : students) {
            txtResults.append("Name: " + student.getName() + "\n");
            txtResults.append("Roll No: " + student.getRollNo() + "\n");
            txtResults.append("Semister: " + student.getSemi() + "\n");
            txtResults.append("Batch: " + student.getBatch() + "\n");
            txtResults.append("\n");
        }
    }
}
}

// Student class
class Student {
// Declare variables
private String name;
private int rollNo;
private int semi;
private String batch;
// Constructor
public Student(String name, int rollNo, int semi, String batch) {
    this.name = name;
    this.rollNo = rollNo;
    this.semi = semi;
    this.batch = batch;
}

// Getters
public String getName() {
    return name;
}

public int getRollNo() {
    return rollNo;
}

public int getSemi() {
    return semi;
}

public String getBatch() {
    return batch;

}
}


