package io.github.fourlastor.game.di

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class GdxModule {

    @Provides
    @Singleton
    fun batch(): SpriteBatch = SpriteBatch()
}
