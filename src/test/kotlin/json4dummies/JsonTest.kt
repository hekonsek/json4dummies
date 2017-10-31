package json4dummies;

import json4dummies.Json.Companion.fromJson
import json4dummies.Json.Companion.toJson
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class JsonTest {

    val map = mapOf("foo" to "bar")

    @Test
    fun shouldConvertMapToJson() {
        // When
        val json = toJson(map)

        // Then
        val parsedMap = fromJson(json)
        assertThat(parsedMap).isEqualTo(map)
    }

    @Test
    fun shouldConvertMapToBytesToJson() {
        val json = Json.toJsonBytes(map)
        val parsedMap = Json.fromJson(json)
        assertThat(parsedMap).isEqualTo(map)
    }

    @Test
    fun shouldReadBytes() {
        val json = toJson(map)
        val parsedMap = fromJson(json.toByteArray())
        assertThat(parsedMap).isEqualTo(map);
    }

    @Test
    fun shouldIncludeNullFields() {
        val json = toJson(Person(null, null))
        assertThat(json).contains("\"name\":null")
        assertThat(json).contains("\"surname\":null")
    }

}
