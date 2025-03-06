package hello.core.singleton;

/*
Eager Initialization 방식이다.
이는 메모리 낭비를 유발 할 수 있다. 왜냐하면 메인 메서드에서 SingletonService 클래스를 호출 할 일이 없어도
객체는 생성되어 있기 때문이다. 보완하기 위한 방식이 lazy Initialization 방식
 */
public class SingletonService {
    private static final SingletonService instance = new SingletonService();
    // 접근 제한자 private : 외부에서 사용하지 못하도록 막는다. 지금 클래스에서만 이용한다는것.
    // 사용하고 싶다면 getter(접근 제한자는 publice)를 만들어서 메서드를 이용한다.
    // static : 프로그램이 실행하자마자 생성시킨다. static 영역에 존재하고, 프로그램이 종료되면 사라진다.
    // final : 상수임을 의미한다. 다른곳에서 변경시키지 못하도록 한다.

    // 위에 내가 작성한 주석에서 틀린점
    // static은 프로그램이 실행하자마자가 아니라 클래스가 로딩 될 때 한번만 메모리만 사용한다.
    // final은 상수도 맞는 말이지만 객체의 참조값을 변경하지 못하도록 한다. 단 객체 내부의 필드값들은 변경 가능하다.


    //static 필드의 instance를 반환하기 위해 getInstance()도 static이어야 함.
    public static SingletonService getInstance(){
        return instance;
    }

    private SingletonService(){
    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }
}
