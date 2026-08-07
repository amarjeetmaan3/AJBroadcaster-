package com.amarjeetmaan.ajbroadcaster.di

import android.content.Context
import com.amarjeetmaan.ajbroadcaster.data.repository.FirebaseGraphicsRepository
import com.amarjeetmaan.ajbroadcaster.data.repository.FirebaseMatchRepository
import com.amarjeetmaan.ajbroadcaster.data.repository.FirebasePlayerRepository
import com.amarjeetmaan.ajbroadcaster.data.repository.FirebaseScoreRepository
import com.amarjeetmaan.ajbroadcaster.data.repository.FirebaseSettingsRepository
import com.amarjeetmaan.ajbroadcaster.data.repository.FirebaseSponsorRepository
import com.amarjeetmaan.ajbroadcaster.data.repository.FirebaseStreamRepository
import com.amarjeetmaan.ajbroadcaster.data.repository.FirebaseTeamRepository
import com.amarjeetmaan.ajbroadcaster.data.repository.FirebaseTournamentRepository
import com.amarjeetmaan.ajbroadcaster.data.repository.FirebaseUserRepository
import com.amarjeetmaan.ajbroadcaster.repository.GraphicsRepository
import com.amarjeetmaan.ajbroadcaster.repository.MatchRepository
import com.amarjeetmaan.ajbroadcaster.repository.PlayerRepository
import com.amarjeetmaan.ajbroadcaster.repository.ScoreRepository
import com.amarjeetmaan.ajbroadcaster.repository.SettingsRepository
import com.amarjeetmaan.ajbroadcaster.repository.SponsorRepository
import com.amarjeetmaan.ajbroadcaster.repository.StreamRepository
import com.amarjeetmaan.ajbroadcaster.repository.TeamRepository
import com.amarjeetmaan.ajbroadcaster.repository.TournamentRepository
import com.amarjeetmaan.ajbroadcaster.repository.UserRepository
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Provides Firebase dependencies and repository implementations.
 */
@Module
@InstallIn(SingletonComponent::class)
object FirebaseModule {

    @Provides
    @Singleton
    fun provideFirebaseApp(
        @ApplicationContext context: Context
    ): FirebaseApp {
        return FirebaseApp.initializeApp(context)
            ?: throw IllegalStateException(
                "Firebase initialization failed."
            )
    }

    @Provides
    @Singleton
    fun provideFirebaseAuth(): FirebaseAuth {
        return FirebaseAuth.getInstance()
    }

    @Provides
    @Singleton
    fun provideFirebaseDatabase(): FirebaseDatabase {
        return FirebaseDatabase.getInstance()
    }

    @Provides
    @Singleton
    fun provideMatchRepository(
        database: FirebaseDatabase
    ): MatchRepository {
        return FirebaseMatchRepository(database)
    }

    @Provides
    @Singleton
    fun provideTournamentRepository(
        database: FirebaseDatabase
    ): TournamentRepository {
        return FirebaseTournamentRepository(database)
    }

    @Provides
    @Singleton
    fun provideTeamRepository(
        database: FirebaseDatabase
    ): TeamRepository {
        return FirebaseTeamRepository(database)
    }

    @Provides
    @Singleton
    fun providePlayerRepository(
        database: FirebaseDatabase
    ): PlayerRepository {
        return FirebasePlayerRepository(database)
    }

    @Provides
    @Singleton
    fun provideScoreRepository(
        database: FirebaseDatabase
    ): ScoreRepository {
        return FirebaseScoreRepository(database)
    }

    @Provides
    @Singleton
    fun provideStreamRepository(
        database: FirebaseDatabase
    ): StreamRepository {
        return FirebaseStreamRepository(database)
    }

    @Provides
    @Singleton
    fun provideSponsorRepository(
        database: FirebaseDatabase
    ): SponsorRepository {
        return FirebaseSponsorRepository(database)
    }

    @Provides
    @Singleton
    fun provideGraphicsRepository(
        database: FirebaseDatabase
    ): GraphicsRepository {
        return FirebaseGraphicsRepository(database)
    }

    @Provides
    @Singleton
    fun provideUserRepository(
        auth: FirebaseAuth,
        database: FirebaseDatabase
    ): UserRepository {
        return FirebaseUserRepository(
            auth,
            database
        )
    }

    @Provides
    @Singleton
    fun provideSettingsRepository(
        database: FirebaseDatabase
    ): SettingsRepository {
        return FirebaseSettingsRepository(database)
    }
}
