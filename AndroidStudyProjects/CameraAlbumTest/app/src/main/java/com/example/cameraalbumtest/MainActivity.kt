package com.example.cameraalbumtest

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.media.ExifInterface
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.cameraalbumtest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    private val getPictureFromCamera = registerForActivityResult(GetPictureFromCamera()) {
        val bitmap = BitmapFactory.decodeFile("$externalCacheDir/output_image.jpg")
        binding.imageView.setImageBitmap(rotateIfRequired(bitmap))
    }

    private val selectPicture = registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        binding.imageView.setImageURI(uri)
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.takePhotoBtn.setOnClickListener {
            getPictureFromCamera.launch(null)
        }

        binding.fromAlbumBtn.setOnClickListener {
            selectPicture.launch("image/*")
        }
    }

    // 判断图片需要旋转多少度的方法 只接收一个bitmap对象
    private fun rotateIfRequired(bitmap: Bitmap) : Bitmap? {
        val exif = ExifInterface("$externalCacheDir/output_image.jpg")
        if (exif != null) {
            return when (exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL)) {
                ExifInterface.ORIENTATION_ROTATE_90 -> rotateBitmap(bitmap, 90)
                ExifInterface.ORIENTATION_ROTATE_180 -> rotateBitmap(bitmap, 180)
                ExifInterface.ORIENTATION_ROTATE_270 -> rotateBitmap(bitmap, 270)
                else -> bitmap
            }
        }
        return null
    }

    // 单纯旋转图片的方法 接收一个bitmap对象和需要旋转的角度
    private fun rotateBitmap(bitmap: Bitmap, degree: Int): Bitmap {
        val matrix = Matrix()
        matrix.postRotate(degree.toFloat())
        val rotatedBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.width, bitmap.height, matrix, true)
        bitmap.recycle() // 回收不再需要的Bitmap对象
        return rotatedBitmap
    }
}