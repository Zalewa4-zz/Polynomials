import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JToggleButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
/**
 * 
 * @author Adrian Zalewski 10041
 *
 */
public class Aplikacja {

	private JFrame frame;
	private JTable tab;
	private JTable tab2;
	Dzialania d = new Dzialania();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Aplikacja window = new Aplikacja();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Aplikacja() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("serial")
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Program Wielomiany by Adrian Zalewski 10041");
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		Insets insets = frame.getInsets();
		this.setBounds(0,0, insets.left + 1920 + insets.right, insets.top + 1080 + insets.bottom);
		tab = new JTable();

		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 101, 1887, 432);
		frame.getContentPane().add(scrollPane);
		tab.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		//tab.setTableHeader(null);
		tab.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					
				}
		));
		scrollPane.setViewportView(tab);
		
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(20, 579, 1887, 432);
		frame.getContentPane().add(scrollPane2);
		
		tab2 = new JTable();
		tab2.setVisible(true);
		tab2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		//tab2.setTableHeader(null);
		tab2.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					
				}
		));
		scrollPane2.setViewportView(tab2);

		
		JLabel lblN = new JLabel("n");
		lblN.setBounds(32, 11, 10, 19);
		frame.getContentPane().add(lblN);
		lblN.setFont(new Font("Lucida Bright", Font.BOLD, 15));
		
		JLabel lblP = new JLabel("p");
		lblP.setBounds(82, 11, 10, 19);
		frame.getContentPane().add(lblP);
		lblP.setFont(new Font("Lucida Bright", Font.BOLD, 15));
		
		JLabel lblA = new JLabel("A");
		lblA.setBounds(134, 11, 12, 19);
		frame.getContentPane().add(lblA);
		lblA.setFont(new Font("Lucida Bright", Font.BOLD, 15));
		
		JLabel lblB = new JLabel("B");
		lblB.setBounds(182, 11, 10, 19);
		frame.getContentPane().add(lblB);
		lblB.setFont(new Font("Lucida Bright", Font.BOLD, 15));
		
		JSpinner spinnerN = new JSpinner();
		spinnerN.setBounds(20, 41, 40, 20);
		frame.getContentPane().add(spinnerN);
		spinnerN.setModel(new SpinnerNumberModel(new Integer(3), null, null, new Integer(1)));
		
		int n = (int) spinnerN.getValue();
		
		JSpinner spinnerP = new JSpinner();
		spinnerP.setBounds(70, 41, 40, 20);
		frame.getContentPane().add(spinnerP);
		spinnerP.setModel(new SpinnerNumberModel(new Integer(7), null, null, new Integer(1)));
		
		int p = (int) spinnerP.getValue();
		
		JSpinner spinnerA = new JSpinner();
		spinnerA.setBounds(122, 41, 40, 20);
		frame.getContentPane().add(spinnerA);
		spinnerA.setModel(new SpinnerNumberModel(new Integer(10), null, null, new Integer(1)));
		
		int a = (int) spinnerA.getValue();
		
		JSpinner spinnerB = new JSpinner();
		spinnerB.setBounds(172, 41, 40, 20);
		frame.getContentPane().add(spinnerB);
		int b = (int) spinnerB.getValue();
		spinnerB.setModel(new SpinnerNumberModel(new Integer(10), null, null, new Integer(1)));
		
		JLabel tresc = new JLabel("");
		tresc.setBounds(379, 15, 1528, 75);
		frame.getContentPane().add(tresc);
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("Oblicz");
		tglbtnNewToggleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				d.Dodawanie(spinnerN, spinnerP, spinnerA, spinnerB, tab, tresc);
				d.Mnozenie(spinnerN, spinnerP, spinnerA, spinnerB, tab2);

			}
		});
		tglbtnNewToggleButton.setBounds(238, 40, 123, 23);
		frame.getContentPane().add(tglbtnNewToggleButton);
		
		JLabel lblNewLabel = new JLabel("Dodawanie wielomian\u00F3w:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setBounds(20, 76, 192, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblMnoenieWielomianw = new JLabel("Mno\u017Cenie wielomian\u00F3w:");
		lblMnoenieWielomianw.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblMnoenieWielomianw.setBounds(20, 554, 172, 14);
		frame.getContentPane().add(lblMnoenieWielomianw);
		

		
		
	}

	private void setBounds(int i, int j, int k, int l) {
		// TODO Auto-generated method stub
		
	}
}
