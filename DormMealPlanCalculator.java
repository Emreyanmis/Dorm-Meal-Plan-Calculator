package question3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DormMealPlanCalculator extends JFrame
{
	// Combo box for dorm plan
	private JComboBox dormPlan;
	
	// Combo box for meal plan
	private JComboBox mealPlan;
	
	// Dorm plan panel
	private JPanel dormPlanPanel;
	
	// Dorm meal panel
	private JPanel mealPlanPanel;
	
	// Message panel
	private JPanel messagePanel;
	
	//Selected meal plan
	private JTextField totalCost;
	
	// Displays a message
	private JLabel label1; 
	
	private JLabel dormLabel;
	private JLabel mealLabel;
	
	private String[] dorms = {"Allen Hall: $1,500 per semester",
							  "Pike Hall: $1,600 per semester",
							  "Fathering Hall: $1,200 per semester", 
							  "University Suites: $1,800 per semester"};
	
	private String[] meals = {"7 meals per week: $560 per semester",
							  "14 meals per week: $1,095 per semester",
							  "Unlimited meals: $1,500 per semester"};

	public DormMealPlanCalculator()
	{
		setTitle("Dorm and Meal Plans Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(3,2));
		
		// Build the panels
		buildMealPlan();
		buildDormPlan();
		buildMessagePlan();
		
		add(dormPlanPanel);
		add(mealPlanPanel);
		add(messagePanel);
		
		pack();
		setVisible(true);
	}
	
	private void buildMessagePlan() 
	{
		messagePanel = new JPanel();
		label1 = new JLabel("Total Expenses: $");
		totalCost = new JTextField("0.0",10);
		totalCost.setEditable(false);
		messagePanel.add(label1);
		messagePanel.add(totalCost);
	}

	private void buildDormPlan() 
	{
		dormPlanPanel = new JPanel();
		dormLabel = new JLabel("Select your dorm:");
		dormPlan = new JComboBox(dorms);
		dormPlan.setSelectedItem(null);
		dormPlan.setEditable(false);
		dormPlan.addActionListener(new ComboBoxListener());	
		dormPlanPanel.add(dormLabel);
		dormPlanPanel.add(dormPlan);		
	}

	private void buildMealPlan() 
	{	
		mealPlanPanel = new JPanel();
		mealLabel = new JLabel("Select yout meal plan:");
		mealPlan = new JComboBox(meals);
		mealPlan.setSelectedItem(null);
		mealPlan.setEditable(false);
		mealPlan.addActionListener(new ComboBoxListener());	
		mealPlanPanel.add(mealLabel);
		mealPlanPanel.add(mealPlan);
	}
	
	public class ComboBoxListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			double totalMeal = 0.0, totalDorm = 0.0;
			String TOTAL;
			
			// Get the selected meal plan
			String selectedMeal = (String) mealPlan.getSelectedItem();
			
			if(selectedMeal.startsWith("7"))
				totalMeal += 560;
			if(selectedMeal.startsWith("14"))
				totalMeal += 1095;
			if(selectedMeal.startsWith("U"))
				totalMeal += 1500;
			
			// Get the selected dorm plan
			String selectedDorm = (String) dormPlan.getSelectedItem();
			
			if(selectedDorm.startsWith("A"))
				totalDorm += 1500;
			if(selectedDorm.startsWith("P"))
				totalDorm += 1600;
			if(selectedDorm.startsWith("F"))
				totalDorm += 1200;
			if(selectedDorm.startsWith("U"))
				totalDorm += 1800;
			
			TOTAL = String.valueOf(totalDorm + totalMeal);
					
			// Display the selected dorm and meal plan cost in the text field
			totalCost.setText(TOTAL);
		}

	}

	public static void main(String[] args) 
	{
		new DormMealPlanCalculator();
	}

}
