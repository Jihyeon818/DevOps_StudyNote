# git

## git bash 다운

- [https://git-scm.com/downloads](https://git-scm.com/)
- [https://velog.io/@selenium/Git-Git-Bash-설치-Windows-OS](https://velog.io/@selenium/Git-Git-Bash-%EC%84%A4%EC%B9%98-Windows-OS)

<img src="/02. JAVA/00. img/17-1.png" width="500">

<img src="/02. JAVA/00. img/17-2.png" width="500">

## 소스트리

- [https://www.sourcetreeapp.com/](https://www.sourcetreeapp.com/)
- 건너뛰고 다 next 다

<img src="/02. JAVA/00. img/17-3.png" width="500">


## VSCode에서 깃 연결

- 깃 연결할 폴더 만들기
    
    <img src="/02. JAVA/00. img/17-4.png" width="500">
    
- vscode에서 해당 폴더 open
    
    <img src="/02. JAVA/00. img/17-5.png" width="500">
    
- 터미널 열기
    
    <img src="/02. JAVA/00. img/17-6.png" width="500">
    
- 깃 연결 : git init(해당 폴더를 관리할 것 이다)
    
    <img src="/02. JAVA/00. img/17-7.png" width="500">
    
- 파일 생성 후 상태 확인
    
    <img src="/02. JAVA/00. img/17-8.png" width="500">
    
- 폴더에 있는 모든 파일을 깃에 올림(git add . ) .이 모든임
    
    <img src="/02. JAVA/00. img/17-9.png" width="500">
    

- 소스트리에서 올라간 파일 확인
    
    <img src="/02. JAVA/00. img/17-10.png" width="500">
    
- 커밋

<img src="/02. JAVA/00. img/17-11.png" width="500">

- 파일 변경 후 커밋
- 새로 생성한 파일이 있는 경우
    - git add . : 파일 모두 추가
    - git commit -m “” : 커밋 메세지 작성 후 커밋
- 새로 추가된파일이 없을 경우 untracked
    - git commit -am “” : add 후 message까지 작성
    
    <img src="/02. JAVA/00. img/17-12.png" width="500">
    
- 커밋 되돌리기 : reset, revert
    - reset: 되돌린 내역 존재하지 않음
    - revert: 되돌린 내역이 존재하지 않