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

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import digithon.data.repository.QuoteRepositoryImpl
import digithon.domain.model.Quote
import digithon.domain.repository.QuoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {
    @Singleton
    @Binds
    fun bindQuoteRepository(
        quoteRepository: QuoteRepositoryImpl
    ): QuoteRepository
}

class FakeQuoteRepository @Inject constructor() : QuoteRepository {
    override fun getNotes(): Flow<List<Quote>> = flowOf(fakeQuotes)
    override suspend fun getQuoteById(quoteId: String): Quote {
        throw NotImplementedError()
    }
    override suspend fun insertQuote(quote: Quote) {
        throw NotImplementedError()
    }
    override suspend fun deleteQuote(quote: Quote) {
        throw NotImplementedError()
    }

}

val fakeQuotes = listOf(Quote(quoteId = "QTETest", policyStartDate = System.currentTimeMillis(), dateCreated = System.currentTimeMillis(), recentInsurer = "TestInsurer", title = "Mr.", firstName = "FirstName", surname = "Surname"))
