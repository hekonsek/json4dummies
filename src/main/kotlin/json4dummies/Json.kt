package json4dummies

import com.fasterxml.jackson.databind.ObjectMapper

class Json {

    companion object {

        private var mapper = ObjectMapper()

        @JvmStatic
        fun toJson(obj: Any): String {
            return mapper.writeValueAsString(obj)
        }

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