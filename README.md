## 자바지기 박재성님 TDD강의
> 다음 달에 [코드스쿼드 TDD, 리팩토링 강의](http://codesquad.kr/page/specialTdd.html)를 수강하기 전에 유투브에서 자바지기님의 사다리게임을 구현하는 TDD 강좌가 있어서 정주행 하게 되었다.


### 사다리 게임 강좌 목록
##### 0. 요구사항 분석
- <a href="https://www.youtube.com/watch?v=1nL9S34qCtA" target="_blank">요구사항 분석

##### 1. 일단 사다리 게임 구현해 보기
- <a href="https://www.youtube.com/watch?v=naZzd1XBNLw" target="_blank">step1-1</a>
- <a href="https://www.youtube.com/watch?v=0rJynxa_DWk" target="_blank">step1-2</a>
- <a href="https://www.youtube.com/watch?v=vtB4gsZzLs8" target="_blank">step1-3</a>

##### 2. 사다리게임 구현
- <a href="https://www.youtube.com/watch?v=ByuSPCyfp-c" target="_blank">step2-1</a> 사다리 좌우 이동 기능 구현
- <a href="https://www.youtube.com/watch?v=5gklOOLUkxA" target="_blank">step2-2</a> 사다리 여러행 추가, 2차원 배열로 바꿈
- <a href="https://www.youtube.com/watch?v=z3OAEFSlzsM" target="_blank">step2-3</a> 리팩토링 (Row클래스 추출, if문 조건확인 로직 메소드 추출)

##### 3. 리팩토링
- <a href="https://www.youtube.com/watch?v=i20kNIDzV6g" target="_blank">step3-1</a> Ladder Test를 RowTest로 이동 / Row의 moveRow -> move로 rename /moveRow() 메서드 리팩토링 부분을 찾아보기
- <a href="https://www.youtube.com/watch?v=xRh4oTJpTFU" target="_blank">step3-2</a> isLeftDirection메서드명 isRightDirection rename / -1, 0, 1 상수값을 enum 타입으로 정의
- <a href="https://www.youtube.com/watch?v=IPhG75TmGiA" target="_blank">step3-3</a> Ladder, Row 클래스, 필드, 메소드 접근제어자 처리
- <a href="https://www.youtube.com/watch?v=ULVkcOnimQk" target="_blank">step3-4</a> Ladder,Row 클래스 예외처리 (생성자 drawLine메서드)

##### 4. 객체 추출 리팩토링
- <a href="https://www.youtube.com/watch?v=llmCtOZkIKg" target="_blank">step4-1</a> NaturalNumber 클래스 추가, Ladder, Row클래스에서 사용하던 int형 값들을 NaturalNumber객체 값으로 리팩토링
- <a href="https://www.youtube.com/watch?v=BiVqCJwb1Tc" target="_blank">step4-2</a> 좌우 이동 기능을 하는 Marker 클래스 추가(단일 책임) Ladder클래스 run메소드, Row클래스 move메소드에서 Marker 사용하도록 리팩토링
- <a href="https://www.youtube.com/watch?v=9n3tVzh31rk" target="_blank">step4-3</a> 현재 위치의 상태를 나타내는 Node 클래스 추가 Row내 Direction Enum클래스 제거
- <a href="https://www.youtube.com/watch?v=wmEz6QdeMbA" target="_blank">step4-4</a> 리팩토링 패키지, 접근제어자 정리, 소스 가독성을 위한 메소드 추출 작업

##### 5. 디버깅 로그메시지 출력기능
- <a href="https://www.youtube.com/watch?v=jTD8gjuKJG4" target="_blank">step5-1</a> 디버깅 로그 메시지 출력 기능(StringBuilder 사용)
- <a href="https://www.youtube.com/watch?v=T6-LOoGKgDE" target="_blank">step5-2</a> 디버깅 로그메시지 출력기능 리팩토링, 이중for문 제거, if else문 enum처리
- <a href="https://www.youtube.com/watch?v=0hn71C22UBI" target="_blank">step5-3</a> 디버깅 로그메시지 출력기능 리팩토링, height, persons쌍 Position 객체 추출

##### 6. 클래스 분리 및 선 Random 생성
- <a href="https://www.youtube.com/watch?v=HGcLW5vjXkA" target="_blank">step6-1</a> SOLID원칙 중 단일책임의 원칙 적용. 클래스 분리 Ladder -> LadderGame, LadderRunner, LadderCreator 분리
- <a href="https://www.youtube.com/watch?v=XzzRB_v9psU" target="_blank">step6-2</a> RandomLadderCreator 클래스 생성, Random 생성시 발생하는 요구사항 분석
- <a href="https://www.youtube.com/watch?v=DhATT92zivs" target="_blank">step6-3</a> 총 position 수 구하기, 사다리 크기에 따라 ratio값에 따라 생성되는 선의 수를 결정 사다리 생성시 크기값을 담당하는 객체 추출 int값을 2차원 배열 위치 값으로 변환
- <a href="https://www.youtube.com/watch?v=vQRbvQzGe8o" target="_blank">step6-4</a> LadderSize 클래스 추출
- <a href="https://www.youtube.com/watch?v=MfuQXbC6-U4" target="_blank">step6-5</a> RandomLadderCreator 랜덤값 유효성 검증

##### 7. 인터페이스 추출 및 DI
- <a href="https://www.youtube.com/watch?v=snyOIxmGPpg" target="_blank">step7-1</a> LadderGame에 RandomLadderCreator 붙이기
- <a href="https://www.youtube.com/watch?v=rKcx4T1v4SM" target="_blank">step7-2</a> ManualLadderCreator, RandomLadderCreator -> LadderCreator 인터페이스 분리
- <a href="https://www.youtube.com/watch?v=Ae2VHMefCBU" target="_blank">step7-3</a> LadderCreate 기능을 LadderCreatorFactory에 위임, ladder.creator패키지 생성 및 접근 제어자 수정
- <a href="https://www.youtube.com/watch?v=9rpKwHhikY0" target="_blank">step7-4</a> LadderCreator DI 적용
- <a href="https://www.youtube.com/watch?v=gb-oUxhrjIc" target="_blank">step7-5</a> 상속을 통한 RandomLadderCreator 중복 제거
- <a href="https://www.youtube.com/watch?v=wdj6FHANwmk" target="_blank">step7-6</a> 조합을 통한 RandomLadderCreator 중복 제거

##### 8. Collection을 사용한 리팩토링
- <a href="https://www.youtube.com/watch?v=aeDpzF66Poo" target="_blank">step8-1</a> 리팩토링 RandomNaturalNumber 생성
- <a href="https://www.youtube.com/watch?v=_ddHRLLmdeM" target="_blank">step8-2</a> 리팩토링 RandomLadderCreator Array사용하는 부분 -> Collection의 List로 변경
- <a href="https://www.youtube.com/watch?v=kHyS413ZEEs" target="_blank">step8-3</a> 리팩토링 RandomLadderCreator NaturalNumber isFirst() 구현
- <a href="https://www.youtube.com/watch?v=KyzFFKaTliA" target="_blank">step8-4</a> RandomLadderCreator클래스의 generateRandomPositions() 복잡한 로직을 Collection비교 방법으로 리팩토링

#### 후기
- 일주일간 틈틈이 한강좌씩 따라하다 보니 TDD방식으로 코딩하는게 이런거다하는 몸소 느낄 수 있었다.
- 테스트 클래스가 있다보니 리팩토링 할 때 마음 놓고 수정할 수 있어서 if else문으로 짜여진 복잡도가 높은 로직도 step by step으로 리팩토링이 가능했다. 실패하던 빨간색 테스트 케이스를 실행해서 녹색불이 들어왔을 때 짜릿한 성취감을 느낄 수 있었다.
- 기능단위의 test클래스를 먼저 만들고 기능을 구현하다보니 자연스럽게 SOLID원칙 중에 단일책임의 원칙을 생각하면서 클래스를 만들 수 있게 되었다. 나머지 다른 원칙들도 어떻게 적용되는지 공부가 더 필요하다.
- 사전 과제로 내주신 기본적인 git 사용법을 익히기 위해 source tree나 ide에서 제공하는 git 기능을 사용하지 않고 terminal에서 git명령어를 직접 사용하였다. commit로그도 최대한 상세하게 남겼다. oh-my-zsh을 설치해서 사용하니 터미널에서도 이쁜 commit 로그를 볼 수 있어서 좋았다.
