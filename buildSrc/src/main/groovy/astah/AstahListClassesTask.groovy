package astah

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

import simpleRead.APIForReadingModelsSample

class AstahListClassesTask extends DefaultTask {
    def inFile

    @TaskAction
    def listClasses() {
        APIForReadingModelsSample.main([inFile] as String[])
    }
}
