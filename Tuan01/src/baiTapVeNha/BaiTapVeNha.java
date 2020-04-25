package baiTapVeNha;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class BaiTapVeNha extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private JButton giai, xoa, thoat;
	private JTextField a, b, kq;
	private JRadioButton cong , tru, nhan, chia;
	
	public BaiTapVeNha() {
		this.setSize(600, 450);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
	
		
		JLabel title =new JLabel("Cộng Trừ Nhân Chia");
		title.setFont(new Font("arial", Font.BOLD, 25));
		title.setHorizontalAlignment(JLabel.CENTER);
		this.add(title, BorderLayout.NORTH);
		
		
		JPanel tacVu =new JPanel();
		tacVu.setLayout(new FlowLayout());
		giai=new JButton("Giải");
		giai.addActionListener(this);
		xoa=new JButton("Xóa");
		xoa.addActionListener(this);
		thoat=new  JButton("Thoát");
		thoat.addActionListener(this);
		giai.setPreferredSize(new Dimension(90,30));
		xoa.setPreferredSize(new Dimension(90,30));
		thoat.setPreferredSize(new Dimension(90,30));

		tacVu.add(giai);
		tacVu.add(xoa);
		tacVu.add(thoat);
		tacVu.setBorder(BorderFactory.createTitledBorder("Chọn tác vụ"));
		tacVu.setPreferredSize(new Dimension(120,0));
		tacVu.setBackground(Color.gray);
		this.add(tacVu, BorderLayout.WEST );
		
		
		
		JPanel south =new JPanel();
		south.setLayout(new FlowLayout());
		south.setBackground(Color.GRAY);
		south.setPreferredSize(new Dimension(0, 50));
		this.add(south, BorderLayout.SOUTH);
		
		
		JPanel center =new JPanel();
		center.setBorder(BorderFactory.createTitledBorder("Tính toán"));
		center.setLayout(null);
		this.add(center, BorderLayout.CENTER);
		
		JPanel nhap = new JPanel();
		nhap.add(new JLabel("Nhập a:"));
		a= new JTextField();
		a.setPreferredSize(new Dimension(250,30));
		nhap.setBounds(40, 20, 350, 50);
		nhap.add(a);
		center.add(nhap);
		
		nhap = new JPanel();
		nhap.add(new JLabel("Nhập b:"));
		b= new JTextField();
		b.setPreferredSize(new Dimension(250,30));
		nhap.setBounds(40, 70, 350, 50);
		nhap.add(b);
		center.add(nhap);
		
		JPanel phepToan = new JPanel();
		phepToan.setBorder(BorderFactory.createTitledBorder("Phép toán"));
		phepToan.setBounds(110,120, 250, 150);
		phepToan.setLayout(new GridLayout(2, 2));
		ButtonGroup btg= new ButtonGroup();
		cong= new JRadioButton("Cộng", true);
		btg.add(cong);
		tru=new JRadioButton("Trừ");
		btg.add(tru);
		nhan=new JRadioButton("Nhân");
		btg.add(nhan);
		chia=new JRadioButton("Chia");
		btg.add(chia);
		phepToan.add(cong);
		phepToan.add(tru);
		phepToan.add(nhan);
		phepToan.add(chia);

		
		center.add(phepToan);
		
		nhap = new JPanel();
		nhap.add(new JLabel("Kết quả"));
		kq= new JTextField();
		kq.setPreferredSize(new Dimension(250,30));
		kq.setEditable(false);
		nhap.setBounds(40, 280, 350, 50);
		nhap.add(kq);
		center.add(nhap);
		
		
	}
	public static void main(String[] args) {
		BaiTapVeNha b=new BaiTapVeNha();
		b.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==xoa) {
			this.a.setText("");
			this.b.setText("");
			this.kq.setText("");
		}
		else if(e.getSource()==thoat)
			System.exit(0);
		else {
			String text_a, text_b;
			text_a=this.a.getText();
			text_b=this.b.getText();
			try {
				double var_a, var_b;
				var_a =Double.parseDouble(text_a);
				var_b =Double.parseDouble(text_b);
				if (cong.isSelected())
					kq.setText(""+(var_a+var_b));
				else if(tru.isSelected())
					kq.setText(""+(var_a-var_b));
				else if(nhan.isSelected())
					kq.setText(""+(var_a*var_b));
				else
					kq.setText(""+(var_a/var_b));
			} catch (Exception e2) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(this, "Dữ liệu không hợp lệ");
			}
		}
	}
}
