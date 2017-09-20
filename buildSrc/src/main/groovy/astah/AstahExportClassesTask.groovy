package astah

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

import csvexporter.ClassDefinitionExporter

class AstahExportClassesTask extends DefaultTask {
    def inFile
    def outFile

    @TaskAction
    def exportClasses() {
        ClassDefinitionExporter.main([inFile, outFile] as String[])
    }
}
