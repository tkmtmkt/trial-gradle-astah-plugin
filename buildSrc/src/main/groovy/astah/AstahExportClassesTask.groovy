package astah

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

import csvexporter.ClassDefinitionExporter
import simpleRead.APIForReadingModelsSample

class AstahExportClassesTask extends DefaultTask {
    @TaskAction
    def exportClasses() {
        ClassDefinitionExporter.main(["SampleModel.asta", "SampleModel.csv"] as String[])
    }
}
