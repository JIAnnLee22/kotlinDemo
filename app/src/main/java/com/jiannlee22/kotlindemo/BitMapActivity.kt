package com.jiannlee22.kotlindemo

import android.app.Activity
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.bitmap.*
import kotlinx.android.synthetic.main.creat_bitmap.view.*
import java.io.File
import java.util.jar.Manifest


class BitMapActivity : AppCompatActivity() {

    // The path to the root of this app's internal storage
    private lateinit var privateRootDir: File
    // The path to the "images" subdirectory
    private lateinit var imagesDir: File
    // Array of files in the images subdirectory
    private lateinit var imageFiles: Array<File>
    // Array of filenames corresponding to imageFiles
    private lateinit var imageFilenames: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bitmap)
        imageview.setImageResource(R.drawable.ic_sentiment_satisfied_black_24dp)
        // Set up an Intent to send back to apps that request a file
        val resultIntent = Intent("com.jiannlee22.kotlindemo.ACTION_RETURN_FILE")
        // Get the files/ subdirectory of internal storage
        privateRootDir = filesDir
        // Get the files/images subdirectory;
        imagesDir = File(privateRootDir, "images")
        // Get the files in the images subdirectory
        imageFiles = imagesDir.listFiles()
        // Set the Activity's result to null to begin with
        setResult(Activity.RESULT_CANCELED, null)
        imageview.setOnClickListener {
            val view = View.inflate(this, R.layout.creat_bitmap, null)
            view.bitmap.setImageResource(R.mipmap.ic_launcher)
//            BitmapUtils.viewToBitmap(view)
            val bitmap = viewToBitmap(view)
            if (bitmap != null) {
                val sendIntent: Intent =
                    Intent("com.jiannlee22.kotlindemo.ACTION_RETURN_FILE").apply {
                        action = Intent.ACTION_SEND
                        addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
                        putExtra(Intent.EXTRA_TEXT, bitmap)
                        type = "image/jpeg"
                    }

                val shareIntent = Intent.createChooser(sendIntent, null)
                startActivity(shareIntent)
            }
        }
    }

    //然后View和其内部的子View都具有了实际大小，也就是完成了布局，相当与添加到了界面上。接着就可以创建位图并在上面绘制了：
    private fun layoutViewAtMost(v: View) {
        // 整个View的大小 参数是左上角 和右下角的坐标
        val measuredWidth = View.MeasureSpec.makeMeasureSpec(10000, View.MeasureSpec.AT_MOST)
        val measuredHeight = View.MeasureSpec.makeMeasureSpec(10000, View.MeasureSpec.AT_MOST)
        /** 当然，measure完后，并不会实际改变View的尺寸，需要调用View.layout方法去进行布局。
         * 按示例调用layout函数后，View的大小将会变成你想要设置成的大小。
         */
        v.measure(measuredWidth, measuredHeight)
        v.layout(0, 0, v.measuredWidth, v.measuredHeight)
    }

    fun layoutViewExactly(v: View, width: Int, height: Int) {
        // 整个View的大小 参数是左上角 和右下角的坐标
        v.layout(0, 0, width, height)
        val measuredWidth = View.MeasureSpec.makeMeasureSpec(width, View.MeasureSpec.EXACTLY)
        val measuredHeight = View.MeasureSpec.makeMeasureSpec(height, View.MeasureSpec.EXACTLY)
        /** 当然，measure完后，并不会实际改变View的尺寸，需要调用View.layout方法去进行布局。
         * 按示例调用layout函数后，View的大小将会变成你想要设置成的大小。
         */
        v.measure(measuredWidth, measuredHeight)
        v.layout(0, 0, v.measuredWidth, v.measuredHeight)
    }

    private fun loadBitmapFromView(v: View): Uri? {
        val w = v.width
        val h = v.height
        val bmp = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888)
        val c = Canvas(bmp)

        c.drawColor(Color.WHITE)
        /** 如果不设置canvas画布为白色，则生成透明  */

        v.layout(0, 0, w, h)
        v.draw(c)

        return bitmapSaveToImage(bmp)
    }

    private fun viewToBitmap(v: View): Uri? {
        layoutViewAtMost(v)
        return loadBitmapFromView(v)
    }

    private fun bitmapSaveToImage(cachebmp: Bitmap): Uri? {
        val saveUri = contentResolver.insert(
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
            ContentValues()
        )
        if (saveUri != null) {
            contentResolver.openOutputStream(saveUri).use {
                cachebmp.compress(Bitmap.CompressFormat.JPEG, 90, it)
            }
        }
        return saveUri
    }

    companion object {
        const val REQ = 1
    }


}
