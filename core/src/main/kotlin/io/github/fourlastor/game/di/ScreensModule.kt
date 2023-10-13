package io.github.fourlastor.game.di

import dagger.Module
import io.github.fourlastor.game.level.di.LevelComponent

@Module(subcomponents = [LevelComponent::class])
class ScreensModule
