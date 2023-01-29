package com.example.cameraalbumtest

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import androidx.activity.result.contract.ActivityResultContract
import androidx.core.content.FileProvider
import java.io.File

class GetPictureFromCamera : ActivityResultContract<Void, String?>() {
    lateinit var imageUri : Uri
    lateinit var outputImage : File

    override fun parseResult(resultCode: Int, intent: Intent?): String? {
        if (resultCode == Activity.RESULT_OK) {
            return "success"
        }
        return null
    }

    override fun createIntent(context: Context, input: Void?): Intent {
        // 创建File对象，用于储存拍下来的照片
        outputImage = File(context.externalCacheDir, "output_image.jpg")
        if (outputImage.exists()) {
            outputImage.delete()
        }
        outputImage.createNewFile()
        // 判断版本号，根据版本号的不同调用不同的方法将File对象转换为Uri对象
        imageUri = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            FileProvider.getUriForFile(context, "com.example.cameraalbumtest.fileprovider", outputImage)
        } else {
            Uri.fromFile(outputImage)
        }
        // 启动相机程序
        val intent = Intent("android.media.action.IMAGE_CAPTURE")
        intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri) // 指定图片的输出地址
        return intent
    }
}

