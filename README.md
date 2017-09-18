study-astah_api-gradle
======================

ディレクトリ以下のastahファイル内のモデル、クラス図から
クラス一覧を作成する。

gradle astahListClasses
gradle astahExportClasses


ビルド設定
---------

### ライブラリ

astah apiから以下のファイルをコピーする。

    buildSrc/
    +-- lib
        +-- astah-api.jar
        +-- astah-community.jar

gradleのライブラリ指定を自動で解決できない場合、
以下のファイルをビルドパスに追加する。

    $GRADLE_HOME/caches/4.1/generated-gradle-jars/gradle-api-4.1.jar
    $GRADLE_HOME/lib/groovy-all-2.4.11.jar
    $GRADLE_HOME/lib/gradle-installation-beacon-4.1.jar
    study-astah_api-gradle/buildSrc/lib/astah-api.jar
    study-astah_api-gradle/buildSrc/lib/astah-community.jar


参考
----

* [第58章 カスタムタスクの作成](http://gradle.monochromeroad.com/docs/userguide/custom_tasks.html)
* [第59章 カスタムプラグインの作成](http://gradle.monochromeroad.com/docs/userguide/custom_plugins.html)
