# java 기능추가

## java frame 만들기

### JFrame을 상속받는 main() 클래스 작성

<img src="/02. JAVA/00. img/16-1.png" width="500">
```java
import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Test1 extends JFrame{
	//JFrame 상속받아 만듬
	Test1(){
		super("java"); //제목 설정
		setVisible(true); //프레임 출력 메서드
		
		
		JButton j1 = new JButton("버튼1");
		JButton j2 = new JButton("버튼2");
		JButton j3 = new JButton("버튼3");
		
		Container c = getContentPane();
		//컨텐트팬을 알아낸다
		c.add(j1);
		c.add(j2);
		c.add(j3);
		
		c.setLayout(new FlowLayout()); //배치관리자 순서대로 배치
	}
	
	public static void main(String[] args) {
		new Test1(); //생성자 호출
	}
}
```

### JFrame을 객체로 만들어 작성

<img src="/02. JAVA/00. img/16-2.png" width="500">

```java
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Test1 {
	public static void main(String[] args) {
		JFrame j = new JFrame();
		j.setLayout(new BorderLayout());
		
		j.add(new JButton("동"), BorderLayout.EAST);
		j.add(new JButton("서"), BorderLayout.WEST);
		j.add(new JButton("남"), BorderLayout.SOUTH);
		j.add(new JButton("북"), BorderLayout.NORTH);
		j.add(new JButton("중앙"), BorderLayout.CENTER);
		
		j.setVisible(true);
	}
}
```

<img src="/02. JAVA/00. img/16-3.png" width="500">

```java
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Test1 {
	public static void main(String[] args) {
		JFrame j = new JFrame();
		j.setLayout(new FlowLayout());
		
		JButton j1 = new JButton("ONE");
		JButton j2 = new JButton("TWO");
		
		j.add(j1);
		j.add(j2);
		
		j.setVisible(true);
	}
}

```

### 기능 넣기

<img src="/02. JAVA/00. img/16-4.png" width="500">

```java
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;

class Mouse extends MouseAdapter{
	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("마우스 클릭");
	}
}

public class Test1 {
	public static void main(String[] args) {
		JFrame j = new JFrame();
		j.setLayout(new FlowLayout());
		
		JButton j1 = new JButton("ONE");
		JButton j2 = new JButton("TWO");
		
		j.add(j1);
		j.add(j2);
		
		j.setVisible(true);
		
		//ONE 버튼을 마우스로 클릭했을 때(이벤트 처리)
		j1.addMouseListener(new Mouse());		
	}
}

```

## 이벤트 리스너 넣기

[자바 강의 3주차(awt).pdf](java%20%E1%84%80%E1%85%B5%E1%84%82%E1%85%B3%E1%86%BC%E1%84%8E%E1%85%AE%E1%84%80%E1%85%A1%20e4efb242c7ab4a2189d96e6c59ff4348/%25EC%259E%2590%25EB%25B0%2594_%25EA%25B0%2595%25EC%259D%2598_3%25EC%25A3%25BC%25EC%25B0%25A8(awt).pdf)

### 누를때 마다 버튼 텍스트 변경

```java
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;

class My implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e){
		JButton b = (JButton) e.getSource(); //이벤트가 어디서 발행했냐
		
		if(b.getText().equals("클릭")) { //이벤트가 발생한 버튼명 알아냄
			b.setText("Clickt"); //버튼명을 영어로 세팅함"
		}else {
			b.setText("클릭");
		}
	}
}

public class Test extends JFrame{
	Test(){
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JButton j1 = new JButton("클릭");
		
		c.add(j1);
		setVisible(true);
		j1.addActionListener(new My());
	}
	
	public static void main(String[] args) {
		new Test();
	}
}
```

<img src="/02. JAVA/00. img/16-5.png" width="500">

### 클릭 시 텍스트 출력, 버튼 비활성화

```java
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Test extends JFrame{
	Test(){
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JButton j1 = new JButton("OK");
		JButton j2 = new JButton("cancle");
		
		c.add(j1);
		c.add(j2);
		setVisible(true);
		
		j1.addActionListener(new ActionListener() {
			
			@Override //자동으로 오버라이드됨
			public void actionPerformed(ActionEvent e) {
				System.out.println("OK");
				
			}
		});
		j2.addActionListener(new ActionListener() {
			
			@Override //자동으로 오버라이드됨
			public void actionPerformed(ActionEvent e) {
				j2.setEnabled(false); //버튼 비활성화
				
			}
		});
	}
	
	public static void main(String[] args) {
		new Test();
	}
}
```

<img src="/02. JAVA/00. img/16-6.png" width="500">

### mouseDragged 이벤트

```java
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

class Mouse extends MouseAdapter implements MouseMotionListener{ 
	//마우스 어뎁터에 드래그 이벤트 있어서 마우스 모션리스너 다중상속할 필요는 없음
	@Override
	public void mouseDragged(MouseEvent e) {
		Container c = (Container) e.getSource();
		c.setBackground(Color.yellow);
	}
	
	public void mouseReleased(MouseEvent e) {
		Container c = (Container) e.getSource();
		c.setBackground(Color.pink);
	}
}

public class Test1 extends JFrame{
	Test1(){
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.setLayout(new FlowLayout());
		c.setBackground(Color.pink);

		setVisible(true);
		
		c.addMouseListener(new Mouse());
		c.addMouseMotionListener(new Mouse());

	}
	
	public static void main(String[] args) {
		new Test1();
	}
}
```

<img src="/02. JAVA/00. img/16-7.png" width="500">

### mouseEntered, mouseExited 이벤트(마우스 올리고 내릴때 변경)

```java
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;

class My extends MouseAdapter{
	@Override
	public void	mouseEntered(MouseEvent e) { //마우스 올릴때
		JLabel j = (JLabel)e.getSource();
		j.setText("재밌어");
	}
	@Override
	public void mouseExited(MouseEvent e) { //마우스 내릴때
		JLabel j = (JLabel)e.getSource();
		j.setText("자바는");
	}
}

public class Test extends JFrame{
	Test(){
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		setVisible(true);
		
		JLabel j = new JLabel("자바는"); //글자,이미지
		c.add(j);
		
		j.addMouseListener(new My());
	}
	
	public static void main(String[] args)  {
			
		new Test();
		
	}
}
```

<img src="/02. JAVA/00. img/16-8.png" width="500">

### itemStateChanged

```java
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Scanner;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Test extends JFrame{
	Test(){
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		setVisible(true);
		
		JCheckBox j = new JCheckBox("자바");
		c.add(j);
		
		j.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					System.out.println("자바 재밌당");
				}
				
			}
		});
	}
	
	public static void main(String[] args)  {
			
		new Test();
		
	}
}
```

<img src="/02. JAVA/00. img/16-9.png" width="500">

### 체크박스 여러개 생성

```sql
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Scanner;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Test extends JFrame{
	Test(){
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		setVisible(true);
		
		JCheckBox j[] = new JCheckBox[15]; //객체배열, 체크박스가 여거래일 때
		c.setLayout(new GridLayout(3,5)); //Grid = 행,열구조
		
		//객체를 생성해서 배열에 저장
		for(int i=0; i<j.length; i++) {
			j[i]=new JCheckBox("check "+(i+1)); //JCheckBox안에는 String만 가능(api 참고)
			c.add(j[i]);
			
		}
		
	}
	
	public static void main(String[] args)  {
		new Test();
	}
}
```

<img src="/02. JAVA/00. img/16-10.png" width="500">

### 이미지 부착

```java
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Test1 extends JFrame{
   Test1(){
      Container c=getContentPane();
      setVisible(true);
      c.setLayout(new FlowLayout());
      
      JLabel j = new JLabel("안녕하세요");
      ImageIcon i = new ImageIcon("C://Users//bitcamp//Pictures/mang.jpg");
      JLabel j1 = new JLabel(i); //사진은 항상 JLable 매개변수로 들어옴
      
      JLabel j2 = new JLabel("월요일이네요",SwingConstants.CENTER);
      
      c.add(j);
      c.add(j1);
      c.add(j2);     
      
   }
   
   public static void main(String[] args) {   
      new Test1();
   }
}
```

<img src="/02. JAVA/00. img/16-11.png" width="500">

### main()함수 안에 JFrame 생성, 체크박스·라디오버튼 이벤트

```java
import java.awt.Checkbox;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

class Check implements ItemListener{
	JRadioButton b1, b2, b3;
	Check(JRadioButton b1,JRadioButton b2,JRadioButton b3){
		this.b1 = b1; this.b2 = b2; this.b3 = b3;
	}
	
	@Override
	public void itemStateChanged(ItemEvent e){ //ItemEvent = 체크박스
		if(e.getStateChange() == ItemEvent.SELECTED){
			//체크박스 선택 시 라디오버튼 비활성화 해제
			b1.setEnabled(true);
			b2.setEnabled(true);
			b3.setEnabled(true);
		}else { //체크박스 미선택 시
			b1.setEnabled(false);
			b2.setEnabled(false);
			b3.setEnabled(false);
		}
	}
}

public class Test1 {
	public static void main(String[] args) {
		JFrame j = new JFrame();
		j.setLayout(new GridLayout(0, 1));

		JCheckBox jc = new JCheckBox("공부선택");

		JRadioButton b1 = new JRadioButton("java");
		JRadioButton b2 = new JRadioButton("python");
		JRadioButton b3 = new JRadioButton("c++");

		// 라디오버튼이기때문에 하나만 선택가능
		ButtonGroup g1 = new ButtonGroup();
		g1.add(b1); g1.add(b2); g1.add(b3);
		// JFrame에 부착
		j.add(jc);
		j.add(b1); j.add(b2); j.add(b3);
		// 라디오버튼 비활성화(체크박스를 선택해야 활성화하게끔
		b1.setEnabled(false);
		b2.setEnabled(false);
		b3.setEnabled(false);
		//jc를 누르면(addItemListener) 라디오버튼 활성화
		jc.addItemListener(new Check(b1,b2,b3));
		
		j.setVisible(true);
		
		//라디오버튼 선택 이벤트 작성
		b1.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED){
					System.out.println("자바!");
				}	
			}
		});
		b2.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED){
					System.out.println("파이썬!");
				}	
			}
		});
		b3.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED){
					System.out.println("c++!");
				}	
			}
		});

	}
}
```

<img src="/02. JAVA/00. img/16-12.png" width="500">

### 텍스트필드 생성 및 입력

```java
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Test1 extends JFrame{
	JTextField j = new JTextField(20);
	JTextArea j1 = new JTextArea(10,20);
	
	Test1() {
		Container c = getContentPane();
		setVisible(true);
		c.setLayout(new FlowLayout());
		
		JLabel jl = new JLabel("enter키 입력");
		c.add(j);
		c.add(jl);
		c.add(new JScrollPane(j1));
		
		j.addActionListener(new ActionListener() { //enter키 입력 시 이벤트 처리
			@Override
			public void actionPerformed(ActionEvent e) {
				JTextField jt = (JTextField)e.getSource();
				j1.append(jt.getText()); //text필드에 입력한 문자를 textarea에 삽입
				jt.setText(" "); // 공백으로 초기화
			}
		});
		
	}
	
	public static void main(String[] args) {
		new Test1();
	}
}
```

<img src="/02. JAVA/00. img/16-13.png" width="500">

### **다이얼로그**

```java
package kr.co.bit;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Test extends JFrame{
	Test(){
		Container c = getContentPane();
		setVisible(true);
		c.add(new Dia(),BorderLayout.NORTH);		
	}
	class Dia extends Panel{
		JButton j = new JButton("이름 입력");
		JTextField j1 = new JTextField(10);
		JButton j2 = new JButton("확인");
		JButton j3 = new JButton("메세지");
		
		Dia(){
			setBackground(Color.pink);
			add(j);
			add(j1);
			add(j2);
			add(j3);
			
			j.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String name = JOptionPane.showInputDialog("이름 입력");
					if(name != null) {
						j1.setText(name);
					}
					
				}
			});
			j2.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					int r = JOptionPane.showConfirmDialog(null, "계속?",
									"확인", JOptionPane.YES_NO_OPTION);
					if(r==JOptionPane.CLOSED_OPTION) { //창을 그냥 닫을 경우
						j1.setText("선택안함");
					}else if(r==JOptionPane.YES_OPTION) {
						System.out.println("네");
					}else {
						System.out.println("아니오");
					}
					
				}
			});
			j3.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, "경고","메세지",
											JOptionPane.WARNING_MESSAGE);
					
				}
			});
			
		}
		
	}
	public static void main(String[] args) {
		new Test();	
	}
}
```

- j 이벤트: 입력창 생성
    
    <img src="/02. JAVA/00. img/16-14.png" width="500">
    
- j1 이벤트: 확인창 생성
    
    <img src="/02. JAVA/00. img/16-15.png" width="500">
    
- j3 이벤트: 경고창 생성
    
    <img src="/02. JAVA/00. img/16-16.png" width="500">
    

### **객체배열 버튼**

```java
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Test{
	public static void main(String[] args) {
		Color c[] = {Color.RED, Color.orange, Color.yellow, Color.green, Color.blue};
		JFrame j = new JFrame();
		j.setLayout(new GridLayout(1,5));
		
		JButton [] buttons = new JButton[5]; //객체배열
		
		for(int i=0; i<buttons.length;i++) {
			buttons[i] = new JButton(String.valueOf(i));
			buttons[i].setBackground(c[i]);
			j.add(buttons[i]);
		}
		j.setVisible(true);
	}
}
```

<img src="/02. JAVA/00. img/16-17.png" width="500">

### **스레드와 awt 연결**

```java
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class Th extends Thread{
	JLabel j;
	
	Th(JLabel j){
		this.j = j;
	}
	@Override
	public void run() {
		int n=0;
		while(true) {
			j.setText(Integer.toString(n)); //문자열밖에 못오니까 n을 문자열로 변경
			n++;
			try {
				sleep(1000);
			}catch(Exception e) {
				return;
			}
		}
	}
	
}

public class Test extends JFrame{
	Test(){
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		JLabel j = new JLabel();
		c.add(j);
		
		Th t = new Th(j); //스레드 객체 생성
		t.start(); //스레드 실행
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Test();
	}
}
```

<img src="/02. JAVA/00. img/16-18.png" width="500">

### 다이얼로그창 생성

```java
package kr.co.bit;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Test extends JFrame{
	JButton j = new JButton("Cal");
	JLabel j1 = new JLabel("계산 결과");
	
	Test(){
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(j);
		c.add(j1);
		
		setVisible(true);
		
		//cal 버튼 눌렀을 때 이벤트
		j.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Aa a = new Aa(); //JDialog
				a.setVisible(true);
			}
		});
	}
	
	class Aa extends JDialog{ // j버튼(cal)선택 시 생성되는 또다른 창 JDialog
		JTextField f1=new JTextField(15);
		JTextField f2=new JTextField(15);
		
		JButton j2 = new JButton("ADD");
		
		Aa(){
			setLayout(new FlowLayout());
			add(new JLabel("두 수를 더합니다"));
			add(f1);
			add(f2);
			add(j2);
			
			j2.addActionListener(new ActionListener() {	
				@Override
				public void actionPerformed(ActionEvent e) {
					setVisible(false); //다이얼로그창 종료됨
					int sum = Integer.parseInt(f1.getText())+ //텍스트창에 들어가면 문자열이라 정수로 변경
							Integer.parseInt(f2.getText());   //.getText()
					j1.setText(Integer.toString(sum)); //기존 창에서 계산결과가 뜸
				}
			});
		}
	}
	
	public static void main(String[] args) {
		new Test();
	}
}
```

<img src="/02. JAVA/00. img/16-19.png" width="500">

<img src="/02. JAVA/00. img/16-20.png" width="500">

### select box + img

```java
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Test extends JFrame{
	String s[] = {"짱구","망곰이"};
	
	ImageIcon [] im = {new ImageIcon("C:/Users/bitcamp/Pictures/짱구.jpg"),
			new ImageIcon("C:/Users/bitcamp/Pictures/mang.jpg")};
	
	JLabel j = new JLabel(im[0]);
	
	Test(){
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		setVisible(true);
		
		JComboBox com = new JComboBox(s);
		c.add(j);
		c.add(com);
		
		com.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox c = (JComboBox)e.getSource(); //Object 강제 형변환
				int i = c.getSelectedIndex(); //콤보박스의 선택된 아이템 인덱스 알아내기
				j.setIcon(im[i]);
			}
		});
	}
	
	public static void main(String[] args) {
		new Test();
	}
```

<img src="/02. JAVA/00. img/16-21.png" width="500">

### 계산하는 버튼 생성

```java
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Test extends JFrame{
	public static void main(String[] args) {
		JFrame j = new JFrame();
		j.setLayout(new FlowLayout());
		
		int n = (int)(Math.random()*50)+1;
		JLabel num = new JLabel(String.valueOf(n)); 
		//Lable은 문자열이라 정수 → 문자열(Integer.toString 가능)
		j.add(num);
		j.setVisible(true);
		
		JButton plus = new JButton("+5");
		JButton minus = new JButton("-5");
		
		plus.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				plus.setEnabled(false); //한번 누르면 비활성화
				int n = Integer.valueOf(num.getText()); 
				//JLable에서 문자열로 바꿨어서 다시 정수로 변환(언박싱)
				num.setText(Integer.toString(n+5)); //다시 정수를 문자로 변경해서 띄움
			}
		});
		minus.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				minus.setEnabled(false); //한번 누르면 비활성화
				int n = Integer.valueOf(num.getText());
				num.setText(Integer.toString(n-5));
			}
		});
		j.add(plus);
		j.add(minus);
	}
}
```

<img src="/02. JAVA/00. img/16-22.png" width="500">

### 3/22 JTable 작성

- javafx ui layout을 통해 테이블 형식 만들 수 있음(ui는 아직 중요한게 아님)

```java
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Test extends JFrame{
	private JTable jTable;
	
	Test(){
		this.getContentPane().add(new JScrollPane(gt()), BorderLayout.CENTER);
		setVisible(true);		
	}
	public JTable gt() {
		if(jTable == null) {
			String[] str = {"아이디","이름"};
			Object[][] ob = {{"11","aa"},{"22","bb"},{"33","cc"}};			
			
			jTable = new JTable(ob, str);
			jTable.getColumn("아이디").setPreferredWidth(100);
			jTable.getColumn("이름").setPreferredWidth(50);
			
		}
		
		
		return jTable;
	}
	public static void main(String[] args) {
		new Test();		
	}
}
```

<img src="/02. JAVA/00. img/16-23.png" width="500">