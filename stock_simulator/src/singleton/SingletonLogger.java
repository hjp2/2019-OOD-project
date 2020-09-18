package singleton;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;


import java.util.logging.SimpleFormatter;

/**
 *
 * @author 김현준
 * 내용 : 로깅에 관한 내용 정리겸 실습 소스
 * 정리 :
 * 로깅의 강점은 언제 어떻게 실행되는지 파일로 자장시켜 주고
 * 이를 통해 디버깅이 쉬워진다는 것이다
 * 또 하나의 큰 장점은 로깅은 자신이 이제 콘솔창이나 로그파일에 저장할 필요가 없다면
 * logger.setLevel(Level.OFF); 이 문장 하나만으로 
 * 더 이상 실행시키지 않을 수 있다는 장점이다.
 */
public class SingletonLogger {
    
    
    public static final Logger logger = Logger.getLogger("로깅 : ");
    private static boolean use = true;
    private static SingletonLogger singletonClass;
    
    
    /**
     * SingletonLogger 의 생성자이다
     * 로그를 초기화하는 역할을 한다
     * 단) getInstance() 함수에 의해 한번만 실행될 수 있다.
     */
    private SingletonLogger(){
        use = false;
        
        try {
            initializeWithFile();
        } catch (IOException ex) {
            Logger.getLogger(SingletonLogger.class.getName()).log(Level.SEVERE, null, ex);
        }

        initializeWithConsole();
    }
    
    /**
     * 싱글턴 패턴의 핵심인 getInstance 이다
     * 동기화 문제를 다루고 클래스 객체를 한번 생성했다면 다시 생성하지 않는다.
     * @return SingletonLogger singletonClass
     */
    public static synchronized SingletonLogger getInstance(){
        if(isUse())
            singletonClass = new SingletonLogger();
        logger.setLevel(Level.FINE);
        return singletonClass;
    }
    
    /**
     * 내용 : 이 함수는 파일 핸들러를 초기화 하는 함수이다
     * 이 함수를 통해 파일 핸들러를 입맛에 맞게 초기화 할 수 있다.
     * @throws 입출력 예외
     */
    private static void initializeWithFile() throws IOException{ // 파일 핸들러 초기화
        // FileHandler(String pattern, boolean append) --> 프로그램 로그 파일에 덫붙일 것인가 or 삭제하고 다시 쓸 것인가.  /  true -> 덫붙임,  false -> 삭제 후 작성
        Handler fh = new FileHandler("study_test.log",true); 
        SimpleFormatter sf = new SimpleFormatter();
        fh.setFormatter(sf); // --> 파일 핸들러에서 사용할 심플 포메터 객체를 생성한 다음 파일 핸들러의 setFommatter 메소드로 설정
        // 위 구문은 파일 핸들러의 저장 디폴트값이 xml 이기 때문에 편하게 보기 위해 심플 포매터로 설정하는 것이다. 
        // 위 구문이 없다면 파일 핸들러의 디폴트값인 xml 로 저장이 된다.
        
        fh.setLevel(Level.FINE); // FINE 수준 이상의 로그 메세지를 출력한다. finer 와 finest 수준은 무시한다.
        logger.addHandler(fh); // 에드 핸들러를 통해 로그에 추가시켜준다.
    }
    
    /**
     * 내용 : 이 함수는 ConsoleHandler에 대해
     * 초기화 하는 함수이다
     * 이 함수를 통해 콘솔 핸들러를 입맛에 맞게 초기화 할 수 있다.
     */
    private static void initializeWithConsole(){
        
        logger.setUseParentHandlers(false);
        /* false를 하는 이유 : 이전에 사용하고 있는 시스템핸들러 사용 막기
        기본적으로 자바에서 jre/lib 에  logging.properties 라는 로깅에 관련된 환경설정 파일이 있다. 
        한번 봐봐라 여기서 여러 환경 설정을 건들 수 있다. (파일 핸들러와 콘솔 핸들러 등)
        기본적으로 핸들러는 콘솔 핸들러가 사용된다. 이 핸들러의 기본적인 레벨은 INFO 따라서 특별한 환경설정을 하지 않으면 
        현재 시스템에서 환경 설정한 INFO 수준 까지만 출력된다.
        콘솔창으로는 읽기 쉬운 형태 / 파일로는 xml 형태로 출력되는게 default 값 */
        
        Handler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.FINE);
        
        logger.addHandler(consoleHandler);
    }
    
    /**
     * 생성자를 한번 불렀는지 체크하는 use 변수 return를 한다
     * is변수() 이 포멧이 불리언변수를 리턴하는 하나의 포멧이라고 기억하자.
     * @return use 
     */
    private static boolean isUse(){
        return use;
    }
    
}
