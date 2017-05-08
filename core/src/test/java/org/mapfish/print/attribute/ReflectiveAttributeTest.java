package org.mapfish.print.attribute;

import com.vividsolutions.jts.util.AssertionFailedException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;
import org.mapfish.print.config.Configuration;
import org.mapfish.print.config.Template;
import org.mapfish.print.wrapper.json.PJsonArray;
import org.mapfish.print.wrapper.json.PJsonObject;

import java.util.List;

public class ReflectiveAttributeTest {
    @Test(expected = AssertionFailedException.class)
    public void testPJsonObjIllegal() throws Exception {
        new TestReflectiveAtt(PJsonObjParamIllegal.class).init();
    }

    @Test(expected = AssertionFailedException.class)
    public void testPJsonArrayIllegal() throws Exception {
        new TestReflectiveAtt(PJsonArrayParamIllegal.class).init();
    }

    @Test(expected = AssertionFailedException.class)
    public void testJsonObjIllegal() throws Exception {
        new TestReflectiveAtt(JsonObjParamIllegal.class).init();
    }

    @Test(expected = AssertionFailedException.class)
    public void testJsonArrayIllegal() throws Exception {
        new TestReflectiveAtt(JsonArrayParamIllegal.class).init();
    }

    @Test(expected = AssertionFailedException.class)
    public void testEmpty() throws Exception {
        new TestReflectiveAtt(Empty.class).init();
    }

    private static class TestReflectiveAtt extends ReflectiveAttribute<Object> {

        private final Class<?> type;

        private TestReflectiveAtt(Class<?> type) {
            this.type = type;
        }

        @Override
        public Class<?> getValueType() {
            return type;
        }

        @Override
        public Object createValue(Template template) {
            return null;
        }

        @Override
        public void validate(List<Throwable> validationErrors, final Configuration configuration) {

        }
    }

    static class PJsonObjParamIllegal {
        public PJsonObject p;
    }

    static class JsonObjParamIllegal {
        public JSONObject p;
    }

    static class PJsonArrayParamIllegal {
        public PJsonArray p;
    }

    static class JsonArrayParamIllegal {
        public JSONArray p;
    }
    static class Empty {
    }
}
