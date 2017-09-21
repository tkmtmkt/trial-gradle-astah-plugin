package astah

import java.nio.file.Path

import com.change_vision.jude.api.inf.AstahAPI
import com.change_vision.jude.api.inf.model.IClass
import com.change_vision.jude.api.inf.model.IModel
import com.change_vision.jude.api.inf.model.INamedElement
import com.change_vision.jude.api.inf.model.IPackage

class AstahListClasses {

    /**
     * Astahファイルからクラス一覧を取得する
     *
     * @param path
     *          Astahファイルのパス
     * @return クラス一覧
     */
    public List<String> getClassList(Path path) {
        def prjAccessor = AstahAPI.astahAPI.projectAccessor
        prjAccessor.open(path.toString())
        final IModel project = prjAccessor.project
        final Map<IModel, List<IClass>> allClasses = getAllClasses(project)

        final List<String> result = new ArrayList<>();
        for (entry in allClasses.entrySet()) {
            IModel model = entry.key
            for (clazz in entry.value) {
                final String record = String.join(
                    ",",
                    model.name,
                    clazz.getFullNamespace("."),
                    clazz.name)
                result.add record
            }
        }

        prjAccessor.close()

        return result
    }

    /**
     * Astahプロジェクト内の全クラスの一覧を取得する
     *
     * @param project
     *          Astahプロジェクト
     * @return クラス一覧
     */
    private Map<IModel, List<IClass>> getAllClasses(final IModel project) {
        final Map<IModel, List<IClass>> models = new HashMap<>()

        INamedElement[] elements = project.getOwnedElements()
        for (final INamedElement element : elements) {
            if (element instanceof IModel) {
                final List<IClass> classes = getClasses(element)
                models.put(element, classes)
            }
        }
        return models
    }

    /**
     * パッケージ内のクラス一覧を取得する
     *
     * @param iPackage
     *          パッケージ
     * @return クラス一覧
     */
    private List<IClass> getClasses(final IPackage iPackage) {
        final List<IClass> classes = new ArrayList<>();

        INamedElement[] elements = iPackage.getOwnedElements()
        for (final INamedElement element : elements) {
            if (element instanceof IClass) {
                classes.add(element)
            } else if (element instanceof IPackage) {
                classes.addAll(getClasses(element))
            }
        }
        return classes
    }
}
