package com.example.beatbox

import org.hamcrest.core.Is.`is`
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import javax.security.auth.Subject

class SoundViewModelTest {

    private lateinit var sound:Sound
    private lateinit var  subject: SoundViewModel
    private lateinit var beatBox: BeatBox
    @Before
    fun setUp() {
        sound= Sound("AssetPath")
        beatBox=mock(BeatBox::class.java)
        subject= SoundViewModel(beatBox)
        subject.sound=sound
    }

    @Test
    fun exposesSoundNameAsTitle(){
        assertThat(subject.title, `is`(sound.name))
    }
    @Test
    fun callsBeatboxPlayOnButtonClicked(){
        subject.onButtonClicked()

        verify(beatBox).play(sound)
    }
}