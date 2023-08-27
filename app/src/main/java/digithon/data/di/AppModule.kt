/*
 * Copyright (C) 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package digithon.data.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import digithon.data.database.AppDatabase
import digithon.data.database.QuoteDao
import digithon.domain.repository.QuoteRepository
import digithon.domain.usecase.quoteUsecases.AddQuoteUseCase
import digithon.domain.usecase.quoteUsecases.DeleteQuoteUseCase
import digithon.domain.usecase.quoteUsecases.GetQuoteByIdUseCase
import digithon.domain.usecase.quoteUsecases.GetQuotesUseCase
import digithon.domain.usecase.quoteUsecases.QuoteUseCases
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    fun provideQuoteDao(appDatabase: AppDatabase): QuoteDao {
        return appDatabase.quoteDao()
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "Quote",)
            // IMPORTANT: UNCOMMENT BELOW TO MIGRATE LOCAL DB TO NEW SCHEMA. WILL WIPE OUT LOCAL DB
            // Change Version number in AppDatabase.kt file and uncomment for quick way to drop Db
            //.fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideQuoteUseCases(repository: QuoteRepository): QuoteUseCases {
        return QuoteUseCases(
            getQuotesUseCase = GetQuotesUseCase(repository = repository),
            deleteQuoteUseCase = DeleteQuoteUseCase(repository = repository),
            addQuoteUseCase = AddQuoteUseCase(repository = repository),
            getQuoteByIdUseCase = GetQuoteByIdUseCase(repository = repository)
        )
    }
}
