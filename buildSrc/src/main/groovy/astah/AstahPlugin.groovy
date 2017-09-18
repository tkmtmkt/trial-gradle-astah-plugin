package astah

import org.gradle.api.Plugin
import org.gradle.api.Project

import csvexporter.ClassDefinitionExporter
import simpleRead.APIForReadingModelsSample

class AstahPlugin implements Plugin<Project> {
    void apply(Project project) {
        project.task('astahListClasses') {
            description = 'クラス一覧を表示する'
            doLast {
                APIForReadingModelsSample.main([""] as String[])
            }
        }

        project.task('astahExportClasses') {
            description = "指定したクラスの情報をエクスポートする"
            doLast {
                ClassDefinitionExporter.main(["SampleModel.asta", "SampleModel.csv"] as String[])
            }
        }
    }
}
