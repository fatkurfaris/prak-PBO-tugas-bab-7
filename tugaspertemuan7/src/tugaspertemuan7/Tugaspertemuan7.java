package tugaspertemuan7;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

class kalkulator extends JFrame implements ActionListener {
	static JFrame f;
	static JTextField l;
	String s0, s1, s2;
	kalkulator()
	{
		s0 = s1 = s2 = "";
	}

	public static void main(String args[])
	{
		f = new JFrame("kalkulator");
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
		}
		kalkulator kal = new kalkulator();
		l = new JTextField(16);
		l.setEditable(false);
		JButton button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, buttonTambah, buttonKurang, buttonBagi, 
                        buttonKali, buttonE, buttonClear, buttonHasil;
		button0 = new JButton("0");
		button1 = new JButton("1");
		button2 = new JButton("2");
		button3 = new JButton("3");
		button4 = new JButton("4");
		button5 = new JButton("5");
		button6 = new JButton("6");
		button7 = new JButton("7");
		button8 = new JButton("8");
		button9 = new JButton("9");
		buttonHasil = new JButton("=");
		buttonTambah = new JButton("+");
		buttonKurang = new JButton("-");
		buttonBagi = new JButton("/");
		buttonKali = new JButton("*");
		buttonClear = new JButton("C");
		buttonE = new JButton(".");
		JPanel p = new JPanel();

		buttonKali.addActionListener(kal);
		buttonBagi.addActionListener(kal);
		buttonKurang.addActionListener(kal);
		buttonTambah.addActionListener(kal);
		button9.addActionListener(kal);
		button8.addActionListener(kal);
		button7.addActionListener(kal);
		button6.addActionListener(kal);
		button5.addActionListener(kal);
		button4.addActionListener(kal);
		button3.addActionListener(kal);
		button2.addActionListener(kal);
		button1.addActionListener(kal);
		button0.addActionListener(kal);
		buttonE.addActionListener(kal);
		buttonClear.addActionListener(kal);
		buttonHasil.addActionListener(kal);

		p.add(l);
		p.add(buttonTambah);
		p.add(button1);
		p.add(button2);
		p.add(button3);
		p.add(buttonKurang);
		p.add(button4);
		p.add(button5);
		p.add(button6);
		p.add(buttonKali);
		p.add(button7);
		p.add(button8);
		p.add(button9);
		p.add(buttonBagi);
		p.add(buttonE);
		p.add(button0);
		p.add(buttonClear);
		p.add(buttonHasil);
		f.add(p);
		f.setSize(200, 220);
		f.show();
	}
	public void actionPerformed(ActionEvent e)
	{
		String s = e.getActionCommand();
		if ((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == '.') {
			if (!s1.equals(""))
				s2 = s2 + s;
			else
				s0 = s0 + s;

			l.setText(s0 + s1 + s2);
		}
		else if (s.charAt(0) == 'C') {
			s0 = s1 = s2 = "";
			l.setText(s0 + s1 + s2);
		}
		else if (s.charAt(0) == '=') {

			double te;
			if (s1.equals("+"))
				te = (Double.parseDouble(s0) + Double.parseDouble(s2));
			else if (s1.equals("-"))
				te = (Double.parseDouble(s0) - Double.parseDouble(s2));
			else if (s1.equals("/"))
				te = (Double.parseDouble(s0) / Double.parseDouble(s2));
			else
				te = (Double.parseDouble(s0) * Double.parseDouble(s2));
			l.setText(s0 + s1 + s2 + "=" + te);
			s0 = Double.toString(te);
			s1 = s2 = "";
		}
		else {
			if (s1.equals("") || s2.equals(""))
				s1 = s;
			else {
				double te;

				if (s1.equals("+"))
					te = (Double.parseDouble(s0) + Double.parseDouble(s2));
				else if (s1.equals("-"))
					te = (Double.parseDouble(s0) - Double.parseDouble(s2));
				else if (s1.equals("/"))
					te = (Double.parseDouble(s0) / Double.parseDouble(s2));
				else
					te = (Double.parseDouble(s0) * Double.parseDouble(s2));
				s0 = Double.toString(te);
				s1 = s;
				s2 = "";
			}
			l.setText(s0 + s1 + s2);
		}
	}
}
