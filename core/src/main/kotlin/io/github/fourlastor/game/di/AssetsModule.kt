package io.github.fourlastor.game.di

import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.assets.loaders.BitmapFontLoader.BitmapFontParameter
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.TextureAtlas
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.github.tommyettinger.textra.Font
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class AssetsModule {
    @Provides
    @Singleton
    fun assetManager(): AssetManager {
        return AssetManager().apply {
            load(PATH_TEXTURE_ATLAS, TextureAtlas::class.java)
            load(PATH_FONT, BitmapFont::class.java, BitmapFontParameter().apply { atlasName = PATH_TEXTURE_ATLAS })
            finishLoading()
        }
    }

    @Provides
    fun textureAtlas(assetManager: AssetManager): TextureAtlas =
        assetManager.get(PATH_TEXTURE_ATLAS, TextureAtlas::class.java)

    @Provides
    @Named(WHITE_PIXEL)
    fun whitePixel(atlas: TextureAtlas): TextureRegion = atlas.findRegion("whitePixel")

    @Provides
    fun bitmapFont(assetManager: AssetManager): BitmapFont = assetManager.get(PATH_FONT)

    @Provides
    fun font(bitmapFont: BitmapFont): Font = Font(bitmapFont).scale(0.2f, 0.2f)

    companion object {
        private const val PATH_TEXTURE_ATLAS = "images/images.pack.atlas"
        private const val PATH_FONT = "fonts/rosarivo.fnt"
        private const val WHITE_PIXEL = "white-pixel"
    }
}
