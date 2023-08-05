package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class))
// 컴포넌트 스캔은 @Component 어노테이션이 붙은 클래스를 스캔해서 스프링 빈으로 등록한다.
// 이 때 스프링 빈의 기본 이름은 클래스명을 사용하되 맨 앞글자만 소문자를 사용한다.
// AppConfig 클래스와 TestConfig 클래스 등 @Configuration 어노테이션이 붙은 설정 정보 클래스도 자동으로 등록되기 때문에 컴포넌트 스캔 대상에서 제외한다.
// (@Configuration 어노테이션 소스코드를 열어보면 @Component 어노테이션이 붙어있기 때문이다.)
public class AutoAppConfig {
}