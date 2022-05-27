// 작성자: 김지웅
// 개인정보 수정 프레임
package frame.login;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import frame.db.dbOpen;
import frame.main.MainFrame;

public class ChangeInfo extends JFrame implements ActionListener{
	private Font mainFont;
	private Font subFont;
	//DB연결 전 임시 데이터 저장
	private final String ID = "gomwoong";
	private JButton profile;
	private Color def;
	private JButton edit;
	private Object obj;
	private MainFrame mf;
	private dbOpen db;
	private JTextField nameField;
	private JPasswordField pwField;
	private JPasswordField pwCheckField;
	private JTextField phoneField;
	private JTextField addressField;
	private JButton pwEdit;

	public JPasswordField getPwField() {
		return pwField;
	}

	public JTextField getPhoneField() {
		return phoneField;
	}

	public JTextField getAddressField() {
		return addressField;
	}
	
	//201945012 MainFrame 연결
	public ChangeInfo(MainFrame mf) {
		this.mf = mf;
		setTitle("Change Info");
		setBounds(100, 100, 360, 450);
		setResizable(false); //창 크기 조절 불가능하게 만들기
		setLocationRelativeTo(null); //정가운데 출력
		setLayout(new BorderLayout());

		mainFont = new Font("210 맨발의청춘 L", Font.BOLD, 20); // 메인 및 서브 컬러 RGB값 담는 객체 생성
		subFont = new Font("210 맨발의청춘 L", 0, 13);
		def = new Color(189, 215, 238); //별도로 사용할 글꼴의 세부사항 설정
		
		setNorth(); //상단 패널 설정하는 생성자 호출
		setCenter(); //중앙 패널 설정하는 생성자 호출
		db = new dbOpen();
		db.pullInfo(ID, nameField, phoneField, addressField, pwField, pwCheckField);
		
		setVisible(true);
	}
	
	public ChangeInfo() {
		setTitle("Change Info");
		setBounds(100, 100, 360, 450);
		setResizable(false); //창 크기 조절 불가능하게 만들기
		setLocationRelativeTo(null); //정가운데 출력
		setLayout(new BorderLayout());

		mainFont = new Font("210 맨발의청춘 L", Font.BOLD, 20); // 메인 및 서브 컬러 RGB값 담는 객체 생성
		subFont = new Font("210 맨발의청춘 L", 0, 13);
		def = new Color(189, 215, 238); //별도로 사용할 글꼴의 세부사항 설정
		
		setNorth(); //상단 패널 설정하는 생성자 호출
		setCenter(); //중앙 패널 설정하는 생성자 호출
		db = new dbOpen();
		db.pullInfo(ID, nameField, phoneField, addressField, pwField, pwCheckField);
		
		setVisible(true);
	}
	
	private void setNorth() {
		JPanel NorthPanel = new JPanel();
		NorthPanel.setBackground(def);
		NorthPanel.setLayout(null);
		NorthPanel.setPreferredSize(new Dimension(360, 160)); //상단 패널 크기 360*160 설정
		add(NorthPanel, BorderLayout.NORTH);
		
		JLabel title = new JLabel("회원정보 수정");
		title.setFont(mainFont);
		title.setBounds(115, 10, 120, 30);
		NorthPanel.add(title);
		
		//이미지 붙은 버튼 추가하기
		ImageIcon profileImg = new ImageIcon("imges/person.png"); 
		profile = new JButton(profileImg);
		profile.setContentAreaFilled(false); //버튼 영역 배경 표시 설정
		profile.setBorderPainted(false); //버튼 테두리 표시 설정
		profile.setFocusPainted(false); //포커스 표시 설정
		profile.setBounds(125, 50, 100, 100);
		profile.addActionListener(this);
		NorthPanel.add(profile);
	}

	
	private void setCenter() {
		JPanel CenterPanel = new JPanel();
		CenterPanel.setBackground(Color.WHITE);
		CenterPanel.setLayout(null);
		add(CenterPanel, BorderLayout.CENTER);
		
		String[] text = {"아이디", "이름", "비밀번호", "전화번호", "주소"}; 
		//라벨에 사용할 텍스트
		
		//5개의 라벨을 붙이기 위한 for문
		JLabel[] textlb = new JLabel[5];
		int y = 10;
		for(int i = 0; i < textlb.length; i++, y+=40) {
			textlb[i] = new JLabel(text[i]);
			textlb[i].setFont(subFont);
			textlb[i].setBounds(20, y, 100, 30);
			CenterPanel.add(textlb[i]);
		}
		
		//텍스트필드 뒤의 배경 이미지를 추가
		JLabel idImage = new JLabel(new ImageIcon("imges/textField.png"));
		idImage.setBounds(72, 10, 130, 30);
		CenterPanel.add(idImage);
		
		JLabel nameImage = new JLabel(new ImageIcon("imges/textField.png"));
		nameImage.setBounds(72, 50, 130, 30);
		CenterPanel.add(nameImage);
		
		JLabel pwImage = new JLabel(new ImageIcon("imges/textField.png"));
		pwImage.setBounds(72, 90, 130, 30);
		CenterPanel.add(pwImage);
		
		JLabel pwchImage = new JLabel(new ImageIcon("imges/textField.png"));
		pwchImage.setBounds(202, 90, 130, 30);
		CenterPanel.add(pwchImage);
		
		JLabel phoneImage = new JLabel(new ImageIcon("imges/textField.png"));
		phoneImage.setBounds(72, 130, 130, 30);
		CenterPanel.add(phoneImage);
		
		JLabel addImage = new JLabel(new ImageIcon("imges/addtextField.png"));
		addImage.setBounds(61, 170, 280, 30);
		CenterPanel.add(addImage);
		
		//아이디 텍스트 필드 붙이기
		JTextField idField = new JTextField(ID, 11);
		idField.setBorder(null); //텍스트필드 테두리 없애기
		idField.setEditable(false); //편집 불가능하게 만들기
		idField.setFont(subFont);
		idField.setBackground(Color.WHITE);
		idField.setBounds(80, 11, 115, 27);
		CenterPanel.add(idField);
		
		//이름 텍스트 필드 붙이기
		nameField = new JTextField(11);
		nameField.setBorder(null);
		nameField.setEditable(false);
		nameField.setFont(subFont);
		nameField.setBackground(Color.WHITE);
		nameField.setBounds(80, 52, 115, 27);
		CenterPanel.add(nameField);
		
		//비밀번호 패스워드필드 붙이기
		pwField = new JPasswordField();
		pwField.setBorder(null);
		pwField.setBounds(80, 92, 115, 27);
		pwField.setEditable(false);
		pwField.setBackground(Color.WHITE);
		CenterPanel.add(pwField);
		
		//비밀번호 확인 패스워드필드 붙이기
		pwCheckField = new JPasswordField();
		pwCheckField.setBorder(null);
		pwCheckField.setBounds(210, 92, 115, 27);
		pwCheckField.setEditable(false);
		pwCheckField.setBackground(Color.WHITE);
		CenterPanel.add(pwCheckField);
		
		//전화번호 텍스트필드 붙이기
		phoneField = new JTextField(11);
		phoneField.setBorder(null);
		phoneField.setFont(subFont);
		phoneField.setBounds(80, 132, 115, 27);
		CenterPanel.add(phoneField);
		
		//비밀번호 수정 버튼 붙이기
		pwEdit = new JButton("비밀번호 수정");
		pwEdit.setFont(subFont); 
		pwEdit.setBounds(215, 122, 150, 27);
		pwEdit.setBorderPainted(false);
		pwEdit.setContentAreaFilled(false);
		CenterPanel.add(pwEdit);
		pwEdit.addActionListener(this);
		
		//주소 텍스트필드 붙이기
		addressField = new JTextField(20);
		addressField.setBorder(null);
		addressField.setFont(subFont);
		addressField.setBounds(80, 172, 245,  27);
		CenterPanel.add(addressField);
		
		//수정 버튼 추가하기
		edit = new JButton("수정하기");
		edit.setFont(subFont);
		edit.setBorderPainted(false);
		edit.setContentAreaFilled(false);
		edit.setBounds(260, 210, 90, 30);
		CenterPanel.add(edit);
		edit.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		obj = e.getSource();
		
		if(obj == profile) {
			//파일입출력 부분
		}else if(obj == pwEdit) {
			pwField.setEditable(true);
			pwField.setText("");
			pwCheckField.setEditable(true);
			pwCheckField.setText("");
		}else if(obj == edit){
			char[] temp = pwField.getPassword();
			String result = "";
			String result2 = "";
			
			for(char ch	: temp) {
				Character.toString(ch);
				result += ""+ch+"";
			}
			
			temp = pwCheckField.getPassword();
			
			for(char ch	: temp) {
				Character.toString(ch);
				result2 += ""+ch+"";
			}
			
			if(result.equals(result2)) {
				QuestionPW pw = new QuestionPW(this, 2); //수정 버튼 클릭시 비밀번호 확인 프레임 호출
			}
			else
				JOptionPane.showMessageDialog(this, "입력한 비밀번호가 일치하지 않습니다.", "알림",
						JOptionPane.INFORMATION_MESSAGE);
		}
	}
}