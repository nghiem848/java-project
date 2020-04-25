package bai02;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Bai02 extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField input;
	private JButton generate;
	private JTextArea output;

	public Bai02() {
		this.setSize(400, 250);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(new FlowLayout());
		this.setResizable(false);

		input = new JTextField(15);
		this.add(input);
		generate = new JButton("Generate");
		generate.addActionListener(this);
		this.add(generate);
		output = new JTextArea(10, 24);
		JScrollPane p = new JScrollPane(output);
		this.add(p);

	}

	public static void main(String[] args) {
		Bai02 b = new Bai02();
		b.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == generate) {
			String text = this.input.getText();
			try {
				int var = Integer.parseInt(text);
				ArrayList<Integer> out = this.soNguyenTo(var);
				String s = "";
				for (int integer : out) {
					s += integer + "\n";
				}
				this.output.setText(s);
			} catch (Exception e2) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(this, "Dữ liệu không hợp lệ");
			}
		}
	}

	public ArrayList<Integer> soNguyenTo(int n) {
		ArrayList<Integer> nt = new ArrayList<Integer>();
		int i = 0, khoiTao = 2;
		while (i < n) {
			int dem = 0;
			for (int j = 2; j <= khoiTao; j++) {
				if (khoiTao % j == 0)
					dem++;
				if (dem == 2)
					break;
			}
			if (dem == 1) {
				nt.add(khoiTao);
				i++;
			}
			khoiTao++;

		}

		return nt;
	}
}
