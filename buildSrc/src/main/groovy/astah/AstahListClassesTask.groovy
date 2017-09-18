package astah

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

import csvexporter.ClassDefinitionExporter
import simpleRead.APIForReadingModelsSample

class AstahListClassesTask extends DefaultTask {
    @TaskAction
    def listClasses() {
        APIForReadingModelsSample.main([""] as String[])
    }
}
