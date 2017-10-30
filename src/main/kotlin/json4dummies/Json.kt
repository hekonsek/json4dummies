package json4dummies

import com.fasterxml.jackson.databind.ObjectMapper

class Json {

    companion object {

        private var mapper = ObjectMapper()

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
        fun fromJson(value: String): Map<String, Any> {
            return mapper.readValue(value, Map::class.java) as Map<String, Any>
        }

        @JvmStatic
        fun fromJson(bytes: ByteArray): Map<String, Any> {
            return mapper.readValue(bytes, Map::class.java) as Map<String, Any>
        }

    }

}