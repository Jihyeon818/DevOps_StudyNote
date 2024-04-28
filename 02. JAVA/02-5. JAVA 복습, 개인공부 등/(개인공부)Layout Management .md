# (개인공부)Layout Management

[GUI 정리 내용 참고](https://dahye-jeong.gitbook.io/java/java/undefined/gui)

## AWT(Abstrack Windowing Toolkit)

- AWT의 컴포넌트들은 OS의 도움을 받아 화면 출력
- 예) Frame, Panel, Dialog, Button, Label

## Swing

- AWT기술을 기반으로 작성된 라이브러리
- 예) Jframe, Jpanel, JButton, JLabel

## Swing 프로그램 만드는 과정

### 1. 프레임 만들기 (2가지 방법)

- JFrame 객체를 직접 생산 : JFrame jframe = new JFrame();
- JFrame 클래스 상속 : public class MyClass extends JFrame{]

### 2. 프레임에 스윙 컴포넌트 붙이기

- 프레임: 응용프로그램을 구성하는 틀, 컴포넌트를 추가하는 방식

## 대표적인 레이아웃 5가지

- FlowLayout : 컴포넌트가 순서대로 왼쪽 → 오른쪽 배치
- BorderLayout : 공간을 동서남북 중앙으로 나누고 배치
- GridLayout : 응용프로그램에서 설정한 동일 크기의 2차원 그리드로 나눔
- CardLayout : 컴포넌트를 쌓아서 배치
- AbsoluteLayout : 임의로 위치 지정

## **Container**

자바에서 Container는 창의 역할을 한다.

- 한 개 이상의 Container 위에 **Component들이 올려질 영역**
- Container는 실제로는 Component보다 작은 개념
- (예) Frame, Window, Panel, Dialog, Applet
- (예) JFrame, JDialog, JApplet, JPanel, JScrollPane
    
    
    | 컨테이너 | 디폴트 배치관리자 |
    | --- | --- |
    | Window, JWindow | BorderLayout |
    | Frame, JFrame | BorderLayout |
    | Dialog, JDialog | BorderLayout |
    | Panel, Jpanel | FlowLayout |
    | Applet, JApplet | FlowLayout |

## JLabel

- GUI상에서 직접 수정이 불가능한 텍스트를 설정하기 위해 사용하는 컴포넌트
- 텍스트 또는 이미지 추가(동시도 가능)
    - JLabel() : 기본 생성자
    - JLabel(String) : Label의 텍스트 추가
    - JLabel(Icon) : 아이콘 객체 추가(Imagelcon 클래스 등)
- JLabel 주요 사용 메소드
    - setText(String)
    - getText()
    - setIcon(Icon)
    - setHorizontalAlignment(int)

## JButton

- JButton 주요 사용 메소드
    - setText()
    - getText()
    - addActionListener() : 이벤트 추가
    

## JTextArea

- JTextArea 주요 사용 메소드
    - setText()
    - append()

## JTextField

- 로그인 화면의 id,pw 입력 받는 컴포넌트 등
- JTextField 주요 사용 메소드
    - setText()
    - getText()

## JCheckBox: 그룹 안 묶음

## JRadioButton: 그룹으로 묶음(ButtonGroup)