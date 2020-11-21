package proto

import com.galexey.bradley.Bradley
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import org.junit.Test
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream

class TestProtoIntegration {

    @Test
    fun canReadWriteTrivialProtobufFiles() {
        val gameData = Bradley.GameData.newBuilder()
                .setVisibilityRadius(5)
                .build()

        val baos = ByteArrayOutputStream()
        gameData.writeTo(baos)
        baos.close()

        val bios = ByteArrayInputStream(baos.toByteArray())
        val parsed = Bradley.GameData.parseFrom(bios)

        assertThat(parsed.visibilityRadius, equalTo(5))
    }
}