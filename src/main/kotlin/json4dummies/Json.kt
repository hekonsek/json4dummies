package json4dummies

import com.fasterxml.jackson.databind.ObjectMapper

class Json {

    companion object {

        private val mapper = ObjectMapper().findAndRegisterModules()

        // To JSON operations

        @JvmStatic
        fun toJson(value: Any): String = mapper.writeValueAsString(value)

        @JvmStatic
        fun toJsonBytes(value: Any): ByteArray = mapper.writeValueAsBytes(value)

        // From JSON operations

        @JvmStatic
        fun <T> fromJson(value: String, type: Class<T>): T {
            return mapper.readValue(value, type)
        }

        @JvmStatic
        fun fromJson(value: String): Map<String, Any> {
            @Suppress("UNCHECKED_CAST")
            return fromJson(value, Map::class.java) as Map<String, Any>
        }

        @JvmStatic
        fun <T> fromJson(bytes: ByteArray, type: Class<T>): T {
            return mapper.readValue(bytes, type)
        }

        @JvmStatic
        fun fromJson(bytes: ByteArray): Map<String, Any> {
            @Suppress("UNCHECKED_CAST")
            return fromJson(bytes, Map::class.java) as Map<String, Any>
        }

    }

}