package json4dummies;

import com.google.common.collect.ImmutableMap;
import org.junit.Test;

import java.util.Map;

import static json4dummies.Json.fromJson;
import static json4dummies.Json.toJson;
import static json4dummies.Json.toJsonBytes;
import static org.assertj.core.api.Assertions.assertThat;

public class JsonTest {

    Map map = ImmutableMap.of("foo", "bar");

    @Test
    public void shouldConvertMap() {
        String json = toJson(map);
        Map<String, Object> parsedMap = fromJson(json);
        assertThat(parsedMap).isEqualTo(map);
    }

    @Test
    public void shouldConvertMapToBytes() {
        byte[] json = toJsonBytes(map);
        Map<String, Object> parsedMap = fromJson(json);
        assertThat(parsedMap).isEqualTo(map);
    }

    @Test
    public void shouldReadBytes() {
        String json = toJson(map);
        Map<String, Object> parsedMap = fromJson(json.getBytes());
        assertThat(parsedMap).isEqualTo(map);
    }

    @Test
    public void shouldIncludeNullFields() {
        String json = toJson(new Person(null, null));
        assertThat(json).contains("\"name\":null");
        assertThat(json).contains("\"surname\":null");
    }

}
