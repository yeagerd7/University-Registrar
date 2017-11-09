package oopda;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
/**
 * RegistrarGui class constructs and builds the GUI for the program.
 * @author David Yeager, Tyler Cockburn
 * @version  July 10, 2016
 */
public class RegistrarGui implements ActionListener {
    //Field declarations for the panel attributes
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    //Field declarations for the label attributes
    private JLabel panel3text;
    private JLabel panel1text;
    private JLabel panel4text;
    //Field declaration for the window attribute
    private JFrame window;
    //Field declaration for the department combo box
    private JComboBox<Department> departmentbox;
    //Field declaration for the lastName attribute
    private String lastName;
    //Field declaration for the term attribute
    private Term term;
    //Field declaration for the student attribute
    private Student student;
    /**
     * Constructor for the RegistrarGui class that builds and constructs the entire GUI object
     */
    public RegistrarGui(){
        lastName = JOptionPane.showInputDialog("Enter your last name:");
        student = new Student(1, lastName);

        Department[] department = Department.values();

        window = new JFrame("Banner Self Service for " + lastName);

        final int WINDOW_WIDTH = 1200,
                WINDOW_HEIGHT = 120;
        window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        panel1 = new JPanel();
        panel1.setLayout(new FlowLayout());

        departmentbox = new JComboBox<Department>(department);
        departmentbox.setSelectedIndex(0);
        departmentbox.addActionListener(this);

        panel2 = new JPanel();
        panel2.setLayout(new GridLayout(0,1));
        panel2.setBackground(Color.WHITE);

        panel3 = new JPanel();

        panel1text = new JLabel("Select a department: ");
        panel3text = new JLabel("Matching Sections");

        panel1.add(panel1text);
        panel1.add(departmentbox);
        panel3.add(panel3text);

        window.add(panel1, BorderLayout.NORTH);
        window.add(panel2, BorderLayout.CENTER);
        window.add(panel3, BorderLayout.SOUTH);

        panel1.setVisible(true);
        panel2.setVisible(true);
        departmentbox.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);

        term = Driver.initialize();
    }
    /**
     * Action Method for the combobox that sets the foundation for the GUI to run and populate itself.  The end
     * of the method contains an internal method call which continues the execution of the program and GUI
     */
    public void actionPerformed(ActionEvent arg0) {
        panel1.remove(panel1text);
        panel2.removeAll();
        panel3.removeAll();

        JLabel crnLabel = new JLabel("  Click CRN to add or drop a class");
        JLabel courseLabel = new JLabel("Course Number");
        JLabel titleLabel = new JLabel("Title");
        JLabel instructorLabel = new JLabel("Instructor");
        JLabel scheduleLabel = new JLabel("             Schedule");

        Font bold = new Font("Courier", Font.BOLD, 12);

        crnLabel.setFont(bold);
        crnLabel.setForeground(Color.BLUE);
        courseLabel.setFont(bold);
        courseLabel.setForeground(Color.BLUE);
        titleLabel.setFont(bold);
        titleLabel.setForeground(Color.BLUE);
        instructorLabel.setFont(bold);
        instructorLabel.setForeground(Color.BLUE);
        scheduleLabel.setFont(bold);
        scheduleLabel.setForeground(Color.BLUE);

        JPanel panel5 = new JPanel();

        panel5.add(crnLabel);
        panel5.add(courseLabel);
        panel5.add(titleLabel);
        panel5.add(instructorLabel);
        panel5.add(scheduleLabel);
        panel5.setLayout(new GridLayout(1,5));
        panel5.setBackground(Color.WHITE);

        panel2.add(panel5);
        panel3text.remove(panel3text);
        window.pack();

        crnLabel.setVisible(true);
        courseLabel.setVisible(true);
        titleLabel.setVisible(true);
        instructorLabel.setVisible(true);
        scheduleLabel.setVisible(true);
        panel2.setVisible(true);

        generateLabels();
    }
    /**
     * Generates and builds the center region depending on the combobox selection.  It then, adds action listeners
     * on the CRN buttons allowing the user to add or drop a specific section.
     **/
    private void generateLabels(){
        int counter = 0;
        Department department = (Department) departmentbox.getSelectedItem();
        ArrayList <Section> classSections = new ArrayList<>();
        for (Section s: term.getSections()){
            if(s.getCourse().getDepartment() == department){
                classSections.add(s);
                counter++;
            }
        }
        panel3text = new JLabel(counter + " sections of " + department + " found.");
        panel3.add(panel3text);
        panel4text = new JLabel("");
        for (Section s: classSections){
            int counter1 = 0;
            JButton crnlabelbutton = new JButton(s.getCrn().toString());
            JLabel courselabel = new JLabel(s.getCourse().getCourseNumber());
            JLabel titleLabel = new JLabel(s.getCourse().getTitle());
            JLabel instructorLabel = new JLabel(s.getInstructor().getLastName());
            JLabel scheduleLabel = new JLabel(s.getSchedule());

            JPanel panel4 = new JPanel();
            JPanel panel6 = new JPanel();

            panel6.setLayout(new FlowLayout());
            panel6.add(crnlabelbutton);

            panel4.setBorder(BorderFactory.createBevelBorder(0));
            panel4.add(panel6);
            panel4.add(courselabel);
            panel4.add(titleLabel);
            panel4.add(instructorLabel);
            panel4.add(scheduleLabel);

            panel4.setBackground(new Color(255, 255,204));
            panel6.setBackground(new Color(255, 255,204));

            if(classSections.indexOf(s) % 2 == 0) {
                panel4.setBackground(Color.WHITE);
                panel6.setBackground(Color.WHITE);
            }

            Font plain = new Font("Courier", Font.BOLD, 11);
            Font plain2 = new Font("Courier", Font.BOLD, 10);

            courselabel.setFont(plain);
            titleLabel.setFont(plain);
            instructorLabel.setFont(plain);
            scheduleLabel.setFont(plain2);

            counter1++;

            panel4.setLayout(new GridLayout(counter1,5));
            panel2.add(panel4);

            crnlabelbutton.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    boolean valid;
                    panel3.remove(panel3text);
                    panel4text.setText("Registered Courses: ");
                    if(student.getCurrentSections().keySet().contains(Integer.parseInt(crnlabelbutton.getText()))) {
                        student.drop(s);
                    }
                    else{
                        if(s instanceof HybridSection){
                            valid = HybridSection.validateChoice();
                            if(valid == true){
                                student.add(s);
                            }
                        }
                        else if(s instanceof OnlineSection){
                            valid = OnlineSection.validateChoice();
                            if(valid == true){
                                student.add(s);
                            }
                        }
                        else {
                            student.add(s);
                        }
                    }
                    generateRegisteredSections();
                }
            });
            window.pack();
            panel3.add(panel4text);
            panel3text.setVisible(true);
            panel2.setVisible(true);
            panel3.setVisible(true);
        }
    }
    /**
     * Mutator Method that generates every class a user registers for and sets it to an appropriate JLabel variable
     */
    public void generateRegisteredSections(){
        for(Integer key : student.getCurrentSections().keySet()) {
            panel4text.setText(panel4text.getText() + " "+ key + " " + student.getCurrentSections().get(key).getCourse().getTitle());
        }
    }
}
