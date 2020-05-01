package bai01;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Bai01 extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	private JTextField txtA;
	private JTextField txtB;
	private JTextField txtC;
	private JTextField txtKq;
	private JButton btnGiai, btnXoa, btnThoat;

	public Bai01() {
		this.setSize(600, 450);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
	
		// Tieu de
		JLabel title = new JLabel("GIẢI PHƯƠNG TRÌNH BẬC 2");
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setBackground(Color.gray);
		title.setBounds(0, 0, 600, 50);
		title.setOpaque(true);
		title.setFont(new Font("Arial", Font.BOLD, 25));
		title.setPreferredSize(new Dimension(0, 50));
		this.add(title, BorderLayout.NORTH);

		// them phan nhap 321
		JPanel nhap = new JPanel();
		nhap.setLayout(null);
		this.add(nhap, BorderLayout.CENTER);
		nhap.setLayout(new BoxLayout(nhap, BoxLayout.Y_AXIS));

		// nhap a
		nhap.add(Box.createRigidArea(new Dimension(0,20)));
		JPanel pla=new JPanel();
		JLabel lba = new JLabel("Nhập a:");
		lba.setPreferredSize(new Dimension(100,30));
		txtA = new JTextField(20);
		txtA.setPreferredSize(new Dimension(100,30));
		pla.add(lba);
		pla.add(txtA);
		nhap.add(pla);
		
		
		// nhap b
		JPanel plb=new JPanel();
		JLabel lbb = new JLabel("Nhập b:");
		lbb.setPreferredSize(lba.getPreferredSize());
		txtB = new JTextField(20);
		txtB.setPreferredSize(txtA.getPreferredSize());
		plb.add(lbb);
		plb.add(txtB);
		nhap.add(plb);

		// nhap c
		JPanel plc=new JPanel();
		JLabel lbc = new JLabel("Nhập c:");
		lbc.setPreferredSize(lba.getPreferredSize());
		txtC = new JTextField(20);
		txtC.setPreferredSize(txtA.getPreferredSize());
		plc.add(lbc);
		plc.add(txtC);
		nhap.add(plc);

		// ket qua
		JPanel plKq=new JPanel();
		JLabel lbkq = new JLabel("Kết quả:");
		lbkq.setPreferredSize(lba.getPreferredSize());
		txtKq = new JTextField(20);
		txtKq.setEditable(false);
		txtKq.setPreferredSize(txtA.getPreferredSize());
		plKq.add(lbkq);
		plKq.add(txtKq);
		nhap.add(plKq);

		// them button
		JPanel tinh = new JPanel();
		tinh.setBorder(BorderFactory.createTitledBorder("Chọn tác vụ"));
		tinh.setLayout(new FlowLayout());
		btnGiai = new JButton("Giải");
		btnXoa = new JButton("Xóa rỗng");
		btnThoat = new JButton("Thoát");
		btnGiai.addActionListener(this);
		btnXoa.addActionListener(this);
		btnThoat.addActionListener(this);
		tinh.add(btnGiai);
		tinh.add(btnXoa);
		tinh.add(btnThoat);
		tinh.setPreferredSize(new Dimension(0, 70));
		this.add(tinh, BorderLayout.SOUTH);

	}

	public static void main(String[] args) {
		Bai01 b = new Bai01();
		b.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btnThoat) {
			System.exit(0);
		} else if (e.getSource() == btnXoa) {
			this.txtA.setText("");
			this.txtB.setText("");
			this.txtC.setText("");
			this.txtKq.setText("");
		} else {
			String text_a, text_b, text_c;
			text_a = this.txtA.getText();
			text_b = this.txtB.getText();
			text_c = this.txtC.getText();
			double var_a, var_b, var_c;
			try {
				var_a = Double.parseDouble(text_a);
				var_b = Double.parseDouble(text_b);
				var_c = Double.parseDouble(text_c);
				ArrayList<Double> n = giaiPhuongTrinh2(var_a, var_b, var_c);
				if (n.contains(null))
					txtKq.setText("Vô nghiệm");
				else {
					if (n.size() == 1)
						txtKq.setText("X = " + n.get(0));

					else
						txtKq.setText("X1 = " + n.get(0) + "  X2 = " + n.get(1));
				}
			} catch (Exception e2) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(this, "Dữ liệu không hợp lệ");
			}
		}

	}

	public ArrayList<Double> giaiPhuongTrinh2(double a, double b, double c) {
		ArrayList<Double> n = new ArrayList<Double>();
		if (a == 0) {
			if (b == 0)
				n.add(null);

			else
				n.add(-c / b);

		} else {
			double delta = b * b - 4 * a * c;
			if (delta < 0)
				n.add(null);
			else if (delta == 0)
				n.add(-b / (2 * a));
			else {
				double n1 = (-b + Math.sqrt(delta)) / (2 * a);
				double n2 = (-b - Math.sqrt(delta)) / (2 * a);
				n.add(n1);
				n.add(n2);
			}
		}
		return n;
	}

}
