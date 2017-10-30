package json4dummies

import com.fasterxml.jackson.databind.ObjectMapper

class Json {

    companion object {

        private val mapper = ObjectMapper()

        // To JSON operations

        @JvmStatic
        fun toJson(obj: Any): String {
            return mapper.writeValueAsString(obj)
        }

        @JvmStatic
        fun toJsonBytes(obj: Any): ByteArray {
            return mapper.writeValueAsBytes(obj)
        }

        // From JSON operations

        @JvmStatic
        fun <T> fromJson(value: String, type: Class<T>): T {
            return mapper.readValue(value, type)
        }

        @JvmStatic
        fun fromJson(value: String): Map<String, Any> {
            return fromJson(value, Map::class.java) as Map<String, Any>
        }

        @JvmStatic
        fun <T> fromJson(bytes: ByteArray, type: Class<T>): T {
            return mapper.readValue(bytes, type)
        }

        @JvmStatic
        fun fromJson(bytes: ByteArray): Map<String, Any> {
            return fromJson(bytes, Map::class.java) as Map<String, Any>
        }

    }

}