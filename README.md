# JAVA GUI IDE Project
Java Text IDE Project의 기능을 베이스로 한 Java GUI IDE 프로젝트입니다.

**경기대학교 컴퓨터과학과 자바프로그래밍2 TermProject - 2 과제이며, 본 프로그램에 대한 피드백은 언제나 환영합니다.**


##이번 GUI 프로젝트에서 생긴 새로운 기능

**Editor가 추가되었습니다.**
> IDE를 통해서 소스코드를 불러오고, 작성된 소스코드를 사본 파일로 저장할 수 있습니다. *저장되는 경로는 C:\Temp*



### 사용법

**1. Java File Upload**
컴파일 하고자하는 Java 파일의 경로명 + 파일명을 입력합니다. 파일의 위치에 대한 제한은 없습니다.

**2. Compile**
업로드한 파일을 컴파일합니다.

**3. Run**
컴파일한 파일을 실행하여 실행합니다. 만약 업로드된 파일이 없거나, 컴파일 오류가 발생 시, 이 기능은 작동하지 않습니다.

**4. Reset**
업로드한 파일을 초기화, 컴파일 오류시 생겼던 출력용 임시파일을
제거합니다. __다른 파일을 업로드할 시, Reset 기능으로 꼭 초기화해주세요.__

**5.Compile Error List**
컴파일 오류 발생 시 출력되는 에러 내용을 출력합니다. 컴파일이 성공했을 때 아무 것도 출력되지 않습니다.

**6. End**
IDE 프로그램을 종료하며, 동시에 출력용 임시파일을 제거합니다.

**7. Save**
Editor로 작성한 소스코드를 저장합니다. 저장경로는 *C:\Temp 입니다.*
