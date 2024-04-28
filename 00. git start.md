# 데브옵스 10기 과정 정리
- 2월 20 ~ 4월 27일까지 약 2달간의 과정을 진행하며 노션으로 정리한 내용을 깃허브로 이동

## 어려움1. 깃허브가 익숙하지 않아 연동 과정에 문제 발생! 
- vscode의 소스 컨트롤에서 파일을 직접 fetch하여 가져옴

### git bash 정리

#### git 용어
##### 구성요소
- 워크스페이스(workspace): 작업폴더
- 인덱스(index): git의 장바구니(add 추가, unstage 삭제)
- 로컬 리포지토리(local repository): 로컬 저장소 (git init으로 작업폴더 내부에 저장되는 .git폴더)
- 원격 리포지토리(remote repository): 원격 저장소 (github의 리포지토리 주소. .git으로 끝남)

##### 명령어
- 추가(add): 작업폴더에 있는 파일을 인덱스에 저장
- 언스테이지(unstage): git의 인덱스에 담겨 있는 파일 제거
- 커밋(commit): git의 인덱스에 담겨있는 파일을 로컬 리포지토리에 저장
- 체크아웃(checkout): git의 커밋된 타임라인과 해당 내용으로 돌아감

#### 1. 로컬 폴더와 git repository 연결
> git remote add origin 깃허브주소
- 레파지토리 url 복사

> git remote -v
- 현재 이 폴더가 어떤 원격 저장소에 있는지 확인

#### 2. git repository를 로컬 폴더로 가져오기
> git clone 원격저장소url
- 새 폴더로 불러옴

> git clone 원격저장소url .
- 원격저장소의 내용들이 현재 폴더에 들어옴

#### 3. 원격 저장소(깃허브)에 업데이트 된 내용 → 내 로컬폴더 반영
> git pull origin main(또는 브랜치명)
- 로컬에서 변경사항을 add하거나 commit한 경우 충돌이 발생할 수 있으니 주의!

#### 4. 로컬 변경내역 원격 저장소에 반영
> git add 파일명
- 지금까지의 변경 내용을 다음 버전(커밋)에 반영
- add뒤에 . 을 붙이면 변경사항 모두 반영, 특정 파일(a.txt) 지정 가능

> git commit -m "커밋내용"
- 지금까지 add한 내용을 하나의 버전으로 묶음

> git push origin 브랜치명
- 월격 저장소에 올림

#### 5. 커밋 내용 삭제 및 이동
> git reset
- git의 인덱스에 있는 모든 파일 제거(unstage)

> git checkout "로그명 또는 브랜치명"
- 해당 로그명이 커밋된 파일 버전으로 돌아감
- 가장 최근에 커밋된 해당 브랜치명의 최신 버전으로돌아감

> git reset --soft "로그명"
- 해당 로그 파일 버전으로 돌아감. 이후 커밋 이력과 인덱스는 남아있음

> git reset --hard "로그명"
- 해당 파일 버전으로 돌아감. 이후 커밋 이력과 인덱스 전부 삭제!

#### 6. 상태관리
> git log
- 지금까지의 commit 이력 확인

> git status
- 마지막 버전과 현재 버전의 차이 확인
