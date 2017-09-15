package cc.aoeiuv020.comic.ui

import android.content.Context
import android.widget.ImageView
import cc.aoeiuv020.comic.R
import com.bumptech.glide.Glide
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.jetbrains.anko.indeterminateProgressDialog

/**
 * 拓展，
 * Created by AoEiuV020 on 2017.09.12-18:33:43.
 */

/**
 * 展示进度条，
 */
fun Context.loading(str: String = "") = indeterminateProgressDialog(getString(R.string.loading, str))

fun Context.loading(id: Int) = loading(getString(id))


fun <T : Any?> Observable<T>.async(): Observable<T> = this
        .subscribeOn(Schedulers.newThread())
        .observeOn(AndroidSchedulers.mainThread())

@Suppress("unused")
fun asyncLoadImage(image: ImageView, url: String) {
    Glide.with(image).load(url).into(image)
}
