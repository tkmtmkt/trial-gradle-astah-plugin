package astah

import static org.assertj.core.api.Assertions.*

import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Test

class AstahPluginTest {

    @Test
    public void task追加の確認() {
        //準備
        Project project = ProjectBuilder.builder().build()

        //実行
        project.apply plugin: 'astah.AstahPlugin'

        //検証
        assertThat(project.tasks.astahListClasses)
            .isInstanceOf(AstahListClassesTask)
        assertThat(project.tasks.astahExportClasses)
            .isInstanceOf(AstahExportClassesTask)
    }
}
