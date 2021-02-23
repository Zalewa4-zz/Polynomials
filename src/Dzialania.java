
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
/**
 * 
 * @author Adrian Zalewski 10041
 *
 */


public class Dzialania {
	
	
	
	
	public void Dodawanie(JSpinner spinnerN, JSpinner spinnerP, JSpinner spinnerA, JSpinner spinnerB, JTable tab, JLabel tresc) {
		
		int n = (int) spinnerN.getValue();
		int p = (int) spinnerP.getValue();
		int a = (int) spinnerA.getValue();
		int b = (int) spinnerB.getValue();
		Object rowData[] = new Object[(int) spinnerB.getValue()];
		DefaultTableModel model = (DefaultTableModel) tab.getModel();
		model.setRowCount(0);
		model.setColumnCount(0);
		for( int i=0; i<(int) spinnerB.getValue();i++){
			model.addColumn(+i);
			}
		tab.getColumn("0").setCellRenderer(
		        new DefaultTableCellRenderer() {
		            public Component getTableCellRendererComponent(JTable tab, 
		                                                           Object value, 
		                                                           boolean isSelected, 
		                                                           boolean hasFocus, 
		                                                           int row, 
		                                                           int column) {
		                setText(value.toString());
		                setBackground(isSelected ? Color.blue : Color.gray);
		                return this;
		            }
		        });
		
		int s = 0, aa, bb, pv, pdn;
        int wyniki[][] = new int[a][b];
        int i, j, k, h;
        int[] at = new int[n];
        int[] bt = new int[n];
        int[] st = new int[n];
        int flag = (int) Math.pow(p, n); 
        pdn = p;
        for (i = 2; i <= n; i++) pdn = pdn * p;

        tresc.setText("<html>Algebra Wielomianów stopnia < n = " + String.valueOf(n) +
        		" nad cialem Zp,  p = " + String.valueOf(p) + "<br /> Wielomian nierozkladalny plD = [X]_p = " + String.valueOf(flag) + " stopnia stpD = "+ String.valueOf(n)+"</html>");
        pv = 0;
        aa = 0; bb = 0;
        for(i = 0; i < a; i++) {
        	for(j = 0; j < b; j++) {
        		aa=i;
        		bb=j;
        		for (k = 0; k < n; k++) {
        			at[k] = aa % p;
        			bt[k] = bb % p;
        			st[k] = (at[k] + bt[k]) % p;
        			aa = aa / p;
        			bb = bb / p; 
        		}
        		s=0;
   		  		for(h=n-1; h>=0; h--) {
   		  			s = s * p + st[h];
   		  			wyniki[i][j] = s;
   		  		}
   		  		rowData[j] = wyniki[i][j];
   		  	
        	}
        	model.addRow(rowData);
        }
        
	}
	@SuppressWarnings("serial")
	public void Mnozenie(JSpinner spinnerN, JSpinner spinnerP, JSpinner spinnerA, JSpinner spinnerB, JTable tab2) {
		int n = (int) spinnerN.getValue();
		int p = (int) spinnerP.getValue();
		int a = (int) spinnerA.getValue();
		int b = (int) spinnerB.getValue();
		Object rowData[] = new Object[(int) spinnerB.getValue()];
		DefaultTableModel model = (DefaultTableModel) tab2.getModel();
		model.setRowCount(0);
		model.setColumnCount(0);
		for( int i=0; i<(int) spinnerB.getValue();i++){
			model.addColumn(+i);
			}
/*		tab2.getColumn("0").setCellRenderer(
		        new DefaultTableCellRenderer() {
		            public Component getTableCellRendererComponent(JTable tab, 
		                                                           Object value, 
		                                                           boolean isSelected, 
		                                                           boolean hasFocus, 
		                                                           int row, 
		                                                           int column) {
		                setText(value.toString());
		                setBackground(isSelected ? Color.blue : Color.gray);
		                return this;
		            }
		        });
		
		
		tab2.setTableHeader(null);*/
		
		int s=0, aa = 0, bb = 0;
        int wyniki[][] = new int[a][b];
        int i, j, k, h;
        int[] at = new int[n];
        int[] bt = new int[n];
        int[] st = new int[n];
        int[] ilw = new int[2 * n - 1];
        int flag;
   

        
        for(i=0; i <a; i++) {
        	for(j=0; j<b; j++) {
        		aa=i;
        		bb=j;
        		for (k = 0; k < n; k++) {
        			at[k] = aa % p;
        			bt[k] = bb % p;
        			aa = aa / p;
        			bb = bb / p; 
        		}
        		for (k = 2 * n - 2; k >= 0; k--){
        			ilw[k] = 0;
        			for (h = Math.max(0, k - n + 1); h <= Math.min(k, n - 1); h++) {
        				ilw[k] = (ilw[k] + at[h] * bt[k - h]) % p;
        			};
        			s = s * p + ilw[k];
        			wyniki[i][j]= s;
        		}
        		s=0;
        		rowData[j]=wyniki[i][j];     	
        	}
        	model.addRow(rowData);
        	
        }

	}
}
