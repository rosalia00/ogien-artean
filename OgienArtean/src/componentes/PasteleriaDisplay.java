package componentes;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSpinner;

import ogienartean.Pasteleria;

public class PasteleriaDisplay {
	Pasteleria q;
	JButton b;
	JSpinner s;
	JLabel l;
	public Pasteleria getQ() {
		return q;
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
	public void setQ(Pasteleria q) {
		this.q = q;
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
	public PasteleriaDisplay(Pasteleria q, JButton b, JSpinner s, JLabel l) {
		super();
		this.q = q;
		this.b = b;
		this.s = s;
		this.l = l;
	}
}
