package com.example.beatbox

import android.content.res.AssetManager
import android.util.Log
import java.lang.Exception


private const val TAG= "BEAT BOX"
private const val SOUNDS_FOLDER="sample_sounds"
class BeatBox (private val assets: AssetManager){
    val sounds:List<Sound>
    init {
        sounds=loadSounds()
    }

   private fun loadSounds(): List<Sound> {
        val soundNames:Array<String>
        try {
             soundNames= assets.list(SOUNDS_FOLDER) as Array<String>
        }catch (e:Exception){
            Log.e(TAG,"Could not list assets",e)
            return emptyList()
        }
        val sounds= mutableListOf<Sound>()
        soundNames.forEach { fileName->
            val assetPath="$SOUNDS_FOLDER/$fileName"
            val sound= Sound(assetPath)
            sounds.add(sound)
        }
        return sounds
    }
}