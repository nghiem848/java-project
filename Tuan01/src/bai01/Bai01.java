package bai01;
///test github
//xong
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Bai01 extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField a, b, c, kq;
	private JButton giai, xoa, thoat;

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

		// them phan nhap
		JPanel nhap = new JPanel();
		nhap.setLayout(null);
		this.add(nhap, BorderLayout.CENTER);

		// nhap a
		JLabel lba = new JLabel("Nhập a:");
		lba.setBounds(40, 40, 50, 20);
		a = new JTextField(15);
		a.setBounds(150, 40, 350, 30);
		nhap.add(lba);
		nhap.add(a);

		// nhap b
		JLabel lbb = new JLabel("Nhập b:");
		lbb.setBounds(40, 100, 50, 20);
		b = new JTextField(15);
		b.setBounds(150, 100, 350, 30);
		nhap.add(lbb);
		nhap.add(b);

		// nhap c
		JLabel lbc = new JLabel("Nhập c:");
		lbc.setBounds(40, 160, 50, 20);
		c = new JTextField(15);
		c.setBounds(150, 160, 350, 30);
		nhap.add(lbc);
		nhap.add(c);

		// ket qua
		JLabel lbkq = new JLabel("Kết quả:");
		lbkq.setBounds(40, 220, 50, 20);
		kq = new JTextField(15);
		kq.setBounds(150, 220, 350, 30);
		kq.setEditable(false);
		nhap.add(lbkq);
		nhap.add(kq);

		// them button
		JPanel tinh = new JPanel();
		tinh.setBorder(BorderFactory.createTitledBorder("Chọn tác vụ"));
		tinh.setLayout(new FlowLayout());
		giai = new JButton("Giải");
		xoa = new JButton("Xóa rỗng");
		thoat = new JButton("Thoát");
		giai.addActionListener(this);
		xoa.addActionListener(this);
		thoat.addActionListener(this);
		tinh.add(giai);
		tinh.add(xoa);
		tinh.add(thoat);
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
		if (e.getSource() == thoat) {
			System.exit(0);
		} else if (e.getSource() == xoa) {
			this.a.setText("");
			this.b.setText("");
			this.c.setText("");
			this.kq.setText("");
		} else {
			String text_a, text_b, text_c;
			text_a = this.a.getText();
			text_b = this.b.getText();
			text_c = this.c.getText();
			double var_a, var_b, var_c;
			try {
				var_a = Double.parseDouble(text_a);
				var_b = Double.parseDouble(text_b);
				var_c = Double.parseDouble(text_c);
				ArrayList<Double> n = giaiPhuongTrinh2(var_a, var_b, var_c);
				if (n.contains(null))
					kq.setText("Vô nghiệm");
				else {
					if (n.size() == 1)
						kq.setText("X = " + n.get(0));

					else
						kq.setText("X1 = " + n.get(0) + "  X2 = " + n.get(1));
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
