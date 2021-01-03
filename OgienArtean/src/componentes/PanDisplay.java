package componentes;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSpinner;

import ogienartean.Pan;

public class PanDisplay {
	Pan p;
	JButton b;
	JSpinner s;
	JLabel l;
	public Pan getP() {
		return p;
	}
	public JButton getB() {
		return b;
	}
	public JSpinner getS() {
		return s;
	}
	public JLabel getL() {
		return l;
	}
	public void setP(Pan p) {
		this.p = p;
	}
	public void setB(JButton b) {
		this.b = b;
	}
	public void setS(JSpinner s) {
		this.s = s;
	}
	public void setL(JLabel l) {
		this.l = l;
	}
	public PanDisplay(Pan p, JButton b, JSpinner s, JLabel l) {
		super();
		this.p = p;
		this.b = b;
		this.s = s;
		this.l = l;
	}
	
}
