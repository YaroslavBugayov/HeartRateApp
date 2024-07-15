package com.bugayov.heartrateapp.utils

import android.graphics.Bitmap
import android.graphics.Color
import android.os.SystemClock
import android.util.Log
import androidx.camera.core.ExperimentalGetImage
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy
import androidx.compose.runtime.MutableState
import java.nio.ByteBuffer

class PulseAnalyzer(
    private val isFingerDetected: MutableState<Boolean>,
    private val progress: MutableState<Int>,
    private val pulseBpm: MutableState<Int>
    ) : ImageAnalysis.Analyzer {
    private val lastReds = ArrayDeque<Double>()
    private var average = 0.0
    private var summary = 0.0
    private var lastUpdateTime = 0L
    private var lastProgressTime = 0L
    private var counter = 0

    override fun analyze(image: ImageProxy) {
        val red = calculateAverageRed(image.planes[0].buffer)

        isFingerDetected.value = red > 75

        if (isFingerDetected.value) {
            lastReds.addLast(red)
            if (lastReds.size > 50) {
                lastReds.removeFirst()
            }

            summary = 0.0
            lastReds.forEach {
                summary += it
            }
            average = summary / (lastReds.size)

            val currentTime = SystemClock.elapsedRealtime()

            if (red < average - 0.4 && isFingerDetected.value && currentTime - lastUpdateTime > 200) {
                pulseBpm.value++
                lastUpdateTime = currentTime
            }

            if (currentTime - lastProgressTime > 50) {
                counter++
                lastProgressTime = currentTime
            }
            pulseBpm.value = counter * 12

        } else {
            progress.value = 0
            pulseBpm.value = 0
            counter = 0
        }

        image.close()
    }

    private fun calculateAverageRed(buffer: ByteBuffer): Double {
        var redSum = 0.0
        var pixelCount = 0

        while (buffer.hasRemaining()) {
            val pixel = buffer.get().toInt() and 0xFF
            redSum += pixel
            pixelCount++
        }

        return if (pixelCount > 0) redSum / pixelCount else 0.0
    }
}