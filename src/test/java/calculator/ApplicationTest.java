package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
    void 소숫점_테스트() {
        assertSimpleTest(() -> {
            run("1.5,2.5");
            assertThat(output()).contains("결과 : 4.0");
        });
    }

    @Test
    void 소숫점_자리_테스트() {
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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
