package json4dummies

import org.apache.kafka.common.utils.Bytes

class KafkaJson {

    companion object {

        @JvmStatic
        fun toJsonBytes(obj: Any): Bytes {
            return Bytes(Json.toJsonBytes(obj))
        }

        @JvmStatic
        fun <T> fromJson(bytes: Bytes, type: Class<T>): T {
            return Json.fromJson(bytes.get(), type)
        }

        @JvmStatic
        fun fromJson(bytes: Bytes): Map<String, Any> {
            return Json.fromJson(bytes.get())
        }

    }

}