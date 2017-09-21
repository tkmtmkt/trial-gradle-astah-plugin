package astah

import java.nio.file.Path
import java.nio.file.Paths

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class AstahListClassesTask extends DefaultTask {
    def inFile

    @TaskAction
    def listClasses() {
        Path path = Paths.get(inFile.toString())
        def astahListClasses = new AstahListClasses()
        List<String> classes = astahListClasses.getClassList(path)
        classes.each { println it }
        //TODO ビルドツリー内のastahファイルに対応するクラス一覧をcsvファイルにしてbuildディレクトリに出力する。
    }
}
