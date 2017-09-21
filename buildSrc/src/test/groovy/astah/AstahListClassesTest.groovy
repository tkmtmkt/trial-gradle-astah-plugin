package astah

import static org.assertj.core.api.Assertions.*

import java.nio.file.Path
import java.nio.file.Paths

import org.junit.Test

class AstahListClassesTest {

    @Test
    public void test_getClassList() {
        //準備
        AstahListClasses sut = new AstahListClasses()
        def path = getFile("SampleModel.asta")

        //実行
        List<String> result = sut.getClassList(path)

        //検証
        assertThat(result).isNotNull()
        result.each {println it}
    }

    private Path getFile(String fileName) {
        def url = this.class.classLoader.getResource(fileName)
        Paths.get(url.toURI())
    }
}
