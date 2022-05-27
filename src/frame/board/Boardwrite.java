package frame.board;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.plaf.DimensionUIResource;

import frame.db.DB;

public class Boardwrite extends JFrame implements ActionListener, WindowListener{
	
	

	private JPanel PanelUp;
	private JPanel PanelDown;
	private JPanel PanelCenter;
	private JTextArea ta;
	private JButton btnSend;
	private JLabel lblboardname;
	private JLabel lbltitle;
	private JTextField tftitle;
	private JLabel lblWriter;
	private JTextField tfWriter;
	private JLabel lblWriteday;
	private JTextField tfWriteday;
	private JPanel panel1;
	private JPanel panel1UP;
	private JPanel panel1Center;
	private JPanel panel1Down;
	private JPanel panel2;
	private JLabel lblselection;
	private Vector<String> vecCombo;
	private JComboBox<String> comboselection;
	private JPanel panelUpp;
	private Color skyblue;
	private JScrollPane sp;
	private int i;
	//private DB db;

	public Boardwrite(String title) {
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(300, 300);
		setSize(390, 500);
		setLayout(new BorderLayout());
		skyblue = new Color(189, 215, 238);
		PanelUP();
		PanelCenter();
		PanelDown();
		addWindowListener(this);
		//db = new DB();
		
		setVisible(true);
	}

	private void PanelUP() {
		PanelUp = new JPanel();
		PanelUp.setLayout(new BorderLayout());
			
		panel1 = new JPanel();
		panel1.setLayout(new GridLayout(4,1));
		
		panel1UP=new JPanel();
		panel1UP.setLayout(null);
		panel1UP.setPreferredSize(new DimensionUIResource(100, 50));
		panel1UP.setBackground(skyblue);
		
		lbltitle = new JLabel("제목");
		lbltitle.setFont(new Font("210 맨발의청춘 L", Font.BOLD, 15));
		lbltitle.setLocation(10, 20);
		lbltitle.setSize(40, 20);
		panel1UP.add(lbltitle);
		
		//제목 텍스트 필드
		tftitle = new JTextField(25);
		tftitle.setLocation(85, 20);
		tftitle.setSize(280, 10);
		tftitle.setBorder(BorderFactory.createEmptyBorder());
		tftitle.setFont(new Font("210 맨발의청춘 L", Font.PLAIN, 10));
		panel1UP.add(tftitle);
		
		// 제목 텍스트 배경
		ImageIcon imgtitle = new ImageIcon("imges/text5.png");
		JLabel lbltitle = new JLabel(imgtitle);
		lbltitle.setBounds(75, 10, 302, 30);
		panel1UP.add(lbltitle);
				
		panel1.add(panel1UP);//제목
		
		panel1Center = new JPanel();
		panel1Center.setLayout(null);
		panel1Center.setPreferredSize(new DimensionUIResource(100, 50));
		panel1Center.setBackground(skyblue);
		
		lblWriteday = new JLabel("작성일자");
		lblWriteday.setFont(new Font("210 맨발의청춘 L", Font.BOLD, 15));
		lblWriteday.setLocation(10, 20);
		lblWriteday.setSize(150, 20);
		panel1Center.add(lblWriteday);
		
		tfWriteday = new JTextField(25);
		tfWriteday.setLocation(85, 20);
		tfWriteday.setSize(280, 10);
		tfWriteday.setBorder(BorderFactory.createEmptyBorder());
		tfWriteday.setFont(new Font("210 맨발의청춘 L", Font.PLAIN, 10));
		panel1Center.add(tfWriteday);
		
		ImageIcon imgwriteday = new ImageIcon("imges/text5.png");
		JLabel lblwriteday = new JLabel(imgwriteday);
		lblwriteday.setBounds(75, 10, 302, 30);
		panel1Center.add(lblwriteday);
		
		panel1.add(panel1Center);//작성일자
		
		panel1Down = new JPanel();
		panel1Down.setLayout(null);
		panel1Down.setPreferredSize(new DimensionUIResource(100, 50));
		panel1Down.setBackground(skyblue);
		
		lblWriter = new JLabel("작성자");
		lblWriter.setFont(new Font("210 맨발의청춘 L", Font.BOLD, 15));
		lblWriter.setLocation(10, 20);
		lblWriter.setSize(150, 20);
		panel1Down.add(lblWriter);
		
		tfWriter = new JTextField(25);
		tfWriter.setLocation(85, 20);
		tfWriter.setSize(280, 10);
		tfWriter.setBorder(BorderFactory.createEmptyBorder());
		tfWriter.setFont(new Font("210 맨발의청춘 L", Font.PLAIN, 10));
		panel1Down.add(tfWriter);
		
		ImageIcon imgwriter = new ImageIcon("imges/text5.png");
		JLabel lblwriter = new JLabel(imgwriter);
		lblwriter.setBounds(75, 10, 302, 30);
		panel1Down.add(lblwriter);
		
		panel1.add(panel1Down);//작성자
		
		panel2 = new JPanel();
		panel2.setLayout(new FlowLayout(FlowLayout.RIGHT,10,5));
		panel2.setBackground(skyblue);
		lblselection = new JLabel("카테고리");
		lblselection.setFont(new Font("210 맨발의청춘 L", Font.BOLD, 10));
		panel2.add(lblselection);
		
		vecCombo = new Vector<String>();
	      vecCombo.add("운동");
	      vecCombo.add("나눔");
	      
	      comboselection = new JComboBox<String>(vecCombo);
	      comboselection.setPreferredSize(new Dimension(100, 35));
	      comboselection.setBackground(Color.white);
	      
		panel2.add(comboselection);//콤보박스
		panel1.add(panel2);
		
		PanelUp.add(panel1);
		add(PanelUp, BorderLayout.NORTH);
	}
	
	private void PanelCenter() {
		PanelCenter = new JPanel();
		PanelCenter.setBackground(skyblue);
		ta = new JTextArea(12,26);
		ta.setLineWrap(true);
		ta.setFont(new Font("210 맨발의청춘 L", Font.PLAIN, 13));
		sp = new JScrollPane(ta, 
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		PanelCenter.add(sp);
		add(PanelCenter, BorderLayout.CENTER);
	}
	
	private void PanelDown() {
		PanelDown = new JPanel();
		PanelDown.setBackground(skyblue);
		
		PanelDown.setPreferredSize(new Dimension(300, 50));
		PanelDown.setLayout(new FlowLayout(FlowLayout.RIGHT,10,0));
		
		btnSend = new JButton(new ImageIcon("imges/upload.png"));
		btnSend.setBorderPainted(false);
		btnSend.setContentAreaFilled(false);
		btnSend.setFont(new Font("210 맨발의청춘 L", Font.BOLD, 10));
		btnSend.addActionListener(this);
		PanelDown.add(btnSend);
		add(PanelDown, BorderLayout.SOUTH);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == btnSend) {
			DB db = new DB();
			i = db.GetBDID();
			System.out.println("리턴 받은 값 : " + i);
			i = i + 1;
			db.BDInsert(i, tftitle.getText(), tfWriteday.getText(), tfWriter.getText(), comboselection.getSelectedItem().toString(), ta.getText());
			dispose();
		}
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		this.dispose();
	}

	@Override
	public void windowClosed(WindowEvent e) {
		Board bd = new Board(null);
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}

