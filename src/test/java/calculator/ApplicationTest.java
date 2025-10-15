package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SuppressWarnings("NonAsciiCharacters")
class ApplicationTest extends NsTest {
    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 커스텀_구분자와_기본_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1,2:3;4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void 커스텀_구분자_이스케이프_사용(){
        assertSimpleTest(() -> {
            run("//\\\\n1,2\\3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_일반_문장_사용(){
        assertSimpleTest(() -> {
            run("//a.bc\\n1a.bc2a.bc3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_닷_사용(){
        assertSimpleTest(() -> {
            run("//.\\n1.2.3.4.5");
            assertThat(output()).contains("결과 : 15");
        });
    }

    @Test
    void 기본_구분자_사용() {
        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 빈_문자열_입력() {
        assertSimpleTest(() -> {
            run("");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 구분자만_존재() {
        assertSimpleTest(() -> {
            run(",,,,,,,,,,,,,");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 구분자_사이_숫자_존재() {
        assertSimpleTest(() -> {
            run(",,,,,,2,,,,,,,");
            assertThat(output()).contains("결과 : 2");
        });
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 잘못된_숫자표현_테스트(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,.,2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 소수점_테스트() {
        assertSimpleTest(() -> {
            run("1.5,2.5");
            assertThat(output()).contains("결과 : 4.0");
        });
    }

    @Test
    void 소수점_자리_테스트() {
        assertSimpleTest(() -> {
            run("1.5,2.50");
            assertThat(output()).contains("결과 : 4.0");
        });
    }

    @Test
    void 음의_소수_테스트(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1.5,2.5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 여러자리_숫자_테스트() {
        assertSimpleTest(() -> {
            run("10,20:30");
            assertThat(output()).contains("결과 : 60");
        });
    }

    @Test
    void 연속된_커스텀_구분자_테스트() {
        assertSimpleTest(() -> {
            run("//;\\n1;;2;;;3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 여러문자_커스텀구분자_기본구분자_혼합() {
        assertSimpleTest(() -> {
            run("//***\\n1***2,3:4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void 특수문자_커스텀구분자_테스트() {
        assertSimpleTest(() -> {
            run("//$^&\\n1$^&2$^&3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 숫자와_공백_혼합_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" 1 , 2 : 3 "))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 큰_숫자_테스트() {
        assertSimpleTest(() -> {
            run("1000000000,2000000000");
            assertThat(output()).contains("결과 : 3000000000");
        });
    }

    @Test
    void 소수점_여러자리_테스트() {
        assertSimpleTest(() -> {
            run("1.123,2.877");
            assertThat(output()).contains("결과 : 4.0");
        });
    }

    @Test
    void 공백_커스텀구분자_형식_테스트() {
        assertSimpleTest(() -> {
            run("//\\n112");
            assertThat(output()).contains("결과 : 4");
        });
    }

    @Test
    void 숫자_커스텀_구분자_테스트() {
        assertSimpleTest(() -> {
            run("//1\\n112");
            assertThat(output()).contains("결과 : 2");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
