package com.bugayov.heartrateapp.ui.components


import android.Manifest
import android.util.Log
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageCapture
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.LifecycleOwner
import com.bugayov.heartrateapp.utils.PulseAnalyzer
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import java.util.concurrent.Executors

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun CameraView(
    modifier: Modifier,
    isFingerDetected: MutableState<Boolean>,
    progress: MutableState<Int>,
    pulseBpm: MutableState<Int>
) {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val cameraPermission = rememberPermissionState(Manifest.permission.CAMERA)
    val torchEnabled = remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        cameraPermission.launchPermissionRequest()
    }

    if (cameraPermission.status.isGranted) {
        val cameraProviderFuture = remember { ProcessCameraProvider.getInstance(context) }
        val previewView = remember { PreviewView(context) }
        val preview = Preview.Builder().build()
        preview.setSurfaceProvider(previewView.surfaceProvider)

        val imageAnalysis = ImageAnalysis
            .Builder()
            .setBackpressureStrategy(ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST)
            .build()

        val pulseAnalyzer = PulseAnalyzer(isFingerDetected, progress, pulseBpm)

        imageAnalysis.setAnalyzer(Executors.newSingleThreadExecutor(), pulseAnalyzer)

        val cameraSelector = CameraSelector
            .Builder()
            .requireLensFacing(CameraSelector.LENS_FACING_BACK)
            .build()

        val imageCapture = remember { ImageCapture.Builder().build() }

        val cameraProvider = cameraProviderFuture.get()
        cameraProvider.unbindAll()
        val camera = cameraProvider.bindToLifecycle(
            lifecycleOwner, cameraSelector, preview,
            imageCapture, imageAnalysis
        )

        if (camera.cameraInfo.hasFlashUnit()) {
            torchEnabled.value = true
        }

        camera.cameraControl.enableTorch(torchEnabled.value)

        Box(modifier = modifier) {
            AndroidView(
                factory = { previewView },
                modifier = Modifier.size(42.dp).clip(CircleShape)
            )
        }
    } else {
        Text("No permission")
    }
}