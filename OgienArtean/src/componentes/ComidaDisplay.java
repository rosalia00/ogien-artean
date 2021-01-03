package componentes;

import javax.swing.*;

import ogienartean.Comida;

public class ComidaDisplay {
	Comida c;
	JButton b;
	JSpinner s;
	JLabel l;
	
	public Comida getC() {
		return c;
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
	public void setC(Comida c) {
		this.c = c;
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
	public ComidaDisplay(Comida c, JButton b, JSpinner s, JLabel l) {
		super();
		this.c = c;
		this.b = b;
		this.s = s;
		this.l = l;
	}
	
}
