package cc.aoeiuv020.data

import cc.aoeiuv020.comic.api.site.ClassificationSniper
import cc.aoeiuv020.model.ClassificationModel

/**
 * 处理分类这块的爬虫和模型，
 * 有的方法涉及网络访问，
 */
class ClassificationManager {
    internal val classificationSnipers: List<ClassificationSniper>?
        get() = Comic.siteManager.siteSpider?.classificationSnipers
    val classificationModel: ClassificationModel?
        get() = classificationIndex?.let { i -> classificationSnipers?.let { s -> ClassificationModel(s[i]) } }
    var classificationIndex: Int? = null
    val classificationModels: List<ClassificationModel>?
        get() = classificationSnipers?.map { ClassificationModel(it) }

    fun reset() {
        classificationIndex = null
    }
}