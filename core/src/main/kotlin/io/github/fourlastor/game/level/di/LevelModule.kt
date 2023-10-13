package io.github.fourlastor.game.level.di

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.utils.viewport.FitViewport
import com.badlogic.gdx.utils.viewport.Viewport
import dagger.Module
import dagger.Provides
import io.github.fourlastor.game.di.ScreenScoped

@Module
class LevelModule {
    @Provides @ScreenScoped
    fun viewport(): Viewport = FitViewport(256f, 144f)

    @Provides
    @ScreenScoped
    fun stage(viewport: Viewport, batch: SpriteBatch): Stage = Stage(viewport, batch)
}
