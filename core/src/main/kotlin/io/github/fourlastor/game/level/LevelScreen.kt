package io.github.fourlastor.game.level

import com.badlogic.gdx.InputMultiplexer
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.utils.Align
import com.badlogic.gdx.utils.ScreenUtils
import com.github.tommyettinger.textra.Font
import com.github.tommyettinger.textra.TextraLabel
import io.github.fourlastor.game.di.ScreenScoped
import ktx.app.KtxScreen
import javax.inject.Inject

@ScreenScoped
class LevelScreen @Inject constructor(
    private val inputMultiplexer: InputMultiplexer,
    private val font: Font,
    private val stage: Stage,
) : KtxScreen {

    init {
        stage.addActor(
            TextraLabel("Hello world", font).apply {
                alignment = Align.center
                setPosition(128f, 72f, Align.center)
            },
        )
    }

    override fun show() {
        inputMultiplexer.addProcessor(stage)
    }

    override fun hide() {
        inputMultiplexer.removeProcessor(stage)
    }

    override fun resize(width: Int, height: Int) {
        stage.viewport.update(width, height, true)
    }

    override fun render(delta: Float) {
        ScreenUtils.clear(Color.DARK_GRAY)
        stage.viewport.apply()
        stage.act(delta)
        stage.draw()
    }

    override fun dispose() {
        stage.dispose()
    }
}
