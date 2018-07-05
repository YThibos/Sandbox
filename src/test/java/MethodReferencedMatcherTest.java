import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Test;

import static org.junit.Assert.assertThat;

public class MethodReferencedMatcherTest {

    @Test
    public void simpleStringMatcher() {
        String me = new String("Thibos");
        assertThat(me, isThibos("Thibos"));
    }

    @Test
    public void stupidObjectMatcher() {

    }

    private Matcher<ReturnsAString> isTheSame(final ReturnsAString object) {
        return new BaseMatcher<ReturnsAString>() {
            ReturnsAString test;

            public boolean matches(Object item) {
                if (item instanceof ReturnsAString) {
                    test = (ReturnsAString) item;
                } else {
                    return false;
                }
                return test.apply().equals(((ReturnsAString) item).apply());
            }

            public void describeTo(Description description) {

            }
        };
    }

    private Matcher<String> isThibos(final String string) {
        return new BaseMatcher<String>() {
            public boolean matches(Object item) {
                final String tested = new String(string);
                return "Thibos".equals(tested);
            }

            public void describeTo(Description description) {
                description.appendText(" should equal \"Thibos\"");
            }
        };
    }

    class StupidObject implements Comparable<StupidObject> {
        public String aString;

        public StupidObject(String aString) {
            this.aString = aString;
        }

        public int compareTo(StupidObject o) {
            return this.aString.compareTo(o.aString);
        }
    }

    @FunctionalInterface
    public interface ReturnsAString {
        String apply();
    }

}
