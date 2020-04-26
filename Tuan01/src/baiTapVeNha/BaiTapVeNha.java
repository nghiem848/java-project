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
	
	
	private JButton btnGiai;
	private JButton  btnXoa;
	private JButton btnThoat;
	private JTextField txtA;
	private JTextField txtB;
	private JTextField txtKq;
	private JRadioButton rbnCong ;
	private JRadioButton rbnTru;
	private JRadioButton rbnNhan;
	private JRadioButton rbnChia;


	public BaiTapVeNha() {
		this.setSize(600, 450);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
	
		
		JLabel title =new JLabel("Cộng Trừ Nhân rbnChia");
		title.setFont(new Font("arial", Font.BOLD, 25));
		title.setHorizontalAlignment(JLabel.CENTER);
		this.add(title, BorderLayout.NORTH);
		
		
		JPanel tacVu =new JPanel();
		tacVu.setLayout(new FlowLayout());
		btnGiai=new JButton("Giải");
		btnGiai.addActionListener(this);
		btnXoa=new JButton("Xóa");
		btnXoa.addActionListener(this);
		btnThoat=new  JButton("Thoát");
		btnThoat.addActionListener(this);
		btnGiai.setPreferredSize(new Dimension(90,30));
		btnXoa.setPreferredSize(btnGiai.getPreferredSize());
		btnThoat.setPreferredSize(btnGiai.getPreferredSize());

		tacVu.add(btnGiai);
		tacVu.add(btnXoa);
		tacVu.add(btnThoat);
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
		txtA= new JTextField();
		txtA.setPreferredSize(new Dimension(250,30));
		nhap.setBounds(40, 20, 350, 50);
		nhap.add(txtA);
		center.add(nhap);
		
		nhap = new JPanel();
		nhap.add(new JLabel("Nhập b:"));
		txtB= new JTextField();
		txtB.setPreferredSize(new Dimension(250,30));
		nhap.setBounds(40, 70, 350, 50);
		nhap.add(txtB);
		center.add(nhap);
		
		JPanel phepToan = new JPanel();
		phepToan.setBorder(BorderFactory.createTitledBorder("Phép toán"));
		phepToan.setBounds(110,120, 250, 150);
		phepToan.setLayout(new GridLayout(2, 2));
		ButtonGroup btg= new ButtonGroup();
		rbnCong= new JRadioButton("Cộng", true);
		btg.add(rbnCong);
		rbnTru=new JRadioButton("Trừ");
		btg.add(rbnTru);
		rbnNhan=new JRadioButton("Nhân");
		btg.add(rbnNhan);
		rbnChia=new JRadioButton("rbnChia");
		btg.add(rbnChia);
		phepToan.add(rbnCong);
		phepToan.add(rbnTru);
		phepToan.add(rbnNhan);
		phepToan.add(rbnChia);

		
		center.add(phepToan);
		
		nhap = new JPanel();
		nhap.add(new JLabel("Kết quả"));
		txtKq= new JTextField();
		txtKq.setPreferredSize(new Dimension(250,30));
		txtKq.setEditable(false);
		nhap.setBounds(40, 280, 350, 50);
		nhap.add(txtKq);
		center.add(nhap);
		
		
	}
	public static void main(String[] args) {
		BaiTapVeNha b=new BaiTapVeNha();
		b.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnXoa) {
			this.txtA.setText("");
			this.txtB.setText("");
			this.txtKq.setText("");
		}
		else if(e.getSource()==btnThoat)
			System.exit(0);
		else {
			String text_a, text_b;
			text_a=this.txtA.getText();
			text_b=this.txtB.getText();
			try {
				double var_a, var_b;
				var_a =Double.parseDouble(text_a);
				var_b =Double.parseDouble(text_b);
				if (rbnCong.isSelected())
					txtKq.setText(""+(var_a+var_b));
				else if(rbnTru.isSelected())
					txtKq.setText(""+(var_a-var_b));
				else if(rbnNhan.isSelected())
					txtKq.setText(""+(var_a*var_b));
				else
					txtKq.setText(""+(var_a/var_b));
			} catch (Exception e2) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(this, "Dữ liệu không hợp lệ");
			}
		}
	}
}
